package AISS.vimeo.model.User;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @JsonProperty("name")
    private String name;
    @JsonProperty("link")
    private String link;

    @JsonProperty("uri")
    private String uri;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id= uri.replace("/users/","");
    }


    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    private String id;

    @JsonProperty("pictures")
    private Picture picture;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", id=" + id +
                ", picture=" + picture +
                '}';
    }
}
