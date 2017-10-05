package com.ufc.phdestination.ph_guide.View.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ufc.phdestination.ph_guide.Controller.tools.Utilities;
import com.ufc.phdestination.ph_guide.Model.Review;
import com.ufc.phdestination.ph_guide.Model.UserAccount;
import com.ufc.phdestination.ph_guide.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leehongo on 05/10/2017.
 */

public class DestinationDetailReviewsAdapter extends RecyclerView.Adapter<DestinationDetailReviewsAdapter.MyViewHolder> {

    private static final String TAG = "DestinationDetailReviewsAdapter";

    List<Review> reviewList = new ArrayList<Review>();

    private Context mContext;

    View itemView;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView name;
        public RatingBar ratingBar;
        public TextView message;
        public MyViewHolder(View view) {
            super(view);
            image = (ImageView) view.findViewById(R.id.destination_detail_review_image);
            name = (TextView) view.findViewById(R.id.destination_detail_review_name);
            ratingBar = (RatingBar) view.findViewById(R.id.destination_detail_review_ratings);
            message = (TextView) view.findViewById(R.id.destination_detail_review_message);
        }
    }

    public DestinationDetailReviewsAdapter(Context mContext, List<Review> reviewList){
        this.mContext = mContext;
        this.reviewList = reviewList;
    }

    @Override
    public DestinationDetailReviewsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.destination_detail_content_review_item, parent, false);
        return new DestinationDetailReviewsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DestinationDetailReviewsAdapter.MyViewHolder viewHolder, int position) {

        final Review review = reviewList.get(position);
        UserAccount userAccount = review.getUserAccount();

        viewHolder.name.setText(userAccount.getFirstName() + " " + userAccount.getLastName());

        Utilities.loadAsRoundImageFromURL(this.mContext, viewHolder.image, userAccount.getImage());

        viewHolder.message.setText(review.getMessage());

    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }
}
