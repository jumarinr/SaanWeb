package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juan Diego
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
    public static String eliminar(Long identificacion){
      Profesor pro = (Profesor)Persona.buscarPersona(identificacion);
      if (pro!=null){
        if(pro.getGrupos().size() >0){
          return "No se puede, no insista y vayase >:v";
        }
      }
      return Persona.eliminar(identificacion);
    }
    public static String registrar(Profesor pro){
      return Persona.registrar(pro);
    }
    //public static encontrarCorreosYEnviar(List lista, Integer grupo, String Asunto, Integer Materia, String Fecha, String nombre, String Detalle){
    //}
}
