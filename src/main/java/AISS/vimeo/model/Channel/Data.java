package AISS.vimeo.model.Channel;

import AISS.vimeo.model.Video.Video;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    @JsonProperty("data")
    private List<Video> videos;

    public List<Video> getVideos() {
        return videos;
    }

    @Override
    public String toString() {
        return "Data{" +
                "videos=" + videos +
                '}';
    }
}
