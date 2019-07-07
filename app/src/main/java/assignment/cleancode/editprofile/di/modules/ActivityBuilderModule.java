package assignment.cleancode.editprofile.di.modules;

/**
 * Created by Munir Ahmad on 07/07/19.
 */


import assignment.cleancode.editprofile.views.SplashActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract SplashActivity splashActivity();



}