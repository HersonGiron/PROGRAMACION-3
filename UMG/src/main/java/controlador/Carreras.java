/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author giron
 */
// Declaración de la clase Carreras
public class Carreras { 

    // Variable que almacena el código único de la carrera
    private int CodigoCarrera;
    // Variable que almacena el nombre de la carrera
    private String NombreCarrera;
    // Variable que almacena el estatus de la carrera
    private int Estatus;


    // Constructor vacío de la clase Carreras
    public Carreras() {        
    }


    // Constructor con parámetros para inicializar el nombre y estatus de la carrera
    public Carreras(String NombreCarrera,int Estatus) {
    // Asigna el valor recibido al atributo NombreCarrera del objeto
    this.NombreCarrera = NombreCarrera;
    // Asigna el valor recibido al atributo Estatus del objeto
    this.Estatus = Estatus;
    }


    // Método getter que devuelve el código de la carrera
    public int getCodigoCarrera() {
    // Retorna el valor del atributo CodigoCarrera
    return CodigoCarrera;
    }


    // Método setter que permite asignar un valor al código de la carrera
    public void setCodigoCarrera(int CodigoCarrera) {
    // Asigna el valor recibido al atributo CodigoCarrera del objeto
    this.CodigoCarrera = CodigoCarrera;
    }


    // Método getter que devuelve el nombre de la carrera
    public String getNombreCarrera() {
    // Retorna el valor del atributo NombreCarrera
    return NombreCarrera;
    }


    // Método setter que permite asignar un nombre a la carrera
    public void setNombreCarrera(String NombreCarrera) {
    // Asigna el valor recibido al atributo NombreCarrera del objeto
    this.NombreCarrera = NombreCarrera;
    }
    

    // Método getter que devuelve el estatus de la carrera
    public int getEstatus() {
    // Retorna el valor del atributo Estatus
    return Estatus;
    }


    // Método setter que permite asignar un estatus a la carrera
    public void setEstatus(int Estatus) {
    // Asigna el valor recibido al atributo Estatus del objeto
    this.Estatus = Estatus;
    }
    

    // Sobrescritura del método toString() de la clase Object
    // Permite mostrar la información del objeto en formato de texto
    @Override
    public String toString() {
        // Retorna una cadena con todos los datos del objeto Carreras
        return "Carreras{" + "CodigoCarrera=" + CodigoCarrera + ", NombreCarrera=" + NombreCarrera + ", Estatus=" + Estatus +'}';
    }
}