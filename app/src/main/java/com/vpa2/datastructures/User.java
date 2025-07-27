package com.vpa2.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends DataStructure {

    public static final String DEFAULT_USER_NAME = "user";
    public static final String DEFAULT_USER_PASSWORD = "123";
    public static final String DEFAULT_USER_DESCRIPTION = "user_description";
    private String name;
    private String password;
    private String description;
    private byte[] picture;
    private Playlist viewHistory;
    private Collection<String> ownedPlaylists;
    private Playlist ownedVideos;

    public User() {
        this(DEFAULT_USER_NAME, DEFAULT_USER_PASSWORD);
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.description = DEFAULT_USER_DESCRIPTION;
        this.picture = new byte[]{0};

        this.viewHistory = new Playlist(name + "'s view history", new ArrayList<>());
        this.ownedVideos = new Playlist(name + "'s owned videos", new ArrayList<>());
        this.ownedPlaylists = Arrays.asList(viewHistory.getTitle(), ownedVideos.getTitle());
    }

    @Override
    public String key() {
        return name;
    }
}
