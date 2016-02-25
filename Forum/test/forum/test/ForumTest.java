/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.test;

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

}
