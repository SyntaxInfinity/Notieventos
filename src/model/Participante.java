/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Participante {

    private String nombre;
    private String rut;
    private String rol;

    public Participante(String nombre, String rut, String rol) {
        this.nombre = nombre;
        this.rut = rut;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public String getRol() {
        return rol;
    }

    public String getDatos() {
        return nombre + " | " + rut + " | " + rol;
    }
}
