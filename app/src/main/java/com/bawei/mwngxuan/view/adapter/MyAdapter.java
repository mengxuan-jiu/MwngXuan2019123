package com.bawei.mwngxuan.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.mwngxuan.R;
import com.bawei.mwngxuan.mabel.bean.Mall;
import com.bawei.mwngxuan.util.NetUtil;

import java.util.List;

/**
 * @包名 com.bawei.mwngxuan.view.adapter
 * @mengxuan
 * @日期2019/12/3
 * @日期2019 : 12:03
 * @项目名MwngXuan2019123
 * @类名MyAdapter
 **/
public class MyAdapter extends BaseAdapter {
    private List<Mall.ShopGridDataBean> list;

    public MyAdapter(List<Mall.ShopGridDataBean> list) {

        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHordy viewHordy = new ViewHordy();

        if (view == null) {

            view = View.inflate(viewGroup.getContext(), R.layout.ll, null);
            viewHordy.imageView = view.findViewById(R.id.im);
            viewHordy.textView = view.findViewById(R.id.tt);
            view.setTag(viewHordy);
        } else {
          viewHordy= (ViewHordy) view.getTag();
        }
        Mall.ShopGridDataBean bean = list.get(i);
      NetUtil.getInstance().getBitmap(bean.getImageurl(), viewHordy.imageView);
        viewHordy.textView.setText(bean.getPrice());
        return view;
    }


    private class ViewHordy {
        ImageView imageView;
        TextView textView;
    }
}
