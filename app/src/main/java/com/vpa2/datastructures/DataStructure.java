package com.vpa2.datastructures;


import com.vpa2.DatabaseAccess;

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
    private int views = 0;

    public int score() {
        int likesValue = peopleLike.size() * LIKE_VALUE;
        int dislikesValue = peopleDislike.size() * DISLIKE_VALUE;
        int viewsValue = views * VIEW_VALUE;

        int score;
        score = likesValue - dislikesValue + viewsValue;
        return score;
    }

    public void view(String username) {
        ++views;
        if (!peopleViewed.contains(username)) {
            peopleViewed.add(username);
        }
    }

    public void like(String username) {
        peopleDislike.remove(username);
        if (!peopleLike.contains(username)) {
            peopleLike.add(username);
        }
    }

    public void dislike(String username) {
        peopleLike.remove(username);
        if (!peopleDislike.contains(username)) {
            peopleDislike.add(username);
        }
    }
}
