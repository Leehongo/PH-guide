package com.ufc.phdestination.ph_guide.View.Activities;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ufc.phdestination.ph_guide.Model.Destination;
import com.ufc.phdestination.ph_guide.Model.Review;
import com.ufc.phdestination.ph_guide.R;
import com.ufc.phdestination.ph_guide.Controller.tools.Utilities;
import com.ufc.phdestination.ph_guide.View.Adapters.DestinationDetailReviewsAdapter;
import com.ufc.phdestination.ph_guide.View.Adapters.TopDestinationsAdapter;

import java.util.ArrayList;
import java.util.List;

public class DestinationDetailActivity extends AppCompatActivity {

    private Menu menu;
    private ImageView imageView;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ProgressBar progressBar;
    private TextView destinationName;
    private FloatingActionButton fab;
    private AppBarLayout appBarLayout;
    private MenuItem menuItemWIshlist;
    private RecyclerView mRecyclerView;


    private int HIGHTLIGHT_REVIEWS_SHOW_COUNT = 3;

    private DestinationDetailReviewsAdapter reviewsAdapter;



    static List<Review> reviewList = new ArrayList<Review>();


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.actionbar_destination, menu);

        menuItemWIshlist = menu.findItem(R.id.destination_menu_action_wishlist);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination_detail_activity);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        toolbar = (Toolbar) findViewById(R.id.destination_detail_toolbar);
        imageView = (ImageView) findViewById(R.id.destination_image);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.destination_toolbar_layout);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        destinationName = (TextView) findViewById(R.id.destination_name);
        appBarLayout = (AppBarLayout) findViewById(R.id.destination_app_bar);

        Utilities.getTransparentStatusBar(this);

        init();
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

        //Review List

        reviewList = Review.REVIEWS;    //TODO remove, for test only

        mRecyclerView = (RecyclerView) findViewById(R.id.destination_detail_content_review_highlight_recycleview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        reviewsAdapter = new DestinationDetailReviewsAdapter(this, reviewList, HIGHTLIGHT_REVIEWS_SHOW_COUNT);
        mRecyclerView.setAdapter(reviewsAdapter);


        appBarLayout.addOnOffsetChangedListener(offsetChangedListener);

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

            case R.id.destination_menu_action_wishlist:
                break;
        }
        return true;
    }

    AppBarLayout.OnOffsetChangedListener offsetChangedListener = new AppBarLayout.OnOffsetChangedListener(){
        boolean isShow = false;
        int scrollRange = -1;

        @Override
        public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

            if (scrollRange == -1) {
                scrollRange = appBarLayout.getTotalScrollRange();
            }

            if(menuItemWIshlist != null){
                boolean isFabVisible = (fab.getVisibility() == View.VISIBLE)? false: true;
                menuItemWIshlist.setVisible(isFabVisible);
            }

            if (scrollRange + verticalOffset == 0) {
                getSupportActionBar().setDisplayShowTitleEnabled(true);
                isShow = true;
            } else if(isShow) {
                getSupportActionBar().setDisplayShowTitleEnabled(false);
                isShow = false;
            }
        }
    };
       
       private void onClickBack(){
           super.onBackPressed();
       }
}
