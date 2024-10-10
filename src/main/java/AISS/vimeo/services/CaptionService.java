package AISS.vimeo.services;

import AISS.vimeo.model.Caption.Caption;
import AISS.vimeo.model.Caption.CaptionList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CaptionService {
    @Autowired
    RestTemplate restTemplate;


    public List<Caption> findAllCaptions(String id) {
        List<Caption> captions = null;
        String uri = "https://api.vimeo.com/videos/" + id + "/texttracks";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + "74c76fd58260e9ce388570e9d0123052");
        HttpEntity<Caption> request = new HttpEntity<>(null, headers);
        ResponseEntity<CaptionList> captionList = restTemplate.exchange(uri, HttpMethod.GET, request, CaptionList.class);
        captions = captionList.getBody().getData();
       return captions;
    }


}
