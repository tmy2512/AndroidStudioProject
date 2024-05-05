package com.example.btl_truyentranh2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.firebase.Firebase;
import com.google.firebase.database.ChildEvent;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Gridview_TruyenHot.HotAdapter_Helper;
import Gridview_TruyenHot.TruyenHot_Adapter;

public class MainActivity extends AppCompatActivity {
    // khai báo flipper
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    ViewFlipper viewFlipper;
    Button btnSinhVien;
    GridView gridView, gridview2, gridview3, gridview4;
    RecyclerView recyclerView;
    ImageView ic_search;
    TextView seeall;
    ArrayList<Sach> listBook, list_book_kinhdien, list_book_rcm;
    Recommend_Adapter recommendAdapter;
    TruyenHot_Adapter truyenHot_adapter, adapter_TacPhamKinhDien;


    // declare resource for adapter data
    String[] name_novel = {"Sự lựa chọn của em chỉ có thể là anh", "Yêu tinh nhỏ", "Nàng đến cùng ánh trăng", "Bí mật nguy hiểm, xin anh tha thứ"};
    int imgs_novel[] = {
            R.drawable.img, R.drawable.img1, R.drawable.img_1, R.drawable.img_2
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        setWifiManager(wifiManager);
        AnhXa();
        SlideShow();
        show_gridview_custom_truyenhot();
        show_gridview_custom_tpkinhdien();
        recommend_recycleview();
        btnSinhVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SinhVien.class);
                startActivity(i);
            }
        });
    }


    public void sliderImage(int image) {
        // slider chỉ mới là frame để đặt ảnh, vì thế trong frame phải gán 1 view là Imageview
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(image);
        // load view vào flipper
        viewFlipper.addView(imageView);
        // set timer
        viewFlipper.setFlipInterval(2000);
        viewFlipper.setAutoStart(true);
        // set animation
        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
        viewFlipper.showPrevious();
    }
    public void SlideShow() {
        // khai báo mảng ảnh cần load vào flipper
        int images[] = {R.drawable.slider5, R.drawable.slider4, R.drawable.slider1};
        // create foreach
        for (int img : images)
            sliderImage(img);
    }
    public void show_gridview_custom_truyenhot() {
        listBook = new ArrayList<>();
        Toast.makeText(MainActivity.this, "dsjkgfjdsfdsfdsf", Toast.LENGTH_SHORT).show();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Sach");
//        String key = databaseReference.push().getKey();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snap : snapshot.getChildren()) {
                    Sach data = snap.getValue(Sach.class);
                    listBook.add(data);
                }
                truyenHot_adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        truyenHot_adapter = new TruyenHot_Adapter(MainActivity.this, listBook, R.layout.view_in_gridview);
        gridView.setAdapter(truyenHot_adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, Trangconchinh.class).
                        putExtra("id", listBook.get(position).getId().toString()));

            }
        });

    }
    public void show_gridview_custom_tpkinhdien() {
        list_book_kinhdien = new ArrayList<>();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("TacPhamKinhDien");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snap : snapshot.getChildren()) {
                    Sach data = snap.getValue(Sach.class);
                    list_book_kinhdien.add(data);
                }
                adapter_TacPhamKinhDien.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
         adapter_TacPhamKinhDien = new TruyenHot_Adapter(MainActivity.this, list_book_kinhdien, R.layout.view_in_gridview);
        gridview2.setAdapter(adapter_TacPhamKinhDien);
        gridview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, Trangconchinh.class).
                        putExtra("id_TPKD", list_book_kinhdien.get(position).getId().toString()));
            }
        });

    }
    // show recycleview
    public void recommend_recycleview() {
     list_book_rcm = new ArrayList<>();
//        // truyền dữ liệu cho list
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("RecommendForYou");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snap : snapshot.getChildren()) {
                    Sach data = snap.getValue(Sach.class);
                    list_book_rcm.add(data);
                }
                recommendAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//        //tối ưu hoá ở adapter
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
         recommendAdapter = new Recommend_Adapter(MainActivity.this, list_book_rcm);
        recyclerView.setAdapter(recommendAdapter);
//        seeall.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this, SeeAll.class);
//                startActivity(i);
//            }
//        });
    }
    void AnhXa() {
        viewFlipper = findViewById(R.id.vf);
        gridView = findViewById(R.id.gridview);
        gridview2 = findViewById(R.id.gridview2);
        recyclerView = (RecyclerView) findViewById(R.id.recommend_recycleview);
        ic_search = findViewById(R.id.search);
        seeall = findViewById(R.id.txtmore);
        btnSinhVien = findViewById(R.id.btnSinhVien);
    }

}