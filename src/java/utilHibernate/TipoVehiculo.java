package utilHibernate;
// Generated 16/03/2019 12:45:30 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TipoVehiculo generated by hbm2java
 */
public class TipoVehiculo  implements java.io.Serializable {


     private Integer idtipoAutomovil;
     private String tipo;
     private Date fechaRegistro;
     private Set vehiculos = new HashSet(0);

    public TipoVehiculo() {
    }

    public TipoVehiculo(String tipo, Date fechaRegistro, Set vehiculos) {
       this.tipo = tipo;
       this.fechaRegistro = fechaRegistro;
       this.vehiculos = vehiculos;
    }
   
    public Integer getIdtipoAutomovil() {
        return this.idtipoAutomovil;
    }
    
    public void setIdtipoAutomovil(Integer idtipoAutomovil) {
        this.idtipoAutomovil = idtipoAutomovil;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public Set getVehiculos() {
        return this.vehiculos;
    }
    
    public void setVehiculos(Set vehiculos) {
        this.vehiculos = vehiculos;
    }




}

