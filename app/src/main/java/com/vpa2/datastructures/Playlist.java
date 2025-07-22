package com.vpa2.datastructures;

import com.vpa2.DatabaseDatastructure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Playlist implements DatabaseDatastructure {
    private String title;
    private String description;
    private String owner;
    private Video[] videos;
    private int views;

    private String[] peopleLike;
    private String[] peopleDislike;
    private String[] peopleViewed;

    public static final String DEFAULT_PLAYLIST_TITLE ="playlist";
    public static final String DEFAULT_PLAYLIST_OWNER =User.DEFAULT_USER_NAME;
    public static final String DEFAULT_PLAYLIST_DESCRIPTION ="";

    public Playlist() {
        this(DEFAULT_PLAYLIST_TITLE,new Video[]{});
    }
    public Playlist(String title, Video[]videos) {
        this.title=title;
        this.videos=videos;
        this.description= DEFAULT_PLAYLIST_DESCRIPTION;
        this.owner= DEFAULT_PLAYLIST_OWNER;
        this.views=0;

        this.peopleLike=new String[]{};
        this.peopleDislike=new String[]{};
        this.peopleViewed=new String[]{};
    }

    @Override
    public String header() {
        return "playlists";
    }

    @Override
    public String key() {
        return title;
    }
}
