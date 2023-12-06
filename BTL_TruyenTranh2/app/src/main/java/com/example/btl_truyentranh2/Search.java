package com.example.btl_truyentranh2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Gridview_TruyenHot.HotAdapter_Helper;
import Gridview_TruyenHot.TruyenHot_Adapter;

public class Search extends AppCompatActivity {
    ImageView ic_back;
    Button btnsearch;
    EditText editText_search;
    AutoCompleteTextView autotext;
    ArrayList<HotAdapter_Helper> list_book_adapter;
    HotAdapter_Helper hotAdapterHelper;
    TruyenHot_Adapter truyenHot_adapter;
    Database database;
    Cursor datashow;
    GridView show_found_list;
    String desc;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        ic_back = findViewById(R.id.back);
//        editText_search = findViewById(R.id.edt_search);
        autotext = findViewById(R.id.autoCompleteTextView1);
        //       =========== show test list in gridview
        show_found_list = findViewById(R.id.gridview);
        list_book_adapter = new ArrayList<>();
//        String desc[] = {
//                "Mô tả này dành cho truyện của Kim Lân 1234543hhdfjds foiwe dsfh ehfi ieuwofie jđj",
//                "Mô tả này dành cho truyện của Nam Cao",
//                "Mô tả này dành cho truyện của Tố Hữu",
//                "Mô tả này dành cho truyện của Nguyễn Bỉnh Khiêm",
//                "Mô tả này dành cho truyện của Hai Bà Trung",
//                "Mô tả này dành cho truyện của Lan Khuê",
//        };
//        String subject[] = {"Kinh dị", "Trinh thám", "Ngôn tình", "Tiểu thuyết", "Anime", "Khoa học"};
//        String author[] = {"Kim Lân", "Nam Cao", "Tố Hữu", "Nguyễn Bỉnh Khiêm", "Hai Bà Trưng", "Lan Khuê"};
//        String title[] = {"Name 1", "Name 2", "Name 3", "Name 4", "Name 5", "Name 6"};
//        String imgs[] = {
//                "slider1",  "slider2", "img_2",
//                "slider4", "slider5", "slider5"};
//        String name_pdf[] = {"tailieu.pdf", "truyen2.pdf", "tailieu.pdf", "truyen2.pdf", "tailieu.pdf", "truyen2.pdf"};
//
//
//        for(int i = 0 ; i<imgs.length; i++){
//            hotAdapterHelper = new HotAdapter_Helper(imgs[i], title[i], author[i], desc[i], subject[i], name_pdf[i]);
//            list_book_adapter.add(hotAdapterHelper);
//        }
//        // declare adapter
//        TruyenHot_Adapter truyenHot_adapter = new TruyenHot_Adapter(Search.this, list_book_adapter, R.layout.view_in_gridview);
//        show_found_list.setAdapter(truyenHot_adapter);
//        actiongetData();
//        show_found_list.setAdapter(truyenHot_adapter);
//        database = new Database(this, "Listbook.sqlite", null, 1);
//        database = new Database(this);
//        database.Query("CREATE TABLE IF NOT EXISTS " +
//                "Book2(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                "Image CHAR(10), Title NVARCHAR(50), Author NVARCHAR(30), " +
//                "Desc NVARCHAR(100)," +
//                "Subj NVARCHAR(30))");
//        database.Query("INSERT INTO Book2(Image, Title, Author, Desc, Subj) VALUES " +
//                "('slider2', 'Name2', 'Nam Cao', " +"'Mô tả này dành cho truyện của Nam Cao 1234543hhdfjds foiwe dsfh ehfi ieuwofie jđj', 'Kinh dị'),
//                ('slider', 'Name3', 'Kim Lân', 'Mô tả này dành cho truyện của Kim Lân',  )
//                ");
        String titles[] = {"Name 1", "Name 2", "Name 3", "Name 4", "Name 5", "Name 6"};
        // tạo string text cho autotext
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titles);
        autotext.setThreshold(1); // start working from first character
        autotext.setAdapter(adapter);

        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnsearch = findViewById(R.id.btn_search2);
//        database = new Database(this, "Listbook.sqlite", null, 1);

        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tmp = autotext.getText().toString().trim();
                String title, author, desc, subj, image, name_pdf;
                if(TextUtils.isEmpty(autotext.getText().toString().trim())) {
                    Toast.makeText(Search.this, "Please enter your data", Toast.LENGTH_SHORT).show();
                    autotext.requestFocus();
                }
//                else {
//                    try {
//                         datashow = database.cursor("SELECT * FROM Book2 ");
//                        list_book_adapter = new ArrayList<>();
//                        while(datashow.moveToNext()) {
//                            image = datashow.getString(0);
//                            title =datashow.getString(1);
//                            author = datashow.getString(2);
//                            desc = datashow.getString(3);
//                            subj = datashow.getString(4);
//                            name_pdf =  datashow.getString(5);
//                            list_book_adapter.add(new HotAdapter_Helper(image, title, author, desc, subj, name_pdf));
//                        }
//                        Toast.makeText(Search.this, "dsjkgfjdsfdsfdsf", Toast.LENGTH_SHORT).show();
//
//                        TruyenHot_Adapter truyenHot_adapter = new TruyenHot_Adapter(Search.this, list_book_adapter, R.layout.view_in_gridview);
//                        truyenHot_adapter.notifyDataSetChanged();
//                        show_found_list.setAdapter(truyenHot_adapter);
//                    }
//                    catch(Exception e) {
//                        Log.e("msg", "error");
//                    }
//                }

            }
        });


    }

//    private void actiongetData() {
//
//        datashow = database.cursor("select *from Book2");
//        String title, author, desc, subj, image, name_pdf;
//        list_book_adapter = new ArrayList<>();
//        while(datashow.moveToNext()) {
////            int resID = ((Activity) this).getResources().
////                    getIdentifier(image, "drawable", ((Activity)this).getPackageName());
////            avatar.setImageResource(resID);
//            image = datashow.getString(0);
//
//            title =datashow.getString(1);
//            author = datashow.getString(2);
//            desc = datashow.getString(3);
//            subj = datashow.getString(4);
//            name_pdf = datashow.getString(5);
//            list_book_adapter.add(new HotAdapter_Helper(image, title, author, desc, subj, name_pdf));
//        }
//        TruyenHot_Adapter truyenHot_adapter = new TruyenHot_Adapter(Search.this, list_book_adapter, R.layout.view_in_gridview);
////        truyenHot_adapter.noti
//        show_found_list.setAdapter(truyenHot_adapter);
//    }
}