/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entityBeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Dave
 */
@Entity
@Table(name = "FORUMUSER")
@NamedQueries({
    @NamedQuery(name = "Forumuser.findAll", query = "SELECT f FROM Forumuser f"),
    @NamedQuery(name = "Forumuser.findByIduser", query = "SELECT f FROM Forumuser f WHERE f.iduser = :iduser"),
    @NamedQuery(name = "Forumuser.findByNick", query = "SELECT f FROM Forumuser f WHERE f.nick = :nick"),
    @NamedQuery(name = "Forumuser.findByHome", query = "SELECT f FROM Forumuser f WHERE f.home = :home"),
    @NamedQuery(name = "Forumuser.findByEmail", query = "SELECT f FROM Forumuser f WHERE f.email = :email"),
    @NamedQuery(name = "Forumuser.findByPosts", query = "SELECT f FROM Forumuser f WHERE f.posts = :posts"),
    @NamedQuery(name = "Forumuser.findByRegdate", query = "SELECT f FROM Forumuser f WHERE f.regdate = :regdate"),
    @NamedQuery(name = "Forumuser.findByPass", query = "SELECT f FROM Forumuser f WHERE f.pass = :pass")})
public class Forumuser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDUSER")
    private BigDecimal iduser;
    @Basic(optional = false)
    @Column(name = "NICK")
    private String nick;
    @Column(name = "HOME")
    private String home;
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @Column(name = "POSTS")
    private BigInteger posts;
    @Basic(optional = false)
    @Column(name = "REGDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regdate;
    @Column(name = "PASS")
    private String pass;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private List<Post> postList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iduser")
    private List<Thread> threadList;
    @JoinColumn(name = "IDRANK", referencedColumnName = "IDRANK")
    @ManyToOne(optional = false)
    private Rank idrank;
    @JoinColumn(name = "IDROLE", referencedColumnName = "IDROLE")
    @ManyToOne
    private Userrole idrole;

    public Forumuser() {
    }

    public Forumuser(BigDecimal iduser) {
        this.iduser = iduser;
    }

    public Forumuser(BigDecimal iduser, String nick, BigInteger posts, Date regdate) {
        this.iduser = iduser;
        this.nick = nick;
        this.posts = posts;
        this.regdate = regdate;
    }

    public BigDecimal getIduser() {
        return iduser;
    }

    public void setIduser(BigDecimal iduser) {
        this.iduser = iduser;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getPosts() {
        return posts;
    }

    public void setPosts(BigInteger posts) {
        this.posts = posts;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public List<Thread> getThreadList() {
        return threadList;
    }

    public void setThreadList(List<Thread> threadList) {
        this.threadList = threadList;
    }

    public Rank getIdrank() {
        return idrank;
    }

    public void setIdrank(Rank idrank) {
        this.idrank = idrank;
    }

    public Userrole getIdrole() {
        return idrole;
    }

    public void setIdrole(Userrole idrole) {
        this.idrole = idrole;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduser != null ? iduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Forumuser)) {
            return false;
        }
        Forumuser other = (Forumuser) object;
        if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entityBeans.Forumuser[iduser=" + iduser + "]";
    }

}
