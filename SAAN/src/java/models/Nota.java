package models;

import util.EnvioDeCorreo;
import java.util.ArrayList;
import java.util.List;
import util.Mensajes;

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
    public static Nota buscarNota(long doc_estudiante, int id_materia, int num_grupo, int id) {
        for (Nota nota : Nota.notas) {
            if (nota.getMatricula().getEstudiante().getIdentificacion() == doc_estudiante && nota.getMatricula().getGrupo().getNumero() == num_grupo && nota.getMatricula().getGrupo().getMateria().getId() == id_materia && nota.getId() == id) {
                return nota;
            }
        }
        return null;
    }

    public static String registrar(Nota nota) {
        if (nota.getId() <= 0 || nota.getMatricula() == null || nota.getPorcentaje() < 0 ||
                nota.getValor() < 0) {
            return Mensajes.mensaje.get("err");
        }
        if (Nota.buscarNota(nota.getMatricula().getEstudiante().getIdentificacion(),
                nota.getMatricula().getGrupo().getNumero(),
                nota.getMatricula().getGrupo().getMateria().getId(), nota.getId()) != null) {
            return Mensajes.mensaje.get("err");
        } else {
            Nota.notas.add(nota);
            nota.getMatricula().getNotas().add(nota);
            return Mensajes.mensaje.get("reg");
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

    public static void enviarCorreoActualizarNota(short opc, int id, double nota, double porcentaje, Estudiante estudiante, String materia) {
        String correo_enviar = estudiante.getCorreo();
        String cuerpo = "";
        String asunto = "";
        EnvioDeCorreo.EnvioDeMail(correo_enviar, asunto, cuerpo);
    }

    public static String mejoresNotas(int id_materia, int id_grupo) {
        return "working on";
    }

    public static boolean porcentajeDiferente100(int id_grupo, int estudiante, double porcentaje) {
        //...
        return true;
    }
}
