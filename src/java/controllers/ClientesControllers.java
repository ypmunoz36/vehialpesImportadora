package controllers;
import co.edu.ucatolica.pa.DAOs.ClienteDAO;
import co.edu.ucatolica.pa.DAOs.PersonaDAO;
import co.edu.ucatolica.pa.DAOs.VentaDAO;
import co.edu.ucatolica.pa.DTOs.ClienteDTO;
import co.edu.ucatolica.pa.DTOs.Persona;
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
import utilHibernate.Venta;
 
@Controller
@RequestMapping("/")
public class ClientesControllers {
    
    // front
@RequestMapping(method = RequestMethod.GET, value = "clienteCrear.htm")
    public String processSubmit(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {
        // model.put("mensajePersona", "Pase por el controller de Persona:::"+req.getParameter("nombre"));
        return "cliente_crear"; // nombre del jsp gui
    }  
@RequestMapping(method = RequestMethod.POST, value = "clienteRegistrar.htm")
    public String processSubmit1(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {
        ClienteDAO c = new ClienteDAO();
            
       // Logger.getLogger(ClientesControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit1...");

       // int id = vDao.obtenerId(MySqlDataSource.getConexionBD());
        String identificacion = req.getParameter("identificacion");
        String nombre = req.getParameter("nombre");
        String apellidos = req.getParameter("apellidos");
        String direccion = req.getParameter("direccion");
        String ciudad = req.getParameter("ciudad");
        String telefono  = req.getParameter("telefono");
        String celular = req.getParameter("celular");
        String fechaNacimiento = req.getParameter("fechaNacimiento");
        String correo = req.getParameter("correo");
        String sexo = req.getParameter("sexo");
        String descripcion = req.getParameter("descripcion");
        
        ClienteDTO cl = new ClienteDTO();
        cl.setIdentificacion(identificacion);
        cl.setNombre(nombre);
        cl.setApellidos(apellidos);
        cl.setDireccion(direccion);
        cl.setCiudad(Integer.parseInt( ciudad) );
        cl.setTelefono(telefono);
        cl.setCelular(celular);
        cl.setFechaNacimiento(fechaNacimiento);
        cl.setCorreo(correo);
        cl.setSexo(sexo);
        cl.setDescripcion(descripcion);
        cl.setTipo(1);
        
        boolean insert = c.crearCliente(cl, MySqlDataSource.getConexionBD());

     //   Logger.getLogger(VentaControllers.class.getName()).log(Level.SEVERE, null, "Registrar + " + ident + "-" + insert);
        
        if (insert)
            model.put("mensaje", "El registro fue creado satisfactoriamente!!!");
        else
            model.put("mensaje", "El registro NO fue creado, consulte con el administrador...");
        return "cliente_crear";//jsp
    }     
   
@RequestMapping(method = RequestMethod.GET, value = "clienteEditar.htm")
    public String processSubmit2(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
     //   Logger.getLogger(ClientesControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit2...");
        return "cliente_editar"; // JSP
    } 
  
@RequestMapping(method = RequestMethod.POST, value = "clienteConsultarForm.htm")
    public String processSubmit3(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {

        ClienteDAO cd = new ClienteDAO();
            
        //Logger.getLogger(PersonaDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit3...");

        String id = req.getParameter("identificacion");
       // String ident = req.getParameter("identificacion");
      //  String nombre1 = req.getParameter("nombre1");
        
        ClienteDTO c = new ClienteDTO();
        c.setIdentificacion(id);
        
        System.out.println("estoy consultando ");    
        ClienteDTO datos = cd.consultarCliente(c,  MySqlDataSource.getConexionBD());
        
      //  Logger.getLogger(VentaControllers.class.getName()).log(Level.SEVERE, null, "Consultar + " + ident + "-" + datos.size());
        
        model.put("clienteConsultado", datos);
     
        if (datos.getIdentificacion()!= null){
            System.err.println("no esta nulo");
            model.put("mensaje", "La consulta se realizo satisfactoriamente!!!");
        }else{
            System.err.println("Esta nulo");
            model.put("mensaje", "La consulta NO tiene resultados...");
        }
        return "cliente_editar";  // JSP
    }     
   
    // GUI
    /*
@RequestMapping(method = RequestMethod.GET, value = "clienteEditar.htm")
    public String processSubmit4(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {      
        Logger.getLogger(ClientesControllers.class.getName()).log(Level.INFO, "Ejecutando processSubmit4...");
        return "venta_editar";
    } */
    
@RequestMapping(method = RequestMethod.POST, value = "clienteEditarForm.htm")
    public String processSubmit5(HttpServletRequest req, SessionStatus status,ModelMap model) 
    {
        ClienteDAO cD = new ClienteDAO();
            
     //   Logger.getLogger(PersonaDAO.class.getName()).log(Level.INFO, "Ejecutando processSubmit6...");

    String identificacion = req.getParameter("identificacion");
        String nombre = req.getParameter("nombre");
        String apellidos = req.getParameter("apellidos");
        String direccion = req.getParameter("direccion");
        String ciudad = req.getParameter("ciudad");
        String telefono  = req.getParameter("telefono");
        String celular = req.getParameter("celular");
        String fechaNacimiento = req.getParameter("fechaNacimiento");
        String correo = req.getParameter("correo");
        String descripcion = req.getParameter("descripcion");
        
        ClienteDTO cl = new ClienteDTO();
        cl.setIdentificacion(identificacion);
        cl.setNombre(nombre);
        cl.setApellidos(apellidos);
        cl.setDireccion(direccion);
        cl.setCiudad(Integer.parseInt( ciudad) );
        cl.setTelefono(telefono);
        cl.setCelular(celular);
        cl.setFechaNacimiento(fechaNacimiento);
        cl.setCorreo(correo);
        cl.setDescripcion(descripcion);
        cl.setTipo(1);
            
        boolean res = cD.editarCliente(cl, MySqlDataSource.getConexionBD()) ;
        
        if (res)
            model.put("mensaje", "Se edito satisfactoriamente!!!");
        else
            model.put("mensaje", "No se guardaron los cambios...");
        
        return "cliente_editar";
        
    }   
}    
    
 