package com.example.fragmenttest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragmenttest.HomeFragment.Fragment1;
import com.example.fragmenttest.HomeFragment.Fragment2;
import com.example.fragmenttest.HomeFragment.Fragment3;
import com.example.fragmenttest.HomeFragment.Fragment4;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends FragmentActivity {


    Button btnOne, btnTwo, btnThree, btnFour;
    ViewPager vpContent;


    List<Fragment> fragmentList;
    HomeVpAdapter homeVpAdapter;

    View.OnClickListener btnOnClickListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();


        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());
        fragmentList.add(new Fragment3());
        fragmentList.add(new Fragment4());

        vpContent.setAdapter(homeVpAdapter);
        btnOne.setOnClickListener(btnOnClickListener);
        btnTwo.setOnClickListener(btnOnClickListener);
        btnThree.setOnClickListener(btnOnClickListener);
        btnFour.setOnClickListener(btnOnClickListener);
    }

    public void initData() {
        fragmentList = new ArrayList<>();
        homeVpAdapter = new HomeVpAdapter(getSupportFragmentManager());

        btnOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_one:
                        vpContent.setCurrentItem(0, false);
                        break;
                    case R.id.btn_two:
                        vpContent.setCurrentItem(1, false);
                        break;
                    case R.id.btn_three:
                        vpContent.setCurrentItem(2, false);
                        break;
                    case R.id.btn_four:
                        vpContent.setCurrentItem(3, false);
                        break;
                }
            }
        };

    }

    public void initView() {
        btnOne = (Button) findViewById(R.id.btn_one);
        btnTwo = (Button) findViewById(R.id.btn_two);
        btnThree = (Button) findViewById(R.id.btn_three);
        btnFour = (Button) findViewById(R.id.btn_four);

        vpContent = (ViewPager) findViewById(R.id.vp_content);
    }


    class HomeVpAdapter extends FragmentPagerAdapter {

        public HomeVpAdapter(FragmentManager fm) {
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
}
