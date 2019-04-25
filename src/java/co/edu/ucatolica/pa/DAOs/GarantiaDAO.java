/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.pa.DAOs;

import co.edu.ucatolica.pa.DTOs.GarantiaDTO;
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
public class GarantiaDAO  {

    public GarantiaDTO selectGarantia(Connection conexion, String param) {
         GarantiaDTO rta = new GarantiaDTO();
        
          Connection con = null;
          con = conexion;
        Statement s;
        try {
            
            s = con.createStatement();
            ResultSet rs = s.executeQuery ("SELECT \n" +
                        "    cliente_cli_identificacion,\n" +
                        "    CONCAT(cli_nombres, ' ', cli_apellidos) cliente,\n" +
                        "    vehiculo_idcarro,\n" +
                        "    ven_precio,\n" +
                        "    ven_fecha,\n" +
                        "    DATE(DATE_ADD(ven_fecha, INTERVAL 1 YEAR)) AS finGarantia,\n" +
                        "    IF(CURDATE() > DATE(DATE_ADD(ven_fecha, INTERVAL 1 YEAR)),\n" +
                        "        'Vencida',\n" +
                        "        'Vigente') AS estado\n" +
                        "FROM\n" +
                        "    vehialpes.venta\n" +
                        "        JOIN\n" +
                        "    cliente ON cliente_cli_identificacion = cli_identificacion\n" +
                        "WHERE\n" +
                        "    cliente_cli_identificacion = '"+param+"'\n" +
                        "        OR vehiculo_idcarro = '"+param+"';");
            while (rs.next())
            {
                rta.setIdCliente(rs.getString("cliente_cli_identificacion"));
                rta.setNomCliente(rs.getString("cliente"));
                rta.setVinVehiculo(rs.getString("vehiculo_idcarro"));
                rta.setValVehiculo(rs.getString("ven_precio"));
                rta.setFechaVenta(rs.getString("ven_fecha"));
                rta.setFechaGarantia(rs.getString("finGarantia"));
                rta.setEstado(rs.getString("estado"));
            }
           
           
        } catch (SQLException ex) {
            Logger.getLogger(GarantiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return rta;
    }

    
    
}
