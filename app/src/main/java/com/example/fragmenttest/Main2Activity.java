package com.example.fragmenttest;

import android.os.Bundle;

import com.example.fragmenttest.HomeFragment.Fragment1;
import com.example.fragmenttest.HomeFragment.Fragment2;
import com.example.fragmenttest.HomeFragment.Fragment3;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class Main2Activity extends FragmentActivity {

    TabLayout tabLayout;
    ViewPager vpContent;
    String[] titleStrings = new String[]{"标题1", "标题2标题2标题2标题2", "标题3"};
    List<Fragment> fragmentList;

    VpAdapter vpAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tabLayout = (TabLayout) findViewById(R.id.tab);

        fragmentList = new ArrayList<>();

        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());
        fragmentList.add(new Fragment3());

        vpContent = (ViewPager) findViewById(R.id.vp_content);

        vpAdapter = new VpAdapter(getSupportFragmentManager());

        vpContent.setAdapter(vpAdapter);

        tabLayout.setupWithViewPager(vpContent);

    }


    class VpAdapter extends FragmentPagerAdapter {

        public VpAdapter(FragmentManager fm) {
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

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titleStrings[position];
        }
    }
}
