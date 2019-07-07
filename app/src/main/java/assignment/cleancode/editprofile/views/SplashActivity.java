package assignment.cleancode.editprofile.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import assignment.cleancode.editprofile.R;

public class SplashActivity extends AppCompatActivity {

    public static final String TAG = SplashActivity.class.getSimpleName();

    private Handler handler = null;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        handler = new Handler();
        handler.postDelayed(runnable, 2000);

    }


    @Override
    public void onBackPressed() {
        try {
            handler.removeCallbacks(runnable);
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onBackPressed();
    }
}
