package Gridview_TruyenHot;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.btl_truyentranh2.MainActivity;
import com.example.btl_truyentranh2.R;
import com.example.btl_truyentranh2.Sach;
import com.example.btl_truyentranh2.Trangconchinh;

import java.util.ArrayList;
import java.util.List;

public class TruyenHot_Adapter extends  BaseAdapter {
    // with custom file, it's compulsory to declare context
    private Context context;
    private ArrayList<Sach> lst_book;
    private int layout;

    public TruyenHot_Adapter(Context context, ArrayList<Sach> lst_book, int layout) {
        this.context = context;
        this.lst_book = lst_book;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return lst_book.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Sach temp = lst_book.get(position);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout,null);
        ImageView imageView = convertView.findViewById(R.id.img_view);
        TextView textView = convertView.findViewById(R.id.txtview);
//        ListView listChapters = convertView.findViewById(R.id.listChapters);

        String imageName = temp.getImg();
        int resID = ((Activity) context).getResources().
                getIdentifier(imageName, "drawable", ((Activity)context).getPackageName());
        imageView.setImageResource(resID);
        textView.setText(lst_book.get(position).getTitle_book());
//        ArrayAdapter<String> list= new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, temp.getChapters());
//        listChapters.setAdapter(list);
        return convertView;
    }

}
