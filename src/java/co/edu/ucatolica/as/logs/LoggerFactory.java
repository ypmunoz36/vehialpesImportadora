/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ucatolica.as.logs;

/**
 *
 * @author sala8
 */
public class LoggerFactory {
    // LoggerFactory.ERROR
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    
    public Logger getLogger(int tipoLog) {
        
        switch(tipoLog){
            case ERROR:
                return new ErrorLogger();
            case DEBUG:
                return new DebugLogger();
            case INFO:
                return new InfoLogger();
            case WARN:
                return new warningLogger();
        }
        return  new ErrorLogger();
    }
}
