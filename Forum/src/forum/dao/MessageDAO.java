/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forum.dao;

import forum.entity.Message;
import java.util.List;

/**
 *
 * @author admin
 */
public interface MessageDAO {

    public void ajouter(Message m);

    public void supprimer(long id);

    public void modifier(Message m);

    public Message rechercherParId(long id);

    public List<Message> listerTous();
}
