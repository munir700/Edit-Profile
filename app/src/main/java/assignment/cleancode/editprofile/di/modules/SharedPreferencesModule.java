package assignment.cleancode.editprofile.di.modules;

import android.app.Application;

import javax.inject.Singleton;

import assignment.cleancode.editprofile.preferences.PreferenceHandler;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Munir Ahmad on 3/7/2018.
 */

@Module
public class SharedPreferencesModule {

    @Provides
    @Singleton
    PreferenceHandler provideSharedPreferences(Application application) {
        PreferenceHandler preferenceHandler = new PreferenceHandler(application);
        return preferenceHandler;
    }
}
