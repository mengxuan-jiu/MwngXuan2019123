package com.bawei.mwngxuan.contract;

import com.bawei.mwngxuan.mabel.bean.Mall;

/**
 * @包名 com.bawei.mwngxuan.contract
 * @mengxuan
 * @日期2019/12/3
 * @日期2019 : 12:03
 * @项目名MwngXuan2019123
 * @类名IContract
 **/
public interface IMyContract {
    interface IView{
//        成功 失败
        void success(Mall mall);
        void failure(Throwable throwable);
    }

    interface IMabel{
        //        成功 失败
        void success(Mall mall);
        void failure(Throwable throwable);
    }
}
