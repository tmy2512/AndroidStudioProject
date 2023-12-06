package com.example.testsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    SQLiteHelper sqLiteHelper;
    ListView lstview;
    PersonAdapter adapter;
    ArrayList<Person> arrayList;
    Button btnadd, btnadd2;
    EditText edtxt;
    ImageView img_Search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
//        btnadd2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainActivity.this, act_add.class);
//                startActivity(i);
//            }
//        });
        img_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_search = edtxt.getText().toString().trim();
                if(TextUtils.isEmpty(name_search)) {
                    Toast.makeText(MainActivity.this, "Please enter your data", Toast.LENGTH_SHORT).show();
                    edtxt.requestFocus();
                }
                Cursor data_show = sqLiteHelper.getData("SELECT *FROM QLSV WHERE TenSinhVien LIKE '%"+name_search+"%'");
                arrayList.clear();
                String name_data;
                int id;
                arrayList.clear();
                while (data_show.moveToNext()) {
                    name_data = data_show.getString(1);
                    id = data_show.getInt(0);
                    arrayList.add(new Person(id, name_data));

                    //Toast.makeText(this, name_data , Toast.LENGTH_SHORT).show();
                }
                adapter.notifyDataSetChanged();
                // show ra listview
                adapter = new PersonAdapter(MainActivity.this, R.layout.activity_main2, arrayList);
                lstview.setAdapter(adapter);
            }
        });
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // lấy chữ trong edtxt
                String edName = edtxt.getText().toString().trim();
                if(TextUtils.isEmpty(edName)) {
                    Toast.makeText(MainActivity.this, "Please enter your data", Toast.LENGTH_SHORT ).show();
                    return;
                }
                else {
                    sqLiteHelper.Query("insert into QLSV values(null, '"+edName+"')");
                    actiongetData();
                    edtxt.setText("");
                }
            }
        });
        arrayList = new ArrayList<>();
        adapter = new PersonAdapter(this, R.layout.activity_main2, arrayList);
        lstview.setAdapter(adapter);
        //tạo db
        sqLiteHelper = new SQLiteHelper(this, "QLSinhVien.sqlite", null, 1);
//        sqLiteHelper = new SQLiteHelper(this, "QLtest1.sqlite", null, 1);
        // tạo bảng( chính là câu vấn không trả kết quả ta đã tạo bên SQLiteHelper)
        sqLiteHelper.Query("CREATE TABLE IF NOT EXISTS " +
                "QLSV(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "TenSinhVien VARCHAR(200))");
        // theem dữ liệu vào bảng
        //sqLiteHelper.Query("insert into QLSV values(null, 'Nguyễn Văn AN')");
        //sqLiteHelper.Query("insert into QLSV values(null, 'Trần Kim Sao')");
        // xoá dữ liệu ra khỏi bảnh
       // sqLiteHelper.Query("DELETE FROM QLSV WHERE ID = ?");
        // Hiển thị dữ liệu
       actiongetData();


    }
    public void popup_update(String name, int id) {
        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.popup_edit);
        EditText ed_Sua = dialog.findViewById(R.id.edtext);
        Button btn_edit = dialog.findViewById(R.id.btn_update);
        Button btn_cancle = dialog.findViewById(R.id.btn_cancle);
        ed_Sua.setText(name);
        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = ed_Sua.getText().toString().trim();
                if(TextUtils.isEmpty(newName)) {
                    Toast.makeText(MainActivity.this, "Please enter your required content", Toast.LENGTH_SHORT).show();
                    ed_Sua.requestFocus();
                }
                else {
                    // sửa thì vẫn dùng câu lệnh không trả về kq đã được tạo ở sqlitehelper
                    sqLiteHelper.Query("UPDATE QLSV SET TenSinhVien = '"+newName+"' WHERE ID = '"+id+"'");
                    dialog.dismiss();
                    actiongetData();
                }

            }
        });
        dialog.show();
    }

    public void DialogDelete(String name, int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you wanna delete "+name+"?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sqLiteHelper.Query("DELETE FROM QLSV WHERE ID= "+id+"");
                actiongetData();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    private void anhXa() {
        lstview = findViewById(R.id.lstview);
        btnadd = findViewById(R.id.btn_add);
        edtxt = findViewById(R.id.edtxt);
        img_Search = findViewById(R.id.img_search);
        btnadd2 = findViewById(R.id.btn_add2);
    }
    private void actiongetData() {
        Cursor data_show = sqLiteHelper.getData("SELECT *FROM QLSV");
        String name_data;
        int id;
        arrayList.clear();
        while (data_show.moveToNext()) {
            name_data = data_show.getString(1);
            id = data_show.getInt(0);
            arrayList.add(new Person(id, name_data));
            //Toast.makeText(this, name_data , Toast.LENGTH_SHORT).show();
        }
        adapter.notifyDataSetChanged();
    }



}