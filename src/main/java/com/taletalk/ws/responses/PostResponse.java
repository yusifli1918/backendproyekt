package com.taletalk.ws.responses;

import com.taletalk.ws.Entity.Like;
import com.taletalk.ws.Entity.Post;
import lombok.Data;

import java.util.List;

@Data
public class PostResponse {
    Long id;
    Long userId;
    String userName;
    String title;
    String text;
    List<LikeResponse> postLikes;

    public PostResponse(Post entity, List<LikeResponse> likes){
this.id=entity.getId();
this.userId=entity.getUser().getId();
this.userName=entity.getUser().getUserName();
this.title=entity.getTitle();
this.text=entity.getText();
this.postLikes = likes;
    }
}
