/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manageBeans;

import entityBeans.Forumuser;
import entityBeans.Rights;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import sessionBeans.PersistanceLocal;
import entityBeans.Thread;
import entityBeans.Topic;
import java.util.ArrayList;
import java.util.Iterator;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Dave
 * Backing bean for showing all topics. Here is executed code for users permisions,
 * which is used in aplication further.
 */
public class TopicBean {

    @EJB
    PersistanceLocal pstl;

    Topic topic;
    String name;
    String descroption;
    boolean privat;
    boolean create;
    boolean update;
    boolean delete;

    public boolean isCreate() {
        return create;
    }

    public void setCreate(boolean create) {
        this.create = create;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }

    public String getDescroption() {
        return descroption;
    }

    public void setDescroption(String descroption) {
        this.descroption = descroption;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getPrivat() {
        return privat;
    }

    public void setPrivat(boolean privat) {
        this.privat = privat;
    }

    public List<Topic> getTopics() {
        return pstl.getAllTopics();
    }

    public List<Thread> getThreads() {
        return pstl.getAllTopicThreads(getTopic());
        //return topic.getThreadList();
    }

    public List<SelectItem> getPreparedTopics() {
        List<SelectItem> list = new ArrayList<SelectItem>();
        Iterator<Topic> it = getTopics().iterator();
        while(it.hasNext()) {
            Topic t = it.next();
            list.add(new SelectItem(t.getIdtopic().intValue(), t.getName()));
        }
        return list;
    }

    public String showTopic() {
        boolean read = false;
        FacesContext ctx= FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
        if(session.getAttribute("user") != null) {
            Forumuser fu = (Forumuser)session.getAttribute("user");
            Iterator it = fu.getIdrole().getRightsList().iterator();
            while(it.hasNext()) {
                Rights r = (Rights)it.next();
                if(r.getIdtopic().getIdtopic().intValue() == topic.getIdtopic().intValue()) {
                    this.setCreate(r.getCreateright());
                    this.setDelete(r.getDeleteright());
                    this.setUpdate(r.getUpdateright());
                    read = r.getReadright();
                }
            }
            if(!topic.getPrivate1()) {
                this.setCreate(true);
            }
        }
        if(topic.getPrivate1()){
            if(!read) {
                return "deniedAccess";
            }
        }
        this.setDescroption(topic.getDescription());
        this.setName(topic.getName());
        this.setPrivat(topic.getPrivate1());

        return "showTopic";
    }

}
