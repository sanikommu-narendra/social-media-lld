package org.example.dto;

import lombok.AllArgsConstructor;
import org.example.enums.LikeType;
import org.example.server.ContentServer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RegisteredUser extends User{
    private TimeLine timeLine;
    private FeedWall feedWall;
    private List<RegisteredUser> followers;
    private List<RegisteredUser> following;
    public RegisteredUser(String name, String emailId, String contactNumber) {
        super(name, emailId, contactNumber);
        this.timeLine = new TimeLine();
        this.feedWall = new FeedWall();
        followers = new ArrayList<>();
        following = new ArrayList<>();
    }

    public TimeLine getTimeLine() {
        return timeLine;
    }

    public FeedWall getFeedWall() {
        return feedWall;
    }

    public boolean checkCelebrity() {
        return followers.size() > 1000;
    }

    public String viewTweet(Tweet tweet) {
        return tweet.getContent();
    }

    public void addTweet(Tweet tweet) {
        timeLine.addTweet(tweet);
    }

    public void postTweet(Tweet tweet, ContentServer contentServer) {
        feedWall.addTweet(tweet);
        contentServer.sendMessage(this, tweet);
    }

    public List<Tweet> showTimeLine(ContentServer contentServer) {
        List<Tweet> nonCelebTweets = timeLine.getTweets();
        List<Tweet> celebTweets = new ArrayList<>();
        following
                .stream()
                .filter(RegisteredUser::checkCelebrity)
                .map(followee -> contentServer.getCelebTweets().get(followee))
                .forEach(celebTweets::addAll);

        nonCelebTweets.addAll(celebTweets);
        return nonCelebTweets;
    }

    public void addFollower(RegisteredUser follower, ContentServer server) {
        followers.add(follower);
        server.addSubscriber(this, follower);
    }

    public void followUser(RegisteredUser registeredUser, ContentServer contentServer) {
        following.add(registeredUser);
    }

    public void addLikeOnTweet(Tweet tweet, LikeType likeType) {
        tweet.addLike(this, likeType);
    }

    public void removeLikeOnTweet(Tweet tweet) {
        tweet.removeLike(this);
    }

    public void addLikeOnComment(Comment tweet, LikeType likeType) {
        tweet.addLike(this, likeType);
    }

    public void removeLikeOnComment(Comment  tweet) {
        tweet.removeLike(this);
    }
}
