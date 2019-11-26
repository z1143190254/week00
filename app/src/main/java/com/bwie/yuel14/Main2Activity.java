package com.bwie.yuel14;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonm;
    private WebView web;
    String url = "file:///android_asset/info.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    @SuppressLint("JavascriptInterface")
    private void initView() {
        buttonm = (Button) findViewById(R.id.buttonm);
        web = (WebView) findViewById(R.id.web);

        buttonm.setOnClickListener(this);
        web.addJavascriptInterface(new JsDemo(), "android");
        web.loadUrl(url);
        web.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }
        });
        web.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        WebSettings settings = web.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setJavaScriptEnabled(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonm:
                web.loadUrl("Javascript: changeTitle('哈哈哈')");
                break;
            case R.id.buttonbuy:
                web.loadUrl("Javascript:buy()");
                break;
        }
    }

    class JsDemo {
        @JavascriptInterface
        public void buy() {
            Toast.makeText(Main2Activity.this, "快快快", Toast.LENGTH_SHORT).show();
        }

    }
}
