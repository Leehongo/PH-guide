package com.ufc.phdestination.ph_guide.View.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ufc.phdestination.ph_guide.R;

/**
 * Created by Ideapad 300-15 on 28/11/2016.
 */

public class FragmentDestinationDestinations extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.destination_detail_tab_destinations_fragment, container, false);

        return view;
    }

    public static FragmentDestinationDestinations createInstance(String text) {

        FragmentDestinationDestinations f = new FragmentDestinationDestinations();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }



}
