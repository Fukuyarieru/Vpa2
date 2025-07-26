package com.vpa2.datastructures;

import com.vpa2.DatabaseAccess;

import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment extends DataStructure  {
    private String text;
    private String commenter;
    private String date;
    // "EXPERIMENTAL" IDEA
//    private String parent;
    private String context;
    private Collection<String> children;

    public static final String DEFAULT_COMMENT_TEXT ="comment";
    public static final String DEFAULT_COMMENT_COMMENTER =User.DEFAULT_USER_NAME;

    public Comment() {
        this(DEFAULT_COMMENT_TEXT, DEFAULT_COMMENT_COMMENTER,new Video());
    }
    public Comment(String text, String commenter, DatabaseAccess parent) {
        this.text=text;
        this.commenter=commenter;
        this.context=parent.key()+"|"+text;
    }

//  NO IDEA HOW TO MAKE IT BE CORRECTLY SYNBABLE WITH SYNC.
//  PROBLEM OCCURS FROM THE FACT COMMENTS NEED TO BE UPLOADED TO DATABASE AND THIS IS JUST A METHOD.
//  KEEPING CODE AS A REMINDER
//    public void addReply(String text, String commenter) {
//
//    }
//    public void addReply(Comment comment) {
//
//    }
//    public void addReplies(Comment... comments) {
//
//    }

    @Override
    public String key() {
        return context;
    }
}
