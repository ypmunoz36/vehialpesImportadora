package utilHibernate;
// Generated 16/03/2019 12:45:30 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Venta generated by hbm2java
 */
public class Venta  implements java.io.Serializable {


     private Integer idventa;
     private Cliente cliente;
     private String vehiculoIdcarro;
     private Date venFecha;
     private Integer venPrecio;
     private String usuarioAsesor;
     private Date venFechaRegistra;

    public Venta() {
    }

	
    public Venta(Cliente cliente) {
        this.cliente = cliente;
    }
    public Venta(Cliente cliente, String vehiculoIdcarro, Date venFecha, Integer venPrecio, String usuarioAsesor, Date venFechaRegistra) {
       this.cliente = cliente;
       this.vehiculoIdcarro = vehiculoIdcarro;
       this.venFecha = venFecha;
       this.venPrecio = venPrecio;
       this.usuarioAsesor = usuarioAsesor;
       this.venFechaRegistra = venFechaRegistra;
    }
   
    public Integer getIdventa() {
        return this.idventa;
    }
    
    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String getVehiculoIdcarro() {
        return this.vehiculoIdcarro;
    }
    
    public void setVehiculoIdcarro(String vehiculoIdcarro) {
        this.vehiculoIdcarro = vehiculoIdcarro;
    }
    public Date getVenFecha() {
        return this.venFecha;
    }
    
    public void setVenFecha(Date venFecha) {
        this.venFecha = venFecha;
    }
    public Integer getVenPrecio() {
        return this.venPrecio;
    }
    
    public void setVenPrecio(Integer venPrecio) {
        this.venPrecio = venPrecio;
    }
    public String getUsuarioAsesor() {
        return this.usuarioAsesor;
    }
    
    public void setUsuarioAsesor(String usuarioAsesor) {
        this.usuarioAsesor = usuarioAsesor;
    }
    public Date getVenFechaRegistra() {
        return this.venFechaRegistra;
    }
    
    public void setVenFechaRegistra(Date venFechaRegistra) {
        this.venFechaRegistra = venFechaRegistra;
    }




}


