package resthunter.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.google.android.gms.internal.id;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.rest.RestService;

import java.util.ArrayList;
import java.util.List;

import resthunter.adapters.views.CategoryItemView;
import resthunter.adapters.views.PlaceItemView;
import resthunter.content.model.Category;
import resthunter.content.model.Place;
import resthunter.content.rest.PlaceListResponse;
import resthunter.content.rest.PlaceResponse;
import resthunter.rest.RestClient;

/**
 * Created by blood_000 on 31.05.2014.
 */
@EBean
public class PlaceListAdapter extends BaseAdapter {

    List<Place> places = new ArrayList<Place>();

    @RootContext
    Context context;

    @RestService
    RestClient restClient;

    @AfterInject
    void initAdapter() {
        getPlaces();
    }

    @Background
    void getPlaces() {
        PlaceListResponse response = restClient.getPlaceList();
        if (response.result != null && response.result.size() > 0) {
            for (PlaceResponse placeResponse : response.result) {
                Place place = new Place(Long.valueOf(placeResponse.id));
                place.name = placeResponse.name;
                place.address = placeResponse.address;
                place.lat = Double.parseDouble(placeResponse.lat);
                place.lng = Double.parseDouble(placeResponse.lng);
                place.phone = placeResponse.phone;
                place.descrpition = placeResponse.descrpition;
                place.workTime = placeResponse.work_time;
                place.link = placeResponse.link;
                place.avgPrice = placeResponse.everage_price;
                place.logo = placeResponse.logo;
                places.add(place);
            }
        } else {
            //TODO get places error
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PlaceItemView placeItemView;
        if (convertView == null) {
            placeItemView = PlaceItemView_.build(context);
        } else {
            placeItemView = (PlaceItemView) convertView;
        }
        placeItemView.bind(getItem(position));
        return placeItemView;
    }

    @Override
    public int getCount() {
        return places.size();
    }

    @Override
    public Place getItem(int position) {
        return places.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
