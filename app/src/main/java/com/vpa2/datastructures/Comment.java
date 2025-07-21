package com.vpa2.datastructures;

import com.vpa2.DatabaseDatastructure;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment implements DatabaseDatastructure {
    private String text;
    private String commenter;

    private String[] peopleLike;
    private String[] peopleDislike;
    private String[] peopleViewed;

    public static final String defaultCommentText="comment";
    public static final String defaultCommentCommenter=User.defaultUserName;

    public Comment() {
        this(defaultCommentText,defaultCommentCommenter);
    }
    public Comment(String text, String commenter) {
        this.text=text;
        this.commenter=commenter;

        this.peopleLike=new String[]{};
        this.peopleDislike=new String[]{};
        this.peopleViewed=new String[]{};
    }

    @Override
    public String header() {
        return "comments";
    }

    @Override
    public String key() {
        return "";
    }
}
