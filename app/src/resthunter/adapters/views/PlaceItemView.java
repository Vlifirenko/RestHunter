package resthunter.adapters.views;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.internal.id;
import com.vlifirenko.resthunter.R;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

import resthunter.content.model.Category;
import resthunter.content.model.Place;

/**
 * Created by blood_000 on 31.05.2014.
 */
@EViewGroup(R.layout.view_place_item)
public class PlaceItemView extends LinearLayout {

    private final Context context;

    @ViewById(R.id.name)
    TextView name;

    @ViewById(R.id.distance)
    TextView distance;

    @ViewById(R.id.address)
    TextView address;

    @ViewById(R.id.work_time)
    TextView workTime;

    @ViewById(R.id.avg_price)
    TextView avgPrice;

    @ViewById(R.id.likes)
    TextView likes;

    @ViewById(R.id.rating)
    TextView rating;

    @ViewById(R.id.kitchen)
    TextView kitchen;

    @ViewById(R.id.img)
    ImageView img;

    public PlaceItemView(Context context) {
        super(context);
        this.context = context;
    }

    public void bind(Place place) {
        name.setText(place.name);
        distance.setText(String.valueOf(place.distance));
        address.setText(place.address);
        workTime.setText(place.workTime);
        avgPrice.setText(place.avgPrice);
        likes.setText(String.valueOf(place.likes));
        rating.setText(String.valueOf(place.rating));
        kitchen.setText(context.getResources().getStringArray(R.array.kitchens)[place.kitchen]);
        //TODO set img
    }
}
