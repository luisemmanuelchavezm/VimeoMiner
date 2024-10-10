package AISS.vimeo.services;


import AISS.vimeo.model.Channel.Data;
import AISS.vimeo.model.Video.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    CaptionService captionsService;
    @Autowired
    CommentService commentService;

    private final String Token= "74c76fd58260e9ce388570e9d0123052";

    public List<Video> findAllVideos(String id,String maxResultVideo,String maxResultComment) {
        //create a request
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization", "Bearer " + Token);
        HttpEntity<Video> request = new HttpEntity<>(null, header);
        //send request
        String uri = "https://api.vimeo.com/channels/" + id + "/videos?per_page=" + maxResultVideo;
        ResponseEntity<Data> response = restTemplate.exchange(uri, HttpMethod.GET, request, Data.class);
        List<Video> videos = response.getBody().getVideos();
        for (Video video : videos) {
            video.setId(video.getId());
            video.setComments(commentService.findAllComments(video.getId(), maxResultComment));
            video.setCaptions(captionsService.findAllCaptions(video.getId()));
        }
        return response.getBody().getVideos();
    }

}
