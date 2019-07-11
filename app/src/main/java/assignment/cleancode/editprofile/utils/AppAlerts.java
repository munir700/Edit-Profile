package assignment.cleancode.editprofile.utils;

import android.content.Context;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;

import assignment.cleancode.editprofile.R;


public class AppAlerts {

    public static void showSnack(View progressBar, Context context, String value) {

        Snackbar snackbar = Snackbar.make(progressBar, value, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));

        snackbar.show();
    }




}
