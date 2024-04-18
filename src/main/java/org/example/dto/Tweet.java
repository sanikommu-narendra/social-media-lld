package org.example.dto;

import lombok.Getter;
import org.example.enums.LikeType;
import org.example.enums.PostType;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
public class  Tweet {
    private String tweetId;
    private RegisteredUser registeredUser;
    private String content;
    private LocalDateTime createdAt;
    private List<String> hashtags;
    private Map<String, CommentThread> commentThreads;
    private List<String> taggedUsers;
    private Map<RegisteredUser, Like> likes;

    public Tweet(RegisteredUser registeredUser, String content, List<String> hashtags, List<String> taggedUsers ) {
        this.tweetId = UUID.randomUUID().toString();
        this.registeredUser = registeredUser;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.hashtags = hashtags;
        this.commentThreads = new HashMap<>();
        this.taggedUsers = taggedUsers;
        this.likes = new HashMap<>() ;
    }

    public void addComment(String content, RegisteredUser registeredUser) {
        CommentThread commentThread = new CommentThread();
        commentThread.addComment(new Comment(registeredUser, content));
        commentThreads.put(commentThread.getCommentThreadId(), commentThread);

    }

    public void addComment(String threadId, String content, RegisteredUser registeredUser) {
        commentThreads.get(threadId).addComment(new Comment(registeredUser, content));
    }

    public void addLike(RegisteredUser registeredUser, LikeType likeType) {
        likes.put(registeredUser,new Like(registeredUser, PostType.TWEET, likeType));
    }

    public void removeLike(RegisteredUser registeredUser) {
        likes.remove(registeredUser);
    }
}
