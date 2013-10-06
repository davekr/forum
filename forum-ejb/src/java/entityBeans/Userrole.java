/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entityBeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Dave
 */
@Entity
@Table(name = "USERROLE")
@NamedQueries({
    @NamedQuery(name = "Userrole.findAll", query = "SELECT u FROM Userrole u"),
    @NamedQuery(name = "Userrole.findByIdrole", query = "SELECT u FROM Userrole u WHERE u.idrole = :idrole"),
    @NamedQuery(name = "Userrole.findByName", query = "SELECT u FROM Userrole u WHERE u.name = :name"),
    @NamedQuery(name = "Userrole.findByDescription", query = "SELECT u FROM Userrole u WHERE u.description = :description"),
    @NamedQuery(name = "Userrole.findByUseradmin", query = "SELECT u FROM Userrole u WHERE u.useradmin = :useradmin"),
    @NamedQuery(name = "Userrole.findByRoleadmin", query = "SELECT u FROM Userrole u WHERE u.roleadmin = :roleadmin"),
    @NamedQuery(name = "Userrole.findByRightadmin", query = "SELECT u FROM Userrole u WHERE u.rightadmin = :rightadmin"),
    @NamedQuery(name = "Userrole.findByTopicadmin", query = "SELECT u FROM Userrole u WHERE u.topicadmin = :topicadmin")})
public class Userrole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDROLE")
    private BigDecimal idrole;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Column(name = "USERADMIN")
    private char useradmin;
    @Basic(optional = false)
    @Column(name = "ROLEADMIN")
    private char roleadmin;
    @Basic(optional = false)
    @Column(name = "RIGHTADMIN")
    private char rightadmin;
    @Basic(optional = false)
    @Column(name = "TOPICADMIN")
    private char topicadmin;
    @ManyToMany(mappedBy = "userroleList")
    private List<Rights> rightsList;
    @OneToMany(mappedBy = "idrole")
    private List<Forumuser> forumuserList;

    public Userrole() {
    }

    public Userrole(BigDecimal idrole) {
        this.idrole = idrole;
    }

    public Userrole(BigDecimal idrole, String name, char useradmin, char roleadmin, char rightadmin, char topicadmin) {
        this.idrole = idrole;
        this.name = name;
        this.useradmin = useradmin;
        this.roleadmin = roleadmin;
        this.rightadmin = rightadmin;
        this.topicadmin = topicadmin;
    }

    public BigDecimal getIdrole() {
        return idrole;
    }

    public void setIdrole(BigDecimal idrole) {
        this.idrole = idrole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public char getUseradmin() {
        return useradmin;
    }

    public void setUseradmin(char useradmin) {
        this.useradmin = useradmin;
    }

    public char getRoleadmin() {
        return roleadmin;
    }

    public void setRoleadmin(char roleadmin) {
        this.roleadmin = roleadmin;
    }

    public char getRightadmin() {
        return rightadmin;
    }

    public void setRightadmin(char rightadmin) {
        this.rightadmin = rightadmin;
    }

    public boolean getTopicadmin() {
        if(this.topicadmin == '0')
            return false;
        else
            return true;
    }

    public void setTopicadmin(char topicadmin) {
        this.topicadmin = topicadmin;
    }

    public List<Rights> getRightsList() {
        return rightsList;
    }

    public void setRightsList(List<Rights> rightsList) {
        this.rightsList = rightsList;
    }

    public List<Forumuser> getForumuserList() {
        return forumuserList;
    }

    public void setForumuserList(List<Forumuser> forumuserList) {
        this.forumuserList = forumuserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrole != null ? idrole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userrole)) {
            return false;
        }
        Userrole other = (Userrole) object;
        if ((this.idrole == null && other.idrole != null) || (this.idrole != null && !this.idrole.equals(other.idrole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.Userrole[idrole=" + idrole + "]";
    }

}
