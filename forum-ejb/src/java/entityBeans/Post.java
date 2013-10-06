/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entityBeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Dave
 */
@Entity
@Table(name = "POST")
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p"),
    @NamedQuery(name = "Post.findByIdpost", query = "SELECT p FROM Post p WHERE p.idpost = :idpost"),
    @NamedQuery(name = "Post.findByCreated", query = "SELECT p FROM Post p WHERE p.created = :created"),
    @NamedQuery(name = "Post.findBySubject", query = "SELECT p FROM Post p WHERE p.subject = :subject"),
    @NamedQuery(name = "Post.findByContent", query = "SELECT p FROM Post p WHERE p.content = :content")})
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDPOST")
    private BigDecimal idpost;
    @Basic(optional = false)
    @Column(name = "CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "SUBJECT")
    private String subject;
    @Basic(optional = false)
    @Column(name = "CONTENT")
    private String content;
    @JoinColumn(name = "IDUSER", referencedColumnName = "IDUSER")
    @ManyToOne(optional = false)
    private Forumuser iduser;
    @JoinColumn(name = "IDTHREAD", referencedColumnName = "IDTHREAD")
    @ManyToOne(optional = false)
    private Thread idthread;

    public Post() {
    }

    public Post(BigDecimal idpost) {
        this.idpost = idpost;
    }

    public Post(BigDecimal idpost, Date created, String content) {
        this.idpost = idpost;
        this.created = created;
        this.content = content;
    }

    public BigDecimal getIdpost() {
        return idpost;
    }

    public void setIdpost(BigDecimal idpost) {
        this.idpost = idpost;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Forumuser getIduser() {
        return iduser;
    }

    public void setIduser(Forumuser iduser) {
        this.iduser = iduser;
    }

    public Thread getIdthread() {
        return idthread;
    }

    public void setIdthread(Thread idthread) {
        this.idthread = idthread;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpost != null ? idpost.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.idpost == null && other.idpost != null) || (this.idpost != null && !this.idpost.equals(other.idpost))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.Post[idpost=" + idpost + "]";
    }

}
