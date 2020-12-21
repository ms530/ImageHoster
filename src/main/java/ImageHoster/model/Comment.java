package ImageHoster.model;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="comments")
public class Comment {
    @Id()
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @Column(name="text",columnDefinition = "TEXT")
    private String text;
    @Column(name="createdDate")
    private Date createdDate;
    @ManyToOne(fetch = FetchType.EAGER)
    private Image image;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


}
