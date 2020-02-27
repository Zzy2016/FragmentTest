package com.example.fragmentstateadaptertest;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class BlankFragment1 extends Fragment {

    TextView tv1;
    Calendar calendar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_blank_fragment1, container, false);
        tv1=view.findViewById(R.id.tv1);
        calendar=Calendar.getInstance();
        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if(isVisibleToUser){
            Log.e("Fragment1","setUserVisibleHint");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        tv1.setText(calendar.get(Calendar.HOUR_OF_DAY)+"  "+calendar.get(Calendar.MINUTE)+"  "+calendar.get(Calendar.SECOND));
        Log.e("Fragment1","onResume");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("Fragment1","onActivityCreated");

    }



    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e("BlankFragment1","onHiddenChanged   "+hidden);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
