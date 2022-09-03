package com.excavanger.remember.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.excavanger.remember.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private final FirebaseAuth mAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseUser currentUser = mAuth.getCurrentUser();
        transitionSplashScreen(currentUser);
    }

    private void transitionSplashScreen(FirebaseUser currentUser) {
        int SPLASH_SCREEN_TIME_OUT = 2000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    if (currentUser == null){
                        Intent homeActivity = new Intent(MainActivity.this, VideoActivity.class);
                        startActivity(homeActivity);
                    }else{
                        Intent loginActivity = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(loginActivity);
                    }
                    finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}