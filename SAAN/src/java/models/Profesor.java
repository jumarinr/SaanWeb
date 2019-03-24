package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Diego
 */
public class Profesor extends Persona {

    private List<Grupo> grupos;

    public Profesor() {
    }

    public Profesor(String nombre, long identificacion, String correo, String clave) {
        super(nombre, identificacion, correo, clave);
        this.grupos = new ArrayList<Grupo>();
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        if (grupos != null) {
            this.grupos = grupos;
        }
    }

    public static String eliminar(List<Persona> personas, List<Estudiante> estudiantes,
            List<Profesor> profesores, Long identificacion) {
        Profesor pro = (Profesor) Persona.buscarPersona(personas, estudiantes, profesores, identificacion);
        if (pro != null) {
            if (pro.getGrupos().size() > 0) {
                return "No se puede eliminar al profesor";
            }
        }
        return Persona.eliminar(personas, estudiantes, profesores, identificacion);
    }

    public static void encontrarCorreosYEnviar(List lista, Integer grupo, String Asunto, Integer Materia, String Fecha, String nombre, String Detalle) {
    }
}
