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

    public static final String defaultPlaylistTitle="playlist";
    public static final String defaultPlaylistOwner=User.defaultUserName;
    public static final String defaultPlaylistDescription="";

    public Playlist() {
        this(defaultPlaylistTitle,new Video[]{});
    }
    public Playlist(String title, Video[]videos) {
        this.title=title;
        this.videos=videos;
        this.description=defaultPlaylistDescription;
        this.owner=defaultPlaylistOwner;
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
