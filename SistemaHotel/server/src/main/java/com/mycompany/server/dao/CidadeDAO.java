
package com.mycompany.server.dao;

import com.mycompany.server.config.ConnectionFactory;
import com.mycompany.server.model.Cidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.EntityManager;

/**
 *
 * @author viny_
 */
public class CidadeDAO {
    
    public Cidade findById(int id){
        EntityManager em = new ConnectionFactory().getConnection();
        Cidade cidade = null ;
        try{
            cidade = em.find(Cidade.class, id);
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        
        return cidade ;
    }
    public int findByName(String nome){
        EntityManager em = new ConnectionFactory().getConnection();
        Cidade cidade = null ;
        int id = 0 ;
        try{

            id = cidade.getId();
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        
        return id ;
    }
}
    

