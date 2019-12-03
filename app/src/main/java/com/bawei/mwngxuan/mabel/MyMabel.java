package com.bawei.mwngxuan.mabel;

import com.bawei.mwngxuan.contract.IMyContract;
import com.bawei.mwngxuan.mabel.bean.Mall;
import com.bawei.mwngxuan.util.NetUtil;
import com.google.gson.Gson;

/**
 * @包名 com.bawei.mwngxuan.mabel
 * @mengxuan
 * @日期2019/12/3
 * @日期2019 : 12:03
 * @项目名MwngXuan2019123
 * @类名MyMabel
 **/
public class MyMabel {
    public void getDate(final IMyContract.IMabel iMabel) {

        NetUtil.getInstance().get("http://blog.zhaoliang5156.cn/api/mall/mall.json", new NetUtil.MyCoolBack() {
            @Override
            public void git(String s) {
                Mall mall = new Gson().fromJson(s, Mall.class);
                iMabel.success(mall);
            }

            @Override
            public void failure(Throwable throwable) {
                iMabel.failure(throwable);
            }
        });

    }
}
