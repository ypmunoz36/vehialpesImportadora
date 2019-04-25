/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.pa.DAOs;

import co.edu.ucatolica.pa.DTOs.Persona;
import co.edu.ucatolica.pa.DTOs.VehiculoDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author Yury Muñoz
 */
public class VehiculoDAO  {

    public boolean insertVehiculo(Connection conexion, VehiculoDTO v) {
        boolean respuesta = false;
        PreparedStatement pstmt = null;
        Connection con = null;
             
        try {
            con = conexion;
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.INFO, "Ejecutando insert...");
            
            pstmt = con.prepareStatement("INSERT INTO vehiculo" +
                                "(vin," +
                                "matricula," +
                                "anio_fabricacion," +
                                "cilindraje," +
                                "id_tipo_combustible," +
                                "modelo," +
                                "color," +
                                "numero_sillas," +
                                "id_marca," +
                                "id_tipo," +
                                "pais_fabricacion," +
                                "costo," +
                                "precio_venta,nombre)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            pstmt.setString(1,v.getVin());
            pstmt.setString(2,v.getMatricula());
            pstmt.setString(3, v.getAnioFabricacion());
            pstmt.setString(4, v.getCilindraje());
            pstmt.setString(5,  v.getTipoCombustible());
            pstmt.setString(6, v.getModelo());
            pstmt.setString(7, v.getColor());
            pstmt.setString(8, v.getNumSillas());
            pstmt.setInt(9, v.getIdMarca());
            pstmt.setInt(10, v.getIdTipo());
            pstmt.setString(11, v.getPaisFab());
            pstmt.setInt(12, v.getPrecioCosto());
            pstmt.setInt(13, v.getPrecioVenta());
            pstmt.setString(14, v.getNombre());
            pstmt.execute();
          
            respuesta = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return respuesta;
    }

    
    public VehiculoDTO selectVehiculo(Connection conexion, VehiculoDTO v) {
         VehiculoDTO rta = new VehiculoDTO();
        
          Connection con = null;
          con = conexion;
        Statement s;
        try {
            
            s = con.createStatement();
            ResultSet rs = s.executeQuery ("select " +
                "vin," +
                "matricula," +
                "anio_fabricacion," +
                "cilindraje," +
                "id_tipo_combustible," +
                "modelo," +
                "color," +
                "numero_sillas," +
                "id_marca," +
                "id_tipo," +
                "pais_fabricacion," +
                "costo, precio_venta,nombre from vehiculo where vin='" + v.getVin()+"'");
            while (rs.next())
            {
                rta.setVin(rs.getString("vin"));
                rta.setMatricula(rs.getString("matricula"));
                rta.setAnioFabricacion(rs.getString("anio_fabricacion"));
                rta.setCilindraje(rs.getString("cilindraje"));
                rta.setTipoCombustible(rs.getString( "id_tipo_combustible" ));
                rta.setModelo(rs.getString("modelo"));
                rta.setColor(rs.getString("color"));
                rta.setNumSillas(rs.getString("numero_sillas"));
                rta.setIdMarca(rs.getInt("id_marca"));
                rta.setIdTipo(rs.getInt("id_tipo"));
                rta.setPaisFab(rs.getString("pais_fabricacion"));
                rta.setPrecioCosto(rs.getInt("costo"));
                rta.setPrecioVenta(rs.getInt("precio_venta"));
                rta.setNombre(rs.getString("nombre"));
                
                
            }
           
           
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return rta;
    }

    public boolean updateVehiculo(Connection conexion, VehiculoDTO v) {
        Connection con = null;
        PreparedStatement pstmt = null;
        boolean respuesta = false;
         con = conexion;
        
        try {            
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.INFO, "Ejecutando update...");
            
            pstmt = con.prepareStatement("update vehiculo "
                    + " SET "
                    + " matricula=?"
                    + " , anio_fabricacion=?"
                    + " , cilindraje=?"
                    + " , id_tipo_combustible=?"
                    + " , modelo=?"
                    + " , color=?"
                    + " , numero_sillas=?"
                    + " , id_marca=?"
                    + " , id_tipo=?"
                    + " , pais_fabricacion=?"
                    + " , costo=?"
                    + " , precio_venta  =?"
                    + " , nombre  =?"
                    + " where vin=?");
                        
         
            pstmt.setString(1, v.getMatricula());
            pstmt.setString(2, v.getAnioFabricacion());
            pstmt.setString(3, v.getCilindraje());
            pstmt.setString(4, v.getTipoCombustible());
            pstmt.setString(5, v.getModelo());
            pstmt.setString(6, v.getColor());
            pstmt.setString(7, v.getNumSillas());
            pstmt.setInt(8, v.getIdMarca());
            pstmt.setInt(9, v.getIdTipo());
            pstmt.setString(10, v.getPaisFab());
            pstmt.setInt(11, v.getPrecioCosto());
            pstmt.setInt(12, v.getPrecioVenta());
            pstmt.setString(13, v.getNombre());
            pstmt.setString(14, v.getVin());
            pstmt.executeUpdate();
            
          
            
            
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;
    }
    
    public ArrayList<VehiculoDTO> selectAllVehiculo(Connection conexion) {
        
      
         ArrayList<VehiculoDTO> arrayListRta = new ArrayList<VehiculoDTO>();
        Connection con = null;
        con = conexion;
        Statement s;
        try {
            
            s = con.createStatement();
            ResultSet rs = s.executeQuery ("select " +
                "vin," +
                "matricula," +
                "anio_fabricacion," +
                "cilindraje," +
                "id_tipo_combustible," +
                "modelo," +
                "color," +
                "numero_sillas," +
                "id_marca," +
                "id_tipo," +
                "pais_fabricacion," +
                "costo, precio_venta,nombre from vehiculo order by fecha_registro desc");
            
            while (rs.next())
            {
                VehiculoDTO rta = new VehiculoDTO();
                rta.setVin(rs.getString("vin"));
                rta.setMatricula(rs.getString("matricula"));
                rta.setAnioFabricacion(rs.getString("anio_fabricacion"));
                rta.setCilindraje(rs.getString("cilindraje"));
                rta.setTipoCombustible(rs.getString( "id_tipo_combustible" ));
                rta.setModelo(rs.getString("modelo"));
                rta.setColor(rs.getString("color"));
                rta.setNumSillas(rs.getString("numero_sillas"));
                rta.setIdMarca(rs.getInt("id_marca"));
                rta.setIdTipo(rs.getInt("id_tipo"));
                rta.setPaisFab(rs.getString("pais_fabricacion"));
                rta.setPrecioCosto(rs.getInt("costo"));
                rta.setPrecioVenta(rs.getInt("precio_venta"));
                rta.setNombre(rs.getString("nombre"));        
                arrayListRta.add(rta);
            }
           
           
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return arrayListRta;
    }
}
