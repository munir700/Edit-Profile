package assignment.cleancode.editprofile.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

import assignment.cleancode.editprofile.R;
import assignment.cleancode.editprofile.base.BaseActivity;
import assignment.cleancode.editprofile.databinding.ActivityEditProfileBinding;
import assignment.cleancode.editprofile.enums.ViewModelEventsEnum;
import assignment.cleancode.editprofile.viewmodels.EditProfileViewModel;

public class EditProfileActivity extends BaseActivity<EditProfileViewModel, ActivityEditProfileBinding> {

    public static void open(Activity activity) {
        Intent intent = new Intent(activity, EditProfileActivity.class);
        activity.startActivity(intent);
    }


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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
