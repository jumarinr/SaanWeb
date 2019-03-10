/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Pablo
 */
public class Matricula {

    public static List<Matricula> matriculas = new ArrayList<Matricula>();
    private double notaFinal;
    private short semestre;
    private Estudiante estudiante;
    private Grupo grupo;
    private List<Nota> notas;

    public Matricula() {
    }

    public Matricula(short semestre, Estudiante estudiante, Grupo grupo) {
        this.setSemestre(semestre);
        this.setEstudiante(estudiante);
        this.setGrupo(grupo);
        this.setNotaFinal(0.0);
        this.notas = new ArrayList<Nota>();
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        if (notaFinal >= 0) {
            this.notaFinal = notaFinal;
        }
    }

    public short getSemestre() {
        return semestre;
    }

    public void setSemestre(short semestre) {
        if (semestre > 0) {
            this.semestre = semestre;
        }
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        if (estudiante != null) {
            this.estudiante = estudiante;
        }
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        if (grupo != null) {
            this.grupo = grupo;
        }
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        if (notas != null) {
            this.notas = notas;
        }
    }

}
