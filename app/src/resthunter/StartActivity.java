package resthunter;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.vlifirenko.resthunter.R;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.sharedpreferences.Pref;

import resthunter.fragment.LoginFragment_;
import resthunter.prefs.Prefs_;

@EActivity(R.layout.activity_start)
public class StartActivity extends FragmentActivity {

    public static final String LOG_TAG = StartActivity.class.getName();

    @Pref
    Prefs_ prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO
        //BugSenseHandler.initAndStartSession(this, FupmsTmaApplication.BUGSENSE_KEY);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new LoginFragment_(), LoginFragment_.LOG_TAG)
                .addToBackStack(LoginFragment_.LOG_TAG)
                .commitAllowingStateLoss();
    }
}
