package com.example.fragmentstateadaptertest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;


public class BlankFragment2 extends Fragment {
    Calendar calendar;
    TextView tv2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);
        tv2=view.findViewById(R.id.tv2);
        calendar=Calendar.getInstance();

//        tv2.setText(calendar.get(Calendar.HOUR_OF_DAY)+"  "+calendar.get(Calendar.MINUTE)+"  "+calendar.get(Calendar.SECOND));
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(isVisibleToUser){
            tv2.setText(calendar.get(Calendar.HOUR_OF_DAY)+"  "+calendar.get(Calendar.MINUTE)+"  "+calendar.get(Calendar.SECOND));

        }
    }
}
