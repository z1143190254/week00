package com.bwie.yuel14;
/*
 *@auther:周鑫光
 *@Date: 2019/11/26
 *@Time:15:32
 *@Description:${DESCRIPTION}
 * */

public interface Contract {
    interface MycallBack {
        void onsuccess(String json);

        void onerror(String error);
    }

    interface IModel {
        void onget(String url, MycallBack mycallBack);

        void onpost(String url, MycallBack mycallBack);
    }

    interface Iview {
        void onsuccess(String json);

        void onerror(String error);
    }

    interface Presenter {
        void onstart(String url);
    }

}
