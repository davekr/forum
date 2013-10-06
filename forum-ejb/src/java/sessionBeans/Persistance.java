/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBeans;

import entityBeans.Forumuser;
import entityBeans.Post;
import entityBeans.Rank;
import entityBeans.Topic;
import entityBeans.Thread;
import entityBeans.Userrole;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Dave
 * Here are executed all queries to database.
 */
@Stateless
public class Persistance implements PersistanceLocal {
    
    @PersistenceContext
    EntityManager em;

    public List<Topic> getAllTopics() {
        Query q = em.createNamedQuery("Topic.findAll");
        List<Topic> topics = q.getResultList();
        return topics;
    }

    public Topic getTopic(Topic topic) {
        Query q = em.createNamedQuery("Topic.findByIdtopic").setParameter("idtopic", topic);
        return (Topic) q.getSingleResult();
    }

    public Topic getTopic(int id) {
        Query q = em.createNamedQuery("Topic.findByIdtopic").setParameter("idtopic", new BigDecimal(id));
        return (Topic) q.getSingleResult();
    }

    public void updateTopic(Topic topic) {
        em.merge(topic);
    }

    public Thread getThread(Thread thread) {
        Query q = em.createNamedQuery("Thread.findByIdthread").setParameter("idthread", thread.getIdthread());
        return (Thread) q.getSingleResult();
    }

    public List<Thread> getAllTopicThreads(Topic topic) {
        Query q = em.createQuery("SELECT t FROM Thread t WHERE t.idtopic = :idtopic")
                .setParameter("idtopic", topic);
        return q.getResultList();
    }

    public List<Post> getAllThreadPosts(Thread thread) {
        Query q = em.createQuery("SELECT t FROM Post t WHERE t.idthread = :idthread")
                .setParameter("idthread", thread);
        return q.getResultList();
    }

    public Forumuser getUser(String login) {
        Query q = em.createNamedQuery("Forumuser.findByNick").setParameter("nick", login);
        Iterator it = q.getResultList().iterator();
        if(it.hasNext()) {
            return (Forumuser) it.next();
        }
        return null;
    }

    public Userrole getRole(int id) {
        Query q = em.createNamedQuery("Userrole.findByIdrole").setParameter("idrole", id);
        return (Userrole)q.getSingleResult();
    }

    public Rank getRank(int id) {
        Query q = em.createNamedQuery("Rank.findByIdrank").setParameter("idrank", id);
        return (Rank)q.getSingleResult();
    }

    public void insertUser(Forumuser fu) {
        em.persist(fu);
    }

    public void updateUser(Forumuser fu) {
        em.merge(fu);
    }

    public void updateThread(Thread t) {
        em.merge(t);
    }

    public void insertThread(Thread t) {
        em.persist(t);
    }

    public void insertPost(Post p) {
        em.persist(p);
    }

    public void updatePost(Post p) {
        em.merge(p);
    }

    public void deletePost(Post p) {
        em.remove(em.contains(p) ? p : em.merge(p));
    }

    public void deleteThread(Thread t) {
        em.remove(em.contains(t) ? t : em.merge(t));
    }

    public BigDecimal getThreadId() {
        Query q = em.createQuery("SELECT MAX(t.idthread) FROM Thread t");
        return (BigDecimal)q.getSingleResult();
    }
 
}
