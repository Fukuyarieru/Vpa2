package com.vpa2.datastructures;

import com.vpa2.DatabaseDatastructure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Video implements DatabaseDatastructure {

    private String title;
    private String owner;
    private String description;
    private byte[] thumbnail;
    private String[] playlistsIncluded;
    private int views;

    private String[] peopleLike;
    private String[] peopleDislike;
    private String[] peopleViewed;

    public static final int likeValue=3;
    public static final int dislikeValue=3;
    public static final int viewValue=1;

    public static final String DEFAULT_VIDEO_NAME ="video";
    public static final String DEFAULT_VIDEO_OWNER =User.DEFAULT_USER_NAME;
    public static final String DEFAULT_VIDEO_DESCRIPTION ="";

    public Video() {
        this(DEFAULT_VIDEO_NAME, DEFAULT_VIDEO_OWNER);
    }

    public Video(String title, String owner) {
        this.title=title;
        this.owner=owner;
        this.description= DEFAULT_VIDEO_DESCRIPTION;
        this.thumbnail= new byte[]{0};
        this.playlistsIncluded=new String[]{};
        this.views=0;

        this.peopleLike=new String[]{};
        this.peopleDislike=new String[]{};
        this.peopleViewed=new String[]{};
    }

    public int score() {
        int likesValue= peopleLike.length*likeValue;
        int dislikesValue= peopleDislike.length*dislikeValue;
        int viewsValue=views*viewValue;

        int score=likesValue-dislikesValue+viewsValue;
        return score;
    }

    @Override
    public String header() {
        return "videos";
    }

    @Override
    public String key() {
        return title;
    }
}
