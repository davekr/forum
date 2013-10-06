/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manageBeans;

import entityBeans.Forumuser;
import entityBeans.Post;
import entityBeans.Thread;
import java.math.BigInteger;
import java.sql.Timestamp;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;
import sessionBeans.PersistanceLocal;


/**
 *
 * @author Dave
 * Backing bean for inserting, updating and deleting posts
 */
public class PostBean {

    @EJB
    PersistanceLocal pstl;

    String content;
    String subject;
    Thread thread;
    Post post;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void validateContent(FacesContext context,
                         UIComponent component,
                         Object value) throws ValidatorException {
        if (value.toString().length() < 1) {
            throw new ValidatorException(new FacesMessage("Write something decent!"));
        }
    }

    public String insert() {
        Post p = new Post();
        p.setContent(content);
        long time = new java.util.Date().getTime();
        p.setCreated(new Timestamp(time));
        p.setIdthread(thread);
        FacesContext ctx= FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
        p.setIduser((Forumuser)session.getAttribute("user"));
        p.setSubject(subject);
        pstl.insertPost(p);
        thread.getPostList().add(p);
        return "showThread";
    }

    public String delete() {
        pstl.deletePost(post);
        thread.getPostList().remove(post);
        thread.setPosts(thread.getPosts().subtract(BigInteger.ONE));
        if(thread.getPostList().isEmpty()) {
            pstl.deleteThread(thread);
            return "showTopic";
        }
        return "showThread";
    }

    public String updatePost() {
        subject = post.getSubject();
        content = post.getContent();
        return "updatePost";
    }

    public String update() {
        post.setContent(content);
        post.setSubject(subject);
        pstl.updatePost(post);
        return "showThread";
    }

}
