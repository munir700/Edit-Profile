package assignment.cleancode.editprofile.views;

import android.os.Bundle;

import assignment.cleancode.editprofile.R;
import assignment.cleancode.editprofile.base.BaseActivity;
import assignment.cleancode.editprofile.databinding.ActivityEditProfileBinding;
import assignment.cleancode.editprofile.enums.ViewModelEventsEnum;
import assignment.cleancode.editprofile.viewmodels.EditProfileViewModel;

public class EditProfileActivity extends BaseActivity<EditProfileViewModel, ActivityEditProfileBinding> {

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
}
