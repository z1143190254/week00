package com.bwie.yuel14.presenter;
/*
 *@auther:周鑫光
 *@Date: 2019/11/26
 *@Time:15:35
 *@Description:${DESCRIPTION}
 * */

import com.bwie.yuel14.Contract;
import com.bwie.yuel14.base.BasePresenter;
import com.bwie.yuel14.model.Imodel;

public class Presenter extends BasePresenter {

    private Contract.IModel imodel;

    @Override
    protected void inisModel() {
        imodel = new Imodel();
    }

    @Override
    public void onstart(String url) {
        imodel.onget(url, new Contract.MycallBack() {
            @Override
            public void onsuccess(String json) {
                get().onsuccess(json);
            }

            @Override
            public void onerror(String error) {
                get().onerror(error);
            }
        });
    }
}
