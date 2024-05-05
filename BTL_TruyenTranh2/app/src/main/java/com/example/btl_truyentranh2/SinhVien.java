package com.example.btl_truyentranh2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import Gridview_TruyenHot.SinhVienAdapter;
import Gridview_TruyenHot.TruyenHot_Adapter;

public class SinhVien extends AppCompatActivity {
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    GridView gridViewSV;
    Button btnAdd;
    SinhVienAdapter sinhVienAdapter;
    ArrayList<EntitySinhVien> listSinhVien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sinh_vien);
        gridViewSV = findViewById(R.id.gridviewSinVien);
        btnAdd = findViewById(R.id.btnAdd);
hienThiDSSV();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SinhVien.this, ThemSinhVien.class);
                startActivity(i);
            }
        });

//        gridViewSV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                startActivity(new Intent(SinhVien.this, Trangconchinh.class).
//                        putExtra("id", listSinhVien.get(position).getId().toString()));
//
//            }
//        });

    }
    void addSinhVien() {

    }
    void hienThiDSSV() {
        listSinhVien = new ArrayList<>();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("SinhVien");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snap : snapshot.getChildren()) {
                    EntitySinhVien data = snap.getValue(EntitySinhVien.class);
                    listSinhVien.add(data);
                }
                sinhVienAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        sinhVienAdapter = new SinhVienAdapter(SinhVien.this, listSinhVien, R.layout.displaygridsv);
        gridViewSV.setAdapter(sinhVienAdapter);
    }
}