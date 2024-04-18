package org.example.dto;

import lombok.Getter;
import org.example.enums.LikeType;
import org.example.enums.PostType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class Comment {
    private String commentId;
    private RegisteredUser registeredUser;
    private Map<RegisteredUser, Like> likes;
    private String content;
//    private CommentThread commentThread;
    public Comment(RegisteredUser registeredUser, String content) {
        this.commentId = UUID.randomUUID().toString();
        this.registeredUser = registeredUser;
//        this.commentThread = commentThread;
        this.likes = new HashMap<>();
        this.content = content;
    }

    public void addLike(RegisteredUser registeredUser, LikeType likeType) {
        likes.put(registeredUser, new Like(registeredUser, PostType.COMMENT, likeType));
    }

    public void removeLike(RegisteredUser registeredUser) {
        likes.remove(registeredUser);
    }

    public String  getContent() {
        return content;
    }

}
