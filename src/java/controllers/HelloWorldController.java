/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import co.edu.ucatolica.as.logs.Logger;
import co.edu.ucatolica.as.logs.LoggerFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
@RequestMapping("/helloworld.htm")
public class HelloWorldController {
 
    @RequestMapping(method = RequestMethod.GET)
    public String helloWorld(ModelMap modelMap) {
        System.out.println("on method");
        
        LoggerFactory lf = new LoggerFactory();
        Logger l = lf.getLogger(2);
        l.log("Esto es un DEBUG", ""+this.getClass() );
        
        l=lf.getLogger(1);
        l.log("esto es un error----",""+this.getClass() );
       
        l=lf.getLogger(4);
        l.log("esto es un warn----",""+this.getClass() );
     
        
      /*  Log log = LogFactory.getLog(this.getClass());
        
        log.error("Esto es un msj de prueba de ERROR...");
        log.debug("Esto es un msj de prueba de DEBUG...");
        log.info("Esto es un msj de prueba de INFO...");
        log.warn("Esto es un msj de prueba de WARNNING...");
*/
        modelMap.put("printme", "Hello Spring !!");
        return "index";
    }
}