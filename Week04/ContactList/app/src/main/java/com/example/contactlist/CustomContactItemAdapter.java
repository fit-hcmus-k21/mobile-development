package com.example.contactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

public class CustomContactItemAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return listName.size();
    }

    @Override
    public Object getItem(int pos) {
        return -1;
    }

    @Override
     public long getItemId (int pos) {
        return pos;
    }

    Context context;
    List<Integer> icons;
    List<String> listName;
    List<String> phoneNumbers;
    Integer layoutToInflate;

    public CustomContactItemAdapter(Context context, int layoutToBeInflated, List<String> listName, List<String> phoneNumbers, List<Integer> icons) {
        this.context = context;
        this.listName = listName;
        this.phoneNumbers = phoneNumbers;
        this.icons = icons;
        this.layoutToInflate = layoutToBeInflated;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        View viewItem = convertView;
        if (viewItem == null ) {
            LayoutInflater inflater = LayoutInflater.from(context);
            viewItem = inflater.inflate(layoutToInflate, parent, false);
        }

//        binding
        TextView name = viewItem.findViewById(R.id.name);
        TextView phoneNumber = viewItem.findViewById(R.id.phoneNumber);
        ImageView icon = viewItem.findViewById(R.id.icon);

//        setting
        name.setText(listName.get(pos));
        phoneNumber.setText(phoneNumbers.get(pos));
        icon.setImageResource(icons.get(pos));

        return viewItem;
    }
}
