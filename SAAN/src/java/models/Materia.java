package models;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;
import util.Mensajes;

/**
 *
 * @author Juan Pablo
 */
public class Materia {

    public static List<Materia> materias = new ArrayList<Materia>();
    private int id;
    private String nombre;
    private short creditos;
    private List<Grupo> grupos;

    public Materia(int id, String nombre, short creditos) {
        this.setId(id);
        this.setNombre(nombre);
        this.setCreditos(creditos);
        this.grupos = new ArrayList<Grupo>();
    }

    public Materia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (!nombre.equals("")) {
            this.nombre = nombre;
        }
    }

    public short getCreditos() {
        return creditos;
    }

    public void setCreditos(short creditos) {
        if (creditos > 0) {
            this.creditos = creditos;
        }
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        if (grupos != null) {
            this.grupos = grupos;
        }
    }

    public static Materia buscarMateria(int id) {
        for (Materia materia : Materia.materias) {
            if (materia.getId() == id) {
                return materia;
            }
        }
        return null;
    }

    public static String registrar(Materia materia) {
        if (Materia.buscarMateria(materia.getId()) != null) {
            return Mensajes.mensaje.get("err");
        }
        if (materia.getCreditos() <= 0 || materia.getId() <= 0 || materia.getNombre() == null) {
            return Mensajes.mensaje.get("err");
        }
        Materia.materias.add(materia);
        Materia.GuardarCambios();
        return Mensajes.mensaje.get("err");
    }

    public static String eliminar(int id) {
        Materia materia = Materia.buscarMateria(id);
        if (materia != null) {
            Grupo.eliminarPorMateria(id);
            Materia.materias.remove(materia);
            Materia.GuardarCambios();
            return Mensajes.mensaje.get("eli");
        }
        return "err";
    }

    public static void CargarMaterias() {
        String inf = "";
        int ini = 0;
        int fin = 0;
        try {
            File myObj = new File("materias.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                inf += data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        while (inf.indexOf(">", fin + 1) != -1 && fin < inf.length() - 1) {
            ini = inf.indexOf("<", fin);
            fin = inf.indexOf(">", ini);
            String[] mat = inf.substring(ini + 1, fin).split(",");
            Materia.materias.add(new Materia(Integer.valueOf(mat[0]), mat[1], Short.valueOf(mat[2])));
        }
    }

    public static void GuardarCambios() {
        try {
            FileWriter file = new FileWriter("materias.txt");
            file.write("");
            for (Materia materia : Materia.materias) {
                file.write("<" + String.valueOf(materia.getId()) + "," + materia.getNombre() + "," + String.valueOf(materia.getCreditos()) + ">");
            }
            file.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
