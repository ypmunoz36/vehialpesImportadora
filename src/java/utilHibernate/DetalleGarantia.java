package utilHibernate;
// Generated 16/03/2019 12:45:30 PM by Hibernate Tools 4.3.1



/**
 * DetalleGarantia generated by hbm2java
 */
public class DetalleGarantia  implements java.io.Serializable {


     private Integer iddetalleGarantia;
     private Garantia garantia;
     private Repuesto repuesto;

    public DetalleGarantia() {
    }

    public DetalleGarantia(Garantia garantia, Repuesto repuesto) {
       this.garantia = garantia;
       this.repuesto = repuesto;
    }
   
    public Integer getIddetalleGarantia() {
        return this.iddetalleGarantia;
    }
    
    public void setIddetalleGarantia(Integer iddetalleGarantia) {
        this.iddetalleGarantia = iddetalleGarantia;
    }
    public Garantia getGarantia() {
        return this.garantia;
    }
    
    public void setGarantia(Garantia garantia) {
        this.garantia = garantia;
    }
    public Repuesto getRepuesto() {
        return this.repuesto;
    }
    
    public void setRepuesto(Repuesto repuesto) {
        this.repuesto = repuesto;
    }




}


