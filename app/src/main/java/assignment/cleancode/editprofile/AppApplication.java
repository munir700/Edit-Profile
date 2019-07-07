package assignment.cleancode.editprofile;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import androidx.work.Worker;

import com.crashlytics.android.Crashlytics;

import javax.inject.Inject;

import assignment.cleancode.editprofile.di.HasWorkerInjector;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import io.fabric.sdk.android.Fabric;


public class AppApplication extends Application implements HasActivityInjector, HasWorkerInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingInjector;
    @Inject
    DispatchingAndroidInjector<Worker> workerDispatchingAndroidInjector;

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

    @Override
    public AndroidInjector<Worker> workerInjector() {
        return workerDispatchingAndroidInjector;
    }

}
