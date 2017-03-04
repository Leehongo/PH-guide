package com.ufc.phdestination.ph_guide.Controller.tools;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by Ideapad 300-15 on 16/01/2017.
 */

public class Utilities {



    public static void loadImageFromURL(Context context, ImageView imageView, String url){
        Glide.with(context).load(url).crossFade().into(imageView);
    }

    public static void loadImageFullSizeFromURL(Context context, ImageView imageView, String url){
        Glide.with(context).load(url).crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

}
