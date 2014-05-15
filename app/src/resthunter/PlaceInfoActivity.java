package resthunter;

import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.vlifirenko.resthunter.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

import resthunter.prefs.Prefs_;

@EActivity(R.layout.activity_place_info)
public class PlaceInfoActivity extends FragmentActivity {

    public static final String LOG_TAG = PlaceInfoActivity.class.getName();

    @ViewById(R.id.iv_type)
    ImageView typeImg;

    @ViewById(R.id.tv_type)
    TextView typeTxt;

    @Pref
    Prefs_ prefs;

    @AfterViews
    void afterViews() {

    }

    @Click(R.id.btn_back)
    void btnBack() {
        onBackPressed();
    }
}
