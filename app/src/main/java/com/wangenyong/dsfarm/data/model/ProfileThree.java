package com.wangenyong.dsfarm.data.model;

import java.util.List;

/**
 * Created by wangenyong on 2017/2/14.
 */

public class ProfileThree implements Type {
    private String title;
    private int type;
    private List<String> mStrings;

    public ProfileThree(String title, List<String> strings) {
        this.title = title;
        this.mStrings = strings;
        type = Type.PROFILE_THREE;
    }

    @Override
    public int getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getStrings() {
        return mStrings;
    }
}
