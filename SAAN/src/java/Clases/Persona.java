package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Pablo
 */
public class Persona {
    
    public static List<Persona> administradores = new ArrayList<Persona>();
    private String nombre;
    private long identificacion;
    private String correo;
    private String clave;
    
    public Persona() {
    }
    
    public Persona(String nombre, long identificacion, String correo, String clave) {
        this.setNombre(nombre);
        this.setIdentificacion(identificacion);
        this.setCorreo(correo);
        this.setClave(clave);
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        if (!nombre.equals("")) {
            this.nombre = nombre;
        }
    }
    
    public long getIdentificacion() {
        return identificacion;
    }
    
    public void setIdentificacion(long identificacion) {
        if (identificacion > 0) {
            this.identificacion = identificacion;
        }
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public void setCorreo(String correo) {
        if (!correo.equals("")) {
            this.correo = correo;
        }
    }
    
    public String getClave() {
        return clave;
    }
    
    public void setClave(String clave) {
        if (!clave.equals("")) {
            this.clave = clave;
        }
    }
    
    
    
    
}
