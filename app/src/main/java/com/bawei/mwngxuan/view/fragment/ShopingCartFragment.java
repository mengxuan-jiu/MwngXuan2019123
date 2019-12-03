package com.bawei.mwngxuan.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.bawei.mwngxuan.R;
import com.bawei.mwngxuan.contract.IMyContract;
import com.bawei.mwngxuan.mabel.bean.Mall;
import com.bawei.mwngxuan.presenter.MyPresenter;
import com.bawei.mwngxuan.view.adapter.MyAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShopingCartFragment extends Fragment {


    private GridView gv;

    public ShopingCartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_shoping_cart, container, false);
        gv = inflate.findViewById(R.id.scf_gv);
        MyPresenter mypresenter = new MyPresenter();
        mypresenter.getDate(new IMyContract.IView() {
            @Override
            public void success(Mall mall) {
                List<Mall.ShopGridDataBean> list = mall.getShopGridData();
                gv.setAdapter(new MyAdapter(list));
            }

            @Override
            public void failure(Throwable throwable) {

            }
        });
        return inflate;
    }

}
