/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

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
            put("ideMate", "Identificacion de la materia");
            put("gru", "Grupo");
            put("Nonotas", "Materia sin notas");
            put("Nogrup", "Materia sin grupos");
            put("megru", "Mejores grupos");
            put("estper", "Estudiantes que van perdiendo");
            put("ini", "Inicio");
            put("saan", "SISTEMA ACADÉMICO ASISTENTE DE NOTAS");
            put("esp", "Español");
            put("ing", "Ingles");
            put("inisec","Iniciar sesión");
            put("menu","Menú");
        }
    };

}
