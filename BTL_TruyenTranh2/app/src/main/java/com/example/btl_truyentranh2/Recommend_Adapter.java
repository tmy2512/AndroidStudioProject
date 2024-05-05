package com.example.btl_truyentranh2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ContentInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.btl_truyentranh2.R;
import com.example.btl_truyentranh2.Trangconchinh;

import java.util.ArrayList;

import Gridview_TruyenHot.HotAdapter_Helper;

public class Recommend_Adapter extends RecyclerView.Adapter<Recommend_Adapter.ViewHolder>{
    // khai báo các biến vào view dùng cho setAdapter
    private Context context;
    private ArrayList<Sach> listBook;

    public Recommend_Adapter(Context context, ArrayList<Sach> listBook) {
        this.context = context;
        this.listBook = listBook;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview = layoutInflater.inflate(R.layout.recommended_book, parent,false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Sach temp = listBook.get(position);
        // gán dữ liệu vào txt
        String imageName = temp.getImg();
        int resID = ((Activity) context).getResources().
                getIdentifier(imageName, "drawable", ((Activity)context).getPackageName());
//        imageView.setImageResource(resID);
        holder.img_view.setImageResource(resID);
        holder.txt_view.setText(listBook.get(position).getTitle_book());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context =v.getContext();
                Intent i = new Intent(context, Trangconchinh.class);
                i.putExtra("id_RFU", temp.getId());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBook.size();
    }

    // recycleview bắt buộc phải tạo viewholder để tối ưu hoá
    public class ViewHolder extends RecyclerView.ViewHolder {
        // khai báo các view trong Book class
        ImageView img_view;
        TextView txt_view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_view = (TextView) itemView.findViewById(R.id.r_txtview);
            img_view = (ImageView) itemView.findViewById(R.id.r_img_view);

        }
    }
}
