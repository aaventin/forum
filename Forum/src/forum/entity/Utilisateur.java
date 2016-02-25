/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.entity;

import forum.enumeration.TypeUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author admin
 */
@Entity
public class Utilisateur implements Serializable {
    
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mdp;
    private String mail;
    private TypeUtil typeUtil;
    private String login;
    private Boolean inscrit=false;
    
    @OneToOne()
    @JoinColumn(name = "INSEE_ID")
    private NumInsee numInsee;
        
    @OneToMany(mappedBy = "createur", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @CascadeOnDelete
    private List<Forum> forumsCrees = new ArrayList<>();
    
    @OneToMany (mappedBy = "postePar", cascade = CascadeType.PERSIST)
    private List<Message> messagesPostes = new ArrayList<>();
    
    @OneToMany(mappedBy = "postePar",cascade = CascadeType.PERSIST)    
    private List<Sujet> sujetsPostes = new ArrayList<>();

    public List<Forum> getForumsCrees() {
        return forumsCrees;
    }

    public void setForumsCrees(List<Forum> forumsCrees) {
        this.forumsCrees = forumsCrees;
    }

    public List<Message> getMessagesPostes() {
        return messagesPostes;
    }

    public void setMessagesPostes(List<Message> messagesPostes) {
        this.messagesPostes = messagesPostes;
    }

    public List<Sujet> getSujetsPostes() {
        return sujetsPostes;
    }

    public void setSujetsPostes(List<Sujet> sujetsPostes) {
        this.sujetsPostes = sujetsPostes;
    }

    public Boolean getInscrit() {
        return inscrit;
    }

    public void setInscrit(Boolean inscrit) {
        this.inscrit = inscrit;
    }

    public TypeUtil getTypeUtil() {
        return typeUtil;
    }

    public void setTypeUtil(TypeUtil typeUtil) {
        this.typeUtil = typeUtil;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "forum.entity.Utilisateur[ id=" + id + " ]";
    }

}
