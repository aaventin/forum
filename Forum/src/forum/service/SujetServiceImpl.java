/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.service;

import forum.dao.SujetDAOJPAImpl;
import forum.entity.Sujet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class SujetServiceImpl implements SujetService{
    
    @Autowired
    SujetDAOJPAImpl dao ;
    
     public void ajouter(Sujet s){
         dao.ajouter(s);
     }
     
      public void supprimer (long id){
          dao.supprimer(id);
      }
      
    public void modifier (Sujet s){
       dao.modifier(s);
    }
    
    public Sujet rechercherParId(long id){
        return dao.rechercherParId(id);
    }
    
     public List<Sujet> listerTous(){
         return dao.listerTous();
     }
}
