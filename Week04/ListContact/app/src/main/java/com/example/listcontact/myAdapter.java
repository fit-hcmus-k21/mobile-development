package com.example.listcontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class myAdapter extends BaseAdapter {
    Random rand = new Random();
    private Context context;
    public  String[] names;
    public String[] phones;
    public Integer[] avatars;
    public myAdapter(Context maincontext, int layout, String[] name, String[] phone, Integer[] ava){
        context = maincontext;
        names = name;
        phones = phone;
        avatars = ava;
    }
    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int i) {
        return names[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = ((mainActivity)context).getLayoutInflater();
        View row = inflater.inflate(R.layout.item_contact,null);
        ImageView ava = (ImageView) row.findViewById(R.id.avatar);
        TextView name = (TextView) row.findViewById(R.id.txtName);
        TextView phone = (TextView) row.findViewById(R.id.txtPhone);
        ava.setImageResource(avatars[position]);
        name.setText(names[position]);
        phone.setText(phones[position]);
        return(row);
    }


}