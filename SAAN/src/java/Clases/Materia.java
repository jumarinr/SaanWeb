package Clases;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;

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

  //métodos
  public static ArrayList<Materia> MostrarMaterias(ArrayList<Materia> materias){
    if (materias != null) {
      return materias;
    }
    return null;
  }
  public static Materia BuscarMateria(ArrayList<Materia> materias, int id){
    for (Materia materia : materias) {
      if (materia.getId()== id || materia.getNombre().equals(Integer.toString(id))) {
        return materia;
      }
    }
    return null;
  }
  public static ArrayList<Grupo> mostrar_grupos(ArrayList<Grupo> grupos){
    if (grupos != null) {
      return grupos;
    }
    return null;
  }
  public static String Eliminar(int id, ArrayList<Materia> list_materias, ArrayList<Grupo> grupos, ArrayList<Matricula> list_matricula, ArrayList<Nota> list_nota){
    Materia materia = Materia.BuscarMateria(list_materias, id);
    if (materia != null) {
      Grupo.EliminarPorMateria(grupos, id, list_matricula, list_nota);
      list_materias.remove(list_materias.indexOf(materia));
      Materia.GuardarCambios(list_materias);
      return "eli";
    }
    return "err";
  }
  public static void CargarMaterias(ArrayList<Materia> lista){
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
    while(inf.indexOf(">", fin + 1) != -1 && fin < inf.length() - 1){
      ini = inf.indexOf("<", fin);
      fin = inf.indexOf(">", ini);
      String[] mat = inf.substring(ini + 1, fin).split(",");
      lista.add(new Materia(Integer.valueOf(mat[0]), mat[1], Short.valueOf(mat[2])));
    }
  }
  public static void GuardarCambios(ArrayList<Materia> lista){
    try { 
      FileWriter file = new FileWriter("materias.txt");
      file.write("");
      for (Materia materia : lista){
          file.write("<" + String.valueOf(materia.getId()) + "," + materia.getNombre() + "," + String.valueOf(materia.getCreditos()) + ">");
      }
      file.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
    } 
  }
}
