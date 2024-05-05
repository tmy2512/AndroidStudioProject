package com.example.btl_truyentranh2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PopUpActivity extends AppCompatActivity {
    Button btn_light, btn_Dismiss; ImageButton btn_night;
//    Switch aSwitch;  SharedPreferences sharedPreferences;
//    SharedPreferences.Editor editor;boolean night_Mode;
    public static final String WRITE_SETTINGS = "android.permission.WRITE_SETTINGS";
    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.popwindow);

//        LinearLayout ll = findViewById(R.id.mypopup) ;
//                ll.setBackgroundColor(ContextCompat.getColor(this, R.color.background));
//        askPermission(this);




        SeekBar seekBar = findViewById(R.id.sb_modifyBrightness);
        seekBar.setMax(250);
        int brightness = Settings.System.getInt(getContentResolver(),
                Settings.System.SCREEN_BRIGHTNESS, 0);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                android.provider.Settings.System.putInt(getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, progress);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                    boolean canWrite = Settings.System.canWrite(PopUpActivity.this);
                    if (canWrite) {
                        Settings.System.putInt(getContentResolver(),
                                Settings.System.SCREEN_BRIGHTNESS, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
                        Settings.System.putInt(getContentResolver(),
                                Settings.System.SCREEN_BRIGHTNESS, progress);
                    }
                    else {

                        startActivity(new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS));
                    }
                }


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void askPermission(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.System.canWrite(context)) {
                // somethings
                Toast.makeText(context, "hi", Toast.LENGTH_SHORT).show();
            }
            else {
                context.startActivity(new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS));
            }
        }
    }
}