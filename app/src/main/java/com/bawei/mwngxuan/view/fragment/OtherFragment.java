package com.bawei.mwngxuan.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.mwngxuan.R;
import com.bawei.mwngxuan.util.NetUtil;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtherFragment extends Fragment {


    private ImageView im;

    public OtherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        im = view.findViewById(R.id.of_im);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        if ( NetUtil.getInstance().hasNetwork(getActivity())) {

            im.setVisibility(View.VISIBLE);
        }else {
            im.setVisibility(View.GONE);
        }
    }
}
