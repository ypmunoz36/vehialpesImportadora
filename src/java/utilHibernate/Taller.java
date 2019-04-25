package utilHibernate;
// Generated 16/03/2019 12:45:30 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Taller generated by hbm2java
 */
public class Taller  implements java.io.Serializable {


     private Integer idtaller;
     private Concesionario concesionario;
     private String talNombre;
     private Date talFechaRegistro;

    public Taller() {
    }

	
    public Taller(Concesionario concesionario) {
        this.concesionario = concesionario;
    }
    public Taller(Concesionario concesionario, String talNombre, Date talFechaRegistro) {
       this.concesionario = concesionario;
       this.talNombre = talNombre;
       this.talFechaRegistro = talFechaRegistro;
    }
   
    public Integer getIdtaller() {
        return this.idtaller;
    }
    
    public void setIdtaller(Integer idtaller) {
        this.idtaller = idtaller;
    }
    public Concesionario getConcesionario() {
        return this.concesionario;
    }
    
    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }
    public String getTalNombre() {
        return this.talNombre;
    }
    
    public void setTalNombre(String talNombre) {
        this.talNombre = talNombre;
    }
    public Date getTalFechaRegistro() {
        return this.talFechaRegistro;
    }
    
    public void setTalFechaRegistro(Date talFechaRegistro) {
        this.talFechaRegistro = talFechaRegistro;
    }




}

