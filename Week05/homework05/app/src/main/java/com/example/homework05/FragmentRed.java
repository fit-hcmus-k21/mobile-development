package com.example.homework05;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class FragmentRed extends Fragment implements FragmentCallBacks{
    Context context;
    MainActivity main;
    TextView textview_red;
    TextView txtview_name;
    TextView txtview_class;
    TextView txtview_point;
    Button button_next, button_previous, button_last, button_first;
    ImageView imgview_avatar;

    public static FragmentRed newInstance(String strAgs) {
        FragmentRed fragmentRed = new FragmentRed();
        Bundle bundle = new Bundle();
        bundle.putString("args1", strAgs);
        fragmentRed.setArguments(bundle);
        return fragmentRed;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
        main = (MainActivity) getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        view = (View) inflater.inflate(R.layout.layout_red, null);

        textview_red = (TextView) view.findViewById(R.id.textview_red);
        txtview_name = (TextView) view.findViewById(R.id.textview_name);
        txtview_class = (TextView) view.findViewById(R.id.textview_class);
        txtview_point = (TextView) view.findViewById(R.id.textview_point);

        button_first = (Button) view.findViewById(R.id.button_first);
        button_previous = (Button) view.findViewById(R.id.button_previous);
        button_next = (Button) view.findViewById(R.id.button_next);
        button_last = (Button) view.findViewById(R.id.button_last);
        imgview_avatar = (ImageView) view.findViewById(R.id.imageview_avatar);

        button_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.onMessageFromFragmentToMain("RED-FRAGMENT", 0, null);
            }
        });
        button_last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.onMessageFromFragmentToMain("RED-FRAGMENT", 10, null);
            }
        });
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.onMessageFromFragmentToMain("RED-FRAGMENT", 1, null);
            }
        });
        button_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.onMessageFromFragmentToMain("RED-FRAGMENT", -1, null);
            }
        });


        return view;
    }

    @Override
    public void onMessageFromMainToFragment(String sender, int position, ArrayList<Student> students) {
        if(position == 0){
            button_first.setEnabled(false);
            button_previous.setEnabled(false);
            button_next.setEnabled(true);
            button_last.setEnabled(true);
        }
        else if(position == students.size() - 1){
            button_first.setEnabled(true);
            button_previous.setEnabled(true);
            button_next.setEnabled(false);
            button_last.setEnabled(false);
        }
        else{
            button_first.setEnabled(true);
            button_previous.setEnabled(true);
            button_next.setEnabled(true);
            button_last.setEnabled(true);
        }
        textview_red.setText(students.get(position).id);
        txtview_name.setText("Họ tên: " + students.get(position).name);
        txtview_class.setText("Lớp: " + students.get(position).class_name);
        txtview_point.setText("Điểm: " + students.get(position).point.toString());
        imgview_avatar.setImageResource(students.get(position).avatar);
    }



}
