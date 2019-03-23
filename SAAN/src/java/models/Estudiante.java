package models;

import java.util.ArrayList;
import java.util.List;
import util.Mensajes;
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

    public static String eliminar(long identificacion) {
        Matricula.eliminarPorEstudiante(identificacion);
        return Persona.eliminar(identificacion);
    }

    public static String eliminar(String correo) {
        Persona est = Persona.buscarPersona(correo);
        Matricula.eliminarPorEstudiante(est.getIdentificacion());
        return Persona.eliminar(correo);
    }
    public static String registrar(Estudiante est){
        return Persona.registrar(est);
    }
    public static String VanPerdiendo(Matricula mat,Grupo gru){
        List<Nota> not=mat.getNotas();
        if(!not.isEmpty()){
            int sum=0;
            int sum2=0;
            for (Nota nota : not) {
                if(nota.getMatricula().getGrupo()==gru){
                    sum +=((nota.getPorcentaje()/100)*nota.getValor());
                    sum2 +=(nota.getPorcentaje()/100);
                    
                }
            }
            int prom;
            if(sum2!=0 && sum!=0){
                 prom=sum/sum2;
            }else{
                 prom =0;
            }
            if(prom<3 && prom!=0){
                return mat.getEstudiante().getIdentificacion()+" "+mat.getEstudiante().getNombre();
            }else{
                return (Mensajes.mensaje.get("Ganosinno"));
            }
        }else{
            return (Mensajes.mensaje.get("Noestnot"));
        }
    }

}
