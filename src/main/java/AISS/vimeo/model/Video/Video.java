package AISS.vimeo.model.Video;

import AISS.vimeo.model.Caption.Caption;
import AISS.vimeo.model.Comment.Comment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Video {
    @JsonProperty("uri")
    private String uri;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("release_time")
    private String releaseTime;
    private List<Caption> captions;
    private List<Comment> comments;
    private String Id;
    public void setCaptions(List<Caption> captions) {
        this.captions= new ArrayList<Caption>();
        if(captions != null){
            this.captions = captions;
        }
    }

    public void setComments(List<Comment> comments) {
        this.comments =new ArrayList<Comment>();
        if(comments != null){
        this.comments = comments;
        }

    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public String getId() {
        return Id=uri.replace("/videos/","");
    }

    public List<Caption> getCaptions() {
        return captions;
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Video{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", captions=" + captions +
                ", comments=" + comments +
                ", Id='" + Id + '\'' +
                '}';
    }
}
