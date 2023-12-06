package com.example.btl_truyentranh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Trangconchinh extends AppCompatActivity {
    Database database;

    String Chapter[] = {
            "Chương I", "Chương 2", "Chương 3", "Chương 4", "Chương 5"
    };
    ListView lst;
    ImageView avatar;
    TextView desctxt, authortxt, title_booktxt, sub_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangconchinh);
        AnhXa();


      Intent i = getIntent();
        if(i.getExtras() != null) {
            String title = i.getStringExtra("name_book");
            String author = i.getStringExtra("author");
            int image = i.getIntExtra("img",0 );
            String desc = i.getStringExtra("desc");
            String subj = i.getStringExtra("subject");
            title_booktxt.setText(title);
            authortxt.setText(author);
            avatar.setImageResource(image);
            desctxt.setText(desc);
            sub_txt.setText(subj);

//              database.Query("INSERT INTO Book VALUES(null, image, title, author, desc, subj)");
        }

        // set dư liệu cho text

    }

    void AnhXa() {
//        lst = findViewById(R.id.listview);
        authortxt = findViewById(R.id.author);
        desctxt = findViewById(R.id.desc);
        title_booktxt = findViewById(R.id.title_book);
        avatar = findViewById(R.id.profile_image);
        sub_txt = findViewById(R.id.sub);
    }
}