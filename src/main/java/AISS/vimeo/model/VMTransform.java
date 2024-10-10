package AISS.vimeo.model;

import AISS.vimeo.model.Caption.Caption;
import AISS.vimeo.model.Channel.Channel;
import AISS.vimeo.model.Comment.Comment;
import AISS.vimeo.model.User.User;
import AISS.vimeo.model.VM.*;
import AISS.vimeo.model.Video.Video;

import java.util.ArrayList;
import java.util.List;

public class VMTransform {

    public static List<VMCaption> ofCaption(List<Caption> Lcaption) {
        if (Lcaption == null) return null;
        List<VMCaption> captions = new ArrayList<>();
        for (Caption caption : Lcaption) {
        VMCaption cap = new VMCaption(caption.getId(), caption.getName(), caption.getLanguage());
        captions.add(cap);
    }
        return captions;
    }
    public static VMUser ofUser(User user){
        return new VMUser(Long.valueOf(user.getId()), user.getName(), user.getLink(), user.getPicture().getLink());
    }
    public static List<VMComment> ofComment(List<Comment> Lcomment){
        if (Lcomment == null) return null;
        List<VMComment> comments = new ArrayList<>();
         for (Comment comment: Lcomment ) {
             VMComment com = new VMComment(comment.getId(), comment.getText(),
                     comment.getCreatedOn(), ofUser(comment.getAutor()));
             comments.add(com);
         }
         return comments;
         }
    public static List<VMVideo> ofVideo(List<Video> Lvideo){
        if (Lvideo == null) return null;
        List<VMVideo> videos = new ArrayList<>();
        for (Video video: Lvideo) {
            VMVideo vid = new VMVideo(ofCaption(video.getCaptions()), ofComment(video.getComments()),
                    video.getReleaseTime(), video.getDescription(), video.getName(), video.getId());
            videos.add(vid);
        }
        return videos;
        }
    public static VMChannel ofChannel(Channel channel){
        return new VMChannel(channel.getId(), channel.getName(), channel.getDescription(),
                channel.getCreatedTime(),ofVideo(channel.getVideos()));
    }

}
