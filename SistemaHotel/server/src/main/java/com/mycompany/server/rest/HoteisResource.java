
package com.mycompany.server.rest;


import com.mycompany.server.dao.HotelDAO;
import com.mycompany.server.dao.ReservaDAO;
import com.mycompany.server.model.Hotel;
import com.mycompany.server.model.Reserva;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author viny_
 */
@Path("/hotel")
public class HoteisResource {
    Hotel hotel = new Hotel();
    HotelDAO dao = new HotelDAO();
    ReservaDAO rDao = new ReservaDAO();
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Hotel findById(@PathParam("id") long id){
        return dao.findById(id);
    }
    
    //Reservar hotel 
    @POST
    @Path("/reserva")
    @Consumes(MediaType.APPLICATION_JSON)
    public int reserve(Reserva reserva){
        return rDao.save(reserva);
    };
    
    
    //Buscar reserva pelo id
    @GET
    @Path("reserva/{id}")//
    @Produces(MediaType.APPLICATION_JSON)
    public Reserva getReserve(@PathParam("id")Integer id){
        
        return rDao.findById(id);
    };
    
    //Alterar reserva de hotel
    @PUT
    @Path("/reserva")
    @Consumes(MediaType.APPLICATION_JSON)
    public int reserveUpdate(Reserva reserva){
        return rDao.save(reserva);
    };
    
    //Deletando reserva do hotel
    @DELETE
    @Path("/reserva/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Reserva reserveDelete(@PathParam("id")Integer id ){
        return rDao.remove(id);
    };
}
