package assignment.cleancode.editprofile.di.modules;


import androidx.lifecycle.ViewModelProvider;

import assignment.cleancode.editprofile.di.ViewModelFactory;
import dagger.Binds;
import dagger.Module;

/**
 * Created by Munir Ahmad on 07/07/19.
 */

@Module
public abstract class ViewModelModule {




    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);



}