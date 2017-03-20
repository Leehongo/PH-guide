package com.ufc.phdestination.ph_guide.View.Interface;

import com.ufc.phdestination.ph_guide.Model.Destination;

import java.util.List;

/**
 * Created by Ideapad 300-15 on 20/03/2017.
 */

public interface AsyncResponse {
    void processFinish(List<Destination> destinationList);
}
