package AISS.vimeo.services;

import AISS.vimeo.model.Video.Video;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class VideoServiceTest {

    @Autowired
    VideoService service;

    @Test
    @DisplayName("Get 1 video")
    void findVideo(){
        List<Video> video = service.findAllVideos("Staffpicks","5","10");
        System.out.println(video.size());
    }
}