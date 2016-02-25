/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.test;

import forum.entity.Forum;
import forum.entity.Message;
import forum.entity.Sujet;
import forum.entity.Utilisateur;
import forum.entity.Forum;
import forum.entity.Message;
import forum.service.DBService;
import forum.service.ForumService;
import forum.service.MailService;
import forum.service.MessageService;
import forum.service.SujetService;
import forum.service.UtilisateurService;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author admin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:/C:\\Users\\admin\\Documents\\NetBeansProjects\\forum\\Forum\\application-context.xml")
public class ForumTest {
    
    @Autowired
    private DBService dbservice;
    
    @Autowired
    private ForumService fserv;
    
    @Autowired
    private MailService mailserv;
    
    @Autowired
    private MessageService mserv;
    
    @Autowired
    private SujetService sujetserv;
    
    @Autowired
    private UtilisateurService utilserv;
    
    //@Test
    public void listerForum(){
        for(Forum f : fserv.listerTous()){
            System.out.println(f.getTitre());
        }
    }
    
    //@Test
    public void listerMessage(){
        for(Message m : mserv.listerTous()){
            System.out.println(m.getContenu());
        }
    }
      
    
    @Test
    public void testUtilServOK(){
        System.out.println("forum.test.ForumTest.testUtilServOK()");
        for(Utilisateur u : utilserv.listerTous())        
        System.out.println(u.getId());
    }
    
    @Test
    public void testSujetServOK(){
        System.out.println("forum.test.ForumTest.testSujetServOK()");
        for(Sujet s : sujetserv.listerTous())        
        System.out.println(s.getId());
    }
    
    @Test
    public void testMailServOK(){
        System.out.println("forum.test.ForumTest.testMailServOK()");
     mailserv.mail("src", "dest", "Hello", "Comment ça va?");     
        
    }

      

}
