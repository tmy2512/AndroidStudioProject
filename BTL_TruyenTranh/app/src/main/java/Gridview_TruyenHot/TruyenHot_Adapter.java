package Gridview_TruyenHot;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.btl_truyentranh.MainActivity;
import com.example.btl_truyentranh.R;
import com.example.btl_truyentranh.Trangconchinh;

import java.util.List;

public class TruyenHot_Adapter extends  BaseAdapter {
    // with custom file, it's compulsory to declare context
    private Context context;
    private List<HotAdapter_Helper> lst_book;
    private int layout;

    public TruyenHot_Adapter(Context context, List<HotAdapter_Helper> lst_book, int layout) {
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
        HotAdapter_Helper temp = lst_book.get(position);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout,null);
        ImageView imageView = convertView.findViewById(R.id.img_view);
        TextView textView = convertView.findViewById(R.id.txtview);

        imageView.setImageResource(lst_book.get(position).getImg());
        textView.setText(lst_book.get(position).getTitle_book());
        return convertView;
    }

}
