package assignment.cleancode.editprofile.viewmodels;

import android.app.Activity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

import assignment.cleancode.editprofile.base.BaseViewModel;
import assignment.cleancode.editprofile.managers.GoogleManager;

public class LoginViewModel extends BaseViewModel {

    @Inject
    GoogleManager googleManager;

    @Inject
    public LoginViewModel() {

    }

    public FirebaseUser getFirebaseUser() {
        return FirebaseAuth.getInstance().getCurrentUser();
    }

    public void loginUser(Activity activity) {
        googleManager.loginWithGoogle(activity, this);

    }


}
