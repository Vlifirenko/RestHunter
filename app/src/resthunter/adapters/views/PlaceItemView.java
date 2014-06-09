package resthunter.adapters.views;

import android.content.Context;
import android.widget.ImageView;
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
public class PlaceItemView extends LinearLayout {

    private static final int[] imgs = {R.drawable.ic_category_restaurant, R.drawable.ic_category_bar,
            R.drawable.ic_category_cafe, R.drawable.ic_category_sushi, R.drawable.ic_category_pizzeria,
            R.drawable.ic_category_hookahbar, R.drawable.ic_category_bistro};

    private final Context context;

    @ViewById(R.id.img)
    ImageView img;

    @ViewById(R.id.name)
    TextView name;

    @ViewById(R.id.behind)
    TextView behind;

    @ViewById(R.id.behind_txt)
    TextView behindTxt;

    public PlaceItemView(Context context) {
        super(context);
        this.context = context;
    }

    public void bind(Category category) {
        img.setImageResource(imgs[category.id]);
        name.setText(category.name);
        behind.setText(String.valueOf(category.behind));
        if (category.behind > 0)
            behindTxt.setText(context.getString(R.string.behind));
        else
            behindTxt.setText(context.getString(R.string.behind_not));
    }
}
