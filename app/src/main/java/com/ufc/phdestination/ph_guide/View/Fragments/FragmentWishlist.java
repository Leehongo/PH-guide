package com.ufc.phdestination.ph_guide.View.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.ufc.phdestination.ph_guide.R;

/**
 * Created by Leehongo 300-15 on 28/ 11/2016.
 */

public class FragmentWishlist extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_wishlist, container, false);
    }



}
