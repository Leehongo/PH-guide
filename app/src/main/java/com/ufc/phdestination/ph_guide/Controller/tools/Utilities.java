package com.ufc.phdestination.ph_guide.Controller.tools;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.ufc.phdestination.ph_guide.R;

/**
 * Created by Leehongo 300-15 on 16/01/2017.
 */

public class Utilities {

    static RequestOptions myOptions = new RequestOptions()
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.placeholder)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .centerCrop()
            .skipMemoryCache(true);

    public static void loadImageFromURL(@NonNull Context context, @NonNull final ProgressBar progressBar, ImageView imageView, String url){
        Glide.with(context)
                .load(url)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {

                        progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .apply(myOptions)
                .into(imageView);
    }

    public static void loadImageFullSizeFromURL(Context context, ImageView imageView, String url){
        Glide.with(context)
                .load(url)
                .apply(myOptions.circleCrop())
                .into(imageView);
    }

    public static void loadAsRoundImageFromURL(Context context, ImageView imageView, String url){
        Glide.with(context)
                .load(url)
                .apply(myOptions)
                .into(imageView);
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
