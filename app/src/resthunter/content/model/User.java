package resthunter.content.model;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by blood_000 on 16.05.2014.
 */
public class User extends Model implements Parcelable {

    public String firstName;
    public String lastName;
    public String email;
    public String role;
    public String birthday;
    public String sex;
    public String avatar;
    public String city;
    public String lang;

    public User() {
    }

    public User(long id) {
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
