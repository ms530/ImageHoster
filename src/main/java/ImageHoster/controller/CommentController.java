package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private ImageService imageService;


    @RequestMapping(value="/image/{imageId}/{title}/comments", method = RequestMethod.POST)
    public String newComment(@PathVariable("imageId") Integer imageId, @PathVariable("title") String title, Model model, @RequestParam("comment") String commentText, HttpSession session, Comment newComment) {
        Image image = imageService.getImage(imageId);
        User user= (User) session.getAttribute("loggeduser");
        newComment.setText(commentText);
        newComment.setUser(user);
        newComment.setImage(image);
        newComment.setCreatedDate(new Date());
        commentService.createComment(newComment);
        return "redirect:/images/"+imageId+"/"+title;
    }
}

