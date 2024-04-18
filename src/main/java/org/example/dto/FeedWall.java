package org.example.dto;

import java.util.List;

public class FeedWall extends TimeLineWall {
    public List<Tweet> showFeedWall() {
        return getTweets();
    }
}
