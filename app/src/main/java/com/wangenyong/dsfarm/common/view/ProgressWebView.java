package com.wangenyong.dsfarm.common.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

/**
 * Created by wangenyong on 2017/2/3.
 */

public class ProgressWebView extends WebView {
    private ProgressBar mProgressBar;
    private Handler handler;

    public ProgressWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mProgressBar = new ProgressBar(context, null,
                android.R.attr.progressBarStyleHorizontal);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 8);
        mProgressBar.setLayoutParams(layoutParams);

/*        Drawable drawable = context.getResources().getDrawable(
                R.drawable.web_progress_bar_states);
        mProgressBar.setProgressDrawable(drawable);*/
        addView(mProgressBar);
        handler = new Handler();
        setWebChromeClient(new WebChromeClient());
    }


    public class WebChromeClient extends android.webkit.WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                mProgressBar.setProgress(100);
                handler.postDelayed(runnable, 200);//0.2秒后隐藏进度条
            } else if (mProgressBar.getVisibility() == GONE) {
                mProgressBar.setVisibility(VISIBLE);
            }
            //设置初始进度10，这样会显得效果真一点，总不能从1开始吧
            if (newProgress < 10) {
                newProgress = 10;
            }
            //不断更新进度
            mProgressBar.setProgress(newProgress);
            super.onProgressChanged(view, newProgress);
        }
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        LayoutParams lp = (LayoutParams) mProgressBar.getLayoutParams();
        lp.x = l;
        lp.y = t;
        mProgressBar.setLayoutParams(lp);
        super.onScrollChanged(l, t, oldl, oldt);
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mProgressBar.setVisibility(View.GONE);
        }
    };
}
