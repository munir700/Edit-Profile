package assignment.cleancode.editprofile.viewmodels;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

import assignment.cleancode.editprofile.base.BaseViewModel;
import assignment.cleancode.editprofile.managers.GoogleManager;
import assignment.cleancode.editprofile.models.validationmodels.EditProfileModel;

public class EditProfileViewModel extends BaseViewModel {

    EditProfileModel editProfile;

    @Inject
    GoogleManager googleManager;

    @Inject
    public EditProfileViewModel() {

    }

    public FirebaseUser getUserInfo() {
        return googleManager.getFirebaseUser();
    }

    public EditProfileModel getUserInfo(Context context) {
        if (editProfile == null) {
            editProfile = new EditProfileModel(context);
            FirebaseUser user = getUserInfo();
            editProfile.setName(user.getDisplayName());
            editProfile.setEmail(user.getEmail());
            editProfile.setPhoneNumber(user.getPhoneNumber());
        }
        return editProfile;
    }


    public MutableLiveData<FirebaseUser> updateProfile(String name, String imageUrl) {
        return googleManager.updateUserProfile(this, name, imageUrl);
    }


}
