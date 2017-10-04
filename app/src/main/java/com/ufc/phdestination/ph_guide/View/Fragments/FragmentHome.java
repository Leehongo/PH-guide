package com.ufc.phdestination.ph_guide.View.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ufc.phdestination.ph_guide.View.Adapters.FeaturedDestinationViewPagerAdapter;
import com.ufc.phdestination.ph_guide.View.Adapters.TopDestinationsHorizontalAdapter;
import com.ufc.phdestination.ph_guide.View.Adapters.TrendingDestinationsHorizontalAdapter;
import com.ufc.phdestination.ph_guide.Model.Destination;
import com.ufc.phdestination.ph_guide.R;
import com.ufc.phdestination.ph_guide.View.Activities.TopDestinationsActivity;

import java.util.List;

/**
 * Created by Leehongo 300-15 on 28/11/2016.
 */

public class FragmentHome extends Fragment implements ViewPager.OnPageChangeListener, View.OnClickListener {

    private ViewPager viewPager;
    private LinearLayout pager_indicator;
    private int dotsCount;
    private ImageView[] dots;
    private FeaturedDestinationViewPagerAdapter featuredDestinationViewPagerAdapter;

    private RecyclerView topDestinationRecycleView;
    private TextView seeAllTopDestinations;
    private TextView seeAllTrendingDestinations;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_home, container, false);

        seeAllTopDestinations = (TextView) view.findViewById(R.id.fragment_home_topdestinations_see_all);
        seeAllTrendingDestinations = (TextView) view.findViewById(R.id.fragment_home_trending_destination_see_all);


        seeAllTopDestinations.setOnClickListener(ocl);
        seeAllTrendingDestinations.setOnClickListener(ocl);

        initFeaturedDestinations(view);
        initTopDestinations(view);
        initTrendingDestinations(view);
        return view;
    }

    View.OnClickListener ocl = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {
                case R.id.fragment_home_topdestinations_see_all:
                    Intent intent = new Intent(getActivity(), TopDestinationsActivity.class);
                    startActivity(intent);
                    break;
                case R.id.fragment_home_trending_destination_see_all:
                    Snackbar.make(view, "not available", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                    break;
            }
        }
    };


    public void initFeaturedDestinations(View view) {

        viewPager = (ViewPager) view.findViewById(R.id.featured_destination_viewpager);

        pager_indicator = (LinearLayout) view.findViewById(R.id.viewPagerCountDots);

        featuredDestinationViewPagerAdapter = new FeaturedDestinationViewPagerAdapter(getActivity(), Destination.FEATUREDDESTINATIONS);
        viewPager.setAdapter(featuredDestinationViewPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(this);

        dotsCount = featuredDestinationViewPagerAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.viewpager_nonselected_item_dot, null));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            pager_indicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.viewpager_selected_item_dot, null));

    }


    public void initTopDestinations(View view) {
        List<Destination> topDestinations = Destination.TOPDESTINATIONS;    //TODO remove, for test only

        TopDestinationsHorizontalAdapter topDestinationsAdapter = new TopDestinationsHorizontalAdapter(getActivity(), topDestinations);

        topDestinationRecycleView = (RecyclerView) view.findViewById(R.id.top_destination_horizontal_recycleview);

        topDestinationRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        topDestinationRecycleView.setAdapter(topDestinationsAdapter);
    }


    public void initTrendingDestinations(View view) {
        List<Destination> trendingDestinations = Destination.TRENDINGDESTINATIONS;    //TODO remove, for test only

        TrendingDestinationsHorizontalAdapter trendingDestinationsAdapter = new TrendingDestinationsHorizontalAdapter(getActivity(), trendingDestinations);

        topDestinationRecycleView = (RecyclerView) view.findViewById(R.id.trending_destination_horizontal_recycleview);

        topDestinationRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        topDestinationRecycleView.setAdapter(trendingDestinationsAdapter);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dotsCount; i++) {
            dots[i].setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.viewpager_nonselected_item_dot, null));
        }
        dots[position].setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.viewpager_selected_item_dot, null));
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //reference: http://www.androprogrammer.com/2015/06/view-pager-with-circular-indicator.html
    }
}
