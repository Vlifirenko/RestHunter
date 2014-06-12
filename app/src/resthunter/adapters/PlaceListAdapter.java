package resthunter.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

import resthunter.adapters.views.PlaceItemView;
import resthunter.adapters.views.PlaceItemView_;
import resthunter.content.model.Place;

/**
 * Created by blood_000 on 31.05.2014.
 */
@EBean
public class PlaceListAdapter extends BaseAdapter {

    List<Place> places = new ArrayList<Place>();

    @RootContext
    Context context;

    @AfterInject
    void initAdapter() {
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
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
