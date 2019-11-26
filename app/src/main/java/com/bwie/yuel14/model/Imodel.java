package com.bwie.yuel14.model;
/*
 *@auther:周鑫光
 *@Date: 2019/11/26
 *@Time:15:34
 *@Description:${DESCRIPTION}
 * */

import com.bwie.yuel14.Contract;
import com.bwie.yuel14.until.Until;

public class Imodel implements Contract.IModel {
    @Override
    public void onget(String url, final Contract.MycallBack mycallBack) {
        Until.getInstance().onget(url, new Until.MycallBack() {
            @Override
            public void onsuccess(String json) {
                mycallBack.onsuccess(json);
            }

            @Override
            public void onerror(String error) {
                mycallBack.onerror(error);
            }
        });
    }

    @Override
    public void onpost(String url, Contract.MycallBack mycallBack) {

    }
}
