package models;

import Auxiliares.EnvioDeCorreo;
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
        if (nota.getMatricula().getEstudiante().getIdentificacion() == doc_estudiante && nota.getMatricula().getGrupo().getNumero() == num_grupo && nota.getMatricula().getGrupo().getMateria().getId() == id_materia && nota.getId() == id) {
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
          nota.getMatricula().getNotas().remove(nota);
          lista.remove(nota);
        return "eli";
      }
      return "err";
    }
    public static ArrayList<Nota> MostrarNotas(ArrayList<Nota> lista, byte est, byte gru, byte mat){
      ArrayList<Nota> notas = new ArrayList<Nota>();
      for (Nota nota : lista) {
        Grupo grupo = nota.getMatricula().getGrupo();

        if ((est == -1 || est == nota.getMatricula().getEstudiante().getIdentificacion()) && (gru == -1 || (gru == grupo.getNumero() && mat == grupo.getMateria().getId()))) {
          notas.add(nota);
        }
      }
      return notas;
    }
    public static void EliminarPorGrupo(ArrayList<Nota> lista, long num_grupo, long id_materia){
        int borr = 0;
        for(int i=0; i<lista.size(); i++){
            if(lista.get(i-borr).getMatricula().getGrupo().getNumero() == num_grupo && lista.get(i-borr).getMatricula().getGrupo().getMateria().getId()==id_materia){
                Nota.Eliminar(lista , lista.get(i-borr).getMatricula().getEstudiante().getIdentificacion(), id_materia, num_grupo);
                borr += 1;
            }
        }
    }
    public static void EliminarPorEstudiante(ArrayList<Nota> lista, int estu){
        int borr = 0;
        for(int i=0; i<lista.size(); i++){
            if(lista.get(i-borr).getMatricula().getEstudiante().getIdentificacion() == estu ){
                Grupo gru= lista.get(i-borr).getMatricula().getGrupo();
                Nota.Eliminar(lista, lista.get(i-borr).getMatricula().getEstudiante().getIdentificacion(), gru.getMateria().getId(), gru.getNumero());
                borr += 1;
            }
        }
    }
    public static String EliminarPorMatricula(ArrayList<Nota> lista, int num_grupo, int id_materia){
        // ...
        return "working on";
    }
    public static void EnviarCorreoActualizarNota(short opc, int id, double nota, double porcentaje, Estudiante estudiante, String materia){
      String correo_enviar = estudiante.getCorreo();
      String cuerpo = "";
      String asunto = "";
      EnvioDeCorreo.EnvioDeMail(correo_enviar, asunto, cuerpo);
    }
    public static String MejoresNotas(ArrayList<Grupo> lista_grupos, int id_materia, int id_grupo){
//        for(Grupo grupo : lista_grupos){
//            if(grupo.getMateria().getId() == id_materia && grupo.getNumero() == id_grupo){
//                ArrayList<Nota> lista_notas = grupo.
//            }
//        }
        return "working on";
    }
    public static boolean PorcentajeDiferente100(Materia materia, int id_grupo, int estudiante){
        double porcentage = 0;
        List<Grupo> grupos = materia.getGrupos();
        for(Grupo grupo : grupos){
            if(grupo.getNumero()==id_grupo){
                int sum=0;           
            }
        }
      return true;
    }
}
