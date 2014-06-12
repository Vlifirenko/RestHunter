package resthunter;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import com.vlifirenko.resthunter.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;

import java.util.ArrayList;

import resthunter.adapters.PlaceListAdapter;
import resthunter.content.model.Place;
import resthunter.content.rest.PlaceListResponse;
import resthunter.content.rest.PlaceResponse;
import resthunter.rest.RestClient;

@EActivity(R.layout.activity_places)
public class PlacesListActivity extends FragmentActivity {
    public static final String LOG_TAG = PlacesListActivity.class.getName();

    @ViewById(R.id.listView)
    ListView list;

    @ViewById(R.id.et_search)
    EditText search;

    @ViewById(R.id.sp_kitchens)
    Spinner kitchens;

    @Bean
    PlaceListAdapter placeAdapter;

    private ArrayAdapter<CharSequence> kitchenAdapter;

    @RestService
    RestClient restClient;

    @ViewById
    View progressIndicator;

    public void showProgressIndicator(boolean flag) {
        progressIndicator.setVisibility(flag ? View.VISIBLE : View.GONE);
    }

    @UiThread
    public void holdUser(boolean flag) {
        showProgressIndicator(flag);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    void afterViews() {
        getPlaces();
        kitchenAdapter = ArrayAdapter.createFromResource(this, R.array.kitchens, android.R.layout.simple_spinner_item);
        kitchenAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kitchens.setAdapter(kitchenAdapter);
    }

    @Background
    void getPlaces() {
        holdUser(true);
        ArrayList<Place> places = new ArrayList<Place>();
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
            placeAdapter.setPlaces(places);
            showList();
        } else {
            //TODO get places error
        }
        holdUser(false);
    }

    @UiThread
    void showList() {
        list.setAdapter(placeAdapter);
    }

    @Click(R.id.btn_back)
    void back() {
        onBackPressed();
    }

    @Click(R.id.map)
    void map() {
        //TODO show map
    }

    @ItemClick
    public void listItemClicked(Place place) {
        //TODO go to ShowPlaceActivity
    }
}
