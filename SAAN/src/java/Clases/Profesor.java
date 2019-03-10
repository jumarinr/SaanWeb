package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Pablo
 */
public class Profesor extends Persona {

    public static List<Profesor> profesores = new ArrayList<Profesor>();
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

}
