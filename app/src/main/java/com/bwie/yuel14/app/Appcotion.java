package com.bwie.yuel14.app;
/*
 *@auther:周鑫光
 *@Date: 2019/11/26
 *@Time:15:24
 *@Description:${DESCRIPTION}
 * */

import android.app.Application;
import android.content.Context;

public class Appcotion extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
}
