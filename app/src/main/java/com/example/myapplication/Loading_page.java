package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class Loading_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_page);

        ImageView imgView = (ImageView) findViewById(R.id.image_view_1);

        ObjectAnimator animation;
        animation = ObjectAnimator.ofFloat(imgView, "rotation", 0.0f, 360f);

        animation.setDuration(4000);

        animation.setInterpolator(new AccelerateDecelerateInterpolator());

        animation.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity( new Intent(Loading_page.this, Main.class));
            }
        });

        animation.start();
    }
}