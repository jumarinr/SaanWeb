package models;

import util.EnvioDeCorreo;
import util.Mensajes;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class Nota{

    private int porcentaje;
    private double valor;
    private int id;
    private Matricula matricula;

    public Nota() {
    }

    public Nota(int porcentaje, double valor, int id, Matricula matricula) {
        this.setPorcentaje(porcentaje);
        this.setValor(valor);
        this.setId(id);
        this.setMatricula(matricula);
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
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
    public static Nota buscarNota(List<Nota> notas, long doc_estudiante, int id_materia, int num_grupo, int id) {
        for (Nota nota : notas) {
            if (nota.getMatricula().getEstudiante().getIdentificacion() == doc_estudiante && nota.getMatricula().getGrupo().getNumero() == num_grupo && nota.getMatricula().getGrupo().getMateria().getId() == id_materia && nota.getId() == id) {
                return nota;
            }
        }
        return null;

    }

    public static String registrar(List<Nota> notas, Nota nota) {
        if (Nota.buscarNota(notas, nota.getMatricula().getEstudiante().getIdentificacion(), nota.getMatricula().getGrupo().getNumero(), nota.getMatricula().getGrupo().getMateria().getId(), nota.getId()) != null) {
            return Mensajes.mensaje.get("err");
        } else {
            notas.add(nota);
            nota.getMatricula().getNotas().add(nota);
            return Mensajes.mensaje.get("reg");
        }
        return notas;
    }

    public static String eliminar(List<Nota> notas, long doc_estudiante, int id_materia, int num_grupo, int id) {
        Nota nota = Nota.buscarNota(notas, doc_estudiante, id_materia, num_grupo, id);
        if (nota != null) {
            notas.remove(nota);
            nota.getMatricula().getNotas().remove(nota);
            return Mensajes.mensaje.get("eli");
        }
        return Mensajes.mensaje.get("err");

    }

    public static void enviarCorreoActualizarNota(short opc, int id, double nota, double porcentaje, Estudiante estudiante, Materia materia) {
        String correo_enviar = estudiante.getCorreo();
        String cuerpo = "";
        String asunto = "";
        if (Mensajes.mensaje.get(opc).equals("borro")) {
            cuerpo = Mensajes.mensaje.get("cuerpo_borro") + id + Mensajes.mensaje.get("cuerpo_borro2") + materia.toString();
        } else {
            cuerpo = Mensajes.mensaje.get("cuerpo_resto") + materia.toString() + Mensajes.mensaje.get("cuerpo_resto2") + String.valueOf(id) + Mensajes.mensaje.get("cuerpo_resto3") + String.valueOf(nota) + Mensajes.mensaje.get("cuerpo_resto4") + String.valueOf(porcentaje);
            asunto = Mensajes.mensaje.get("asunto") + Mensajes.mensaje.get(opc) + Mensajes.mensaje.get("asunto2");
        }
        EnvioDeCorreo.EnvioDeMail(correo_enviar, asunto, cuerpo);
    }

    public static ArrayList<Nota> MejoresNotas(ArrayList<Matricula> matriculas, int id_materia, int num_grupo) {
        ArrayList<Nota> notas = new ArrayList<Nota>();
        for (Matricula matricula : matriculas) {
            if (matricula.getGrupo().getNumero() == num_grupo && matricula.getGrupo().getMateria().getId() == id_materia) {
                for (Nota n : matricula.getNotas()) {
                    notas.add(n);
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
        Collections.sort(notas, new Comparator() {
            public double compare(Nota n1, Nota n2) {
                return new Double(n2.getValor()).compareTo(new Double(n1.getValor()));
            }

            @Override
            public int compare(Object o1, Object o2) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        if (notas.size() < 3 && notas.size() > 0) {
            return notas;
        } else if (notas.size() >= 3) {
            for (int i = 0; i < notas.size(); i++) {
                if (i >= 3) {
                    notas.remove(i);
                }
            }
            return notas;
        }
        return null;

    }

    public static boolean porcentajeDiferente100(ArrayList<Nota> notas, int id_materia, int num_grupo, int id_estudiante, double porcentaje) {
        double sum = 0;
        for (Nota nota : notas) {
            if (nota.getMatricula().getGrupo().getNumero() == num_grupo && nota.getMatricula().getGrupo().getMateria().getId() == id_materia && nota.getMatricula().getEstudiante().getIdentificacion() == id_estudiante) {
                sum += nota.getPorcentaje();
            }
        }
        double total = sum + porcentaje;
        if (total > 100) {
            return false;
        }
        return true;

    }

}
