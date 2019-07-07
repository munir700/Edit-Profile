package assignment.cleancode.editprofile.di.modules;

/**
 * Created by Munir Ahmad on 07/07/19.
 */


import assignment.cleancode.editprofile.views.EditProfileActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract EditProfileActivity bindMainActivity();

}