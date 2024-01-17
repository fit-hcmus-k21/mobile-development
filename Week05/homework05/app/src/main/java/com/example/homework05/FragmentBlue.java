package com.example.homework05;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentBlue extends Fragment implements FragmentCallBacks {
    TextView textview_blue;
    ListView listview_blue;
    Context context;
    MainActivity main;

    int currentPosition = 0;
    //
    // Create a Pair<String, Integer> String is represented for ID, and Integer will be store icon in Drawable foldera
    public static FragmentBlue newInstance(String strAgs) {
        FragmentBlue fragmentBlue = new FragmentBlue();
        Bundle bundle = new Bundle();
        bundle.putString("args1", strAgs);
        fragmentBlue.setArguments(bundle);
        return fragmentBlue;
    }
    static ArrayList<Student> students = new ArrayList<Student>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getActivity();
        main = (MainActivity) getActivity();

        students.add(new Student("A1_1234", "Trần Phước Nhân", "A1", 10, R.drawable.astronaut));
        students.add(new Student("A3_2234", "Dương Văn Đức", "A3",8,  R.drawable.bear));
        students.add(new Student("B4_4324", "Tống Thế Hải", "B4", 7, R.drawable.bearman));
        students.add(new Student("B1_1232", "Đặng Văn Dương", "B1", 9, R.drawable.boy));
        students.add(new Student("C2_2932",  "Nguyễn Thúc Minh Nhật", "C2", 10, R.drawable.ceo));
        students.add(new Student("D1_9493",  "Lý Nhã Linh", "D1", 5, R.drawable.chinesewoman));
        students.add(new Student("A1_1344", "Trần Văn Phương", "A1", 10, R.drawable.gamer));
        students.add(new Student("H1_4575", "Trần Ngọc Phú", "H1", 8, R.drawable.officer));
        students.add(new Student("H2_3421", "Nguyễn Thị Ngọc Châu", "H2", 9, R.drawable.rabbit));
        students.add(new Student("D1_4324", "Nguyễn Thị Thanh Ngân", "D1", 10, R.drawable.secretary));
        students.add(new Student("E1_1234", "Nguyễn Thị Như Ý", "E1", 10, R.drawable.student));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.layout_blue, null);

        textview_blue = (TextView) view.findViewById(R.id.textview_blue);
        listview_blue = (ListView) view.findViewById(R.id.listview_blue);

        listview_blue.setAdapter(new MyListViewAdapter(context, R.layout.layout_frame_icon_id, students));

        // Default selection
        listview_blue.setSelection(0);
        listview_blue.smoothScrollToPosition(0);

        listview_blue.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                textview_blue.setText(students.get(i).id);
                currentPosition = i;
                main.onMessageFromFragmentToMain("BLUE-FRAGMENT", i, students);
            }
        });
        return view;
    }

    @Override
    public void onMessageFromMainToFragment(String sender, int type, ArrayList<Student> nullStudent) {
        int position = 0;

        Log.d("BLUE-FRAGMENT", "onMessageFromMainToFragment0: " + currentPosition);
        if(type == 10){
            position = students.size() - 1;
        }

        else if(type == -1){

            Log.d("BLUE-FRAGMENT", "onMessageFromMainToFragment-1: " + currentPosition);
            if(currentPosition == 0){
                position = 0;
            }
            else{
                position = currentPosition - 1;
            }
        }
        else if(type == 1){
            Log.d("BLUE-FRAGMENT", "onMessageFromMainToFragment1: " + currentPosition);
            if(currentPosition == students.size() - 1){
                position = students.size() - 1;
            }
            else{
                position = currentPosition + 1;
            }
        }
        else if(type == 0){
            position = 0;
        }
        currentPosition = position;

        Log.d("BLUE-FRAGMENT", "onMessageFromMainToFragment: " + position);
        listview_blue.requestFocusFromTouch();
        listview_blue.setSelection(position);
        listview_blue.smoothScrollToPosition(position);
        textview_blue.setText(students.get(position).id);
        main.onMessageFromFragmentToMain("BLUE-FRAGMENT", position, students);
    }
}
