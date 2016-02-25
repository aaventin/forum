/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.dao.UtilisateurDAO;
import forum.entity.Utilisateur;
import forum.exception.ErreurLoginOuMdpException;
import forum.exception.LoginExistantException;
import forum.exception.MailExistantException;
import java.util.List;

/**
 *
 * @author admin
 */
public class UtilisateurService {

    private UtilisateurDAO dao = new UtilisateurDAO();
    private MailService mailserv = new MailService();
    
    /**
     * Connexion sur base uniquement du login et du mdp, les autrechs champs ne doivent pas etre initialisés.
     * @param u
     * @throws ErreurLoginOuMdpException 
     */
    public void connection(String login, String mdp) throws ErreurLoginOuMdpException, Exception{
        
        List<Utilisateur> util1 = dao.rechercherParLogin(login);
        if(util1.isEmpty() || !util1.get(0).getMdp().equals(mdp)){
            throw new ErreurLoginOuMdpException();
        }        
        if (util1.get(0).getInscrit()==false){
            throw new Exception();
        }           
        
        System.out.println("Félicitations vous êtes connectés !!!");
        
    }
    
    public void validation(Utilisateur u){
        u.setInscrit(Boolean.TRUE);
        modifier(u);
    }

    public void inscription(Utilisateur u) throws MailExistantException, LoginExistantException {

        List<Utilisateur> util = dao.rechercherParMail(u.getMail());
        List<Utilisateur> util2 = dao.rechercherParLogin(u.getLogin());

        // ERR si login existe
        if (util2.isEmpty()==false) {
            throw new LoginExistantException();
        }
        
        // ERR si mail existe
        if (util.isEmpty()==false) {
            throw new MailExistantException();
        }
        
        // Validation ok
        
        // Ajout d'un utilisateur
        dao.ajouter(u);
        MailService mailserv = new MailService();

        mailserv.mail("admin", u.getMdp(), "Validation inscription : ", "Merci de cliquer sur le lien pour valider votre inscription");

    }

    public void ajouter(Utilisateur u) {
        dao.ajouter(u);
    }

    public void supprimer(long id) {
        dao.supprimer(id);
    }

    public void modifier(Utilisateur u) {
        dao.modifier(u);
    }

    public Utilisateur rechercherParId(long id) {
        return dao.rechercherParId(id);
    }

    public List<Utilisateur> listerTous() {
        return dao.listerTous();
    }

}
