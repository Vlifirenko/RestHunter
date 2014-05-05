package resthunter.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.vlifirenko.resthunter.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_news_slider)
public class NewsSliderFragment extends Fragment {
    public static final String LOG_TAG = NewsSliderFragment.class.getName();

    @ViewById(R.id.pager)
    ViewPager pager;

    private PagerAdapter mPagerAdapter;

    @AfterViews
    void afterViews() {
        //mPagerAdapter = new ScreenSlidePagerAdapter(getActivity().getSupportFragmentManager());
        pager.setAdapter(mPagerAdapter);
    }

    @Click(R.id.slide_left)
    void slideLeft() {
        if (pager.getCurrentItem() > 0)
            pager.setCurrentItem(pager.getCurrentItem() - 1);
    }

    @Click(R.id.slide_right)
    void slideRight() {
        if (pager.getCurrentItem() < pager.getChildCount() - 1)
            pager.setCurrentItem(pager.getCurrentItem() + 1);
    }

}
