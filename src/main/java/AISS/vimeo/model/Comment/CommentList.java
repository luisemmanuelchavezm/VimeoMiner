
package AISS.vimeo.model.Comment;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)

public class CommentList {

    @JsonProperty("data")
    private List<Comment> data;

    @JsonProperty("data")
    public void setData(List<Comment> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommentList{" +
                "data=" + data +
                '}';
    }

    @JsonProperty("data")
    public List<Comment> getData() {
        return data;
    }






    }

