package com.example.fragmenttest.HomeFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fragmenttest.R;
import com.example.fragmenttest.SecondFragment.SubFragment1;
import com.example.fragmenttest.SecondFragment.SubFragment2;
import com.example.fragmenttest.SecondFragment.SubFragment3;
import com.example.fragmenttest.SecondFragment.SubFragment4;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


public class Fragment2 extends Fragment {

    private String TAG = "Fragment2--》Home";

    Button btnSub1, btnSub2, btnSub3, btnSub4;
    ViewPager vpContent;

    View.OnClickListener subOnClickListener;

    List<Fragment> fragmentList;
    SubAdapter subAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment2, container, false);

        initData();
        initView(view);
        return view;
    }

    public void initData() {
        subOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_sub1:
                        vpContent.setCurrentItem(0, false);
                        break;
                    case R.id.btn_sub2:
                        vpContent.setCurrentItem(1, false);
                        break;
                    case R.id.btn_sub3:
                        vpContent.setCurrentItem(2, false);
                        break;
                    case R.id.btn_sub4:
                        vpContent.setCurrentItem(3, false);
                        break;
                }
            }
        };

        fragmentList = new ArrayList<>();
        fragmentList.add(new SubFragment1());
        fragmentList.add(new SubFragment2());
        fragmentList.add(new SubFragment3());
        fragmentList.add(new SubFragment4());

        subAdapter = new SubAdapter(getChildFragmentManager());

    }

    public void initView(View view) {
        btnSub1 = view.findViewById(R.id.btn_sub1);
        btnSub2 = view.findViewById(R.id.btn_sub2);
        btnSub3 = view.findViewById(R.id.btn_sub3);
        btnSub4 = view.findViewById(R.id.btn_sub4);
        vpContent = view.findViewById(R.id.vp_content);

        btnSub1.setOnClickListener(subOnClickListener);
        btnSub2.setOnClickListener(subOnClickListener);
        btnSub3.setOnClickListener(subOnClickListener);
        btnSub4.setOnClickListener(subOnClickListener);

        vpContent.setAdapter(subAdapter);

    }

    class SubAdapter extends FragmentPagerAdapter {
        public SubAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            Log.e(TAG, isVisibleToUser + "");
            vpContent.setCurrentItem(0,false);
        }
    }
}
