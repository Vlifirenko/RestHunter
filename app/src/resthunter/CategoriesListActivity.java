package resthunter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import org.androidannotations.annotations.ViewById;

import resthunter.adapters.CategoryListAdapter;
import resthunter.content.model.Category;

@EActivity(R.layout.activity_places)
public class CategoriesListActivity extends FragmentActivity {
    public static final String LOG_TAG = CategoriesListActivity.class.getName();

    @ViewById(R.id.listView)
    ListView list;

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
        list.setAdapter(categoryAdapter);
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
    public void listViewItemClicked(Category category) {
        startActivity(new Intent(this, PlacesListActivity_.class));
    }
}
