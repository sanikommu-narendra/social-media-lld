package org.example.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CommentThread {
    private String commentThreadId;
    private List<Comment> comments;

    public CommentThread() {
        this.comments = new ArrayList<>();
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }


}
