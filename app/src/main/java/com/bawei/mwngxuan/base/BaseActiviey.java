package com.bawei.mwngxuan.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.bawei.mwngxuan.R;
import com.bawei.mwngxuan.view.fragment.OtherFragment;
import com.bawei.mwngxuan.view.fragment.ShopingCartFragment;

import java.util.ArrayList;

/**
 * @包名 com.bawei.mwngxuan.base
 * @mengxuan
 * @日期2019/12/3
 * @日期2019 : 12:03
 * @项目名MwngXuan2019123
 * @类名BaseActiviey
 **/
public abstract class BaseActiviey extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        initView();
        initDate();
    }

    protected abstract int layoutId();

    protected abstract void initView();

    protected abstract void initDate();
}

