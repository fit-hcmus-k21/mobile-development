package com.example.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment implements FragmentCallbacks {
    MainActivity main; TextView txtChoose;
    public static SecondFragment newInstance(String strArg1) {
        SecondFragment fragment = new SecondFragment();
        Bundle bundle = new Bundle(); bundle.putString("arg1", strArg1);
        fragment.setArguments(bundle);
        return fragment;
    }// newInstance
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
// Activities containing this fragment must implement interface: MainCallbacks
        if (!(getActivity() instanceof MainCallbacks)) {
            throw new IllegalStateException( "Activity must implement MainCallbacks");
        }
        main = (MainActivity) getActivity(); // use this reference to invoke main callbacks
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
// inflate res/layout_red.xml which includes a textview and a button
        LinearLayout view_layout_second = (LinearLayout) inflater.inflate(R.layout.second_fragment, null);
        txtChoose = (TextView) view_layout_second.findViewById(R.id.textView1_second_fragment);
// show string argument supplied by constructor (if any!)
        try { Bundle arguments = getArguments();
//            txtChoose.setText(arguments.getString("arg1", ""));
        }
        catch (Exception e) { Log.e("SECOND BUNDLE ERROR – ", "" + e.getMessage()); }

        return view_layout_second;
    }
    @Override
    public void onMsgFromMainToFragment(String strValue) {
// receiving a message from MainActivity (it may happen at any point in time)
        txtChoose.setText(strValue);
    }}// FragmentRed
