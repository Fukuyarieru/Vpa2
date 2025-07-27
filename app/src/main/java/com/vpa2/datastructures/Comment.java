package com.vpa2.datastructures;

import com.vpa2.DatabaseAccess;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment extends DataStructure {

    public static final String DEFAULT_COMMENT_TEXT = "comment";
    public static final String DEFAULT_COMMENT_COMMENTER = User.DEFAULT_USER_NAME;
    private String text;
    private String commenter;
    private String date;
    // "EXPERIMENTAL" IDEA
//    private String parent;
    private String context;
//    private Collection<String> children; - renamed to comments - moved to DataStructure

    public Comment() {
        this(DEFAULT_COMMENT_TEXT, DEFAULT_COMMENT_COMMENTER, new Video());
    }

    public Comment(String text, String commenter, DatabaseAccess parent) {
        this.text = text;
        this.commenter = commenter;
        this.context = parent.key() + "|" + text;
    }

    @Override
    public String key() {
        return context;
    }
}
