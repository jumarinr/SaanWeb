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
public class MensajesEspanol {

    public static HashMap<String, String> espanol = new HashMap<String, String>();
    
    public static void AgregarDatos(){
        MensajesEspanol.espanol.put("err", "Error");
        MensajesEspanol.espanol.put("reg", "Registrado");
        MensajesEspanol.espanol.put("usuInc", "Usuario o contraseña incorrecto");
        MensajesEspanol.espanol.put("eli", "Eliminado");
    }

}
