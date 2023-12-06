package com.example.btl_truyentranh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import Cothebanthich_Adapter.Recommend_Adapter;
import Gridview_TruyenHot.HotAdapter_Helper;
import Gridview_TruyenHot.TruyenHot_Adapter;

public class MainActivity extends AppCompatActivity {
    // khai báo flipper
    ViewFlipper viewFlipper;
    GridView gridView, gridview2, gridview3, gridview4;
    RecyclerView recyclerView;
    ImageView ic_search;
    String title_temp, author_temp, desc_temp, subject_temp;

    // declare resource for adapter data
    String[] name_novel = {"Sự lựa chọn của em chỉ có thể là anh", "Yêu tinh nhỏ", "Nàng đến cùng ánh trăng", "Bí mật nguy hiểm, xin anh tha thứ"};
    int imgs_novel[] = {
            R.drawable.img, R.drawable.img1, R.drawable.img_1, R.drawable.img_2
    };
    // tạo database
    Database database;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        SlideShow();
        show_gridview_custom_truyenhot();
        show_gridview_custom_tpkinhdien();
        recommend_recycleview();
        database = new Database(this, "Listbook.sqlite", null, 1);
        try {
            database.Query("CREATE TABLE IF NOT EXISTS " +
                    "Book(ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    "Image BLOB, Title VARCHAR(50), Author VARCHAR(30), " +
                    "Desc VARCHAR(100)," +
                    "Subj VARCHAR(30))");
        }
        catch (Exception e) {
            Log.e("Error", "Table existed");
        }


