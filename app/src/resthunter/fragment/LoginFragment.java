package resthunter.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.vlifirenko.resthunter.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.sharedpreferences.Pref;

import resthunter.MainActivity_;
import resthunter.prefs.Prefs_;

@EFragment(R.layout.fragment_login)
public class LoginFragment extends Fragment {
    public static final String LOG_TAG = LoginFragment.class.getName();

    @ViewById(R.id.et_login)
    EditText login;

    @ViewById(R.id.et_password)
    EditText password;

    @Pref
    Prefs_ prefs;

    @AfterViews
    void afterViews() {
        login.setText(prefs.username().get());
    }

    @Click(R.id.btn_login)
    void login() {
        if (TextUtils.isEmpty(login.getText())) {
            Toast.makeText(getActivity(), getString(R.string.login_empty), Toast.LENGTH_SHORT).show();
        } else {
            prefs.edit()
                    .username()
                    .put(login.getText() != null ? login.getText().toString() : "")
                    .password()
                    .put(password.getText() != null ? password.getText().toString() : "")
                    .apply();
            // TODO rest login
        }
    }

    @Click(R.id.btn_fb)
    void facebook() {
        // TODO facebook login
    }

    @Click(R.id.btn_tw)
    void twitter() {
        // TODO twitter login
    }

    @Click(R.id.btn_vk)
    void vkontakte() {
        getActivity().startActivity(new Intent(getActivity(), MainActivity_.class));
        // TODO vk login
    }

    @Click(R.id.btn_register)
    void register() {
        getFragmentManager().beginTransaction()
                .replace(R.id.container, new RegisterFragment_(), RegisterFragment_.LOG_TAG)
                .addToBackStack(RegisterFragment_.LOG_TAG)
                .commit();
    }

}
