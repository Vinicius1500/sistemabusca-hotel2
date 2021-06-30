
package com.mycompany.server.dao;

import com.mycompany.server.config.ConnectionFactory;
import com.mycompany.server.model.Reserva;
import javax.persistence.EntityManager;

/**
 *
 * @author viny_
 */
public class ReservaDAO {
    
    public int save(Reserva reserva){
        
        EntityManager em = new ConnectionFactory().getConnection();
        
        try{
            
            em.getTransaction().begin();
            if(reserva.getId()==null){
                em.persist(reserva);
            }else {
                em.merge(reserva);
            }
            em.getTransaction().commit();
            
        }catch(Exception e){
            em.getTransaction().rollback();
            System.err.println(e);
        }finally{
            em.close();
        }
     
        return reserva.getId() ;
    }
    
    public Reserva remove(int id){
        EntityManager em = new ConnectionFactory().getConnection();
        Reserva r = null ;
        
        try{
            r = em.find(Reserva.class, id);
            
            em.getTransaction().begin();
            em.remove(r);
            em.getTransaction().commit();
            
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        return r ;       
    }
    
    public Reserva findById(int id){
        EntityManager em = new ConnectionFactory().getConnection();
        Reserva cidade = null ;
        try{
            cidade = em.find(Reserva.class, id);
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        
        return cidade ;
    }
    
}
