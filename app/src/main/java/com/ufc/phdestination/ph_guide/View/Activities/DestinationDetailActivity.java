package com.ufc.phdestination.ph_guide.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.ufc.phdestination.ph_guide.Model.Destination;
import com.ufc.phdestination.ph_guide.R;
import com.ufc.phdestination.ph_guide.Controller.tools.Utilities;
import com.ufc.phdestination.ph_guide.View.Fragments.FragmentDestinationActivities;
import com.ufc.phdestination.ph_guide.View.Fragments.FragmentDestinationOverview;
import com.ufc.phdestination.ph_guide.View.Fragments.FragmentDestinationReviews;

public class DestinationDetailActivity extends AppCompatActivity {

    private ImageView imageView;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private FloatingActionButton fabAdd,fabReview,fabQuestion;
    private Animation fab_open,fab_close,rotate_forward,rotate_backward;

    private FragmentManager manager;

    private Boolean isFabOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination_detail_activity);

        toolbar = (Toolbar) findViewById(R.id.destination_detail_toolbar);
        imageView = (ImageView) findViewById(R.id.destination_image);
        tabLayout = (TabLayout) findViewById(R.id.destination_tab_layout);
        viewPager = (ViewPager)findViewById(R.id.destination_viewpager);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.destination_toolbar_layout);
        fabAdd = (FloatingActionButton) findViewById(R.id.fab_add);
        fabReview = (FloatingActionButton) findViewById(R.id.fab_review);
        fabQuestion = (FloatingActionButton) findViewById(R.id.fab_question);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_backward);


        fabAdd.setOnClickListener(ocl);
        fabReview.setOnClickListener(ocl);
        fabQuestion.setOnClickListener(ocl);

        manager = getSupportFragmentManager();
        Utilities.getTransparentStatusBar(this);

        init();
       }


       private void init(){
           setSupportActionBar(toolbar);
           getSupportActionBar().setDisplayHomeAsUpEnabled(true);

           collapsingToolbarLayout.setTitleEnabled(false);

           //for tabs and viewpager
           viewPager.setAdapter(new MyPagerAdapter(manager));
           tabLayout.setupWithViewPager(viewPager);

           //set destination details
           Destination destination = (Destination)getIntent().getSerializableExtra("destination");

           getSupportActionBar().setTitle(destination.getDestinationName());
           Utilities.loadImageFromURL(this, imageView, destination.getImage()); //TODO reuse the image,

       }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return FragmentDestinationOverview.createInstance("overview");
                case 1:
                    return FragmentDestinationActivities.createInstance("activities");
                case 2:
                    return FragmentDestinationReviews.createInstance("reviews");
                default:
                    return null;
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return"OVERVIEW";
                case 1:
                    return"ACTIVITIES";
                case 2:
                    return"REVIEWS";
            }
            return "";
        }
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


    View.OnClickListener ocl = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch ( view.getId()){
                case R.id.fab_add:
                    animateFAB();
//                    Snackbar.make(view, "not available", Snackbar.LENGTH_SHORT)
//                            .setAction("Action", null).show();
                    break;
                case R.id.fab_review:
                    break;
                case R.id.fab_question:
                    break;
            }
        }
    };


    public void animateFAB(){

        if(isFabOpen){

            fabAdd.startAnimation(rotate_backward);
            fabQuestion.startAnimation(fab_close);
            fabReview.startAnimation(fab_close);
            fabQuestion.setClickable(false);
            fabReview.setClickable(false);
            isFabOpen = false;

        } else {

            fabAdd.startAnimation(rotate_forward);
            fabQuestion.startAnimation(fab_open);
            fabReview.startAnimation(fab_open);
            fabQuestion.setClickable(true);
            fabReview.setClickable(true);
            isFabOpen = true;

        }
    }
}
