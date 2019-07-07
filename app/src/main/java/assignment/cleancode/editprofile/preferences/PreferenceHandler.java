package assignment.cleancode.editprofile.preferences;

import android.content.Context;

import java.util.HashSet;

import javax.inject.Inject;

/**
 * @author Munir Ahmad on 07/07/2019.
 */
public class PreferenceHandler {

    private Preference preference = null;


    @Inject
    public PreferenceHandler(Context pContext) {
        preference = new Preference(pContext);
    }

    public void removeKeyFromPreference(String key) {
        preference.remove(key);
    }


    public void setString(String key, String value) {
        preference.saveStringInPrefrence(key, value);
    }

    public String getString(String key, String value) {
        return preference.getStringPrefrence(key, value);
    }

    public String getString(String key) {
        return preference.getStringPrefrence(key);
    }


    public boolean isContainBool(String key) {
        return preference.getBooleanFlagPrefrence(key, false);
    }

    public void setBool(String key, boolean value) {
        preference.saveBooleanFlagInPreference(key, value);
    }

}
