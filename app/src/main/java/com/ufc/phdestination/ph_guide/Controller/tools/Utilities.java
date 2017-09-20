package com.ufc.phdestination.ph_guide.Controller.tools;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/**
 * Created by Leehongo 300-15 on 16/01/2017.
 */

public class Utilities {

    public static void loadImageFromURL(@NonNull Context context, @NonNull final ProgressBar progressBar, ImageView imageView, String url){
        Glide.with(context)
                .load(url)
                .crossFade()
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(imageView);
    }

    public static void loadImageFullSizeFromURL(Context context, ImageView imageView, String url){
        Glide.with(context)
                .load(url)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);
    }
    //TODO use  .placeholder(R.drawable.loading_spinner)

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
