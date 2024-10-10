package AISS.vimeo.model.Channel;

import AISS.vimeo.model.Caption.Caption;
import AISS.vimeo.model.Comment.Comment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Videos {
    @JsonProperty("uri")
    private String data;

    @JsonProperty("description")
    private String description;

    @JsonProperty("release_time")
    private String releaseTime;

    private List<Caption> captions;

    private List<Comment> comments;


    private String Id;

    public void setData(String data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public List<Caption> getCaptions() {
        return captions;
    }

    public void setCaptions(List<Caption> captions) {
        this.captions = captions;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Videos{" +
                "data='" + data + '\'' +
                ", description='" + description + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", captions=" + captions +
                ", comments=" + comments +
                ", Id='" + Id + '\'' +
                '}';
    }
}
