package resthunter.adapters.views;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vlifirenko.resthunter.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import resthunter.content.model.Category;

/**
 * Created by blood_000 on 31.05.2014.
 */
@EViewGroup(R.layout.view_places_category_item)
public class CategoryItemView extends LinearLayout{

    @ViewById(R.id.name)
    TextView name;

    public CategoryItemView(Context context) {
        super(context);
    }

    public void bind(Category category) {
        name.setText(category.name);
    }
}
