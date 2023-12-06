package com.example.testsqlite;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class PersonAdapter extends BaseAdapter {
    private MainActivity context;
    private int layout;
    private List<Person> person_list;

    public PersonAdapter(MainActivity context, int layout, List<Person> person_list) {
        this.context = context;
        this.layout = layout;
        this.person_list = person_list;
    }

    @Override
    public int getCount() {
        return person_list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder{
        TextView txtview;
        ImageView img_edit, img_del;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder;
        if(convertView == null) {
            viewholder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            // ánh xạ cho nó để xử li sự kiện xoá và sửa
            viewholder.txtview = (TextView) convertView.findViewById(R.id.txtview);
            convertView.setTag(viewholder);
            viewholder.img_del = (ImageView) convertView.findViewById(R.id.img_del);
            viewholder.img_edit = (ImageView) convertView.findViewById(R.id.img_edit);
        }
        else {
            viewholder = (ViewHolder) convertView.getTag();
        }
        final Person person = person_list.get(position);
        viewholder.txtview.setText(person.getName());
        // xử lí sự kiện cho imgview
        viewholder.img_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "sửa", Toast.LENGTH_SHORT).show();
                context.popup_update(person.getName(), person.getId());
            }
        });
        viewholder.img_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "xoá", Toast.LENGTH_SHORT).show();
                context.DialogDelete(person.getName(), person.getId());
            }
        });

        return convertView;
    }
}
