package com.example.fragmentstateadaptertest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;

import androidx.fragment.app.Fragment;



public class BlankFragment3 extends Fragment {
    Calendar calendar;
    TextView tv3;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_blank_fragment3, container, false);
        tv3=view.findViewById(R.id.tv3);
        calendar=Calendar.getInstance();
//        tv3.setText(calendar.get(Calendar.HOUR_OF_DAY)+"  "+calendar.get(Calendar.MINUTE)+"  "+calendar.get(Calendar.SECOND));
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(isVisibleToUser){
            tv3.setText(calendar.get(Calendar.HOUR_OF_DAY)+"  "+calendar.get(Calendar.MINUTE)+"  "+calendar.get(Calendar.SECOND));

        }
    }
}
