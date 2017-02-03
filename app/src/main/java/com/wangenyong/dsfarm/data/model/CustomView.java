package com.wangenyong.dsfarm.data.model;

/**
 * Created by wangenyong on 2017/1/4.
 */

public class CustomView {
    public static final int WEBVIEW = 1;

    private String title;
    private int type;

    public CustomView(String title) {
        this.title = title;
    }

    public CustomView(String title, int type) {
        this.title = title;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public int getType() {
        return type;
    }
}
