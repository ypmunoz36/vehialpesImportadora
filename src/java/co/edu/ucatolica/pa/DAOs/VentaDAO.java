/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.pa.DAOs;

import co.edu.ucatolica.pa.DTOs.Persona;
import co.edu.ucatolica.pa.DTOs.VentaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utilHibernate.HibernateUtil;
import utilHibernate.Venta;

/**
 *
 * @author nixoduaa
 */
public class VentaDAO {
    
    
    
    public boolean crearVenta(VentaDTO p, Connection con)
    {
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {            
            
            Logger.getLogger(VentaDAO.class.getName()).log(Level.INFO, "Ejecutando crear...");
            
            pstmt = con.prepareStatement("INSERT INTO venta(cliente_cli_identificacion,vehiculo_idcarro,ven_fecha,ven_precio,usuario_asesor) "
                    + "VALUES(?,?,?,?,?)");
            
            pstmt.setInt(1,p.getCliIdentificacion());
            pstmt.setString(2, p.getVehiculoIdcarro());
            pstmt.setString(3, p.getFechaVenta());
            pstmt.setInt(4, p.getPrecioVenta());
            pstmt.setString(5, p.getAsesor());
            
            pstmt.execute();
            
            con.close();
            
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;

    }

    public ArrayList<VentaDTO> consultarVenta(VentaDTO p, Connection con)
    {
        /* hibernate
        ArrayList<Venta> datos = new ArrayList();
        
        Logger.getLogger(VentaDAO.class.getName()).log(Level.INFO, "Ejecutando consultar...");
        
        SessionFactory sf = HibernateUtil.buildSessionFactory();
        Session session = sf.openSession();
        Query q = session.createQuery("select v FROM Venta v");
        Iterator<Venta> it = q.iterate();
        
        Venta v;
        while(it.hasNext()){
            v=it.next();
            System.out.println("---->>>>>"+v.getIdventa()+ " cte " + v.getCliente().getCliIdentificacion());

            datos.add(v);
        }
        session.close(); */
        
         ArrayList<VentaDTO> datos = new ArrayList();
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select idventa,  cliente_cli_identificacion,"
                    + "    vehiculo_idcarro,ven_fecha, ven_precio,usuario_asesor"
                    + " FROM venta");
            
            while (rs.next())
            { 
                VentaDTO ven = new VentaDTO();
                ven.setIdventa(rs.getInt(1));
                ven.setCliIdentificacion(rs.getInt(2));
                ven.setVehiculoIdcarro(rs.getString(3));
                ven.setFechaVenta(rs.getString(4));
                ven.setPrecioVenta(rs.getInt(5));
                ven.setAsesor(rs.getString(6));
                              
                datos.add(ven);
            }
            
            Logger.getLogger(VentaDAO.class.getName()).log(Level.INFO, "Ejecutando consultar fin..." + datos.size());
            
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return datos;
    }
    
    
    public int obtenerId(Connection con)
    {
        int id = -1;
        try {
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery ("select max(idventa)+1 from venta ");
            
            while (rs.next())
            { 
                id = rs.getInt(1);
            }

            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
    }
         
    public boolean editarVenta(VentaDTO p, Connection con)
    {
        PreparedStatement pstmt = null;
        boolean respuesta = false;
        try {            
            
            Logger.getLogger(VentaDAO.class.getName()).log(Level.INFO, "Ejecutando editar...");
            
            pstmt = con.prepareStatement("UPDATE venta "
                    + " SET "
                    + " cliente_cli_identificacion=?"
                    + " , vehiculo_idcarro=?"
                    + " , ven_fecha=?"
                    + " , ven_precio=?"
                    + " , usuario_asesor=?" 
                    + " , ven_fecha_registra=?"
                    + " where idventa=?");
            
            pstmt.executeUpdate();
            
            con.close();
            
            respuesta = true;
        } catch (SQLException ex) {
            Logger.getLogger(VentaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return respuesta;

    }
}
