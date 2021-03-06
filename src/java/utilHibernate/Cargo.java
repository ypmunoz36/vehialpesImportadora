package utilHibernate;
// Generated 16/03/2019 12:45:30 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Cargo generated by hbm2java
 */
public class Cargo  implements java.io.Serializable {


     private Integer idcargo;
     private String carNombre;
     private Date carFechaRegistro;
     private Set usuarios = new HashSet(0);

    public Cargo() {
    }

    public Cargo(String carNombre, Date carFechaRegistro, Set usuarios) {
       this.carNombre = carNombre;
       this.carFechaRegistro = carFechaRegistro;
       this.usuarios = usuarios;
    }
   
    public Integer getIdcargo() {
        return this.idcargo;
    }
    
    public void setIdcargo(Integer idcargo) {
        this.idcargo = idcargo;
    }
    public String getCarNombre() {
        return this.carNombre;
    }
    
    public void setCarNombre(String carNombre) {
        this.carNombre = carNombre;
    }
    public Date getCarFechaRegistro() {
        return this.carFechaRegistro;
    }
    
    public void setCarFechaRegistro(Date carFechaRegistro) {
        this.carFechaRegistro = carFechaRegistro;
    }
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }




}


