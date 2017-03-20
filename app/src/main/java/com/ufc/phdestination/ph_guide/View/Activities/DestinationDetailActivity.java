package com.ufc.phdestination.ph_guide.View.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.ufc.phdestination.ph_guide.Model.Destination;
import com.ufc.phdestination.ph_guide.R;
import com.ufc.phdestination.ph_guide.Controller.tools.Utilities;
import com.ufc.phdestination.ph_guide.View.Fragments.FragmentDestinationActivities;
import com.ufc.phdestination.ph_guide.View.Fragments.FragmentDestinationOverview;
import com.ufc.phdestination.ph_guide.View.Fragments.FragmentDestinationReviews;

public class DestinationDetailActivity extends AppCompatActivity {

    ImageView imageView;
    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination_detail_activity);

        toolbar = (Toolbar) findViewById(R.id.destination_detail_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        manager = getSupportFragmentManager();

        imageView = (ImageView) findViewById(R.id.destination_image);
        tabLayout = (TabLayout) findViewById(R.id.destination_tab_layout);
        viewPager = (ViewPager)findViewById(R.id.destination_viewpager);

        //for tabs and viewpager
        final MyPagerAdapter adapter = new MyPagerAdapter(manager);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        Utilities.getTransparentStatusBar(this);

        collapsingToolbarLayout= (CollapsingToolbarLayout) findViewById(R.id.destination_toolbar_layout);
        collapsingToolbarLayout.setTitleEnabled(false);

        init();
       }


       private void init(){
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
}
