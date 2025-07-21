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

    public static final String defaultPlaylistTitle="Playlist";
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
