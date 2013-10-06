/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manageBeans;

import entityBeans.Forumuser;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import sessionBeans.PersistanceLocal;


/**
 *
 * @author Dave
 * Backing bean for loging and logouting. Saves user object to session.
 */
public class AuthBean {

    @EJB
    PersistanceLocal pstl;

    String password;
    String login;
    String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String log() {
        Forumuser fu = pstl.getUser(login);
        if(fu!=null && fu.getPass().equals(password)) {
            FacesContext ctx= FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
            session.setAttribute("user", fu);
            return "home";
        }
        /*
        FacesContext.getCurrentInstance()
                .addMessage("Error", new FacesMessage("Wrong login or password"));
        */
        this.error = "Wrong login or password";
        return "failed";
    }

    public String logout() {
        FacesContext ctx= FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
        session.invalidate();
        return "home";
    }

}
