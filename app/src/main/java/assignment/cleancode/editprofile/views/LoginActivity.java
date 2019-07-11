package assignment.cleancode.editprofile.views;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import assignment.cleancode.editprofile.R;
import assignment.cleancode.editprofile.base.BaseActivity;
import assignment.cleancode.editprofile.databinding.ActivityLoginBinding;
import assignment.cleancode.editprofile.enums.ViewModelEventsEnum;
import assignment.cleancode.editprofile.viewmodels.LoginViewModel;

public class LoginActivity extends BaseActivity<LoginViewModel, ActivityLoginBinding> {

    public static final int RC_SIGN_IN = 1000;

    @Override
    public Class getViewModel() {
        return LoginViewModel.class;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    public void onObserve(ViewModelEventsEnum event, Object eventMessage) {
        super.onObserve(event, eventMessage);
        switch (event) {
            case NO_INTERNET_CONNECTION:
                showAlert(binding.parentLogin, getString(R.string.STR_NO_INTERNET_CONNECTIVITY));
                break;
            case ON_API_REQUEST_FAILURE:
                showAlert(binding.parentLogin, eventMessage.toString());
                break;
            case ON_API_CALL_START:
                showProgress();
                break;
            case ON_API_CALL_STOP:
                hideProgress();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseUser firebaseUser = viewModel.getFirebaseUser();
        if (firebaseUser == null) {
            viewModel.loginUser(this);
        } else if (firebaseUser != null) {
            //EditProfileActivity.open(this);
            // Name, email address, and profile photo Url
            String name = firebaseUser.getDisplayName();
            String email = firebaseUser.getEmail();
            Uri photoUrl = firebaseUser.getPhotoUrl();

            // Check if user's email is verified
            boolean emailVerified = firebaseUser.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = firebaseUser.getUid();
        }


    }

    public void attemptLogin(View view){

    }

    public void loginWithGoogle(View view){
        FirebaseUser firebaseUser = viewModel.getFirebaseUser();
        if (firebaseUser == null) {
            viewModel.loginUser(this);
        } else if (firebaseUser != null) {
            EditProfileActivity.open(this);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                EditProfileActivity.open(this);
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }


}
