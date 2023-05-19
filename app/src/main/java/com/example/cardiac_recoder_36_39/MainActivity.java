package com.example.cardiac_recoder_36_39;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN = 5000; // 5 seconds delay for splash screen
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hide the action bar
        Objects.requireNonNull(getSupportActionBar()).hide();

        //grab the progress bar
        progressBar = findViewById(R.id.progressbar);
        progress();
        start();
    }

    //progress bar function
    public void progress(){
        //create a thread
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //loop through the progress bar
                for(int i = 0; i < 100; i++){
                    try {
                        //sleep for 100 milliseconds
                        Thread.sleep(100);
                        //set the progress bar
                        progressBar.setProgress(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        //start the thread
        thread.start();
    }

    //start function
    public void start(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //create a new intent
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                //start the activity
                startActivity(intent);
                //finish the activity
                finish();
            }
        }, SPLASH_SCREEN);
    }
}