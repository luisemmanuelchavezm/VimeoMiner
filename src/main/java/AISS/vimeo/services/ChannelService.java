package AISS.vimeo.services;


import AISS.vimeo.model.Channel.Channel;
import AISS.vimeo.model.VM.VMChannel;
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
public class ChannelService {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    VideoService service;
    private final String Token = "74c76fd58260e9ce388570e9d0123052";


    public Channel findChannel(String id, String maxResultVideo, String maxResultComment){
        //create a request
        HttpHeaders header = new HttpHeaders();
        header.set("Authorization","Bearer " + Token);
        HttpEntity<Channel> request= new HttpEntity<>(null,header);
        //send request
        String uri ="https://api.vimeo.com/channels/"+ id;
        //response = canal
        ResponseEntity<Channel> response = restTemplate.exchange(uri, HttpMethod.GET,request,Channel.class);
        List<Video> videos= service.findAllVideos(id,maxResultVideo,maxResultComment);
        response.getBody().setVideos(videos);
        response.getBody().setId(id);
        return response.getBody();
    }

    // Take into account that this function receives a VMChannel
    public VMChannel createChannel(VMChannel channelVm) {
        String uriVm = "http://localhost:8080/videominer/channels"; // uri from videoMiner
        ResponseEntity<VMChannel> vmChannel = restTemplate.postForEntity(uriVm, channelVm, VMChannel.class);
        return vmChannel.getBody();
    }
}
