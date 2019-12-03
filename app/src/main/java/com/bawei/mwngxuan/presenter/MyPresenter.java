package com.bawei.mwngxuan.presenter;

import com.bawei.mwngxuan.contract.IMyContract;
import com.bawei.mwngxuan.mabel.MyMabel;
import com.bawei.mwngxuan.mabel.bean.Mall;
import com.bawei.mwngxuan.util.NetUtil;

/**
 * @包名 com.bawei.mwngxuan.presenter
 * @mengxuan
 * @日期2019/12/3
 * @日期2019 : 12:03
 * @项目名MwngXuan2019123
 * @类名Mypresenter
 **/
public class MyPresenter {

    private MyMabel myMabel;
    ;

    public void getDate(final IMyContract.IView iView) {
        myMabel = new MyMabel();
        myMabel.getDate(new IMyContract.IMabel() {
            @Override
            public void success(Mall mall) {
                iView.success(mall);
            }

            @Override
            public void failure(Throwable throwable) {
                iView.failure(throwable);
            }
        });

    }


}
