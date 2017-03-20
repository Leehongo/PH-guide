package com.ufc.phdestination.ph_guide.Controller.tools;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
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


   public static void getTransparentStatusBar(Activity myActivityReference) {
        myActivityReference.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    public static void getTranslucentStatusBar(Activity myActivityReference){
        myActivityReference.getWindow().setFlags(
                   WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                   WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        myActivityReference.getWindow().setFlags(
                   WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                   WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


    }
}
