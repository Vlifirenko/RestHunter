package resthunter.prefs;

import org.androidannotations.annotations.sharedpreferences.SharedPref;

@SharedPref(value = SharedPref.Scope.APPLICATION_DEFAULT)
public interface Prefs {

    public String username();

    public String password();

    public boolean authorized();
}
