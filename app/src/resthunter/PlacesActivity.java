package resthunter;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ListView;

import com.google.android.gms.maps.GoogleMap;
import com.vlifirenko.resthunter.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import resthunter.adapters.CategoryListAdapter;

@EActivity(R.layout.activity_places)
public class PlacesActivity extends FragmentActivity {
    public static final String LOG_TAG = PlacesActivity.class.getName();

    @ViewById(R.id.listView)
    ListView categoryList;

    @Bean
    CategoryListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    void afterViews() {
        categoryList.setAdapter(adapter);
    }
}
