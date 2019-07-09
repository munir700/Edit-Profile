package assignment.cleancode.editprofile.views;

import android.content.Intent;
import android.os.Bundle;


import java.util.Arrays;
import java.util.List;

import assignment.cleancode.editprofile.R;
import assignment.cleancode.editprofile.base.BaseActivity;
import assignment.cleancode.editprofile.databinding.ActivityEditProfileBinding;
import assignment.cleancode.editprofile.enums.ViewModelEventsEnum;
import assignment.cleancode.editprofile.viewmodels.EditProfileViewModel;

public class EditProfileActivity extends BaseActivity<EditProfileViewModel, ActivityEditProfileBinding> {

    private static final int RC_SIGN_IN = 1000;

    @Override
    public Class getViewModel() {
        return EditProfileViewModel.class;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_edit_profile;
    }

    @Override
    public void onObserve(ViewModelEventsEnum event, Object eventMessage) {
        super.onObserve(event, eventMessage);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }
}
