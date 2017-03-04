package com.ufc.phdestination.ph_guide.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.ufc.phdestination.ph_guide.Model.Destination;
import com.ufc.phdestination.ph_guide.R;
import com.ufc.phdestination.ph_guide.Controller.tools.Utilities;

public class DestinationDetailActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.destination_detail_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        imageView = (ImageView) findViewById(R.id.destination_image);



        int item_id = getIntent().getIntExtra("destiantion_id", 0);
        Destination item = Destination.ITEMS.get(item_id);


        Utilities.loadImageFromURL(this, imageView, item.getImage());


       }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            navigateUpTo(new Intent(this, TopDestinationsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
