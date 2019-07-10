package assignment.cleancode.editprofile.di.modules;


import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import assignment.cleancode.editprofile.di.ViewModelFactory;
import assignment.cleancode.editprofile.di.ViewModelKey;
import assignment.cleancode.editprofile.viewmodels.LoginViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Munir Ahmad on 07/07/19.
 */

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel.class)
    abstract ViewModel bindMovieDetailViewModel(LoginViewModel editProfileViewModel);


    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);


}