package assignment.cleancode.editprofile.managers;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import assignment.cleancode.editprofile.preferences.PreferenceHandler;

public class AppManager {

    private Context appContext;
    private Application application;
    private PreferenceHandler preferenceHandler;

    @Inject
    public AppManager(Application application, PreferenceHandler preferenceHandler) {
        this.application = application;
        appContext = application.getApplicationContext();
        this.preferenceHandler = preferenceHandler;
    }

    public Context getContext() {
        return appContext;
    }

    public void setContext(Context appContext) {
        this.appContext = appContext;
    }

    public Application getApplication() {
        return application;
    }

    public String getResourceString(int resourceName) {
        try {
            return getContext().getString(resourceName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "dfgd";
    }
}
