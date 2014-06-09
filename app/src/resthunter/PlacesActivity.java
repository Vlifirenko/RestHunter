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
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import resthunter.adapters.CategoryListAdapter;

@EActivity(R.layout.activity_places)
public class PlacesActivity extends FragmentActivity {
    public static final String LOG_TAG = PlacesActivity.class.getName();

    enum Page {SHOW_CATEGORIES, SHOW_PLACES}

    private Page page = Page.SHOW_CATEGORIES;

    @ViewById(R.id.listView)
    ListView categoryList;

    @ViewById(R.id.et_search)
    EditText search;

    @ViewById(R.id.sp_kitchens)
    Spinner kitchens;

    @Bean
    CategoryListAdapter categoryAdapter;

    private ArrayAdapter<CharSequence> kitchenAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    void afterViews() {
        categoryList.setAdapter(categoryAdapter);
        kitchenAdapter = ArrayAdapter.createFromResource(this, R.array.kitchens, android.R.layout.simple_spinner_item);
        kitchenAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kitchens.setAdapter(kitchenAdapter);
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
    void itemClick() {
        if (page == Page.SHOW_CATEGORIES) {
            page = Page.SHOW_PLACES;
        } else {

        }
    }
}
