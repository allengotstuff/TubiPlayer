package com.tubitv.media.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

/**
 * Created by allensun on 8/3/17.
 * on Tubitv.com, allengotstuff@gmail.com
 * <p>
 * this is the wrapper class store a representation of AdBreak ojects, could be a list of ad {@link MediaModel}
 */
public abstract class AdMediaModel {

    private List<MediaModel> listOfAds;

    public AdMediaModel(@NonNull List<MediaModel> listOfAds) {
        this.listOfAds = listOfAds;
    }

    @Nullable
    public abstract MediaModel nextAD();

    public List<MediaModel> getListOfAds() {
        return listOfAds;
    }

    public void popFirstAd() {
        if (listOfAds != null && listOfAds.size() > 0) {
            listOfAds.remove(0);
        }
    }

}
