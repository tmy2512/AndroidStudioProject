//package com.example.btl_truyentranh2;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.annotation.SuppressLint;
//import android.os.Bundle;
//import android.widget.GridView;
//
//import java.util.ArrayList;
//
//import Gridview_TruyenHot.HotAdapter_Helper;
//import Gridview_TruyenHot.TruyenHot_Adapter;
//
//public class SeeAll extends AppCompatActivity {
//Recommend_Adapter recommendAdapter;
//RecyclerView recyclerView;
//HotAdapter_Helper hotAdapterHelper;
//    TruyenHot_Adapter truyenHot_adapter;
//GridView gridView;
//ArrayList<HotAdapter_Helper> list_book_adapter, list_book_rcm;
//
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_see_all);
//        recyclerView = findViewById(R.id.recommend_recycleview);
//        gridView = findViewById(R.id.gridview);
//        list_book_rcm = new ArrayList<>();
//        list_book_adapter = new ArrayList<>();
//        // truyền dữ liệu cho list
//        String desc[] = {
//                "Mô tả này dành cho truyện của Harper Lee 1234543hhdfjds foiwe dsfh ehfi ieuwofie jđj",
//                "Mô tả này dành cho truyện của Franz Kafka",
//                "Mô tả này dành cho truyện của J.D. Salinger",
//                "Mô tả này dành cho truyện của Fyodor Dostoevsky",
//                "Mô tả này dành cho truyện của Leo Tolstoy",
//                "Mô tả này dành cho truyện của Charles Dickens",
//        };
//        String subject[] = {"Kinh dị", "Trinh thám", "Ngôn tình", "Tiểu thuyết", "Anime", "Khoa học"};
//        String author[] = {"Harper Lee", "Franz Kafka", "J.D. Salinger", "Fyodor Dostoevsky", "Leo Tolstoy", "Charles Dickens "};
//        String title[] = {"Giết con chim nhại", "Vụ án",
//                "Bắt trẻ đồng xanh", "Anh em nhà Karamazov", "Anna Karenina", "Hồn ma đêm Giáng sinh"};
//
//        String imgs[] = {
//                "slider1",  "slider2", "img_2",
//                "slider4", "slider5", "slider5"};
//        String name_pdf[] = {"tailieu.pdf", "truyen2.pdf", "tailieu.pdf", "truyen2.pdf", "tailieu.pdf", "truyen2.pdf"};
//
//
//
//        for(int i = 0 ; i<imgs.length; i++){
//            hotAdapterHelper = new HotAdapter_Helper(imgs[i], title[i], author[i], desc[i], subject[i], name_pdf[i]);
//            list_book_rcm.add(hotAdapterHelper);
//        }
//        recyclerView.setHasFixedSize(true);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(layoutManager);
//
//        Recommend_Adapter adapter = new Recommend_Adapter(SeeAll.this, list_book_rcm);
//        recyclerView.setAdapter(adapter);
//        // declare adapter
////        truyenHot_adapter = new TruyenHot_Adapter(SeeAll.this, list_book_adapter, R.layout.view_in_gridview);
////        gridView.setAdapter(truyenHot_adapter);
//
//    }
//}