Java.util.Arraylist;
Java.util.Arraylist.*;

public class Nota{
  //attributes
  public static ArrayList<Nota> notas = new ArrayList<Nota>();
  private double porcentaje;
  private double valor;
  private int id;
  private Matricula matricula;

  //constructor
  public Nota(double porcentaje, double valor, int id, Matricula matricula){
    this.porcentaje = porcentaje;
    this.valor = valor;
    this.id = id;
    this.matricula = matricula;
  }
  //getters setters
  public void set_porcentaje(double porcentaje){
    this.porcentaje = porcentaje;
  }
  public double get_porcentaje(){
    return this.porcentaje;
  }
  public void set_valor(double valor){
    this.valor = valor;
  }
  public double get_valor(){
    return this.valor;
  }
  public void set_id(int id){
    this.id = id;
  }
  public int get_id(){
    return this.id;
  }
  public void set_id(Matricula matricula){
    this.matricula = matricula;
  }
  public Matricula get_matricula(){
    return this.matricula;
  }

  //métodos
  public static Matricula buscar_nota(ArrayList<Nota> lista, int doc_estudiante, int id_materia, int num_grupo, int id){
    for (Nota nota : lista) {
      if (nota.get_matricula().get_estudiante().get_identificacion() == doc_estudiante && nota.get_matricula().get_grupo().get_numero() == num_grupo && nota.get_matricula().get_grupo().get_materia().get_id() == id_materia && nota.get_id() = id) {
        return nota;
      }
    }
    return null;
  }
  public static String registrar(Nota nota, ArrayList<Nota> lista){
    if (Nota.buscar_nota(lista, nota.get_matricula().get_estudiante().get_identificacion(), nota.get_matricula().get_grupo().get_numero(), nota.get_matricula().get_grupo().get_materia().get_id(), nota.get_id()) {
      return "err";
    }
    else {
      lista.add(nota);
      nota.get_matricula().get_estudiante().get_nota().add(nota);
      return "reg";
    }
  }
  public static String eliminar(ArrayList<Nota> lista, int doc_estudiante, int id_materia, int num_grupo, int id){
    Nota nota = Nota.buscar_nota(lista, nota.get_matricula().get_estudiante().get_identificacion(), nota.get_matricula().get_grupo().get_numero(), nota.get_matricula().get_grupo().get_materia().get_id(), nota.get_id());
    if (nota) {
      //...
      return "eli";
    }
    return "err";
  }
  public static ArrayList<Nota> mostrar_notas(ArrayList<Nota> lista, short est, short gru, short mat){
    ArrayList<Nota> notas = new ArrayList<Nota>();
    for (Nota nota : lista) {
      Grupo grupo = nota.get_matricula().get_grupo();

      if ((est == -1 || est == nota.get_matricula().get_estudiante().get_identificacion()) && (gru == -1 || (gru == grupo.get_numero() && mat == grupo.get_materia().get_id()))) {
        notas.add(nota);
      }
    }
    return notas;
  }
  public static String eliminar_por_matricula(ArrayList<Nota> lista, int num_grupo, int id_materia){
      // ...
      return "working on";
  }
  public static void enviar_correo_actualizar_nota(short opc, int id, double nota, double porcentaje, Estudiante estudiante, String materia{
    String correo_enviar = estudiante.get_correo();
    String cuerpo = "";
    if (/*...*/) {
      //...
    }
    else}{
        //...
    }
    Operaciones.enviar_correo_electronico(String correo_enviar, String asunto, String cuerpo);
  }
  public static String mejores_notas(ArrayList<Grupo> lista_grupos, int id_materia, int id_grupo){
    return "working on";
  }
  public static boolean porcentaje_diferente_100(Materia materia, int id_grupo, int estudiante, double porcentaje){
    //...
    return true;
  }
}
