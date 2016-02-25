/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.dao.UtilisateurDAOJPAImpl;
import forum.entity.Utilisateur;
import forum.exception.ErreurLoginOuMdpException;
import forum.exception.LoginExistantException;
import forum.exception.MailExistantException;
import java.util.List;

/**
 *
 * @author admin
 */
public interface UtilisateurService {
   

    /**
     * Connexion sur base uniquement du login et du mdp, les autrechs champs ne
     * doivent pas etre initialisés.
     *
     * @param u
     * @throws ErreurLoginOuMdpException
     */
    public void connection(String login, String mdp) throws ErreurLoginOuMdpException, Exception ;

    public void validation(Utilisateur u);

    public void inscription(Utilisateur u) throws MailExistantException, LoginExistantException ;

    public void ajouter(Utilisateur u);

    public void supprimer(long id) ;

    public void modifier(Utilisateur u) ;

    public Utilisateur rechercherParId(long id) ;

    public List<Utilisateur> listerTous() ;

}
