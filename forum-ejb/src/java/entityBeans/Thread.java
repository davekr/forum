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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Dave
 */
@Entity
@Table(name = "THREAD")
@NamedQueries({
    @NamedQuery(name = "Thread.findAll", query = "SELECT t FROM Thread t"),
    @NamedQuery(name = "Thread.findByIdthread", query = "SELECT t FROM Thread t WHERE t.idthread = :idthread"),
    @NamedQuery(name = "Thread.findByName", query = "SELECT t FROM Thread t WHERE t.name = :name"),
    @NamedQuery(name = "Thread.findByPosts", query = "SELECT t FROM Thread t WHERE t.posts = :posts"),
    @NamedQuery(name = "Thread.findByViewed", query = "SELECT t FROM Thread t WHERE t.viewed = :viewed")})
public class Thread implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDTHREAD")
    private BigDecimal idthread;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Column(name = "POSTS")
    private BigInteger posts;
    @Column(name = "VIEWED")
    private BigInteger viewed;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idthread")
    private List<Post> postList;
    @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER")
    @ManyToOne(optional = false)
    private Forumuser iduser;
    @JoinColumn(name = "IDTOPIC", referencedColumnName = "IDTOPIC")
    @ManyToOne(optional = false)
    private Topic idtopic;

    public Thread() {
    }

    public Thread(BigDecimal idthread) {
        this.idthread = idthread;
    }

    public Thread(BigDecimal idthread, String name) {
        this.idthread = idthread;
        this.name = name;
    }

    public BigDecimal getIdthread() {
        return idthread;
    }

    public void setIdthread(BigDecimal idthread) {
        this.idthread = idthread;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getPosts() {
        return posts;
    }

    public void setPosts(BigInteger posts) {
        this.posts = posts;
    }

    public BigInteger getViewed() {
        return viewed;
    }

    public void setViewed(BigInteger viewed) {
        this.viewed = viewed;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public Forumuser getIduser() {
        return iduser;
    }

    public void setIduser(Forumuser iduser) {
        this.iduser = iduser;
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
        hash += (idthread != null ? idthread.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Thread)) {
            return false;
        }
        Thread other = (Thread) object;
        if ((this.idthread == null && other.idthread != null) || (this.idthread != null && !this.idthread.equals(other.idthread))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.Thread[idthread=" + idthread + "]";
    }

}
