package AISS.vimeo.services;

import AISS.vimeo.model.Comment.Comment;
import AISS.vimeo.model.Comment.CommentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommentService {
    RestTemplate restTemplate;

    @Autowired
    public CommentService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Comment> findAllComments(String videoId, String maxResult) {
        String uri = "https://api.vimeo.com/videos/" + videoId + "/comments?per_page=" + maxResult;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + "74c76fd58260e9ce388570e9d0123052");
        HttpEntity<String> request = new HttpEntity<>(headers);
        ResponseEntity<CommentList> response = restTemplate.exchange(uri, HttpMethod.GET, request, CommentList.class);
        for(Comment comment:response.getBody().getData()){
            comment.setId(videoId); // esto da el id del comentario
            comment.getUser().setId();
            comment.setAutor(comment.getUser());

        }
        return response.getBody().getData();
    }
}
