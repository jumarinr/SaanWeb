package Clases;

import Auxiliares.*;
import java.util.ArrayList;
import java.util.List;

public class Nota {

    public static List<Nota> notas = new ArrayList<Nota>();
    private short porcentaje;
    private double valor;
    private String descripcion;
    private int id;
    private Matricula matricula;

    public Nota() {
    }

    public Nota(short porcentaje, double valor, String descripcion, int id, Matricula matricula) {
        this.setPorcentaje(porcentaje);
        this.setValor(valor);
        this.setDescripcion(descripcion);
        this.setId(id);
        this.setMatricula(matricula);
    }

    public short getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(short porcentaje) {
        if (porcentaje > 0) {
            this.porcentaje = porcentaje;
        }
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor > 0) {
            this.valor = valor;
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (!descripcion.equals("")) {
            this.descripcion = descripcion;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        if (matricula != null) {
            this.matricula = matricula;
        }
    }
    
    //métodos
    public static Nota BuscarNota(ArrayList<Nota> lista, Long doc_estudiante, int id_materia, int num_grupo, int id){
      for (Nota nota : lista) {
        if (nota.getMatricula().getEstudiante().getIdentificacion() == doc_estudiante && nota.getMatricula().getGrupo().getNumero() == num_grupo && nota.getMatricula().getGrupo().getMateria().getId() == id_materia && nota.getId() = id) {
          return nota;
        }
      }
      return null;
    }
    public static String Registrar(Nota nota, ArrayList<Nota> lista){
      if (Nota.BuscarNota(lista, nota.getMatricula().getEstudiante().getIdentificacion(), nota.getMatricula().getGrupo().getNumero(), nota.getMatricula().getGrupo().getMateria().getId(), nota.getId()) != null) {
        return "err";
      }
      else {
        lista.add(nota);
        nota.getMatricula().getNotas().add(nota);
        return "reg";
      }
    }
    public static String Eliminar(ArrayList<Nota> lista, Long doc_estudiante, int id_materia, int num_grupo, int id){
      Nota nota = Nota.BuscarNota(lista, doc_estudiante, id_materia, num_grupo, id);
      if (nota != null) {
        //...
        return "eli";
      }
      return "err";
    }
    public static ArrayList<Nota> MostrarNotas(ArrayList<Nota> lista, short est, short gru, short mat){
      ArrayList<Nota> notas = new ArrayList<Nota>();
      for (Nota nota : lista) {
        Grupo grupo = nota.getMatricula().getGrupo();

        if ((est == -1 || est == nota.getMatricula().getEstudiante().getIdentificacion()) && (gru == -1 || (gru == grupo.getNumero() && mat == grupo.getMateria().getId()))) {
          notas.add(nota);
        }
      }
      return notas;
    }
    public static String EliminarPorMatricula(ArrayList<Nota> lista, int num_grupo, int id_materia){
        // ...
        return "working on";
    }
    public static void EnviarCorreoActualizarNota(short opc, int id, double nota, double porcentaje, Estudiante estudiante, String materia){
      String correo_enviar = estudiante.get_correo();
      String cuerpo = "";
      Operaciones.(String correo_enviar, String asunto, String cuerpo);
    }
    public static String MejoresNotas(ArrayList<Grupo> lista_grupos, int id_materia, int id_grupo){
      return "working on";
    }
    public static boolean PorcentajeDiferente100(Materia materia, int id_grupo, int estudiante, double porcentaje){
      //...
      return true;
    }
}
