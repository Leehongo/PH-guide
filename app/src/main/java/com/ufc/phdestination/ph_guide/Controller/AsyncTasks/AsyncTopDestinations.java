package com.ufc.phdestination.ph_guide.Controller.AsyncTasks;

import android.os.AsyncTask;
import android.util.Log;

import com.ufc.phdestination.ph_guide.Controller.tools.HttpHandler;
import com.ufc.phdestination.ph_guide.Model.Destination;
import com.ufc.phdestination.ph_guide.Model.Global;
import com.ufc.phdestination.ph_guide.View.Interface.AsyncResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Ideapad 300-15 on 20/03/2017.
 */

public class AsyncTopDestinations extends AsyncTask<Void, Void, Void> {

    public AsyncResponse delegate = null;


    List<Destination> destinationList = new ArrayList<Destination>();

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... voids) {

        HttpHandler sh = new HttpHandler();

        String jsonStr = sh.makeServiceCall(Global.TOPDESTINATIONURL);
        Log.e(TAG, "Response from url: " + jsonStr);

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);

                JSONArray destinations = jsonObj.getJSONArray("destinations");

                for (int i = 0; i < destinations.length(); i++) {
                    JSONObject c = destinations.getJSONObject(i);

                    int id = c.getInt("id");
                    String name = c.getString("name");
                    String description = c.getString("description");
                    String image = c.getString("image");

                    destinationList.add(new Destination(id, name,description,image));
                }
            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        delegate.processFinish(destinationList);
    }
}