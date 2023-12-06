//package com.example.testsqlite;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//public class act_add extends AppCompatActivity {
//Button btninsert;
//EditText edtxtUSA, edtxtUSD;
//String USA, USD;
//SQLiteHelper sqLiteHelper;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_act_add);
//        btninsert = findViewById(R.id.btn_inserttable);
//        edtxtUSA = findViewById(R.id.edtextUSA);
//        edtxtUSD = findViewById(R.id.edtextUSD);
//        USA = edtxtUSA.getText().toString().trim();
//        USD = edtxtUSD.getText().toString().trim();
//        sqLiteHelper = new SQLiteHelper(act_add.this, "Currency.sqlite", null, 1);
//       sqLiteHelper.Query("create table if not exists CURRENCY( ID integer primary key autoincrement, Country VARCHAR(20), Value VARCHAR(20)");
//        btninsert.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(TextUtils.isEmpty(USA) || TextUtils.isEmpty(USD)) {
//                    Toast.makeText(act_add.this, "check edit text again", Toast.LENGTH_SHORT).show();
//                }
//                else {
////                    sqLiteHelper.Query("");
//                }
//            }
//        });
//
//    }
//}