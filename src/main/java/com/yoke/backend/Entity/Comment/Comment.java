package com.yoke.backend.Entity.Comment;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "comment")
public class Comment {
    @Id
    private String id;
    @Field("comment_time")
    private String comment_time;
    @Field("comment_content")
    private String comment_content;
}
