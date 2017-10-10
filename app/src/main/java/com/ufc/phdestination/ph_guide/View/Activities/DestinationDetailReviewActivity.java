package com.ufc.phdestination.ph_guide.View.Activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.ufc.phdestination.ph_guide.Model.Review;
import com.ufc.phdestination.ph_guide.R;
import com.ufc.phdestination.ph_guide.View.Adapters.DestinationDetailReviewActivityAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jvmangahas on 10/10/2017.
 */

public class DestinationDetailReviewActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private RecyclerView recyclerView;
    private DestinationDetailReviewActivityAdapter reviewsAdapter;


    static List<Review> reviewList = new ArrayList<Review>();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destination_detail_review_activity);

        toolbar = (Toolbar) findViewById(R.id.destination_detail_review_toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // back button
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle(" ");

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_close);

        initData();
    }


    private void initData(){

        reviewList = Review.REVIEWS;    //TODO remove, for test only

        recyclerView = (RecyclerView) findViewById(R.id.destination_detail_review_recycleview);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        reviewsAdapter = new DestinationDetailReviewActivityAdapter(this, reviewList, reviewList.size());
        recyclerView.setAdapter(reviewsAdapter);

    }


}
