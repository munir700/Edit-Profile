package assignment.cleancode.editprofile;

import android.app.Activity;
import android.app.Application;
import android.content.Context;


import com.crashlytics.android.Crashlytics;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import io.fabric.sdk.android.Fabric;
import assignment.cleancode.editprofile.di.*;


public class AppApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingInjector;


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }


    @Override
    public void onCreate() {
        super.onCreate();

        Fabric.with(this, new Crashlytics());

        //DaggerNetComponent.builder().application(this).build().inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingInjector;
    }


}
