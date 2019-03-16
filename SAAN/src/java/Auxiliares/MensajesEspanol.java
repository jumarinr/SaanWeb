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

    public static HashMap<String, String> espanol = new HashMap<String, String>() {
        {
            put("err", "Error");
            put("reg", "Registrado");
            put("usuInc", "Usuario o contraseña incorrecto");
            put("eli", "Eliminado");
            put("recu", "Recuperación de contraseña");
            put("codrecu", "Código de recuperación: ");
            put("mod", "Modificado");
        }
    };

}
