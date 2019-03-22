package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Pablo
 */
public class Estudiante extends Persona {

    public static List<Estudiante> estudiantes = new ArrayList<Estudiante>();
    private List<Matricula> matriculas;

    public Estudiante(String nombre, long identificacion, String correo, String clave) {
        super(nombre, identificacion, correo, clave);
        this.matriculas = new ArrayList<Matricula>();
    }

    public Estudiante() {
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        if (matriculas != null) {
            this.matriculas = matriculas;
        }
    }

}
