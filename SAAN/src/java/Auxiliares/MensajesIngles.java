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

    public static HashMap<String, String> ingles = new HashMap<String, String>() {
        {
            put("err", "Error");
            put("reg", "Registered");
            put("usuInc", "Incorrect username or password");
            put("eli", "Removed");
            put("recu", "Password recovery");
            put("codrecu", "Recovery code: ");
            put("mod", "Modified");
        }
    };
}
