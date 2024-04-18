package org.example.dto;

import java.util.List;

public class TimeLine extends TimeLineWall {
    public List<Tweet> showTimeLine() {
        return getTweets();
    }

    public void addCelebTweets(List<Tweet> celebTweets) {
        getTweets().addAll(celebTweets);
    }
}
