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

    public static final int LIKE_VALUE =3;
    public static final int DISLIKE_VALUE =3;
    public static final int VIEW_VALUE =1;

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
        int likesValue= peopleLike.length* LIKE_VALUE;
        int dislikesValue= peopleDislike.length* DISLIKE_VALUE;
        int viewsValue=views* VIEW_VALUE;

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
