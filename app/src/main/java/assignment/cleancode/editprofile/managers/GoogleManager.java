package assignment.cleancode.editprofile.managers;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import assignment.cleancode.editprofile.viewmodels.LoginViewModel;

import static assignment.cleancode.editprofile.views.LoginActivity.RC_SIGN_IN;

public class GoogleManager {

    private FirebaseAuth auth;

    @Inject
    public GoogleManager(){
        auth = FirebaseAuth.getInstance();
    }

    public void loginWithGoogle(Activity activity, final LoginViewModel viewModel){
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
    }

    public void signupWithGoogle(Activity activity, final LoginViewModel viewModel, String email, String password){
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                    }
                });


    }

}
