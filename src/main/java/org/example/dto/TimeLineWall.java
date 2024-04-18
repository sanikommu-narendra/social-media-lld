package org.example.dto;

import java.util.ArrayList;
import java.util.List;

public class TimeLineWall {
    private List<Tweet> tweets;

    public TimeLineWall() {
        this.tweets = new ArrayList<>();
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
    }
}
