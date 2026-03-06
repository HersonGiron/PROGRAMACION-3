/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
// Declaración del paquete al que pertenece esta clase.
package vista;

// Importa la clase Carreras que se encuentra en el paquete controlador.
import controlador.Carreras;
import controlador.Jornadas;
import modelo.JornadasDAO;
import modelo.CarrerasDAO;
import java.util.List;
/**
 *
 * @author giron
 */
public class UMG {

    /**
     * @param args the command line arguments
     */
    
    // Método principal del programa. 
    public static void main(String[] args) { 
    
    // insert
    // Se crea un objeto de la clase Carreras con el nombre "Psicología Industrial"
    Carreras carrera = new Carreras("Psicología Industrial",1);
    // Se imprime en consola la información del objeto carrera usando el método toString().
    System.out.println("Carrera ingresada: " + carrera.toString());
    // Se crea un objeto que se encargará de interactuar con la base de datos.
    CarrerasDAO carrerasdao = new CarrerasDAO();
    // Se llama al método insert del DAO para guardar la carrera en la base de datos.
    carrerasdao.insert(carrera);
    
    // query
    // Se ejecuta una consulta usando el objeto carrera
    carrerasdao.query(carrera);
    // Se asigna el código de carrera 4 al objeto carrera
    carrera.setCodigoCarrera(4);
    // Se busca en la base de datos la carrera con el código asignado
    carrera = carrerasdao.query(carrera);
    // Se muestra en consola 
    System.out.println("Carrera buscada: " + carrera.toString());

    // select
    // Se crea un nuevo objeto DAO
    CarrerasDAO carrerasdaoModi = new CarrerasDAO();
    // Se obtiene una lista con todas las carreras almacenadas en la base de datos
    List<Carreras> carreras = carrerasdaoModi.select();
    // Se recorre la lista de carreras usando un ciclo for-each
    for (Carreras lista : carreras) {
        // Se imprime cada carrera contenida en la lista
        System.out.println("Lista de carreras: " + lista.toString());
    }


    // delete
    // Se crea un objeto Carreras que representará la carrera a eliminar
    Carreras carreraEliminar = new Carreras();
    // Se asigna el código de la carrera que se desea eliminar 
    carreraEliminar.setCodigoCarrera(3);
    // Se consulta la carrera en la base de datos antes de eliminarla
    carreraEliminar = carrerasdao.query(carreraEliminar);
    // Se elimina la carrera de la base de datos
    carrerasdao.delete(carreraEliminar);
    // Se muestra en consola 
    System.out.println("Carrera eliminada: " + carreraEliminar.toString());


    // update
    // Se establece el código de la carrera que se desea actualizar
    carrera.setCodigoCarrera(1);
    // Se busca la carrera actual en la base de datos
    carrera = carrerasdao.query(carrera);
    // Se modifica el nombre de la carrera
    carrera.setNombreCarrera("Ingenieria Industrial");
    // Se establece el estatus de la carrera 
    carrera.setEstatus(1);
    // Se actualiza la información de la carrera en la base de datos
    carrerasdao.update(carrera);
    // Se muestra en consola la carrera 
    System.out.println("Carrera actualizada: " + carrera.toString());
    
    
    //CRUD JORNADAS
    Jornadas jornada = new Jornadas("Matutina");
    System.out.println("Jornada ingresada: " + jornada.toString());
    JornadasDAO jornadasdao = new JornadasDAO();
    jornadasdao.insert(jornada);

    jornadasdao.query(jornada);
    jornada.setJorCodigo(2);
    jornada = jornadasdao.query(jornada);
    System.out.println("Jornada buscada: " + jornada.toString());

    JornadasDAO jornadasdaoModi = new JornadasDAO();
    List<Jornadas> jornadas = jornadasdaoModi.select();
    for (Jornadas lista : jornadas) {
    System.out.println("Lista de jornadas: " + lista.toString());
    }

    Jornadas jornadaEliminar = new Jornadas();
    jornadaEliminar.setJorCodigo(3);
    jornadaEliminar = jornadasdao.query(jornadaEliminar);
    jornadasdao.delete(jornadaEliminar);
    System.out.println("Jornada eliminada: " + jornadaEliminar.toString());

    jornada.setJorCodigo(1);
    jornada = jornadasdao.query(jornada);
    jornada.setJorNombre("Vespertina");
    jornadasdao.update(jornada);
    System.out.println("Jornada actualizada: " + jornada.toString());
    }
    
}
