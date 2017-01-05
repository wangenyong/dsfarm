package com.wangenyong.dsfarm.data.model;

/**
 * Created by wangenyong on 2017/1/5.
 */

public class ProfileTwo implements Type {
    private String title;
    private int type;

    public ProfileTwo(String title) {
        this.title = title;
        type = Type.PROFILE_TWO;
    }

    @Override
    public int getType() {
        return type;
    }
}
