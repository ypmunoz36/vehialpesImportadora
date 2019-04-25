/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.pa.DTOs;

/**
 *
 * @author otro
 */
public class GarantiaDTO {
    
    private String idCliente ;
    private String nomCliente;
    private String vinVehiculo;
    private String valVehiculo;
    private String fechaVenta;
    private String fechaGarantia;
    private String estado;

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getVinVehiculo() {
        return vinVehiculo;
    }

    public void setVinVehiculo(String vinVehiculo) {
        this.vinVehiculo = vinVehiculo;
    }

 

    public String getValVehiculo() {
        return valVehiculo;
    }

    public void setValVehiculo(String valVehiculo) {
        this.valVehiculo = valVehiculo;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getFechaGarantia() {
        return fechaGarantia;
    }

    public void setFechaGarantia(String fechaGarantia) {
        this.fechaGarantia = fechaGarantia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
