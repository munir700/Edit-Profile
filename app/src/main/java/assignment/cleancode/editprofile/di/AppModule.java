package assignment.cleancode.editprofile.di;

import android.app.Application;

import javax.inject.Singleton;

import assignment.cleancode.editprofile.di.modules.ViewModelModule;
import assignment.cleancode.editprofile.utils.NetworkUtils;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Munir Ahmad on 07/07/19.
 */


@Module(includes = ViewModelModule.class)
public class AppModule {


    @Provides
    @Singleton
    NetworkUtils provideNetworkUtils(Application application) {
        return new NetworkUtils(application);
    }


}
