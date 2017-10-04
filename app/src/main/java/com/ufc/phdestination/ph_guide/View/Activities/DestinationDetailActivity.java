package com.ufc.phdestination.ph_guide.View.Activities;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ufc.phdestination.ph_guide.Model.Destination;
import com.ufc.phdestination.ph_guide.R;
import com.ufc.phdestination.ph_guide.Controller.tools.Utilities;

public class DestinationDetailActivity extends AppCompatActivity {

    private ImageView imageView;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ProgressBar progressBar;
    private TextView destinationName;
    private FloatingActionButton fab;


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
        destinationName = (TextView) findViewById(R.id.destination_name);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        Utilities.getTransparentStatusBar(this);

        init();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.home:
                onClickBack();
                Toast.makeText(this, "back", Toast.LENGTH_SHORT).show();
                break;
            
            case R.id.destination_menu_action_share:
                break;

            case R.id.action_settings:
                break;
        }
        return true;
    }

    private void init(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // back button
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        collapsingToolbarLayout.setTitleEnabled(false);

        //set destination details
        Destination destination = (Destination)getIntent().getSerializableExtra("destination");

        getSupportActionBar().setTitle(destination.getDestinationName());
        Utilities.loadImageFromURL(this, progressBar, imageView, destination.getImage()); //TODO reuse the image,
        destinationName.setText(destination.getDestinationName());


        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.destination_app_bar);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    getSupportActionBar().setDisplayShowTitleEnabled(true);
                    isShow = true;
                } else if(isShow) {
                    getSupportActionBar().setDisplayShowTitleEnabled(false);//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });

    }
       
       private void onClickBack(){
           super.onBackPressed();
       }
}
