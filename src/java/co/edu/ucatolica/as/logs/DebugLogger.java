/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.as.logs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author sala8
 */
public class DebugLogger implements Logger{

    @Override
    public void log(String msg, String className) {
         Log log = LogFactory.getLog(className);
        log.debug(msg+" en "+className);
    }
}
