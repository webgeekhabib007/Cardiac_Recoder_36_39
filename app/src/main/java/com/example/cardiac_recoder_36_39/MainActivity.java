package com.example.cardiac_recoder_36_39;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

/**
 * This class is used to start the app
 */
public class MainActivity extends AppCompatActivity {
    private static final int SPLASH_SCREEN = 5000; // 5 seconds delay for splash screen
    ProgressBar progressBar;
    private FirebaseAuth mAuth;

    /**
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start();
    }

    /**
     * This method is used to start the app
     */
    public void start(){
        new Handler().postDelayed(new Runnable() {
            /**
             * This method is used to start the app
             */
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(),WelcomeActivity.class);
                startActivity(intent);
            }
        },SPLASH_SCREEN);
    }
}