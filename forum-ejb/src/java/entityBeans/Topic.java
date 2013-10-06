/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entityBeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Dave
 */
@Entity
@Table(name = "TOPIC")
@NamedQueries({
    @NamedQuery(name = "Topic.findAll", query = "SELECT t FROM Topic t"),
    @NamedQuery(name = "Topic.findByIdtopic", query = "SELECT t FROM Topic t WHERE t.idtopic = :idtopic"),
    @NamedQuery(name = "Topic.findByName", query = "SELECT t FROM Topic t WHERE t.name = :name"),
    @NamedQuery(name = "Topic.findByDescription", query = "SELECT t FROM Topic t WHERE t.description = :description"),
    @NamedQuery(name = "Topic.findByPrivate1", query = "SELECT t FROM Topic t WHERE t.private1 = :private1")})
public class Topic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDTOPIC")
    private BigDecimal idtopic;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Column(name = "PRIVATE")
    private char private1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtopic")
    private List<Thread> threadList;
    @OneToMany(mappedBy = "idtopic")
    private List<Rights> rightsList;

    public Topic() {
    }

    public Topic(BigDecimal idtopic) {
        this.idtopic = idtopic;
    }

    public Topic(BigDecimal idtopic, String name, char private1) {
        this.idtopic = idtopic;
        this.name = name;
        this.private1 = private1;
    }

    public BigDecimal getIdtopic() {
        return idtopic;
    }

    public void setIdtopic(BigDecimal idtopic) {
        this.idtopic = idtopic;
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

    public boolean getPrivate1() {
        if(this.private1 == '0')
            return false;
        else
            return true;
    }

    public void setPrivate1(char private1) {
        this.private1 = private1;
    }

    public List<Thread> getThreadList() {
        return threadList;
    }

    public void setThreadList(List<Thread> threadList) {
        this.threadList = threadList;
    }

    public List<Rights> getRightsList() {
        return rightsList;
    }

    public void setRightsList(List<Rights> rightsList) {
        this.rightsList = rightsList;
    }

    public List<SelectItem> getPreparedList() {
        List<SelectItem> lst = new ArrayList<SelectItem>();
        lst.add(new SelectItem(this.idtopic.toString() + "." + "1", "Private"));
        lst.add(new SelectItem(this.idtopic.toString() + "." + "0", "Public"));
        return lst;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtopic != null ? idtopic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Topic)) {
            return false;
        }
        Topic other = (Topic) object;
        if ((this.idtopic == null && other.idtopic != null) || (this.idtopic != null && !this.idtopic.equals(other.idtopic))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.Topic[idtopic=" + idtopic + "]";
    }

}
