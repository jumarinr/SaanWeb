import Java.util.Arraylist;
import Java.util.Arraylist.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Materia{
  //attributes
  private int id;
  private String nombre;
  private short creditos;
  private ArrayList<Grupo> grupos = new ArrayList<Grupo>();

  //constructor
  public Materia(int id, String nombre, short creditos){
    this.id = id;
    this.nombre = nombre;
    this.creditos = creditos;
  }

  //setters getters
  public int get_id(){
    return this.id;
  }
  public void set_id(int id){
    this.id = id;
  }
  public String get_nombre(){
    return this.nombre;
  }
  public void set_nombre(String nombre){
    this.nombre = nombre;
  }
  public short get_creditos(){
    return this.creditos;
  }
  public void set_creditos(short creditos){
    this.creditos = creditos;
  }
  public ArrayList<Grupo> get_grupos(){
    return this.grupos;
  }
  public String set_grupos(ArrayList<Grupo> grupos){
    if (grupos) {
      this.grupos = grupos;
      return "mod";
    }
    return "err";
  }

  //métodos
  public static ArrayList<Materia> mostrar_materias(ArrayList<Materia> materias){
    if (materias) {
      return materias;
    }
    return null;
  }
  public static Materia buscar_materia(ArrayList<Materia> materias, int id){
    for (Materia materia : materias) {
      if (materia.get_id() == id || materia.get_nombre().equals((String)id)) {
        return Meteria;
      }
    }
    return null;
  }
  public static ArrayList<Grupo> mostrar_grupos(ArrayList<Grupo> grupos){
    if (grupos) {
      return grupos;
    }
    return null;
  }
  public static String eliminar(int id, ArrayList<Materia> list_materias, ArrayList<Grupo> grupos, ArrayList<Matricula> list_matricula, ArrayList<Nota> list_nota){
    Materia materia = Materia.buscar_materia(list_materias, id);
    if (materia) {
      Grupo.eliminar_por_materia(lista_grupos, id, list_matricula, list_nota);
      list_materias.remove(list_materias.indexOf(materia));
      Materia.guardar_cambios(list_materias);
      return "eli";
    }
    return "err";
  }
  public static void cargar_materias(ArrayList<Materia> lista){
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
      e.printStackTrace();
    }
    while(inf.indexOf(">", fin + 1) != -1 && fin < inf.length() - 1){
      ini = inf.indexOf("<", fin);
      fin = inf.indexOf(">", ini);
      ArrayList<String> mat = 
    }
  }
}
