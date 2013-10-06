/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionBeans;

import javax.ejb.Local;

/**
 *
 * @author Dave
 */
@Local
public interface PersistanceLocal {

    public java.util.List<entityBeans.Topic> getAllTopics();

    public entityBeans.Topic getTopic(entityBeans.Topic topic);

    public java.util.List<entityBeans.Thread> getAllTopicThreads(entityBeans.Topic topic);

    public entityBeans.Forumuser getUser(java.lang.String login);

    public entityBeans.Userrole getRole(int id);

    public entityBeans.Rank getRank(int id);

    public void insertUser(entityBeans.Forumuser fu);

    public void updateThread(entityBeans.Thread t);

    public void insertPost(entityBeans.Post p);

    public java.util.List<entityBeans.Post> getAllThreadPosts(entityBeans.Thread thread);

    public entityBeans.Thread getThread(entityBeans.Thread thread);

    public void insertThread(entityBeans.Thread t);

    public void deletePost(entityBeans.Post p);

    public void updatePost(entityBeans.Post p);

    public java.math.BigDecimal getThreadId();

    public void deleteThread(entityBeans.Thread t);

    public entityBeans.Topic getTopic(int id);

    public void updateUser(entityBeans.Forumuser fu);

    public void updateTopic(entityBeans.Topic topic);
    
}
