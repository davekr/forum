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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Dave
 */
@Entity
@Table(name = "RIGHTS")
@NamedQueries({
    @NamedQuery(name = "Rights.findAll", query = "SELECT r FROM Rights r"),
    @NamedQuery(name = "Rights.findByIdright", query = "SELECT r FROM Rights r WHERE r.idright = :idright"),
    @NamedQuery(name = "Rights.findByCreateright", query = "SELECT r FROM Rights r WHERE r.createright = :createright"),
    @NamedQuery(name = "Rights.findByReadright", query = "SELECT r FROM Rights r WHERE r.readright = :readright"),
    @NamedQuery(name = "Rights.findByUpdateright", query = "SELECT r FROM Rights r WHERE r.updateright = :updateright"),
    @NamedQuery(name = "Rights.findByDeleteright", query = "SELECT r FROM Rights r WHERE r.deleteright = :deleteright")})
public class Rights implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDRIGHT")
    private BigDecimal idright;
    @Basic(optional = false)
    @Column(name = "CREATERIGHT")
    private char createright;
    @Basic(optional = false)
    @Column(name = "READRIGHT")
    private char readright;
    @Basic(optional = false)
    @Column(name = "UPDATERIGHT")
    private char updateright;
    @Basic(optional = false)
    @Column(name = "DELETERIGHT")
    private char deleteright;
    @JoinTable(name = "PERMISSION", joinColumns = {
        @JoinColumn(name = "IDRIGHT", referencedColumnName = "IDRIGHT")}, inverseJoinColumns = {
        @JoinColumn(name = "IDROLE", referencedColumnName = "IDROLE")})
    @ManyToMany
    private List<Userrole> userroleList;
    @JoinColumn(name = "IDTOPIC", referencedColumnName = "IDTOPIC")
    @ManyToOne
    private Topic idtopic;

    public Rights() {
    }

    public Rights(BigDecimal idright) {
        this.idright = idright;
    }

    public Rights(BigDecimal idright, char createright, char readright, char updateright, char deleteright) {
        this.idright = idright;
        this.createright = createright;
        this.readright = readright;
        this.updateright = updateright;
        this.deleteright = deleteright;
    }

    public BigDecimal getIdright() {
        return idright;
    }

    public void setIdright(BigDecimal idright) {
        this.idright = idright;
    }

    public boolean getCreateright() {
        if(this.createright == '0')
            return false;
        else
            return true;
    }

    public void setCreateright(char createright) {
        this.createright = createright;
    }

    public boolean getReadright() {
        if(this.readright == '0')
            return false;
        else
            return true;
    }

    public void setReadright(char readright) {
        this.readright = readright;
    }

    public boolean getUpdateright() {
        if(this.updateright == '0')
            return false;
        else
            return true;
    }

    public void setUpdateright(char updateright) {
        this.updateright = updateright;
    }

    public boolean getDeleteright() {
        if(this.deleteright == '0')
            return false;
        else
            return true;
    }

    public List<Userrole> getUserroleList() {
        return userroleList;
    }

    public void setUserroleList(List<Userrole> userroleList) {
        this.userroleList = userroleList;
    }

    public Topic getIdtopic() {
        return idtopic;
    }

    public void setIdtopic(Topic idtopic) {
        this.idtopic = idtopic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idright != null ? idright.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rights)) {
            return false;
        }
        Rights other = (Rights) object;
        if ((this.idright == null && other.idright != null) || (this.idright != null && !this.idright.equals(other.idright))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.Rights[idright=" + idright + "]";
    }

}
