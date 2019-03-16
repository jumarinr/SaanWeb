package Clases;

import Auxiliares.Mensajes;
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

    public static Persona buscarPersona(long identificacion) {
        for (Persona admin : Persona.administradores) {
            if (admin.getIdentificacion() == identificacion) {
                return admin;
            }
        }
        for (Persona profe : Profesor.profesores) {
            if (profe.getIdentificacion() == identificacion) {
                return profe;
            }
        }
        for (Persona estu : Estudiante.estudiantes) {
            if (estu.getIdentificacion() == identificacion) {
                return estu;
            }
        }
        return null;
    }

    public static Persona buscarPersona(String correo) {
        for (Persona admin : Persona.administradores) {
            if (admin.getCorreo().equals(correo)) {
                return admin;
            }
        }
        for (Persona profe : Profesor.profesores) {
            if (profe.getCorreo().equals(correo)) {
                return profe;
            }
        }
        for (Persona estu : Estudiante.estudiantes) {
            if (estu.getCorreo().equals(correo)) {
                return estu;
            }
        }
        return null;
    }

    public static String registrar(Persona usuario) {
        if (Persona.buscarPersona(usuario.getIdentificacion()) != null) {
            return Mensajes.mensaje.get("err");
        }
        if(usuario.getIdentificacion() == 0 || usuario.getNombre() == null
              ||  usuario.getClave() == null || usuario.getCorreo() == null){
            return Mensajes.mensaje.get("err");
        }
        if (usuario instanceof Profesor) {
            Profesor.profesores.add((Profesor) usuario);
        } else if (usuario instanceof Estudiante) {
            Estudiante.estudiantes.add((Estudiante) usuario);
        } else {
            Persona.administradores.add(usuario);
        }
        return Mensajes.mensaje.get("reg");
    }

    /*
    devuelve 0 si es administrador, 1 si es estudiante,
    2 si es profesor y -1 si no esta registrado
     */
    public static byte login(long identificacion, String clave) {
        Persona usuario = Persona.buscarPersona(identificacion);
        if (usuario.getClave().equals(clave)) {
            if (usuario instanceof Profesor) {
                return 2;
            } else if (usuario instanceof Estudiante) {
                return 1;
            } else {
                return 0;
            }
        }
        return -1;
    }
    
    public static byte login(String correo, String clave) {
        Persona usuario = Persona.buscarPersona(correo);
        if (usuario.getClave().equals(clave)) {
            if (usuario instanceof Profesor) {
                return 2;
            } else if (usuario instanceof Estudiante) {
                return 1;
            } else {
                return 0;
            }
        }
        return -1;
    }

    public static String eliminar(long identificacion){
        Persona usuario = Persona.buscarPersona(identificacion);
        if(usuario != null){
            if(usuario instanceof Profesor){        
                Profesor.profesores.remove((Profesor)usuario);
            }else if(usuario instanceof Estudiante){
                Estudiante.estudiantes.remove((Estudiante)usuario);
            }else{
                Persona.administradores.remove(usuario);
            }
            return Mensajes.mensaje.get("eli");
        }
        return Mensajes.mensaje.get("err");
    }
    
    public static String eliminar(String correo){
        Persona usuario = Persona.buscarPersona(correo);
        if(usuario != null){
            if(usuario instanceof Profesor){
                Profesor.profesores.remove((Profesor)usuario);
            }else if(usuario instanceof Estudiante){
                Estudiante.estudiantes.remove((Estudiante)usuario);
            }else{
                Persona.administradores.remove(usuario);
            }
            return Mensajes.mensaje.get("eli");
        }
        return Mensajes.mensaje.get("err");
    }
}
