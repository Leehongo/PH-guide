package com.ufc.phdestination.ph_guide.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ufc.phdestination.ph_guide.View.Adapters.TopDestinationsAdapter;
import com.ufc.phdestination.ph_guide.Controller.AsyncTasks.AsyncTopDestinations;
import com.ufc.phdestination.ph_guide.Model.Destination;
import com.ufc.phdestination.ph_guide.R;
import com.ufc.phdestination.ph_guide.View.Interface.AsyncResponse;

import java.util.ArrayList;
import java.util.List;

public class TopDestinationsActivity extends AppCompatActivity implements AsyncResponse {


    private static final String TAG = "TopDestinationActivity";

    RecyclerView mRecyclerView;
    protected RecyclerView.LayoutManager mLayoutManager;
    TopDestinationsAdapter topDestinationsAdapter;

    AsyncTopDestinations asynctask = new AsyncTopDestinations();

    static List<Destination> topDestinations = new ArrayList<Destination>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topdestination_list_activity);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getTitle());
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        initData();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            navigateUpTo(new Intent(this, BaseActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initData(){

       topDestinations = Destination.TOPDESTINATIONS;    //TODO remove, for test only

        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview_topdestinations);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        topDestinationsAdapter = new TopDestinationsAdapter(this, topDestinations);
        mRecyclerView.setAdapter(topDestinationsAdapter);


        //AsyncTaks to get the list of top Destinations
       // asynctask.delegate = this;    //TODO enable & delete above soon.
       // asynctask.execute();
    }


    @Override
    public void processFinish(List<Destination> destinationList) {
        topDestinations = destinationList; //get the list after async task is finished

        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview_topdestinations);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        topDestinationsAdapter = new TopDestinationsAdapter(this, topDestinations);
        mRecyclerView.setAdapter(topDestinationsAdapter);
    }
}
