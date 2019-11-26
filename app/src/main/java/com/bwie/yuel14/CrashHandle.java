package com.bwie.yuel14;
/*
 *@auther:周鑫光
 *@Date: 2019/11/26
 *@Time:20:21
 *@Description:${DESCRIPTION}
 * */

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

public class CrashHandle implements Thread.UncaughtExceptionHandler {
    private Context context;
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

    private static final CrashHandle ourInstance = new CrashHandle();

    public static CrashHandle getInstance() {
        return ourInstance;
    }

    private CrashHandle() {

    }

    public void init(Context context) {
        this.context = context;
        this.uncaughtExceptionHandler = uncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (!han(e) && uncaughtExceptionHandler != null) {
            uncaughtException(t, e);
        } else {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    }

    public Boolean han(Throwable e) {
        if (e == null) {
            return false;
        }
        new Thread() {
            @Override
            public void run() {
                super.run();
                Looper.prepare();
                Toast.makeText(context, "程序错误", Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        }.start();
        return true;
    }

}
