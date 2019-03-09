/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author NixonD
 */

import co.edu.uniminuto.pa.DAOs.PersonaDAO;
import co.edu.uniminuto.pa.DAOs.VentaDAO;
import co.edu.uniminuto.pa.DTOs.Persona;
import co.edu.uniminuto.pa.DTOs.VentaDTO;
import co.edu.uniminuto.pa.bds.MySqlDataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
 
@Controller
@RequestMapping("/")
public class VentaControllers {
 /*
    @RequestMapping(method = RequestMethod.GET)
    public String helloWorld(ModelMap modelMap) {
        System.out.println("personaCrear");
        modelMap.put("mensajePersona", "Pase por el controller de Persona");
        return "persona_crear";
    }
    */
@RequestMapping(method = RequestMethod.GET, value = "ventaCrear.htm")
    public String processSubmit(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        System.out.println("personaCrear");
        model.put("mensajePersona", "Pase por el controller de Persona:::"+req.getParameter("nombre"));
        return "venta_crear"; // nombre del jsp gui
    }    
    
@RequestMapping(method = RequestMethod.POST, value = "ventaRegistrar.htm")
    public String processSubmit1(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        VentaDAO vDao = new VentaDAO();
            
        Logger.getLogger(VentaControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit1...");

       // int id = vDao.obtenerId(MySqlDataSource.getConexionBD());
        String identificacion = req.getParameter("identificacion");
        String vin = req.getParameter("vin");
        String fecha = req.getParameter("fecha");
        String precio = req.getParameter("precio");
        String asesor = req.getParameter("asesor");
        
        VentaDTO v = new VentaDTO();
        v.setIdentificacionCliente( Integer.parseInt( identificacion));
        v.setVinAuto(vin);
        v.setFechaVenta(fecha);
        v.setPrecioVenta( Integer.parseInt( precio) );
        v.setAsesor(asesor);
        
        System.out.println("connn---%: " +   MySqlDataSource.getConexionBD());
        boolean insert = vDao.crearVenta(v, MySqlDataSource.getConexionBD());

     //   Logger.getLogger(VentaControllers.class.getName()).log(Level.SEVERE, null, "Registrar + " + ident + "-" + insert);
        
        if (insert)
            model.put("mensaje", "El registro fue creado satisfactoriamente!!!");
        else
            model.put("mensaje", "El registro NO fue creado, consulte con el administrador...");
        
        return "venta_crear";
    }     
    
@RequestMapping(method = RequestMethod.GET, value = "ventaConsultar.htm")
    public String processSubmit2(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
        Logger.getLogger(VentaControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit2...");
        return "venta_consultar";
    } 
    
@RequestMapping(method = RequestMethod.GET, value = "ventaConsultarForm.htm")
    public String processSubmit3(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        VentaDAO pDao = new VentaDAO();
            
        Logger.getLogger(PersonaDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit3...");

      //  int id = pDao.obtenerId(MySqlDataSource.getConexionBD());
       // String ident = req.getParameter("identificacion");
      //  String nombre1 = req.getParameter("nombre1");
        
        VentaDTO v = new VentaDTO();
        
        System.out.println("estoy consultando ");    
        List<VentaDTO> datos = pDao.consultarVenta(v, MySqlDataSource.getConexionBD());

        
      //  Logger.getLogger(VentaControllers.class.getName()).log(Level.SEVERE, null, "Consultar + " + ident + "-" + datos.size());
        
        model.put("listaVentas", datos);
        System.out.println("--->>>>>"+datos.size());
        if (datos.size() > 0)
            model.put("mensaje", "La consulta se realizo satisfactoriamente!!!" + datos.size() );
        else
            model.put("mensaje", "La consulta NO tiene resultados...");
        
        return "venta_consultar";
    }     
    
@RequestMapping(method = RequestMethod.GET, value = "ventaEditar.htm")
    public String processSubmit4(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
        Logger.getLogger(VentaControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit4...");
        return "venta_editar";
    } 
    
@RequestMapping(method = RequestMethod.POST, value = "ventaEditarForm1.htm")
    public String processSubmit5(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        PersonaDAO pDao = new PersonaDAO();
            
        Logger.getLogger(PersonaDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit5...");

        int id = pDao.obtenerId(MySqlDataSource.getConexionBD());
        String ident = req.getParameter("identificacion");
        String nombre1 = req.getParameter("nombre1");
        
        Persona p = new Persona();
        p.setId(id);
        p.setIdentificacion(ident);
        p.setNombre1(nombre1);
            
        List<Persona> datos = pDao.consultarPersona(p, MySqlDataSource.getConexionBD());

        Logger.getLogger(VentaControllers.class.getName()).log(Level.SEVERE, null, "Consultar + " + ident + "-" + datos.size());
        
        model.put("listaPersonas", datos);
        
        
        return "venta_editar";
        
    }    
    
@RequestMapping(method = RequestMethod.POST, value = "ventaEditarForm2.htm")
    public String processSubmit6(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        PersonaDAO pDao = new PersonaDAO();
            
        Logger.getLogger(PersonaDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit6...");

        int id = Integer.parseInt(req.getParameter("id"));
        String ident = req.getParameter("identificacion");
        String nombre1 = req.getParameter("nombre1");
        String nombre2 = req.getParameter("nombre2");
        String apellido1 = req.getParameter("apellido1");
        String apellido2 = req.getParameter("apellido2");
        String genero = req.getParameter("genero");
        String tipoP = req.getParameter("tipop");
        String fNacimiento = req.getParameter("fecha");
        String telef = req.getParameter("telefono");
        String email = req.getParameter("email");
        
        Logger.getLogger(PersonaDAO.class.getName()).log(Level.INFO, "Id persona: " + id);
        
        Persona p = new Persona();
        p.setId(id);
        p.setIdentificacion(ident);
        p.setNombre1(nombre1);
        p.setNombre2(nombre2);
        p.setApellido1(apellido1);
        p.setApellido2(apellido2);
        p.setGenero(genero);
        p.setTipoP(tipoP);
        p.setfNacimiento(fNacimiento);
        p.setTelef(telef);
        p.setEmail(email);
            
        boolean res = pDao.editarPersona(p, MySqlDataSource.getConexionBD());                         
        
        if (res)
            model.put("mensaje", "Se edito satisfactoriamente!!!");
        else
            model.put("mensaje", "NO se guardaron los cambios...");
        
        return "venta_editar";
        
    }    
}