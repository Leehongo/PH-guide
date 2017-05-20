package com.ufc.phdestination.ph_guide.View.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ufc.phdestination.ph_guide.R;

/**
 * Created by Leehongo 300-15 on 28/11/2016.
 */

public class FragmentDestinationOverview extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.destination_detail_tab_overview_fragment, container, false);

        return view;
    }

    public static FragmentDestinationOverview createInstance(String text) {

        FragmentDestinationOverview f = new FragmentDestinationOverview();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

}
