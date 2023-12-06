package com.example.btl_truyentranh;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Search extends AppCompatActivity {
    ImageView ic_back;

    Database database;
    EditText editText_search;
    Cursor datashow;
    String desc;
    TextView search;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        ic_back = findViewById(R.id.back);
        editText_search = findViewById(R.id.edt_search);
        database = new Database(this, "Listbook.sqlite", null, 1);
        search = findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datashow = database.getData("select *from Book where Title LIKE  "+ editText_search.getText());

                while(datashow.moveToNext()){
                    desc = datashow.getString(3);
                }
                if(desc == "Name9") {
                    Toast.makeText(Search.this, desc, Toast.LENGTH_LONG).show();
                }
            }
        });

        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}