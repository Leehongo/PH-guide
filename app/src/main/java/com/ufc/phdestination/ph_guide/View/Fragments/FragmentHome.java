package com.ufc.phdestination.ph_guide.View.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ufc.phdestination.ph_guide.R;
import com.ufc.phdestination.ph_guide.View.Activities.TopDestinationsActivity;

/**
 * Created by Ideapad 300-15 on 28/11/2016.
 */

public class FragmentHome extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        TextView seeall_topDestinations = (TextView) view.findViewById(R.id.fragment_home_topdestinations_seeall);
        seeall_topDestinations.setOnClickListener(ocl);
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

}
