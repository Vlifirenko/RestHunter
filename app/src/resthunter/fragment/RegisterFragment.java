package resthunter.fragment;

import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.vlifirenko.resthunter.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.rest.RestService;
import org.androidannotations.annotations.sharedpreferences.Pref;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import resthunter.StartActivity;
import resthunter.content.model.User;
import resthunter.content.rest.UserRegisterResponse;
import resthunter.prefs.Prefs_;
import resthunter.rest.RestClient;

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

    @RestService
    RestClient restClient;

    @AfterViews
    void afterViews() {
    }

    @Click(R.id.btn_register)
    void register() {
        if (TextUtils.isEmpty(login.getText())) {
            Toast.makeText(getActivity(), getString(R.string.login_empty), Toast.LENGTH_SHORT).show();
        } else if (password.getText().length() < 6) {
            Toast.makeText(getActivity(), getString(R.string.password_min), Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password.getText())) {
            Toast.makeText(getActivity(), getString(R.string.password_empty), Toast.LENGTH_SHORT).show();
        } else if (!password.getText().toString().equals(password2.getText().toString())) {
            Toast.makeText(getActivity(), getString(R.string.password_not_equal), Toast.LENGTH_SHORT).show();
        } else {
            register(login.getText().toString(), password.getText().toString());
        }
    }

    @Background
    void register(String login, String password) {
        ((StartActivity) getActivity()).holdUser(true);

        MultiValueMap<String, Object> user = new LinkedMultiValueMap<String, Object>();
        user.add("User[email]", login);
        user.add("User[fname]", "fname");
        user.add("User[password]", password);
        user.add("User[repeat_password]", password);
        try {
            UserRegisterResponse response = restClient.userRegister(user);
            if (response.error != null) {
                Log.e(LOG_TAG, response.error.toString());
                ((StartActivity) getActivity()).holdUser(false);
                registerError();
                return;
            }
            User registerUser = new User(Long.parseLong(response.id));
            registerUser.firstName = response.fname;
            registerUser.email = response.email;
            //TODO save user info
        } catch (Exception e) {
            e.printStackTrace();
        }

        ((StartActivity) getActivity()).holdUser(false);
    }

    @UiThread
    void registerError() {
        Toast.makeText(getActivity(), "register error", Toast.LENGTH_SHORT).show();
    }

}
