package resthunter.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.vlifirenko.resthunter.R;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

import resthunter.adapters.views.CategoryItemView;
import resthunter.adapters.views.CategoryItemView_;
import resthunter.content.model.Category;

/**
 * Created by blood_000 on 31.05.2014.
 */
@EBean
public class CategoryListAdapter extends BaseAdapter {

    List<Category> categories = new ArrayList<Category>();

    @RootContext
    Context context;

    @AfterInject
    void initAdapter() {
        for (String str : context.getResources().getStringArray(R.array.categories)) {
            categories.add(new Category(str));
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CategoryItemView categoryItemView;
        if (convertView == null) {
            categoryItemView = CategoryItemView_.build(context);
        } else {
            categoryItemView = (CategoryItemView) convertView;
        }

        categoryItemView.bind(getItem(position));

        return categoryItemView;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Category getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
