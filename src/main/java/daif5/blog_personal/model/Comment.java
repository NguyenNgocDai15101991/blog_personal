package daif5.blog_personal.model;

import daif5.blog_personal.model.signinSignup.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Content;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
//    @ManyToOne
//    private User user;

//    @ManyToOne
//    private Post post;

    public Comment() {
    }

    public Comment(String content, Date date, User user, Post post) {
        Content = content;
        this.date = date;
//        this.user = user;
//        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Post getPost() {
//        return post;
//    }
//
//    public void setPost(Post post) {
//        this.post = post;
//    }
}
