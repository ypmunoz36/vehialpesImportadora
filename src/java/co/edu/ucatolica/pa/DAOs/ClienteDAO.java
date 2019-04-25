/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.pa.DAOs;

import co.edu.ucatolica.pa.DTOs.ClienteDTO;
import co.edu.ucatolica.pa.DTOs.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nixoduaa
 */
public class ClienteDAO {
    
    
    
    public boolean crearCliente(ClienteDTO c, Connection con)
    {
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {            
            pstmt = con.prepareStatement("INSERT INTO cliente(cli_identificacion," +
                        "cli_nombres," +
                        "cli_apellidos," +
                        "cli_direccion," +
                        "cli_ciudad," +
                        "cli_telefono," +
                        "cli_celular," +
                        "cli_fecha_nac," +
                        "cli_correo," +
                        "cli_descripcion)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?)");
            
            pstmt.setString(1,c.getIdentificacion());
            pstmt.setString(2, c.getNombre());
            pstmt.setString(3, c.getApellidos());
            pstmt.setString(4, c.getDireccion());
            pstmt.setInt(5, c.getCiudad());
            pstmt.setString(6, c.getTelefono());
            pstmt.setString(7, c.getCelular());
            pstmt.setString(8, c.getFechaNacimiento());
            pstmt.setString(9, c.getCorreo());
            pstmt.setString(10, c.getDescripcion());
            
              pstmt.execute();
            
       
            
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;

    }

    public ClienteDTO consultarCliente(ClienteDTO c, Connection con)
    {
         ClienteDTO rta = new ClienteDTO();
        
        Statement s;
        try {
            
            s = con.createStatement();
            ResultSet rs = s.executeQuery ("select cli_identificacion," +
                "   cli_nombres," +
                "   cli_apellidos," +
                "   cli_direccion," +
                "   cli_ciudad," +
                "   cli_telefono," +
                "   cli_celular," +
                "   cli_fecha_nac," +
                "   cli_correo," +
                "   cli_descripcion" +
                " FROM cliente where cli_identificacion =" + c.getIdentificacion());
            while (rs.next())
            {
                rta.setIdentificacion(rs.getString("cli_identificacion"));
                rta.setNombre(rs.getString("cli_nombres"));
                rta.setApellidos(rs.getString("cli_apellidos"));
                rta.setDireccion(rs.getString("cli_direccion"));
                rta.setCiudad( rs.getInt( "cli_ciudad" ));
                rta.setTelefono(rs.getString("cli_telefono"));
                rta.setCelular(rs.getString("cli_celular"));
                rta.setFechaNacimiento(rs.getString("cli_fecha_nac"));
                rta.setCorreo(rs.getString("cli_correo"));
             
                rta.setDescripcion(rs.getString("cli_descripcion"));
                
            }
            
        } catch (SQLException ex) {
           // Logger.getLogger(ClienteMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return rta;
    }
    
    
    public int obtenerId(Connection con)
    {
        int id = -1;
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select max(id_persona)+1 from persona");
            
            while (rs.next())
            { 
                id = rs.getInt(1);
            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
         
    public boolean editarCliente(ClienteDTO c, Connection con)
    {
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {            
         //   Logger.getLogger(ClienteMySQLDAO.class.getName()).log(Level.INFO, "Ejecutando updateCliente...");
            
            pstmt = con.prepareStatement("UPDATE cliente "
                    + " SET "
                    + " cli_nombres=?"
                    + " , cli_apellidos=?"
                    + " , cli_direccion=?"
                    + " , cli_ciudad=?"
                    + " , cli_telefono=?"
                    + " , cli_celular=?"
                    + " , cli_fecha_nac=?"
                    + " , cli_correo=?"
                    + " , cli_descripcion=?"
                    + " where cli_identificacion=?");
                        
         
            pstmt.setString(1, c.getNombre());
            pstmt.setString(2, c.getApellidos());
            pstmt.setString(3, c.getDireccion());
            pstmt.setInt(4, c.getCiudad());
            pstmt.setString(5, c.getTelefono());
            pstmt.setString(6, c.getCelular());
            pstmt.setString(7, c.getFechaNacimiento());
            pstmt.setString(8, c.getCorreo());
            pstmt.setString(9, c.getDescripcion());
            
            pstmt.setString(10, c.getIdentificacion());
            pstmt.executeUpdate();
           
            respuesta = true;
        } catch (SQLException ex) {
           // Logger.getLogger(ClienteMySQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;
    }
}
