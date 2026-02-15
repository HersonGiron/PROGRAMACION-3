package Controlador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author giron
 */
public class Empresa {
    public Empresa(int CodigoEmpresa, String NombreEmpresa) {
        this.CodigoEmpresa = CodigoEmpresa;
        this.NombreEmpresa = NombreEmpresa;
    }
    int CodigoEmpresa;
    String NombreEmpresa;
    
    public int getCodigoEmpresa() {
        return CodigoEmpresa;
    }

    public void setCodigoEmpresa(int CodigoEmpresa) {
        this.CodigoEmpresa = CodigoEmpresa;
    }

    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    public void setNombreEmpresa(String NombreEmpresa) {
        this.NombreEmpresa = NombreEmpresa;
    }

    @Override
    public String toString() {
        return "Empresa{" + "CodigoEmpresa=" + CodigoEmpresa + ", NombreEmpresa=" + NombreEmpresa + '}';
    }
}
