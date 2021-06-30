
package com.mycompany.server.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author viny_
 */
@Entity
public class Quarto implements Serializable {
    
    @Id
    private long id;
    private String numero_quarto;
    private String andar;
    private String total_camas;
    private double preco;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

   
    public String getNumero_quarto() {
        return numero_quarto;
    }

 
    public void setNumero_quarto(String numero_quarto) {
        this.numero_quarto = numero_quarto;
    }

  
    public String getAndar() {
        return andar;
    }

   
    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getTotal_camas() {
        return total_camas;
    }

    public void setTotal_camas(String total_camas) {
        this.total_camas = total_camas;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}
