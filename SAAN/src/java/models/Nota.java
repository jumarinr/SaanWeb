package models;

import util.EnvioDeCorreo;
import java.util.ArrayList;
import java.util.List;
import util.Mensajes; 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class Nota{

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
        return this.valor;
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
    public static Nota buscarNota(long doc_estudiante, int id_materia, int num_grupo, int id) {
        for (Nota nota : Nota.notas) {
            if (nota.getMatricula().getEstudiante().getIdentificacion() == doc_estudiante && nota.getMatricula().getGrupo().getNumero() == num_grupo && nota.getMatricula().getGrupo().getMateria().getId() == id_materia && nota.getId() == id) {
                return nota;
            }
        }
        return null;

    }

    public static String Registrar(Nota nota, ArrayList<Nota> lista) {
        if (Nota.buscarNota(nota.getMatricula().getEstudiante().getIdentificacion(), nota.getMatricula().getGrupo().getNumero(), nota.getMatricula().getGrupo().getMateria().getId(), nota.getId()) != null) {
            return "err";
        } else {
            lista.add(nota);
            nota.getMatricula().getNotas().add(nota);
            return "reg";
        }
    }

    public static ArrayList<Nota> MostrarNotas(ArrayList<Nota> lista, byte est, byte gru, byte mat) {
        ArrayList<Nota> notas = new ArrayList<Nota>();
        for (Nota nota : lista) {
            Grupo grupo = nota.getMatricula().getGrupo();
            if((est == -1 || est==nota.getMatricula().getEstudiante().getIdentificacion()) && (gru == -1 || (gru == grupo.getNumero() && mat == nota.getMatricula().getGrupo().getMateria().getId()))){}
                notas.add(nota);
        }
        return notas;
    }

    public static void eliminarPorMatricula(ArrayList<Nota> lista, long doc_estudiante) {
        int borr = 0;
        ArrayList<Nota> notasAEliminar = new ArrayList<Nota>();
        for(Nota nota : lista){
            if(nota.getMatricula().getEstudiante().getIdentificacion() == doc_estudiante){
                notasAEliminar.add(nota);
            }
        }
        for(Nota nota : notasAEliminar){
            lista.remove(nota);
        }
    }

    public static String eliminar(long doc_estudiante, int id_materia, int num_grupo, int id) {
        Nota nota = Nota.buscarNota(doc_estudiante, id_materia, num_grupo, id);
        if (nota != null) {
            Nota.notas.remove(nota);
            nota.getMatricula().getNotas().remove(nota);
            return Mensajes.mensaje.get("eli");
        }
        return Mensajes.mensaje.get("err");

    }

    public static void enviarCorreoActualizarNota(short opc, int id, double nota, double porcentaje, Estudiante estudiante, Materia materia) {
        String correo_enviar = estudiante.getCorreo();
        String cuerpo = "";
        String asunto = "";
        if(Mensajes.mensaje.get(opc).equals("borro")){
            cuerpo = Mensajes.mensaje.get("cuerpo_borro")+id+ Mensajes.mensaje.get("cuerpo_borro2") + materia.toString();
        }
        else{
            cuerpo = Mensajes.mensaje.get("cuerpo_resto") + materia.toString() + Mensajes.mensaje.get("cuerpo_resto2") + String.valueOf(id) + Mensajes.mensaje.get("cuerpo_resto3")+ String.valueOf(nota) + Mensajes.mensaje.get("cuerpo_resto4") + String.valueOf(porcentaje);
            asunto = Mensajes.mensaje.get("asunto")+Mensajes.mensaje.get(opc)+Mensajes.mensaje.get("asunto2");
        }
        EnvioDeCorreo.EnvioDeMail(correo_enviar, asunto, cuerpo);
    }

    public static ArrayList<Nota> MejoresNotas(ArrayList<Matricula> matriculas, int id_materia, int num_grupo) {
        ArrayList<Nota> notas = new ArrayList<Nota>();
        for(Matricula matricula : matriculas){
              if(matricula.getGrupo().getNumero() == num_grupo && matricula.getGrupo().getMateria().getId() == id_materia){
                  for(Nota n:matricula.getNotas()){
                      notas.add(n);
                  }
                  
              }
          }
        Collections.sort(notas, new Comparator() {  
            public double compare(Nota n1, Nota n2) {
                return new Double(n2.getValor()).compareTo(new Double(n1.getValor()));
            }

            @Override
            public int compare(Object o1, Object o2) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }          
        });
        if(notas.size()<3 && notas.size()>0){
            return notas;
        }
        else if(notas.size()>=3){
            for(int i=0; i<notas.size(); i++){
                if(i>=3){
                    notas.remove(i);
                }                
            }
            return notas;
        }
        return null;
                
    }
    
    public static boolean porcentajeDiferente100(ArrayList<Nota> notas, int id_materia,int num_grupo, int id_estudiante, double porcentaje) {              
        double sum = 0;
        for(Nota nota : notas) {
            if (nota.getMatricula().getGrupo().getNumero()==num_grupo && nota.getMatricula().getGrupo().getMateria().getId()==id_materia && nota.getMatricula().getEstudiante().getIdentificacion()==id_estudiante) {            
                sum += nota.getPorcentaje();
            }
        }
        double total =sum + porcentaje;
        if(total > 100){
            return false;
        }
        return true;


    }

}
