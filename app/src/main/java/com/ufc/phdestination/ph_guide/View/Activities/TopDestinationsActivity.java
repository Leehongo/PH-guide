package com.ufc.phdestination.ph_guide.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ufc.phdestination.ph_guide.View.Adapters.TopDestinationListActivityAdapter;
import com.ufc.phdestination.ph_guide.Controller.AsyncTasks.AsyncTopDestinations;
import com.ufc.phdestination.ph_guide.Model.Destination;
import com.ufc.phdestination.ph_guide.R;
import com.ufc.phdestination.ph_guide.View.Interface.AsyncResponse;

import java.util.ArrayList;
import java.util.List;

public class TopDestinationsActivity extends AppCompatActivity{


    private static final String TAG = "TopDestinationActivity";

    RecyclerView mRecyclerView;
    protected RecyclerView.LayoutManager mLayoutManager;
    TopDestinationListActivityAdapter topDestinationListActivityAdapter;

    AsyncTopDestinations asynctask = new AsyncTopDestinations();

    static List<Destination> topDestinations = new ArrayList<Destination>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top_destination_activity_list);

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

        topDestinationListActivityAdapter = new TopDestinationListActivityAdapter(this, topDestinations);
        mRecyclerView.setAdapter(topDestinationListActivityAdapter);

    }
}
