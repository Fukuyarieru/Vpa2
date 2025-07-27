package com.vpa2.datastructures;

import com.vpa2.DatabaseAccess;

import java.util.ArrayList;
import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Video extends DataStructure implements DatabaseAccess {

    public static final String DEFAULT_VIDEO_NAME = "video";
    public static final String DEFAULT_VIDEO_OWNER = User.DEFAULT_USER_NAME;
    public static final String DEFAULT_VIDEO_DESCRIPTION = "video_description";
    private String title;
    private String owner;
    private String description;
    private byte[] thumbnail;
    private Collection<String> playlistsIncluded;

    public Video() {
        this(DEFAULT_VIDEO_NAME, DEFAULT_VIDEO_OWNER);
    }

    public Video(String title, String owner) {
        this.title = title;
        this.owner = owner;
        this.description = DEFAULT_VIDEO_DESCRIPTION;
        this.thumbnail = new byte[]{0};
        this.playlistsIncluded = new ArrayList<>();
    }

    @Override
    public String key() {
        return title;
    }
}
