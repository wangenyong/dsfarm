package com.wangenyong.dsfarm.module.webview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.wangenyong.dsfarm.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewActivity extends AppCompatActivity {
    private final static String KEY_WEBVIEW = "com.dsfarm.webview.key";

    @BindView(R.id.toolbar_webview) Toolbar mToolbar;
    @BindView(R.id.webview) WebView mWebView;


    public static Intent newIntent(Context context, String s) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(KEY_WEBVIEW, s);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        mWebView.loadUrl("http://www.dswey.com");
    }
}