        ic_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Search.class);
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
        ArrayList<HotAdapter_Helper> list_book_adapter = new ArrayList<>();

        // Thêm dữ liệu vào list
        String desc[] = {
                "Mô tả này dành cho truyện của Harper Lee 1234543hhdfjds foiwe dsfh ehfi ieuwofie jđj",
                "Mô tả này dành cho truyện của Franz Kafka",
                "Mô tả này dành cho truyện của J.D. Salinger",
                "Mô tả này dành cho truyện của Fyodor Dostoevsky",
                "Mô tả này dành cho truyện của Leo Tolstoy",
                "Mô tả này dành cho truyện của Charles Dickens",
        };
        String subject[] = {"Kinh dị", "Trinh thám", "Ngôn tình", "Tiểu thuyết", "Anime", "Khoa học"};
        String author[] = {"Harper Lee", "Franz Kafka", "J.D. Salinger", "Fyodor Dostoevsky", "Leo Tolstoy", "Charles Dickens "};
        String title[] = {"Giết con chim nhại", "Vụ án",
                "Bắt trẻ đồng xanh", "Anh em nhà Karamazov", "Anna Karenina", "Hồn ma đêm Giáng sinh"};
        int[] imgs = {
                R.drawable.slider1, R.drawable.slider2, R.drawable.img_2,
                R.drawable.slider4, R.drawable.slider5, R.drawable.slider5};
        HotAdapter_Helper hotAdapterHelper;


        for (int i = 0; i < imgs.length; i++) {
            hotAdapterHelper = new HotAdapter_Helper(imgs[i], title[i], author[i], desc[i], subject[i]);
            list_book_adapter.add(hotAdapterHelper);
//            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), (ImageView) hotAdapterHelper.getImg());
//            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
//            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
//            byte[] img = byteArray.toByteArray();

            title_temp = hotAdapterHelper.getTitle_book().toString();
            author_temp = hotAdapterHelper.getAuthor().toString();
            desc_temp = hotAdapterHelper.getDesc().toString();
            subject_temp = hotAdapterHelper.getSubject().toString();
//            database.addBook(hotAdapterHelper);
//            database.addBook(img, title_temp, author_temp, desc_temp, subject_temp);

//            try{
////                database.Query("INSERT INTO Book  VALUES (null, '"+img+"', '"+title_temp+"', " +
////                        "'"+author_temp+"', '"+desc_temp+"', '"+subject_temp+"')");
//                database.addBook(img, title_temp, author_temp, desc_temp, subject_temp);
//            }catch(Exception e) {
//                Log.e("error", "khong the insert duoc");
//            }

        }
        // declare adapter
        TruyenHot_Adapter truyenHot_adapter = new TruyenHot_Adapter(MainActivity.this, list_book_adapter, R.layout.view_in_gridview);
        gridView.setAdapter(truyenHot_adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this, Trangconchinh.class).
                        putExtra("name_book", list_book_adapter.get(position).getTitle_book()).
                        putExtra("author", list_book_adapter.get(position).getAuthor()).
                        putExtra("img", list_book_adapter.get(position).getImg()).
                        putExtra("desc", list_book_adapter.get(position).getDesc()).
                        putExtra("subject", list_book_adapter.get(position).getSubject()));
            }
        });


    }
    public void show_gridview_custom_tpkinhdien() {
        // khai báo arraylist để thêm dữ liệu
        ArrayList<HotAdapter_Helper> list_book_kd = new ArrayList<>();
        // cung cấp dữ liệu
        String desc[] = {
                "Mô tả này dành cho truyện của Antoine de Saint-Exupéry  1234543hhdfjds foiwe dsfh ehfi ieuwofie jđj",
                "Mô tả này dành cho truyện của Gabriel Garcia Marquez",
                "Mô tả này dành cho truyện của Xuân Diệu"
        };
        String subject[] = {"Kinh dị", "Trinh thám", "Ngôn tình"};
        String author[] = {"Antoine de Saint-Exupéry ", "Gabriel Garcia Marquez", "Xuân Diệu"};
        String title[] = {"Hoàng tử bé", "Trăm năm cô đơn", "Nhất định phải nói yêu anh"};
        int imgs[] = {
                R.drawable.img_3, R.drawable.img_3, R.drawable.img_3};
        HotAdapter_Helper hotAdapterHelper;
        for (int i = 0; i < imgs.length; i++) {
            hotAdapterHelper = new HotAdapter_Helper(imgs[i], title[i], author[i], desc[i], subject[i]);
            list_book_kd.add(hotAdapterHelper);
        }
        TruyenHot_Adapter adpt = new TruyenHot_Adapter(this, list_book_kd, R.layout.view_in_gridview);
        gridview2.setAdapter(adpt);
        // chuyển dữ liệu sang trang con chinh
        gridview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, Trangconchinh.class);
                i.putExtra("img", list_book_kd.get(position).getImg());
                i.putExtra("name_book", list_book_kd.get(position).getTitle_book());
                i.putExtra("author", list_book_kd.get(position).getAuthor());
                i.putExtra("desc", list_book_kd.get(position).getDesc());
                i.putExtra("subject", list_book_kd.get(position).getSubject());
                startActivity(i);

            }
        });

    }
    public byte[] converttoArrayByte(ImageView img) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) img.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    // show recycleview
    public void recommend_recycleview() {
        // khai báo list chứa dữ liệu
        ArrayList<HotAdapter_Helper> list_book = new ArrayList<>();
        // truyền dữ liệu cho list
        String desc[] = {
                "Mô tả này dành cho truyện của Dan Brown 1234543hhdfjds foiwe dsfh ehfi ieuwofie jđj",
                "Mô tả này dành cho truyện của  Arthur Conan Doyle",
                "Mô tả này dành cho truyện của Thomas Harris",
                "Mô tả này dành cho truyện của Agatha Christie"
        };
        String subject[] = {"Kinh dị", "Trinh thám", "Ngôn tình", "Ngôn tình"};
        String author[] = {"Dan Brown", " Arthur Conan Doyle", "Thomas Harris", "Agatha Christie"};
        String title[] = {"Mật mã Da Vinci", "Sherlock Holmes", "Sự im lặng của bầy cừu", "Án mạng trên sông Nile"};
        int imgs[] = {
                R.drawable.slider4, R.drawable.slider4, R.drawable.slider4, R.drawable.slider4};
        HotAdapter_Helper hotAdapterHelper;
        for (int i = 0; i < imgs.length; i++) {
            hotAdapterHelper = new HotAdapter_Helper(imgs[i], title[i], author[i], desc[i], subject[i]);
            list_book.add(hotAdapterHelper);
        }
        //tối ưu hoá ở adapter
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        Recommend_Adapter adapter = new Recommend_Adapter(MainActivity.this, list_book);
        recyclerView.setAdapter(adapter);
    }
    void AnhXa() {
        viewFlipper = findViewById(R.id.vf);
        gridView = findViewById(R.id.gridview);
        gridview2 = findViewById(R.id.gridview2);
        recyclerView = (RecyclerView) findViewById(R.id.recommend_recycleview);
        ic_search = findViewById(R.id.search);
    }
    // insert data into table( fix cứng luôn data)


}