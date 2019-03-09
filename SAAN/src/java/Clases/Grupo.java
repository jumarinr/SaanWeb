package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Pablo
 */
public class Grupo {
 
    private short numero;
    private Profesor profesor;
    private List<Matricula> matriculas;
    private Materia materia;

    public Grupo(short numero, Profesor profesor, Materia materia) {
        this.setNumero(numero);
        this.setProfesor(profesor);
        this.setMateria(materia);
        this.matriculas = new ArrayList<Matricula>();
    }

    public Grupo() {
    }

    public short getNumero() {
        return numero;
    }

    public void setNumero(short numero) {
        this.numero = numero;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    
}
