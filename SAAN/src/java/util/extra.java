/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Juan Pablo
 */
public class extra {

    public static boolean isInteger(String dato) {
        try {
            Long.parseLong(dato);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

}
