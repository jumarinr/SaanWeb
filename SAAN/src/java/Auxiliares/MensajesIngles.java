/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliares;

import java.util.HashMap;

/**
 *
 * @author Juan Pablo
 */
public class MensajesIngles {

    public static HashMap<String, String> ingles = new HashMap<String, String>();
    
    public static void AgregarDatos(){
        MensajesIngles.ingles.put("err", "Error");
        MensajesIngles.ingles.put("reg", "Registered");
        MensajesIngles.ingles.put("usuInc", "Incorrect username or password");
        MensajesIngles.ingles.put("eli", "Removed");
    }

}
