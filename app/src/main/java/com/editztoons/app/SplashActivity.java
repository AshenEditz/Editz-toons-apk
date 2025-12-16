package com.editztoons.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Find views
        ImageView logo = findViewById(R.id.splash_logo);
        TextView title = findViewById(R.id.splash_title);
        TextView subtitle = findViewById(R.id.splash_subtitle);

        // Animate logo
        Animation fadeIn = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        fadeIn.setDuration(1000);
        logo.startAnimation(fadeIn);

        // Animate title
        Animation slideUp = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        slideUp.setDuration(800);
        slideUp.setStartOffset(500);
        title.startAnimation(slideUp);

        // Animate subtitle
        subtitle.setAlpha(0f);
        subtitle.animate()
                .alpha(1f)
                .setDuration(800)
                .setStartDelay(1000)
                .start();

        // Navigate to main activity
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }, SPLASH_DURATION);
    }
          }
