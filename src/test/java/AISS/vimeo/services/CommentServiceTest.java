package AISS.vimeo.services;

import AISS.vimeo.model.Comment.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommentServiceTest {
    @Autowired
    CommentService service;
    @Test
    @DisplayName("Get all comments given a videoId")
    void findAllComments() {
        List<Comment> comments = service.findAllComments("939135094","3");
        assertFalse(comments.isEmpty(), "The list of comments is empty!");
        System.out.println(comments);
    }
}