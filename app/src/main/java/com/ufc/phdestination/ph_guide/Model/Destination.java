package com.ufc.phdestination.ph_guide.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ideapad 300-15 on 04/12/2016.
 */

public class Destination {

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
    public static final List<Destination> ITEMS = new ArrayList<Destination>();

    static String image1 = "http://www.gophilippinestravel.ph/wp-content/uploads/2012/12/0006_nido31.jpg";
    static String image2 = "http://cheaptravelandtours.com/wordpress/wp-content/uploads/2016/07/Bohol-4a.jpg";
    static String image3 = "http://3c9bl93o71m619w9kn2rfwinkdh.wpengine.netdna-cdn.com/wp-content/uploads/2014/09/View-of-Maripipi-Volcano-from-Sambawan-Island.jpg";
    static String image4 = "http://8list.ph/wp-content/uploads/2015/09/8-Ways-to-Live-Like-a-Local-in-Bacolod_t.jpg";
    static String image5 = "http://www.rnrlifestyle.com/wp-content/uploads/2015/09/cebu1.jpg";

    static String name[] = {"Palawan", "Bohol", "Biliran", "Bacolod", "Cebu"};
    static String images[] = {image1, image2, image3, image4, image5};

    static {
        // Add some sample items.
        int ctr = 0;
        for (int i = 0; i < 5; i++) {

            ctr = (ctr >= name.length)? 0: ctr;

            ITEMS.add(new Destination(i,name[ctr],name[ctr] + "description" + i,images[ctr]));
            ctr++;
        }
    }


}
