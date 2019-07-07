package assignment.cleancode.editprofile.views;

import androidx.databinding.ViewDataBinding;

import android.os.Bundle;

import assignment.cleancode.editprofile.R;
import assignment.cleancode.editprofile.base.BaseActivity;
import assignment.cleancode.editprofile.base.BaseViewModel;

public class MainActivity<vm extends BaseViewModel, db extends ViewDataBinding> extends BaseActivity {

    @Override
    public Class getViewModel() {
        return BaseViewModel.class;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
