/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.dao;

import forum.entity.Utilisateur;
import java.util.List;


/**
 *
 * @author admin
 */
public interface UtilisateurDAO {
    
    public void ajouter(Utilisateur u) ;        
    

    public void supprimer(long id);

    public void modifier(Utilisateur u) ;
       
    

    public Utilisateur rechercherParId(long id) ;
       
    

    public List<Utilisateur> rechercherParLogin(String login) ;
       
    
    
    public List<Utilisateur> rechercherParMdp(String mdp) ;

    

    public List<Utilisateur> rechercherParMail(String mail) ;
     
    

    public List<Utilisateur> listerTous() ;
      
    

    
}
