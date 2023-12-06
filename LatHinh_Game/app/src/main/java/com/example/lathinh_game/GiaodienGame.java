package com.example.lathinh_game;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class GiaodienGame extends AppCompatActivity {
    ProgressBar progressBar;
    TextView txtview;
    private int points = 0;
    int img[] = {R.drawable.avocado,
            R.drawable.ice_scream,
            R.drawable.burger,
            R.drawable.cherry,
            R.drawable.ff,
            R.drawable.grapes,
            R.drawable.kiwi,
            R.drawable.orange,
            R.drawable.strawberry,
            R.drawable.watermelon};
    int currentPos = -1;
    int pos[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    ImageAdapter imageAdapter = new ImageAdapter(this);
    ImageView currentView = null;
    private int countPair = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giaodien_game);
        AnhXa();
        GridView gridView = findViewById(R.id.gridv);
        txtview = findViewById(R.id.points);
        gridView.setAdapter(imageAdapter);
        txtview.setText("0");
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currentPos < 0) {
                    currentPos = position;
                    currentView = (ImageView) view;
                    ((ImageView) view).setImageResource(img[pos[position]]);
                } else {
                    if (currentPos == position) {
                        ((ImageView) view).setImageResource(R.drawable.ic_action_question);
                    } else if (pos[currentPos] != pos[position]) {
                        currentView.setImageResource(R.drawable.ic_action_question);
                    } else {
                        ((ImageView) view).setImageResource(img[pos[position]]);
                        points +=10;
                        txtview.setText(String.valueOf(points));
                        countPair++;
                        if (countPair == 2) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(GiaodienGame.this);
                            builder.setMessage("Goof job!! Score \n '"+points+ "'!! Do you wanna try it again?");
                            builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                            builder.show();
                        }
                    }
                    currentPos = -1;
                }
            }
        });

//        Timer timer = new Timer();
//        TimerTask timerTask = new TimerTask() {
//            @Override
//            public void run() {
//                count++;
//                progressBar.setProgress(count);
//                if(count == 100000) {
//                    //timer.cancel();
//                    Toast.makeText(GiaodienGame.this, "Time up", Toast.LENGTH_SHORT).show();
//                }
//            }
//        };
//        timer.schedule(timerTask, 100);
        new Mythread().start();
    }

    class Mythread extends Thread {


        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                progressBar.setProgress((i * 100) / 100);
            }
        }
    }

    void AnhXa() {
        progressBar = findViewById(R.id.pb);

    }

}