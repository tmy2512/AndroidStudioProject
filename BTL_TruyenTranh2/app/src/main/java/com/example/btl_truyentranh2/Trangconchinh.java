package com.example.btl_truyentranh2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Trangconchinh extends AppCompatActivity {
    Database database;

    Button button_read, btn_fav;
    ListView lst;
    ImageView avatar;
    TextView desctxt, authortxt, title_booktxt, sub_txt;
    String name_pdf, subj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangconchinh);
        AnhXa();
//        database = new Database(this, "Listbook.sqlite", null, 1);
//        database.Query("CREATE TABLE IF NOT EXISTS " +
//                "Book(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "Image BLOB, Title NVARCHAR(50), Author NVARCHAR(30), " +
//                "Desc NVARCHAR(100)," +
//                "Subj NVARCHAR(30))");
//

        Intent i = getIntent();
        if(i.getExtras() != null) {
            String title = i.getStringExtra("name_book");
            String author = i.getStringExtra("author");
            String image = i.getStringExtra("img" );
            String desc = i.getStringExtra("desc");
             subj = i.getStringExtra("subject");
             name_pdf = i.getStringExtra("name_pdf");
            title_booktxt.setText(title);
            authortxt.setText(author);
            int resID = ((Activity) this).getResources().
                    getIdentifier(image, "drawable", ((Activity)this).getPackageName());
            avatar.setImageResource(resID);
            desctxt.setText(desc);
            sub_txt.setText(subj);
            button_read.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Trangconchinh.this, PdfActivity.class);
                    i.putExtra("name_pdf", name_pdf);
                    startActivity(i);
                }
            });
            Drawable drawable = getDrawable(R.drawable.baseline_favorite_24);
            btn_fav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Trangconchinh.this, "jdsfksd", Toast.LENGTH_SHORT).show();
                        btn_fav.setBackground(getDrawable(R.drawable.baseline_favorite_24));
                }
            });
//            try {
//                database.Query("insert into Book values(null, '"+image+"', '"+title+"', '"+author+"', '"+desc+"', '"+subj+"' )");
//                Toast.makeText(this, "dữ liệu đã được insert", Toast.LENGTH_SHORT).show();
//
//            }
//            catch (Exception e) {
//                Log.e("msg", "lỗi insert");
//            }
//            database.Query("INSERT INTO Book VALUES(null, image, title, author, desc, subj)");
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
        button_read = findViewById(R.id.btn_read);
        btn_fav = findViewById(R.id.fav);
    }
}