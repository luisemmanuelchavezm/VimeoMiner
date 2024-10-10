
package AISS.vimeo.model.Caption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Caption {

    @JsonProperty("language")
    private String language;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Caption{" +
                "language='" + language + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
