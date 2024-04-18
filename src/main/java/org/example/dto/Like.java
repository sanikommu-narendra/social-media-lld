package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.LikeType;
import org.example.enums.PostType;

@Getter
public class Like {
    private RegisteredUser registeredUser;
    private PostType postType;
    @Setter
    private LikeType likeType;

    public Like(RegisteredUser registeredUser, PostType postType, LikeType likeType) {
        this.registeredUser = registeredUser;
        this.postType = postType;
        this.likeType = likeType;
    }

}
