/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manageBeans;

import entityBeans.Forumuser;
import entityBeans.Topic;
import java.util.ArrayList;
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
 * Backing bean managing options section, for update users specifications
 * and manage all admins sections, such as locking and unlocking topics.
 */
public class SettingsBean {

    @EJB
    PersistanceLocal pstl;

    String home;
    String email;
    String pass;
    String pass2;
    Forumuser fu;
    String privat;
    Topic topic;
    List<String> pom = new ArrayList<String>();

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getPrivat() {
        return privat;
    }

    public void setPrivat(String privat) {
        this.privat = privat;
        this.pom.add(privat);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    public void validatePass(FacesContext context,
                         UIComponent component,
                         Object value) throws ValidatorException {
        pass = value.toString();
        if (value.toString().length() > 20) {
            throw new ValidatorException(new FacesMessage("Maximal length is 20 characters"));
        }
        if (value.toString().length() < 1) {
            throw new ValidatorException(new FacesMessage("Enter password"));
        }
    }

    public void validatePass2(FacesContext context,
                         UIComponent component,
                         Object value) throws ValidatorException {
        if(!value.toString().equals(pass)) {
            throw new ValidatorException(new FacesMessage("Passwords should equal"));
        }
    }

    public String setUser() {
        FacesContext ctx= FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
        if(session.getAttribute("user") != null) {
            fu = (Forumuser)session.getAttribute("user");
            home = fu.getHome();
            email = fu.getEmail();
            pass = pass2 = fu.getPass();
        } else {
            return "deniedAccess";
        }
        return "settings";
    }

    public void updateTopic() {
        topic.setPrivate1(pom.get(topic.getIdtopic().intValue() -1).charAt(0));
        System.out.println(pom.get(topic.getIdtopic().intValue() -1).charAt(0));
        Topic t = topic;
        pstl.updateTopic(t);
        pom.clear();
        privat = null;
    }

    public String save() {
        fu.setEmail(email);
        fu.setHome(home);
        fu.setPass(pass);
        Forumuser f = fu;
        pstl.updateUser(f);
        FacesContext ctx= FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
        session.setAttribute("user", f);
        return "home";
    }

    public boolean getAdministrateTopic() {
        if(fu.getIdrole().getTopicadmin()) {
            return true;
        }
        return false;
    }

    public String clear() {
        pom.clear();
        privat = null;
        return "settings";
    }

}
