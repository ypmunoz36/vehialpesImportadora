package controllers;

import co.edu.ucatolica.pa.DAOs.GarantiaDAO;
import co.edu.ucatolica.pa.DAOs.PersonaDAO;
import co.edu.ucatolica.pa.DAOs.VehiculoDAO;
import co.edu.ucatolica.pa.DAOs.VentaDAO;
import co.edu.ucatolica.pa.DTOs.ClienteDTO;
import co.edu.ucatolica.pa.DTOs.GarantiaDTO;
import co.edu.ucatolica.pa.DTOs.VehiculoDTO;
import co.edu.ucatolica.pa.DTOs.VentaDTO;
import co.edu.ucatolica.pa.bds.MySqlDataSource;
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
public class VehiculoControllers {
    
    // front
@RequestMapping(method = RequestMethod.GET, value = "vehiculoCrear.htm")
    public String processSubmit(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {
        // model.put("mensajePersona", "Pase por el controller de Persona:::"+req.getParameter("nombre"));
        return "vehiculo_crear"; // nombre del jsp gui
    }  
@RequestMapping(method = RequestMethod.POST, value = "vehiculoRegistrar.htm")
    public String processSubmit1(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {
        VehiculoDAO v = new VehiculoDAO();
            
       // Logger.getLogger(ClientesControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit1...");

       // int id = vDao.obtenerId(MySqlDataSource.getConexionBD());
        String vin = req.getParameter("vin");
        String matricula = req.getParameter("matricula");
        String anioFabricacion = req.getParameter("anioFabricacion");
        String cilindraje = req.getParameter("cilindraje");
        String tipoCombustible = req.getParameter("tipoCombustible");
        String modelo  = req.getParameter("modelo");
        String color = req.getParameter("color");
        String numSillas = req.getParameter("numSillas");
        int idMarca = Integer.parseInt( req.getParameter("idMarca") );
        int idTipo =Integer.parseInt( req.getParameter("idTipo"));
        String paisFab = req.getParameter("paisFab");
        int precioVenta = Integer.parseInt( req.getParameter("precioVenta") );
        int precioCosto =Integer.parseInt( req.getParameter("precioCosto"));
        String nombre = req.getParameter("nombre");
        
        VehiculoDTO ve = new VehiculoDTO();
      
        ve.setVin(vin);
        ve.setMatricula(matricula);
        ve.setAnioFabricacion(anioFabricacion);
        ve.setCilindraje(cilindraje);
        ve.setTipoCombustible(tipoCombustible);
        ve.setModelo(modelo);
        ve.setColor(color);
        ve.setNumSillas(numSillas);
        ve.setIdMarca(idMarca);
        ve.setIdTipo(idTipo);
        ve.setPaisFab(paisFab);
        ve.setPrecioVenta(precioVenta);
        ve.setPrecioCosto(precioCosto);
        ve.setNombre(nombre);
        
        
        
        boolean insert = v.insertVehiculo(MySqlDataSource.getConexionBD(), ve);
     //   Logger.getLogger(VentaControllers.class.getName()).log(Level.SEVERE, null, "Registrar + " + ident + "-" + insert);
        
        if (insert)
            model.put("mensaje", "El registro fue creado satisfactoriamente!!!");
        else
            model.put("mensaje", "El registro NO fue creado, consulte con el administrador...");
        return "vehiculo_crear";//jsp
    }     
   
@RequestMapping(method = RequestMethod.GET, value = "vehiculoEditar.htm")
    public String processSubmit2(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
     //   Logger.getLogger(ClientesControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit2...");
        return "vehiculo_editar"; // JSP
    } 

@RequestMapping(method = RequestMethod.POST, value = "vehiculoConsultarForm.htm")
    public String processSubmit3(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        VehiculoDAO cd = new VehiculoDAO();
            
        //Logger.getLogger(PersonaDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit3...");

        String id = req.getParameter("vin");
       // String ident = req.getParameter("identificacion");
      //  String nombre1 = req.getParameter("nombre1");
        
        VehiculoDTO v = new VehiculoDTO();
        v.setVin(id);
        
        System.out.println("estoy consultando ");    
        VehiculoDTO datos = cd.selectVehiculo( MySqlDataSource.getConexionBD(), v);
        
      //  Logger.getLogger(VentaControllers.class.getName()).log(Level.SEVERE, null, "Consultar + " + ident + "-" + datos.size());
        
        model.put("vehiculoConsultado", datos);
     
        if (datos.getVin()!= null){
            model.put("mensaje", "La consulta se realizo satisfactoriamente!!!");
        }else{
            model.put("mensaje", "La consulta NO tiene resultados...");
        }
        return "vehiculo_editar";  // JSP
    }     

    // GUI
    /*
@RequestMapping(method = RequestMethod.GET, value = "clienteEditar.htm")
    public String processSubmit4(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
        Logger.getLogger(ClientesControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit4...");
        return "venta_editar";
    } */
    
@RequestMapping(method = RequestMethod.POST, value = "vehiculoEditarForm.htm")
    public String processSubmit5(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {
        VehiculoDAO vD = new VehiculoDAO();
            
     //   Logger.getLogger(PersonaDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit6...");
        String vin = req.getParameter("vin");
        String matricula = req.getParameter("matricula");
        String anioFabricacion = req.getParameter("anioFabricacion");
        String cilindraje = req.getParameter("cilindraje");
        String tipoCombustible = req.getParameter("tipoCombustible");
        String modelo  = req.getParameter("modelo");
        String color = req.getParameter("color");
        String numSillas = req.getParameter("numSillas");
        int idMarca = Integer.parseInt( req.getParameter("idMarca") );
        int idTipo =Integer.parseInt( req.getParameter("idTipo"));
        String paisFab = req.getParameter("paisFab");
        int precioVenta = Integer.parseInt( req.getParameter("precioVenta") );
        int precioCosto =Integer.parseInt( req.getParameter("precioCosto"));
        String nombre = req.getParameter("nombre");
        
        VehiculoDTO ve = new VehiculoDTO();
      
        ve.setVin(vin);
        ve.setMatricula(matricula);
        ve.setAnioFabricacion(anioFabricacion);
        ve.setCilindraje(cilindraje);
        ve.setTipoCombustible(tipoCombustible);
        ve.setModelo(modelo);
        ve.setColor(color);
        ve.setNumSillas(numSillas);
        ve.setIdMarca(idMarca);
        ve.setIdTipo(idTipo);
        ve.setPaisFab(paisFab);
        ve.setPrecioVenta(precioVenta);
        ve.setPrecioCosto(precioCosto);
        ve.setNombre(nombre);
  
            
        boolean res = vD.updateVehiculo( MySqlDataSource.getConexionBD(),ve) ;
        
        if(res)
            model.put("mensaje", "Se edito satisfactoriamente!!!");
        else
            model.put("mensaje", "No se guardaron los cambios...");
        
        return "vehiculo_editar"; //JSP
        
    }   
   

 /*   @RequestMapping(method = RequestMethod.GET, value = "vehiculoCatalogo.htm")
    public String processSubmit4(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
     //   Logger.getLogger(ClientesControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit2...");
        return "vehiculo_catalogo"; // JSP
    } 
 */
    
@RequestMapping(method = RequestMethod.GET, value = "vehiculoConsCatalogo.htm")
    public String processSubmit6(HttpServletRequest req, SessionStatus status,
            ModelMap model) 
    {
        VehiculoDAO vDao = new VehiculoDAO();    
       // Logger.getLogger(PersonaDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit3...");
        
        List<VehiculoDTO> datos = vDao.selectAllVehiculo(MySqlDataSource.
                getConexionBD());
        
        model.put("listaVehiculos", datos);
     
        System.err.println("----SSSSS" + datos.size());
        if (datos.size() > 0)
            model.put("mensaje", "La consulta se realizo satisfactoriamente!!!" 
                    + datos.size() );
        else
            model.put("mensaje", "La consulta NO tiene resultados...");
        
        return "vehiculo_catalogo";
        
    }    
    
    @RequestMapping(method = RequestMethod.POST, value = "garantiaCons.htm")
    public String processSubmit7(HttpServletRequest req, SessionStatus status,
            ModelMap model) 
    {
        String identificacion = req.getParameter("idCliVeh");
        GarantiaDAO gd = new GarantiaDAO();
        GarantiaDTO garantia ;
        
        garantia  = gd.selectGarantia(MySqlDataSource.getConexionBD(), 
                identificacion);
        List<GarantiaDTO> listaGaran = new ArrayList<>();
        
        listaGaran.add(garantia);
        model.put("garantiaConsultada", listaGaran);
        return "garantia";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "garantia.htm")
    public String processSubmit8(HttpServletRequest req, SessionStatus status,
            ModelMap model) 
    {
        return "garantia";
    }
}
