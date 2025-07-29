package com.vpa2.datastructures;


import com.vpa2.database.DatabaseAccess;

import java.util.ArrayList;
import java.util.Collection;

import lombok.Getter;
import lombok.Setter;

// Common datastructures behaviors, issue with the idea of "Votable"
// Consider renaming?

@Setter
@Getter
public abstract class DataStructure implements DatabaseAccess {
    public static final int LIKE_VALUE = 3;
    public static final int DISLIKE_VALUE = 3;
    public static final int VIEW_VALUE = 1;
    private final Collection<String> peopleLike = new ArrayList<>();
    private final Collection<String> peopleDislike = new ArrayList<>();
    private final Collection<String> peopleViewed = new ArrayList<>();
    private final Collection<String> replyContexts = new ArrayList<>();
    private String date = "?";
    private long timestamp=0; // TODO, redo date with this
    private int views = 0;

//    protected DataStructure() {
//
//    }

    public int score() {
        int likesValue = peopleLike.size() * LIKE_VALUE;
        int dislikesValue = peopleDislike.size() * DISLIKE_VALUE;
        int viewsValue = views * VIEW_VALUE;

        int score;
        score = likesValue - dislikesValue + viewsValue;
        return score;
    }

    public void addView(String username) {
        ++views;
        if (!peopleViewed.contains(username)) {
            peopleViewed.add(username);
        }
    }

    public void addLike(String username) {
        peopleDislike.remove(username);
        if (!peopleLike.contains(username)) {
            peopleLike.add(username);
        }
    }

    public void addDislike(String username) {
        peopleLike.remove(username);
        if (!peopleDislike.contains(username)) {
            peopleDislike.add(username);
        }
    }

// problem with these are 2: i need to update in database outside this method, and i need a comment pointer beforehand, so next method is solution
//    public void addComment(String text, String commenter) {
//        Comment comment=new Comment(text,commenter,this);
//        replyContexts.add(comment.getContext());
//    }

    // comment must exist before entering this method because of need uploading to database
    // database actions should not happen inside regular logic methods
    public void addComment(Comment comment) {
        // very bad temporary whooping of an idea of a solution (made like this to always force correct contexts in case of change), TODO
        comment.setContext(new Comment(comment.getText(), comment.getCommenter(), this).getContext());
        replyContexts.add(comment.getContext());
    }


    // FROM: COMMENT CLASS
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
}
