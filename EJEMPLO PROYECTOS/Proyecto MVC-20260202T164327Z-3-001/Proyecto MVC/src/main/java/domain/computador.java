package domain;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author giron
 */
public class computador {
    private String Software;
    private String color;
    private String marca;

    public computador(String Software, String color, String marca) {
        this.Software = Software;
        this.color = color;
        this.marca = marca;
    }
    
    public String getSoftware() {
        return Software;
    }

    public void setSoftware(String Software) {
        this.Software = Software;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
       
    public computador() {
}

    @Override
    public String toString() {
        return "computador{" + "Software=" + Software + ", color=" + color + ", marca=" + marca + '}';
    }
    
    

    
    
    
}
