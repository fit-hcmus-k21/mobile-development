package com.example.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
    String[] data = {"A1", "A2", "A3", "A4", "A5"};
    ListView myListView;


    TextView txtChoose;

    MainActivity main;
    Context context = null;


    public static FirstFragment newInstance(String Arg) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString("strArg1", Arg);

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle saveStateInstance) {
        super.onCreate(saveStateInstance);
        try {
            context = getActivity();
            main = (MainActivity) getActivity();

        } catch (IllegalStateException e) {
            throw new IllegalStateException("MainActivity must implement callbacks");

        }








    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
// inflate res/layout_blue.xml to make GUI holding a TextView and a ListView
        LinearLayout layout_first = (LinearLayout) inflater.inflate(R.layout.first_fragment, null);
// plumbing – get a reference to textview and listview
        final TextView txtChoose = (TextView) layout_first.findViewById(R.id.textView_firstFragment);
        ListView listView = (ListView) layout_first.findViewById(R.id.listView_firstFragment);


//        List<Integer> currentIcons = new ArrayList<>({R.drawable.icon_01, R.drawable.icon_02, R.drawable.icon_03, R.drawable.icon_04, R.drawable.icon_05});
        List<Integer> currentIcons = new ArrayList<>();
        currentIcons.add(R.drawable.icon_01);
        currentIcons.add(R.drawable.icon_02);
        currentIcons.add(R.drawable.icon_03);
        currentIcons.add(R.drawable.icon_04);
        currentIcons.add(R.drawable.icon_05);

        //                set adapter for ListView
        CustomContactItemAdapter adapter = new CustomContactItemAdapter(context, R.layout.custom_contact_item, data, currentIcons);
        myListView.setAdapter(adapter);

//                        set on click for item
//        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                                              @Override
//                                              public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
////                                                       currentItemChooseTextView.setText("You choose: " + listNames.get(currentPage * CONTACT_PER_PAGE + pos));
//                                              }
//                                          }
//        );


//        listView.setBackgroundColor(Color.parseColor(“#ffccddff”));
// define a simple adapter to fill rows of the listview
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
//                android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);
// show listview from the top
        listView.setSelection(0);
        listView.smoothScrollToPosition(0);
// react to click events on listview’srows
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
// inform enclosing MainActivity of the row’s position just selected
                main.onMsgFromFragToMain("FIRST-FRAG", data[position]);
                txtChoose.setText("Mã số : " + data[position]);
            }
        });
// do this for each row (ViewHolder-Pattern could be used for better performance!)
        return layout_first;
    }// onCreateView



    //    func to get list icon
    private List<Integer> loadListIconIds(int num, Resources rs) {
        List<Integer> icons = new ArrayList<Integer>();
        if (rs == null) {
            Toast.makeText(context, "null resources", Toast.LENGTH_SHORT).show();
        }

//        format of img file name: icon_XX.jpg || XX is number from 01 - 38
        String name = "icon_";

        for (int i = 1; i <= num ; i++) {
            String id = i < 10 ? "0" + i : String.valueOf(i);

//            Integer resId = rs.getIdentifier(name + id, "drawable", getPackageName());
//            icons.add(resId);
        }

        return icons;
    }


}// class



