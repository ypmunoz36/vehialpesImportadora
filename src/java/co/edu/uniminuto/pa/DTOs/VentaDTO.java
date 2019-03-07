/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.pa.DTOs;

/**
 *
 * @author sala8
 */
public class VentaDTO {
      private int idventa =0 ;
    private int identificacionCliente = 0 ;
    private String vinAuto = null;
    private String fechaVenta = null;
    private int precioVenta = 0;
    private String asesor = null;

    public VentaDTO() {
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }
    

    public int getIdentificacionCliente() {
        return identificacionCliente;
    }

    public void setIdentificacionCliente(int identificacionCliente) {
        this.identificacionCliente = identificacionCliente;
    }

    public String getVinAuto() {
        return vinAuto;
    }

    public void setVinAuto(String vinAuto) {
        this.vinAuto = vinAuto;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getAsesor() {
        return asesor;
    }

    public void setAsesor(String asesor) {
        this.asesor = asesor;
    }

    @Override
    public String toString() {
        return "VentaDTO{" + "identificacionCliente=" + identificacionCliente + ", vinAuto=" + vinAuto + ", fechaVenta=" + fechaVenta + ", precioVenta=" + precioVenta + ", asesor=" + asesor + '}';
    }

    
}
