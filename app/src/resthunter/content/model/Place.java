package resthunter.content.model;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by blood_000 on 16.05.2014.
 */
public class Place extends Model implements Parcelable {

    public String name;
    public String address;
    public String lat;
    public String lng;
    public String phone;
    public String descrpition;
    public String workTime;
    public String link;
    public String avgPrice;
    public String logo;

    public Place() {
    }

    public Place(long id) {
        this.id = id;
    }

    @Override
    public ContentValues toCV() {
        return null;
    }

    @Override
    public String getPrimaryKeyName() {
        return null;
    }

    @Override
    public Uri getContentUri() {
        return null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
