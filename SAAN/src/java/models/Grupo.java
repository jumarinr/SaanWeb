package Clases;
import Auxiliares.Mensajes;
import Clases.Matricula;
import java.util.*;
/**
 *
 * @author Juan Pablo
 */
public class Grupo {

    public static List<Grupo> grupos = new ArrayList<Grupo>();
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
        if (numero > 0) {
            this.numero = numero;
        }
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        if (profesor != null) {
            this.profesor = profesor;
        }
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        if (matriculas != null) {
            this.matriculas = matriculas;
        }
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        if (materia != null) {
            this.materia = materia;
        }
    }
    public static Grupo buscarGrupo( List<Grupo> lista,short num,int idMateria){
        for (Grupo grupo :lista) {
            if(grupo.getNumero()==num && idMateria==grupo.getMateria().getId()){
                return grupo;
            }
        }
        return null;

    }
    public static String registrar(Grupo gr,List<Grupo> lista){
        if(gr.getMateria()!=null){
            if(gr.buscarGrupo(lista,gr.getNumero(),gr.getMateria().getId())==null||gr.getProfesor()==null){
                return Mensajes.mensaje.get("err");
            }else{
                lista.add(gr);
                gr.getMateria().getGrupos().add(gr);
                gr.getProfesor().getGrupos().add(gr);
                return Mensajes.mensaje.get("reg");
            }

        }
        return Mensajes.mensaje.get("err");
    }
    public static String eliminar(List<Grupo> lista,short num,int idMateria,List<Matricula> listMatricula,List<Nota> listNota){
        Grupo grupo= Grupo.buscarGrupo(lista, num, idMateria);
        if(grupo!=null){
            Matricula.eliminarPorGrupo(idMateria, idMateria);
            grupo.getMateria().getGrupos().remove(grupo);
            grupo.getProfesor().getGrupos().remove(grupos);
            lista.remove(grupo);
            return Mensajes.mensaje.get("eli");
        }else{
            return Mensajes.mensaje.get("err");
        }
    }
    public static void eliminarPorMateria(List<Grupo> lista,int idMateria,List<Matricula> listMatricula){
        int borr=0;
        for (int i = 0; i<lista.size(); i++) {
            if(lista.get(i-borr).getMateria().getId()==idMateria){
                //Grupo.eliminar(lista, lista.get(i-borr).getNumero(), idMateria, listMatricula, listNota);
                borr++;
            }
        }
    }
    public static String mejoresGrupos(Materia mat){
        List<Grupo> n= mat.getGrupos();
        if(!n.isEmpty()){
            HashMap<Integer,Grupo> a = new HashMap<Integer, Grupo>();
            for (Grupo grupo : n) {
                int cont=0;
                List<Matricula> b=grupo.getMatriculas();
                if(!b.isEmpty()){
                    for (Matricula matricula : b) {
                        List<Nota> c=matricula.getNotas();
                        int cont2=0;
                        if(!c.isEmpty()){
                            for (Nota nota : c) {
                                cont2+= nota.getValor();
                            }
                        }else{
                           cont2=0;
                        }
                        cont+=cont2;
                    }
                    a.put(cont/b.size(), grupo);
                }else{
                    a.put(0, grupo);
                }
            }
            int mayor=0;
            for (Map.Entry<Integer,Grupo> i: a.entrySet()) {
                if(i.getKey()>mayor){
                    mayor=i.getKey();
                }
            }
            if(mayor!=0){
                return Mensajes.mensaje.get("ideMat")+mat.getId()+ "\n"+Mensajes.mensaje.get("gru")+a.get(mayor).getNumero();
            }else{
                return Mensajes.mensaje.get("ideMat")+mat.getId()+"\n"+Mensajes.mensaje.get("Nonotas");
            }

        }else{
            return Mensajes.mensaje.get("ideMat")+mat.getId()+"\n"+Mensajes.mensaje.get("Nogrup");
        }
    }

}
