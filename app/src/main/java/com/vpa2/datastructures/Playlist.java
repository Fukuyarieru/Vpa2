package com.vpa2.datastructures;

import java.util.ArrayList;
import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Playlist extends DataStructure {
    public static final String DEFAULT_PLAYLIST_TITLE = "playlist";
    public static final String DEFAULT_PLAYLIST_OWNER = User.DEFAULT_USER_NAME;
    public static final String DEFAULT_PLAYLIST_DESCRIPTION = "playlist_description";
    private String title;
    private String description;
    private String owner;
    private Collection<String> videos;

    public Playlist() {
        this(DEFAULT_PLAYLIST_TITLE, new ArrayList<>());
    }

    public Playlist(String title, Collection<String> videos) {
        this.title = title;
        this.videos = videos;
        this.description = DEFAULT_PLAYLIST_DESCRIPTION;
        this.owner = DEFAULT_PLAYLIST_OWNER;
    }

    @Override
    public String key() {
        return title;
    }
}
