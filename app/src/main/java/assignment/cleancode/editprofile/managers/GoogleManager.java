package assignment.cleancode.editprofile.managers;

import android.app.Activity;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import assignment.cleancode.editprofile.enums.ViewModelEventsEnum;
import assignment.cleancode.editprofile.utils.NetworkUtils;
import assignment.cleancode.editprofile.viewmodels.EditProfileViewModel;
import assignment.cleancode.editprofile.viewmodels.LoginViewModel;

import static assignment.cleancode.editprofile.views.LoginActivity.RC_SIGN_IN;

public class GoogleManager {

    private FirebaseAuth auth;

    @Inject
    NetworkUtils networkUtils;


    @Inject
    public GoogleManager() {
        auth = FirebaseAuth.getInstance();
    }


    public FirebaseUser getFirebaseUser() {
        return FirebaseAuth.getInstance().getCurrentUser();
    }

    public void loginWithGoogle(Activity activity, final LoginViewModel viewModel) {
        if (networkUtils.isConnectedToInternet()) {

            // Choose authentication providers
            List<AuthUI.IdpConfig> providers = Arrays.asList(
                    new AuthUI.IdpConfig.GoogleBuilder().build());

            // Create and launch sign-in intent
            activity.startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(providers)
                            .build(),
                    RC_SIGN_IN);
        } else {
            viewModel.notifyObserver(ViewModelEventsEnum.NO_INTERNET_CONNECTION, null);
        }
    }

    public void signupWithGoogle(Activity activity, final LoginViewModel viewModel, String email, String password) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                    }
                });

    }

    public void signinEmailPassword(Activity activity, final LoginViewModel viewModel, String email, String password) {


    }


    public MutableLiveData<FirebaseUser> updateUserProfile(final EditProfileViewModel viewModel, String name, String imageUrl) {

        final MutableLiveData<FirebaseUser> userMutableLiveData = new MutableLiveData<>();

        if (networkUtils.isConnectedToInternet()) {


            final FirebaseUser user = getFirebaseUser();

            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName(name)
                    .setPhotoUri(Uri.parse(imageUrl))
                    //.setPhotoUri(Uri.parse("https://example.com/jane-q-user/profile.jpg"))
                    .build();

            user.updateProfile(profileUpdates)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                userMutableLiveData.postValue(user);
                            }
                        }
                    });

        } else {
            viewModel.notifyObserver(ViewModelEventsEnum.NO_INTERNET_CONNECTION, null);
        }
        return userMutableLiveData;
    }


    public MutableLiveData<FirebaseUser> updatePassword(final EditProfileViewModel viewModel, String password) {

        final MutableLiveData<FirebaseUser> userMutableLiveData = new MutableLiveData<>();

        if (networkUtils.isConnectedToInternet()) {

            final FirebaseUser user = getFirebaseUser();
            user.updatePassword(password)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                userMutableLiveData.postValue(user);
                            }
                        }
                    });
        } else {
            viewModel.notifyObserver(ViewModelEventsEnum.NO_INTERNET_CONNECTION, null);
        }
        return userMutableLiveData;
    }

    public MutableLiveData<FirebaseUser> updateEmai(final EditProfileViewModel viewModel, String password) {
        final MutableLiveData<FirebaseUser> userMutableLiveData = new MutableLiveData<>();
        if (networkUtils.isConnectedToInternet()) {
            final FirebaseUser user = getFirebaseUser();
            user.updateEmail(password)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                userMutableLiveData.postValue(user);
                            }
                        }
                    });
        } else {
            viewModel.notifyObserver(ViewModelEventsEnum.NO_INTERNET_CONNECTION, null);
        }
        return userMutableLiveData;
    }
}
