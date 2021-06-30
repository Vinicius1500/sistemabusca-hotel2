
package com.mycompany.server.dao;

import com.mycompany.server.config.ConnectionFactory;
import com.mycompany.server.model.Hotel;
import java.util.ArrayList;
import javax.persistence.EntityManager;

/**
 *
 * @author viny_
 */
public class HotelDAO {
    
    public Hotel findById(int id){
        EntityManager em = new ConnectionFactory().getConnection();
        Hotel hotel = null ;
        try{
            hotel = em.find(Hotel.class, id);
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        
        return hotel ;
    }
    public ArrayList<Hotel> findByReservaLocal(String cidade){
        EntityManager em = new ConnectionFactory().getConnection();
        ArrayList <Hotel> hotel = null ;
        System.out.println("Cidade: "+cidade+"'");
        try{
            hotel = (ArrayList<Hotel>) em.createQuery("cidade_id="+cidade+"'").getResultList();
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        
        return hotel;  
    }
    public ArrayList<Hotel> findByReservaLocal(String bairro, String cidade){
        EntityManager em = new ConnectionFactory().getConnection();
        ArrayList <Hotel> hotel = null ;
        System.out.println("Cidade: "+cidade+ "Bairro:" +bairro+"'");
        try{
            hotel = (ArrayList<Hotel>) em.createQuery("bairro_id="+bairro+" and cidade_id="+cidade+"'").getResultList();
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        
        return hotel;  
    }
    
    public ArrayList<Hotel> findByTrajetoDataPreco(String cidade, double preco, String qtd_camas){
        EntityManager em = new ConnectionFactory().getConnection();
        ArrayList <Hotel> hotel = null ;
        System.out.println("Cidade: "+cidade+" Preço: "+preco+" Total de camas: "+qtd_camas+"'");
        try{
            hotel = (ArrayList<Hotel>) em.createQuery("cidade_id="+cidade+
                    " preco_id="+preco+" qtd_camas="+qtd_camas"'").getResultList();
        }catch(Exception e){
            System.err.println(e);
        }finally{
            em.close();
        }
        
        return hotel;  
    }

    public long save(Hotel hotel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Hotel findById(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
