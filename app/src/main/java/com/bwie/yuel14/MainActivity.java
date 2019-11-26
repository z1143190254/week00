package com.bwie.yuel14;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.bwie.yuel14.adapter.MyBase;
import com.bwie.yuel14.base.BaseActivity;
import com.bwie.yuel14.base.BasePresenter;
import com.bwie.yuel14.bean.StudentBean;
import com.bwie.yuel14.presenter.Presenter;
import com.bwie.yuel14.until.Until;
import com.google.gson.Gson;

import java.net.URLEncoder;
import java.util.List;

public class MainActivity extends BaseActivity {

    private Myline myline;
    private RecyclerView recy;
    String url = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?";

    @Override
    protected void startCoding() {

    }

    @Override
    protected BasePresenter inisPresenter() {
        return new Presenter();
    }

    @Override
    protected void inisView() {
        myline = (Myline) findViewById(R.id.myline);
        recy = (RecyclerView) findViewById(R.id.recy);
        recy.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        getInfo(myline.setText());
        myline.onSetname(new Myline.SetName() {
            @Override
            public void onSetnamea(String name) {
                getInfo(name);
            }
        });

    }

    private void getInfo(String name) {
        Until.getInstance().onget(url + "keyword=" + URLEncoder.encode(name) + "&page=1&count=5", new Until.MycallBack() {
            @Override
            public void onsuccess(String json) {
                StudentBean studentBean = new Gson().fromJson(json, StudentBean.class);
                List<StudentBean.ResultBean> result = studentBean.getResult();
                MyBase myBase = new MyBase(MainActivity.this, result);
                recy.setAdapter(myBase);
                myBase.onSetClick(new MyBase.Click() {
                    @Override
                    public void onsetClick(int posion) {
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onerror(String error) {

            }
        });

    }

    @Override
    protected int inisid() {
        return R.layout.activity_main;
    }


    @Override
    public void onsuccess(String json) {

    }

    @Override
    public void onerror(String error) {

    }
}
