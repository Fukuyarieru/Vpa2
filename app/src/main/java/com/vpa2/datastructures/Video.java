package com.vpa2.datastructures;

import com.vpa2.DatabaseDatastructure;

public class Video implements DatabaseDatastructure {

    private String title;

    @Override
    public String header() {
        return "videos";
    }

    @Override
    public String key() {
        return title;
    }
}
