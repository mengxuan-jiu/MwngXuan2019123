package com.bawei.mwngxuan.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.bawei.mwngxuan.R;
import com.bawei.mwngxuan.base.BaseActiviey;
import com.bawei.mwngxuan.view.fragment.OtherFragment;
import com.bawei.mwngxuan.view.fragment.ShopingCartFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActiviey {

    private RadioGroup rg;
    private ViewPager vp;

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        rg = findViewById(R.id.m_rg);
        vp = findViewById(R.id.m_v);
    }

    @Override
    protected void initDate() {
        final ArrayList<Fragment> list = new ArrayList<>();
        OtherFragment otherFragment1 = new OtherFragment();
        OtherFragment otherFragment2 = new OtherFragment();
        OtherFragment otherFragment3 = new OtherFragment();
        ShopingCartFragment shopingCartFragment = new ShopingCartFragment();
        OtherFragment otherFragment4 = new OtherFragment();

        list.add(otherFragment1);
        list.add(otherFragment2);
        list.add(otherFragment3);
        list.add(shopingCartFragment);
        list.add(otherFragment4);

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                rg.check(rg.getChildAt(i).getId());
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.m_rb1:

                        break;
                    case R.id.m_rb2:

                        break;
                    case R.id.m_rb3:

                        break;
                    case R.id.m_rb4:

                        break;
                    case R.id.m_rb5:

                        break;
                }
            }
        });
    }
}
