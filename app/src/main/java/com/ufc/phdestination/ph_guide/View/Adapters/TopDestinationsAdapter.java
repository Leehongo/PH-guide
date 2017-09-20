package com.ufc.phdestination.ph_guide.View.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ufc.phdestination.ph_guide.View.Activities.DestinationDetailActivity;
import com.ufc.phdestination.ph_guide.Model.Destination;
import com.ufc.phdestination.ph_guide.R;
import com.ufc.phdestination.ph_guide.Controller.tools.Utilities;

import java.util.ArrayList;
import java.util.List;

public class TopDestinationsAdapter extends RecyclerView.Adapter<TopDestinationsAdapter.MyViewHolder> {

    private static final String TAG = "TopDestinationsAdapter";

    List<Destination> topDestinationList = new ArrayList<Destination>();

    private Context mContext;

    View itemView;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public ImageView image;
        public ProgressBar progressBar;
        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.destination_name);
            image = (ImageView) view.findViewById(R.id.destination_image);
            progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        }
    }


    public TopDestinationsAdapter(Context mContext, List<Destination> destinationList){
        this.mContext = mContext;
        this.topDestinationList = destinationList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.topdestination_list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder viewHolder, final int position) {
        final Destination destination = topDestinationList.get(position);
        viewHolder.name.setText(destination.getDestinationName());

        Utilities.loadImageFromURL(this.mContext, viewHolder.progressBar, viewHolder.image, destination.getImage());


        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.destination_card_view:
                         Intent intent = new Intent(view.getContext(), DestinationDetailActivity.class);

                        intent.putExtra("destination", destination);

                        ActivityOptionsCompat options = ActivityOptionsCompat.
                                makeSceneTransitionAnimation((Activity)view.getContext(), view.findViewById(R.id.destination_card_view), mContext.getString(R.string.destination_image_trans));
                        view.getContext().startActivity(intent, options.toBundle());

                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return topDestinationList.size();
    }


}
