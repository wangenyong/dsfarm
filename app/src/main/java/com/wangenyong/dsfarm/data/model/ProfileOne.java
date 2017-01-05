package com.wangenyong.dsfarm.data.model;

/**
 * Created by wangenyong on 2017/1/5.
 */

public class ProfileOne implements Type {
    private String title;
    private int type;

    public ProfileOne(String title) {
        this.title = title;
        type = Type.PROFILE_ONE;
    }

    @Override
    public int getType() {
        return type;
    }
}
