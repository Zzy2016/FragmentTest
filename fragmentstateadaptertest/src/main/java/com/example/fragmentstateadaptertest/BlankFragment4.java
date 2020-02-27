package com.example.fragmentstateadaptertest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;

import androidx.fragment.app.Fragment;


public class BlankFragment4 extends Fragment {
    TextView tv4;
    Calendar calendar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank_fragment4, container, false);
        tv4=view.findViewById(R.id.tv4);
        calendar=Calendar.getInstance();
//        tv4.setText(calendar.get(Calendar.HOUR_OF_DAY)+"  "+calendar.get(Calendar.MINUTE)+"  "+calendar.get(Calendar.SECOND));
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(isVisibleToUser){
            tv4.setText(calendar.get(Calendar.HOUR_OF_DAY)+"  "+calendar.get(Calendar.MINUTE)+"  "+calendar.get(Calendar.SECOND));

        }
    }
}
