package com.example.fragmentstateadaptertest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] titles = new String[]{"tab1", "tab2", "tab3", "tab4"};
    ViewPager vpContent;
    TabLayout tlTitle;
    List<Fragment> fragmentList;
    MyAdapter myAdapter;
    MyAdapter1 myAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        vpContent = (ViewPager) findViewById(R.id.vp_content);
        tlTitle = (TabLayout) findViewById(R.id.tl_titlt);
        fragmentList = new ArrayList<>();
        fragmentList.add(new BlankFragment1());
        fragmentList.add(new BlankFragment2());
        fragmentList.add(new BlankFragment3());
        fragmentList.add(new BlankFragment4());
        myAdapter = new MyAdapter(getSupportFragmentManager());

        myAdapter1 = new MyAdapter1(getSupportFragmentManager());
        vpContent.setAdapter(myAdapter);
//        vpContent.setAdapter(myAdapter1);
        tlTitle.setupWithViewPager(vpContent);
    }

    class MyAdapter extends FragmentStatePagerAdapter {

        public MyAdapter(FragmentManager fm) {
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
            return titles[position];
        }
    }

    class MyAdapter1 extends FragmentPagerAdapter {

        public MyAdapter1(FragmentManager fm) {
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
            return titles[position];
        }
    }
}
