package resthunter;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.vlifirenko.resthunter.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

import resthunter.fragment.LevelPageFragment_;
import resthunter.fragment.NewsSliderFragment_;
import resthunter.prefs.Prefs_;

@EActivity(R.layout.activity_main)
public class MainActivity extends FragmentActivity {

    public static final String LOG_TAG = MainActivity.class.getName();

    @ViewById(R.id.img_profile)
    ImageView imgProfile;

    @ViewById(R.id.profile_name)
    TextView profileName;

    @ViewById(R.id.profile_level)
    TextView profileLevel;

    @ViewById(R.id.profile_progress)
    ProgressBar profileProgress;

    @ViewById(R.id.inventory_count)
    TextView inventoryCount;

    @ViewById(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @ViewById(R.id.left_drawer)
    ListView leftDrawer;

    private String[] mPlanetTitles;

    @Pref
    Prefs_ prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    void afterViews() {
        mPlanetTitles = getResources().getStringArray(R.array.left_menu);
        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        leftDrawer.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mPlanetTitles));
        leftDrawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 1:
                        // TODO to profile
                    default:
                        break;
                }
                drawerLayout.closeDrawers();
            }
        });
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new NewsSliderFragment_(), NewsSliderFragment_.LOG_TAG)
                .addToBackStack(NewsSliderFragment_.LOG_TAG)
                .commitAllowingStateLoss();
    }

    @Click(R.id.ll_profile)
    void profile() {
        //TODO to profile
    }

    @Click(R.id.btn_menu)
    void showMenu() {
        drawerLayout.openDrawer(leftDrawer);
    }

    @Click(R.id.btn_location)
    void location() {
        // TODO to location
    }

    @Click(R.id.ll_inventory)
    void inventory() {
        // TODO to inventory
    }

    @Click(R.id.events)
    void events() {
        // TODO to events
    }

    @Click(R.id.places)
    void places() {
        // TODO to places
    }

    @Click(R.id.marks)
    void marks() {
        // TODO to marks
    }

    @Click(R.id.tasks)
    void tasks() {
        // TODO to tasks
    }
}
