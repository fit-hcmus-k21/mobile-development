package com.example.homework05;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListViewAdapter extends BaseAdapter {
    private Context context;
    ArrayList<Student> students;

    public MyListViewAdapter(Context context, int layout, ArrayList<Student> students){
        this.context = context;
        this.students = students;
    }

    public void setSelectedPosition(int position){

    }
    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int i) {
        return students.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View viewConvert, ViewGroup viewGroup) {
        View view;
        if(viewConvert == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.layout_frame_icon_id, null);
        }else{
            view = viewConvert;
        }



        TextView textview_id = (TextView) view.findViewById(R.id.textview_id);
        textview_id.setText(students.get(position).id);
        ImageView imageview_icon = (ImageView) view.findViewById(R.id.imageview_icon);
        imageview_icon.setImageResource(students.get(position).avatar);
        return view;
    }
}
