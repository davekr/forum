/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manageBeans;

import entityBeans.Forumuser;
import java.math.BigInteger;
import java.sql.Timestamp;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import sessionBeans.PersistanceLocal;


/**
 *
 * @author Dave
 * Backing bean for registering
 */
public class RegisterBean {

    @EJB
    PersistanceLocal pstl;

    String nick;
    String password;
    String password2;
    String home;
    String email;

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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public void validateNick(FacesContext context,
                         UIComponent component,
                         Object value) throws ValidatorException {
        nick = value.toString();
        if (pstl.getUser(nick) != null) {
            throw new ValidatorException(new FacesMessage("User with that nick already exists"));
        }
        if (value.toString().length() < 1) {
            throw new ValidatorException(new FacesMessage("Enter nick"));
        }
    }

    public void validatePass(FacesContext context,
                         UIComponent component,
                         Object value) throws ValidatorException {
        password = value.toString();
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
        password2 = value.toString();
        if(!value.toString().equals(password)) {
            throw new ValidatorException(new FacesMessage("Passwords should equal"));
        }
    }

    public String register() {
        Forumuser fu = new Forumuser();
        fu.setEmail(email);
        fu.setHome(home);
        fu.setIdrank(pstl.getRank(1));
        fu.setIdrole(pstl.getRole(2));
        fu.setNick(nick);
        fu.setPass(password);
        fu.setPosts(BigInteger.ZERO);
        long time = new java.util.Date().getTime();
        fu.setRegdate(new Timestamp(time));
        pstl.insertUser(fu);
        return "registered";
    }

}
