package resthunter.fragment;

import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.vlifirenko.resthunter.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

import resthunter.prefs.Prefs_;

@EFragment(R.layout.fragment_register)
public class RegisterFragment extends Fragment {
    public static final String LOG_TAG = RegisterFragment.class.getName();

    @ViewById(R.id.et_login)
    EditText login;

    @ViewById(R.id.et_password)
    EditText password;

    @ViewById(R.id.et_password2)
    EditText password2;

    @ViewById(R.id.login_correct)
    ImageView loginCorrect;

    @ViewById(R.id.password_correct)
    ImageView passwordCorrect;

    @ViewById(R.id.password2_correct)
    ImageView password2Correct;

    @Pref
    Prefs_ prefs;

    @AfterViews
    void afterViews() {
    }

    @Click(R.id.btn_register)
    void register() {
        if (TextUtils.isEmpty(login.getText())) {
            Toast.makeText(getActivity(), getString(R.string.login_empty), Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password.getText())) {
            Toast.makeText(getActivity(), getString(R.string.password_empty), Toast.LENGTH_SHORT).show();
        } else if (!password.getText().toString().equals(password2.getText().toString())) {
            Toast.makeText(getActivity(), getString(R.string.password_not_equal), Toast.LENGTH_SHORT).show();
        } else {
            // TODO rest register
        }
    }

}
