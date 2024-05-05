package com.example.btl_truyentranh2;

import static com.google.android.material.internal.ContextUtils.getActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PdfActivity extends AppCompatActivity{
    String url;
    TextView txt_showManga, txt_showSize,t2;
    ImageButton btn_showSettings, btn_night;
    Button btn_light;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    boolean night_Mode;
    Button upButton, downButton;
    float textSize,diff=2.0f;
    PopupWindow pw;
    boolean checkPopup = false;
//    final LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//    LayoutInflater inflater = LayoutInflater.from(this);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        btn_showSettings = findViewById(R.id.btnSetting);
        txt_showManga = findViewById(R.id.showManga);
        MyFragment fragment = new MyFragment();

        showManga();


            btn_showSettings.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (checkPopup == false) {
//                        fragment.show(getSupportFragmentManager(), "MyPopUp");
//                        fragment.dismiss();
                        @SuppressLint("ResourceType") View pview = LayoutInflater.from(PdfActivity.this).inflate(R.layout.popwindow, (ViewGroup) findViewById(R.layout.activity_pdf));
                        pw = new PopupWindow(pview);
                        pw.showAtLocation(v, Gravity.CENTER, 50, 50);
                        pw.update(100, -70, 1000, 500);
//                        pw.setFocusable(true);
//                        pw.setBackgroundDrawable(new ColorDrawable());
//                        pw.setOutsideTouchable(true);

                        //if onclick written here, it gives null pointer exception.
//                        aSwitch = (Switch) pview.findViewById(R.id.mode);
                        btn_light = (Button) pview.findViewById(R.id.btn_light);
                        btn_night = (ImageButton) pview.findViewById(R.id.btn_night);
                        sharedPreferences = getSharedPreferences("MODE", Context.MODE_PRIVATE);
                        night_Mode = sharedPreferences.getBoolean("night_Mode", false);// light is the default
                        if (night_Mode) {
//                            onThemeChanged();

                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        }
                        btn_light.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                                    editor = sharedPreferences.edit();
                                    editor.putBoolean("night_Mode", false);


                                editor.apply();
                                checkPopup = true;


                            }
                        });
                        btn_night.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                                    editor = sharedPreferences.edit();
                                    editor.putBoolean("night_Mode", true);
                                editor.apply();
                                checkPopup = true;
                            }
                        });

                        upButton = (Button) pview.findViewById(R.id.btn_increaseSize);
                        downButton = (Button) pview.findViewById(R.id.btn_decreaseSize);
                        t2 = (TextView) pview.findViewById(R.id.showManga);
                        txt_showSize = (TextView) pview.findViewById(R.id.txt_showSize);

                        upButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                t2.setTextSize(txt_showManga.getTextSize() + diff);
                            }
                        });
                        downButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                t2.setTextSize(txt_showManga.getTextSize() - diff);
                                Toast.makeText(PdfActivity.this, "hi", Toast.LENGTH_SHORT).show();

                            }
                        });
                    }
                    else {
                    }
//

                }
            });



            }
            public void showManga() {
                Intent i = getIntent();
                if (i.getExtras() != null) {
                    url = i.getStringExtra("url");
                }
                String text = "";
                url += ".txt";
                try {
                    InputStream iS = getAssets().open(url);
                    int size = iS.available();
                    byte[] buffer = new byte[size];
                    iS.read(buffer);
                    iS.close();
                    text = new String(buffer);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                txt_showManga.setText(text);
            }

//    @Override
//    public void onThemeChanged() {
//        recreate();
//    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}


