package com.ufc.phdestination.ph_guide.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ideapad 300-15 on 04/12/2016.
 */

public class Destination implements Serializable {

    int destinationId;
    String destinationName;
    String destinationDescription;
    String image;


    public Destination() {
    }

    public Destination(int destinationId, String destinationName, String destinationDescription, String image) {
        this.destinationId = destinationId;
        this.destinationName = destinationName;
        this.destinationDescription = destinationDescription;
        this.image = image;
    }

    public int getDestinationId() {

        return destinationId;
    }

    public void setDestinationId(int destinationId) {

        this.destinationId = destinationId;
    }

    public String getDestinationName() {

        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getDestinationDescription() {

        return destinationDescription;
    }

    public void setDestinationDescription(String destinationDescription) {
        this.destinationDescription = destinationDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    //for dummy datas
    /**
     * An array of sample (dummy) items.
     */

    public static final List<Destination> FEATUREDDESTINATIONS = new ArrayList<Destination>();

    static String featuredDestinationName[] = {"Coron", "Masjid Dimaukom(Pink Mosque)", "Tinuy-an Falls", "Sumaguing Cave"};
    static String featuredDestinationImages[] = {"http://8wonderstravel.com/wp-content/uploads/2015/09/coron-island-philippines.jpg",
            "http://s6.postimg.org/tolhdj7q9/Pink_Mosque_Masjid_Dimaukom_Philippines_2.jpg",
            "https://mindanaoescapades.files.wordpress.com/2010/01/dsc_0049-1.jpg",
            "http://www.theodora.com/wfb/photos/philippines/sumaguing_cave_sagada_philippines_photo_imfip.jpg"};

    static {
        // Add some sample items.
        int ctr = 0;
        for (int i = 0; i < featuredDestinationName.length; i++) {

            ctr = (ctr >= featuredDestinationName.length)? 0: ctr;

            FEATUREDDESTINATIONS.add(new Destination(i,featuredDestinationName[ctr],featuredDestinationName[ctr] + "description" + i,featuredDestinationImages[ctr]));
            ctr++;
        }
    }

    public static final List<Destination> TOPDESTINATIONS = new ArrayList<Destination>();

    static String topDestinationName[] = {"Palawan", "Bohol", "Biliran", "Bacolod", "Cebu"};
    static String topDestinationImages[] = {"http://www.gophilippinestravel.ph/wp-content/uploads/2012/12/0006_nido31.jpg",
            "http://cheaptravelandtours.com/wordpress/wp-content/uploads/2016/07/Bohol-4a.jpg",
            "http://3c9bl93o71m619w9kn2rfwinkdh.wpengine.netdna-cdn.com/wp-content/uploads/2014/09/View-of-Maripipi-Volcano-from-Sambawan-Island.jpg",
            "http://8list.ph/wp-content/uploads/2015/09/8-Ways-to-Live-Like-a-Local-in-Bacolod_t.jpg",
            "http://www.rnrlifestyle.com/wp-content/uploads/2015/09/cebu1.jpg"};

    static {
        // Add some sample items.
        int ctr = 0;
        for (int i = 0; i < topDestinationName.length; i++) {

            ctr = (ctr >= topDestinationName.length)? 0: ctr;

            TOPDESTINATIONS.add(new Destination(i,topDestinationName[ctr],topDestinationName[ctr] + "description" + i,topDestinationImages[ctr]));
            ctr++;
        }
    }

    public static final List<Destination> TRENDINGDESTINATIONS = new ArrayList<Destination>();

    static String trendingDestinationName[] = {"Calaguas Island", "Jomalig Island", "Vigan", "Alibijaban", "Hulugan Falls"};
    static String trendingDestinationImages[] = {"http://i971.photobucket.com/albums/ae198/chasingphilippines/TRIPS/Calaguas%20Island/4517594802_60a6376594_b.jpg",
            "https://i2.wp.com/www.traveling-up.com/wp-content/uploads/2014/06/jomalig-quezon-cove-beach-swimming.jpg",
            "http://thefilipinoexpat.com/wp-content/uploads/2014/09/Vigan.jpg",
            "http://www.freedomwall.net/files/2014/09/alibijaban.jpg",
            "http://1.bp.blogspot.com/-3c8IkR_qBI4/VqSxk-Mu0oI/AAAAAAAAOps/7jb4XKVbWqM/s1600/DSC_0964.JPG"};

    static {
        // Add some sample items.
        int ctr = 0;
        for (int i = 0; i < trendingDestinationName.length; i++) {

            ctr = (ctr >= trendingDestinationName.length)? 0: ctr;

            TRENDINGDESTINATIONS.add(new Destination(i,trendingDestinationName[ctr],trendingDestinationName[ctr] + "description" + i,trendingDestinationImages[ctr]));
            ctr++;
        }
    }


}
