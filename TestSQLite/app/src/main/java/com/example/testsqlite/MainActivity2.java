//package com.example.testsqlite;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.ProgressDialog;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.ProgressBar;
//
//public class MainActivity2 extends AppCompatActivity {
//ProgressDialog pb ;
//Button btn;
//int count;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//        btn = findViewById(R.id.btn_show);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                pb = new ProgressDialog(MainActivity2.this);
//                pb.setMessage("Loading");
//                pb.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//                pb.show();
//                new thread().start();
//            }
//        });
//
//    }
//    class thread extends Thread{
//        @Override
//        public void run() {
//            for(int i = 0; i<100; i++) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                pb.setProgress((i*100)/100);
//            }
//        }
//    }
//}
//// cập nhật giao diện method.post