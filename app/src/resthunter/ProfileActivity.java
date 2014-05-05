package resthunter;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.vlifirenko.resthunter.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class ProfileActivity extends FragmentActivity {

    public static final String LOG_TAG = ProfileActivity.class.getName();

    @ViewById(R.id.iv_avatar)
    ImageView avatar;

    @ViewById(R.id.tv_nickname)
    TextView nickname;

    @ViewById(R.id.tv_email)
    TextView email;

    @ViewById(R.id.tv_birthday)
    TextView birthday;

    @ViewById(R.id.iv_gender)
    ImageView gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    void afterViews() {
    }
}
