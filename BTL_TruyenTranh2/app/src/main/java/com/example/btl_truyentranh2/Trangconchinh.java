
package com.example.btl_truyentranh2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class  Trangconchinh extends AppCompatActivity {
    Button button_read, btn_fav;
    ListView lst; String id;
    CircleImageView avatar;
    String title, author, image, desc, subj;

    TextView desctxt, authortxt, title_booktxt, sub_txt;
    Sach sach;
    ListView lstViewChapter;
    ArrayList<String> listChapters;
    CustomAdapter adapter;
    private FirebaseDatabase firebaseDatabase, firebaseDatabase2;
    private DatabaseReference databaseReference, databaseReference2;

    Intent i1, i2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangconchinh);
        AnhXa();

        i1 = getIntent();
        i2 = getIntent();

//        Detail_Truyen("Sach", "id");
//        Detail_Truyen("TacPhamKinhDien", "id_TPKD");
//        Detail_Truyen("RecommendForYou", "id_RFU");

    }
    void Detail_Truyen(String dataName, String idIntent) {
    listChapters = new ArrayList<>();
            if (i1.getExtras() != null) {
                id = i1.getStringExtra(idIntent);

                firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference().child(dataName).child(id);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {


                            title = snapshot.child("title_book").getValue(String.class);
                            author = snapshot.child("author").getValue(String.class);
                            desc = snapshot.child("desc").getValue(String.class);
                            subj = snapshot.child("subject").getValue(String.class);
                            image = snapshot.child("img").getValue(String.class);
                        for (DataSnapshot chapterSnapshot : snapshot.child("chapters").getChildren()) {
                            String chapter = chapterSnapshot.getValue(String.class);
                            listChapters.add(chapter);
                        }
                        adapter.notifyDataSetChanged();
                        title_booktxt.setText(title);
                        authortxt.setText(author);
                         desctxt.setText(desc);
                        sub_txt.setText(subj);
                        authortxt.setText(author);
//                        int resID = (Trangconchinh.this).getResources().
//                                getIdentifier(image, "drawable", (Trangconchinh.this).getPackageName());
//                        avatar.setImageResource(resID);
//                        Picasso.with(MainActivity.this).load(image).placeholder(R.drawable.profile).into(NavProfileImage);

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                adapter = new CustomAdapter(this, listChapters);
                lstViewChapter.setAdapter(adapter);
                lstViewChapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        startActivity(new Intent(Trangconchinh.this, PdfActivity.class).
                                putExtra("url", listChapters.get(position).toString()));
                    }
                });

//                Drawable drawable = getDrawable(R.drawable.baseline_favorite_24);

            }
        }


    void Detail_RFY() {
        listChapters = new ArrayList<>();
        if (i1.getExtras() != null) {
            String title = i2.getStringExtra("name_book_RFU");
            String author = i2.getStringExtra("author_RFU");
            String image = i2.getStringExtra("img_RFU");
            String desc = i2.getStringExtra("desc_RFU");
            id = i2.getStringExtra("id_RFU");
            String subj = i1.getStringExtra("subject_RFU");
            title_booktxt.setText(title);
            authortxt.setText(author);
//            int resID = ((Activity) this).getResources().
//                    getIdentifier(image, "drawable", ((Activity) this).getPackageName());
//            avatar.setImageResource(resID);
            desctxt.setText(desc);
            sub_txt.setText(subj);

            firebaseDatabase2 = FirebaseDatabase.getInstance();
            databaseReference2 = firebaseDatabase2.getReference().child("RecommendForYou").child(id).child("chapters");
            databaseReference2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot data : snapshot.getChildren ()) {
                        String snap = data.getValue(String.class);
                        listChapters.add(snap);
                    }
                    adapter.notifyDataSetChanged();

                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            adapter = new CustomAdapter(this, listChapters);
            lstViewChapter.setAdapter(adapter);
            lstViewChapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    startActivity(new Intent(Trangconchinh.this, PdfActivity.class).
                            putExtra("url", listChapters.get(position).toString()));
//                    Toast.makeText(Trangconchinh.this,  , Toast.LENGTH_SHORT).show();
                }
            });

//            Drawable drawable = getDrawable(R.drawable.baseline_favorite_24);

        }
    }

        void AnhXa() {
//        lst = findViewById(R.id.listview);
            authortxt = findViewById(R.id.author);
            desctxt = findViewById(R.id.desc);
            title_booktxt = findViewById(R.id.title_book);
//            avatar = findViewById(R.id.profile_image);
            sub_txt = findViewById(R.id.sub);
//            btn_fav = findViewById(R.id.fav);
            lstViewChapter = findViewById(R.id.lstChapters);
        }
    }