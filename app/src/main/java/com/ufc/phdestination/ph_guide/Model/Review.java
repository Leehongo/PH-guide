package com.ufc.phdestination.ph_guide.Model;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leehongo on 05/10/2017.
 */

public class Review implements Serializable {


    private int reviewId;

    private UserAccount userAccount;

    private int rating;

    private String message;

    public Review() {
    }

    public Review(int reviewId, UserAccount userAccount, int rating, String message) {
        this.reviewId = reviewId;
        this.userAccount = userAccount;
        this.rating = rating;
        this.message = message;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        userAccount = userAccount;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //DUMMY DATA'S


    public static final List<Review> REVIEWS = new ArrayList<Review>();

    static List<UserAccount> userAccountList = UserAccount.USER_ACCOUNTs;

    static int ratings[] = {5,4, 4, 5, 5, 4, 5};

    static String messages[] = {"P*tang ***, ang ganda talaga dito, pinatay ko lahat nang pusher dito para safe lahat at happy",
            "overwhelming dito, ang dami kong dilawan na nakikita, VIP n VIP ako dito at ang aking sistah!",
            "I AM SORRY kung akala nyo sa ibang bansa ito, pero dito lang sa pinas to",
            "kung pwede lang iparetoke ko buong lugar sa bansa kagaya nang gandang place na ito",
            "ay bongga! daming juding dito at welcome na welcome ako",
            "i thought this place is a hoax, it is beautifull, lot of SH***Y Gold digger filipina here",
            "No racist in this place, they make me feel as local here",};

    static {
        // Add some sample items.
        int ctr = 0;
        for (int i = 0; i < ratings.length; i++) {

            ctr = (ctr >= ratings.length)? 0: ctr;

            UserAccount userAccountItem = userAccountList.get(ctr);
            Log.d("LEE", userAccountItem.getFirstName());

            REVIEWS.add(new Review(ctr, userAccountItem,ratings[ctr],messages[ctr]));
            ctr++;
        }
    }
}
