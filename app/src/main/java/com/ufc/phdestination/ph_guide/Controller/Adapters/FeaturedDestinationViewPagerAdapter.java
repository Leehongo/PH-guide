package com.ufc.phdestination.ph_guide.Controller.Adapters;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ufc.phdestination.ph_guide.Controller.tools.Utilities;
import com.ufc.phdestination.ph_guide.Model.Destination;
import com.ufc.phdestination.ph_guide.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leehongo 300-15 on 20/03/2017.
 */

public class FeaturedDestinationViewPagerAdapter extends PagerAdapter {


    private static final String TAG = "FeaturedDestinationViewPagerAdapter";

    List<Destination> featuredDestinationList = new ArrayList<Destination>();
    Destination destination;
    private Context mContext;

    public FeaturedDestinationViewPagerAdapter(Context mContext, List<Destination> destinationList) {
        this.mContext = mContext;
        this.featuredDestinationList = destinationList;
    }

    @Override
    public int getCount() {
        return featuredDestinationList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.featureddestination_list_item, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.featured_destination_list_item_image);

        destination = featuredDestinationList.get(position);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //TODO bug when selecting destination
                Snackbar.make(view, "not available", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
//                        Intent intent = new Intent(view.getContext(), DestinationDetailActivity.class);
//
//                        intent.putExtra("destination", destination);
//
//                        ActivityOptionsCompat options = ActivityOptionsCompat.
//                                makeSceneTransitionAnimation((Activity)view.getContext(), view.findViewById(R.id.featured_destination_list_item_image), mContext.getString(R.string.destination_image_trans));
//                        view.getContext().startActivity(intent, options.toBundle());
            }
        });

        Utilities.loadImageFromURL(this.mContext, imageView, destination.getImage());

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}