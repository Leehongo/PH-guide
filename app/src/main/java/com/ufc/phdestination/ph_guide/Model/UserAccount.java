package com.ufc.phdestination.ph_guide.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leehongo on 05/10/2017.
 */

public class UserAccount {

    private int userId;

    private String image;

    private String FirstName;

    private String LastName;


    public UserAccount() {
    }

    public UserAccount(int userId, String image, String firstName, String lastName) {
        this.userId = userId;
        this.image = image;
        FirstName = firstName;
        LastName = lastName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public static final List<UserAccount> USER_ACCOUNTs = new ArrayList<UserAccount>();

    static String userFirstNames[] = {"Rodrigo", "NoyNoy", "Gloria", "Xander", "Vice","Donald","Barack"};

    static String userLastNames[] = {"Duterte", "Aquino", "Arroyo", "Ford","Ganda","Trump","Obama"};

    static String userImages[] = {"http://newsinfo.inquirer.net/wp-content/blogs.dir/10/files/2016/10/duterte.jpg",
            "http://getrealphilippines.com/blog/wp-content/uploads/2013/10/noynoy_aquino6.jpg",
            "http://cdn.newsapi.com.au/image/v1/7dce116a264a514992b7817914c43e5e",
            "http://www.zeibiz.com/wp-content/uploads/2017/10/Marlou-Arizala-Xander-Ford-New-Look-Revealed-Rated-K.jpg",
            "https://kpbs.media.clients.ellingtoncms.com/img/events/2017/vice.jpg",
            "http://i2.cdn.cnn.com/cnnnext/dam/assets/170822235920-08-trump-phoenix-0822-exlarge-169.jpg",
            "http://cdn01.cdn.justjared.com/wp-content/uploads/headlines/2017/08/barack-obama-tweet-second-most-liked.jpg",};

    static {
        // Add some sample items.
        int ctr = 0;
        for (int i = 0; i < userFirstNames.length; i++) {

            ctr = (ctr >= userFirstNames.length)? 0: ctr;

            USER_ACCOUNTs.add(new UserAccount(ctr,userImages[ctr],userFirstNames[ctr],userLastNames[ctr]));
            ctr++;
        }
    }

}
