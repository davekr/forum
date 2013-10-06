/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entityBeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
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
@Table(name = "RANK")
@NamedQueries({
    @NamedQuery(name = "Rank.findAll", query = "SELECT r FROM Rank r"),
    @NamedQuery(name = "Rank.findByIdrank", query = "SELECT r FROM Rank r WHERE r.idrank = :idrank"),
    @NamedQuery(name = "Rank.findByName", query = "SELECT r FROM Rank r WHERE r.name = :name"),
    @NamedQuery(name = "Rank.findByMinposts", query = "SELECT r FROM Rank r WHERE r.minposts = :minposts"),
    @NamedQuery(name = "Rank.findByMaxposts", query = "SELECT r FROM Rank r WHERE r.maxposts = :maxposts")})
public class Rank implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDRANK")
    private BigDecimal idrank;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "MINPOSTS")
    private BigInteger minposts;
    @Basic(optional = false)
    @Column(name = "MAXPOSTS")
    private BigInteger maxposts;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idrank")
    private List<Forumuser> forumuserList;

    public Rank() {
    }

    public Rank(BigDecimal idrank) {
        this.idrank = idrank;
    }

    public Rank(BigDecimal idrank, String name, BigInteger minposts, BigInteger maxposts) {
        this.idrank = idrank;
        this.name = name;
        this.minposts = minposts;
        this.maxposts = maxposts;
    }

    public BigDecimal getIdrank() {
        return idrank;
    }

    public void setIdrank(BigDecimal idrank) {
        this.idrank = idrank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getMinposts() {
        return minposts;
    }

    public void setMinposts(BigInteger minposts) {
        this.minposts = minposts;
    }

    public BigInteger getMaxposts() {
        return maxposts;
    }

    public void setMaxposts(BigInteger maxposts) {
        this.maxposts = maxposts;
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
        hash += (idrank != null ? idrank.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rank)) {
            return false;
        }
        Rank other = (Rank) object;
        if ((this.idrank == null && other.idrank != null) || (this.idrank != null && !this.idrank.equals(other.idrank))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.Rank[idrank=" + idrank + "]";
    }

}
