package com.ufc.phdestination.ph_guide.View.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ufc.phdestination.ph_guide.Controller.Adapters.TopDestinationsAdapter;
import com.ufc.phdestination.ph_guide.Controller.Adapters.TopDestinationsHorizontalAdapter;
import com.ufc.phdestination.ph_guide.Model.Destination;
import com.ufc.phdestination.ph_guide.R;
import com.ufc.phdestination.ph_guide.View.Activities.TopDestinationsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ideapad 300-15 on 28/11/2016.
 */

public class FragmentHome extends Fragment {


    RecyclerView topDestinationRecycleView;
    TopDestinationsHorizontalAdapter topDestinationsAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        Button seeAllTopDestinations = (Button) view.findViewById(R.id.fragment_home_topdestinations_seeall);

        seeAllTopDestinations.setOnClickListener(ocl);

       initTopDestinations(view);
        initTrendingDestinations(view);
        return view;
    }

    View.OnClickListener ocl = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch ( view.getId()){
                case R.id.fragment_home_topdestinations_seeall:
                    Intent intent = new Intent(getActivity(), TopDestinationsActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };

    public void initTopDestinations(View view){
        List<Destination> topDestinations = Destination.ITEMS;    //TODO remove, for test only

        topDestinationRecycleView = (RecyclerView) view.findViewById(R.id.top_destination_horizontal_recycleview);

        topDestinationsAdapter = new TopDestinationsHorizontalAdapter(getActivity(), topDestinations);

        topDestinationRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        topDestinationRecycleView.setAdapter(topDestinationsAdapter);
    }


    public void initTrendingDestinations(View view){
        List<Destination> trendingDestinations = Destination.ITEMS;    //TODO remove, for test only

        topDestinationRecycleView = (RecyclerView) view.findViewById(R.id.trending_destination_horizontal_recycleview);

        topDestinationsAdapter = new TopDestinationsHorizontalAdapter(getActivity(), trendingDestinations);

        topDestinationRecycleView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        topDestinationRecycleView.setAdapter(topDestinationsAdapter);
    }

}
