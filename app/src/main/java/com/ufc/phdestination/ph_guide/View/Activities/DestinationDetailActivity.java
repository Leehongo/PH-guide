package com.ufc.phdestination.ph_guide.View.Activities;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ufc.phdestination.ph_guide.Model.Destination;
import com.ufc.phdestination.ph_guide.R;
import com.ufc.phdestination.ph_guide.Controller.tools.Utilities;

public class DestinationDetailActivity extends AppCompatActivity {

    private ImageView imageView;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ProgressBar progressBar;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar_destination, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination_detail_activity);

        toolbar = (Toolbar) findViewById(R.id.destination_detail_toolbar);
        imageView = (ImageView) findViewById(R.id.destination_image);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.destination_toolbar_layout);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        Utilities.getTransparentStatusBar(this);

        init();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.destination_menu_action_share:
                break;

            case R.id.action_settings:
                break;
        }
        return true;
    }

    private void init(){
           setSupportActionBar(toolbar);
           getSupportActionBar().setDisplayHomeAsUpEnabled(true);

           collapsingToolbarLayout.setTitleEnabled(false);

           //set destination details
           Destination destination = (Destination)getIntent().getSerializableExtra("destination");

           getSupportActionBar().setTitle(destination.getDestinationName());
           Utilities.loadImageFromURL(this, progressBar, imageView, destination.getImage()); //TODO reuse the image,
       }

}
