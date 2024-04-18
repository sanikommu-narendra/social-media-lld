package org.example.server;

import org.example.dto.Like;
import org.example.dto.RegisteredUser;
import org.example.dto.Tweet;

import java.util.List;
import java.util.Map;

public class ContentServer {
    private Map<RegisteredUser, List<RegisteredUser>> subscriberList;
    private Map<RegisteredUser, List<Tweet>> celebTweets;

    public Map<RegisteredUser, List<RegisteredUser>> getSubscriberList() {
        return subscriberList;
    }

    public Map<RegisteredUser, List<Tweet>> getCelebTweets() {
        return celebTweets;
    }

    public void addSubscriber(RegisteredUser followee, RegisteredUser follower) {
        subscriberList.get(followee).add(follower);
    }

    public void sendMessage(RegisteredUser followee, Tweet tweet) {
        if(!followee.checkCelebrity()) {
            subscriberList.get(followee).stream().forEach(follower -> follower.getTimeLine().addTweet(tweet));
        } else {
            celebTweets.get(followee).add(tweet);
        }
    }
}
