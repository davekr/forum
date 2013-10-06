/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manageBeans;


import entityBeans.Forumuser;
import entityBeans.Post;
import entityBeans.Thread;
import entityBeans.Topic;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;
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
 * Backing bean for inserting, updating and deleting threads. Alsow for
 * shows all threads in topic.
 */
public class ThreadBean {

    @EJB
    PersistanceLocal pstl;

    Thread thread;
    String name;
    int nposts;
    int viewed;
    Topic idtopic;
    String subject;
    String content;
    String idt;

    public String getIdt() {
        return idt;
    }

    public void setIdt(String idt) {
        this.idt = idt;
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

    public Topic getIdtopic() {
        return idtopic;
    }

    public void setIdtopic(Topic idtopic) {
        this.idtopic = idtopic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNposts() {
        return nposts;
    }

    public void setNposts(int nposts) {
        this.nposts = nposts;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    public int getViewed() {
        return viewed;
    }

    public void setViewed(int viewed) {
        this.viewed = viewed;
    }

    public void validateSubject(FacesContext context,
                         UIComponent component,
                         Object value) throws ValidatorException {
        if (value.toString().length() < 1) {
            throw new ValidatorException(new FacesMessage("Thread sould have a name!"));
        }
        if (value.toString().length() > 30) {
            throw new ValidatorException(new FacesMessage("Maximal length is 30 characters"));
        }
    }

    public String insert() {
        Thread t = new Thread();
        t.setIdtopic(idtopic);
        FacesContext ctx= FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
        t.setIduser((Forumuser)session.getAttribute("user"));
        t.setName(subject);
        t.setPosts(BigInteger.ZERO);
        t.setViewed(BigInteger.ZERO);
        pstl.insertThread(t);
        t.setIdthread(pstl.getThreadId());
        Post p = new Post();
        p.setContent(content);
        long time = new java.util.Date().getTime();
        p.setCreated(new Timestamp(time));
        p.setIdthread(t);
        p.setIduser((Forumuser)session.getAttribute("user"));
        p.setSubject(subject);
        pstl.insertPost(p);
        t.getPostList().add(p);
        idtopic.getThreadList().add(t);
        return "showTopic";
    }

    public List<Post> getPosts() {
        return thread.getPostList();
        //return pstl.getAllThreadPosts(thread);
    }

    public String showThread() {
        thread = pstl.getThread(thread);
        name = thread.getName();
        nposts = thread.getPosts().intValue();
        viewed = thread.getViewed().intValue();
        idtopic = thread.getIdtopic();
        Thread t = thread;
        t.setViewed(thread.getViewed().add(BigInteger.ONE));
        thread.setViewed(t.getViewed());
        viewed++;
        pstl.updateThread(t);
        return "showThread";
    }

    public String updateThread() {
        subject = thread.getName();
        return "updateThread";
    }

    public String update() {
        thread.setName(subject);
        thread.setIdtopic(pstl.getTopic(Integer.parseInt(idt)));
        pstl.updateThread(thread);
        return "showTopic";
    }

    public String delete() {
        pstl.deleteThread(thread);
        idtopic.getThreadList().remove(thread);
        return "showTopic";
    }
}
