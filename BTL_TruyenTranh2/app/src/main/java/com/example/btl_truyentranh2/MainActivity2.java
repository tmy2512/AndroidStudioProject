package com.example.btl_truyentranh2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    Animation zoom_in;
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        logo = findViewById(R.id.mainlogo);
        zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                logo.setVisibility(View.VISIBLE);
                logo.startAnimation(zoom_in);
                startActivity(new Intent(MainActivity2.this, MainActivity.class));


            }
        }, 1000);
//        finish();
    }
}