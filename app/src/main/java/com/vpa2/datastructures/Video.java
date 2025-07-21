package com.vpa2.datastructures;

import com.vpa2.DatabaseDatastructure;

import javax.annotation.processing.Generated;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Video implements DatabaseDatastructure {

    private String title;
    private String owner;
    private byte[] thumbnail;
    private String[] peopleLike;
    private String[] peopleDislike;
    private String[] peopleViewed;
    private String[] playlistsIncluded;


    public static final int likeValue=3;
    public static final int dislikeValue=3;
    public static final int viewValue=1;

    public Video() {
        // TODO
    }
    public Video(String title, String owner) {
        this.title=title;
        this.owner=owner;

        thumbnail= new byte[]{0};
        peopleLike=new String[]{};
        peopleDislike=new String[]{};
        peopleViewed=new String[]{};
        playlistsIncluded=new String[]{};
    }

    public int views() {
        return this.peopleViewed.length;
    }
    public int score() {
        int likesValue= peopleLike.length*likeValue;
        int dislikesValue= peopleDislike.length*dislikeValue;
        int viewsValue=peopleViewed.length*viewValue;

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
