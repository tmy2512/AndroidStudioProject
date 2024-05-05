package Gridview_TruyenHot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.btl_truyentranh2.EntitySinhVien;
import com.example.btl_truyentranh2.R;
import com.example.btl_truyentranh2.Sach;

import java.util.ArrayList;

public class SinhVienAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<EntitySinhVien> lstSinhVien;
    private int layout;

    public SinhVienAdapter(Context context, ArrayList<EntitySinhVien> lstSinhVien, int layout) {
        this.context = context;
        this.lstSinhVien = lstSinhVien;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return 0;
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
        EntitySinhVien sv = lstSinhVien.get(position);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(layout,null);

        TextView txtVID = convertView.findViewById(R.id.txtID);
        TextView txtVTen = convertView.findViewById(R.id.txtTen);
        TextView txtVDiaChi = convertView.findViewById(R.id.txtDiaChi);
        TextView txtVNgaySinh = convertView.findViewById(R.id.txtNgaySinh);
        TextView txtVGioiTinh = convertView.findViewById(R.id.txtGioiTinh);
        TextView txtVEmail = convertView.findViewById(R.id.txtEmail);
        TextView txtVDiemTB = convertView.findViewById(R.id.txtDiemTB);

        txtVID.setText(lstSinhVien.get(position).getId());
        txtVTen.setText(lstSinhVien.get(position).getName());
        txtVDiaChi.setText(lstSinhVien.get(position).getAddress());
        txtVNgaySinh.setText(lstSinhVien.get(position).getBirthday());
        txtVGioiTinh.setText(lstSinhVien.get(position).getGender());
        txtVEmail.setText(lstSinhVien.get(position).getEmail());
        txtVDiemTB.setText(lstSinhVien.get(position).getDiemTB());


        return convertView;
    }
}
