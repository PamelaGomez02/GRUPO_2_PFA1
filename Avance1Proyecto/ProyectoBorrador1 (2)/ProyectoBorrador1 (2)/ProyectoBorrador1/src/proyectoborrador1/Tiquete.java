/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoborrador1;

import java.time.LocalDateTime;

/**
 *
 * @author danid
 */
public class Tiquete {
    private Nodo cabeza;
    private String nombre;
    private int id;
    private int edad;
    private LocalDateTime horaCreacion;
    private String horaAtencion;
    private String tramite;
    private char tipo;   // "P" , "A" o "B"
    // P = PREFERENCIAL
    // A = UN TRAMITE
    // B = DOS O MAS TRAMITES

    public Tiquete() {
    }

    public Tiquete(String nombre, int id, int edad, LocalDateTime horaCreacion, String horaAtencion, String tramite, char tipo) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.horaCreacion = horaCreacion;
        this.horaAtencion = horaAtencion;
        this.tramite = tramite;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDateTime getHoraCreacion() {
        return horaCreacion;
    }

    public void setHoraCreacion(LocalDateTime horaCreacion) {
        this.horaCreacion = horaCreacion;
    }

    public String getHoraAtencion() {
        return horaAtencion;
    }

    public void setHoraAtencion(String horaAtencion) {
        this.horaAtencion = horaAtencion;
    }

    public String getTramite() {
        return tramite;
    }

    public void setTramite(String tramite) {
        this.tramite = tramite;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nTiquete: ");
        sb.append("\nNombre: ").append(nombre);
        sb.append("\nID: ").append(id);
        sb.append("\nEdad: ").append(edad);
        sb.append("\nHora de Creacion: ").append(horaCreacion);
        sb.append("\nHora de Atencion: ").append(horaAtencion != null ? horaAtencion : "No atendido");
        sb.append("\nTramite: ").append(tramite);
        sb.append("\nTipo: ").append(tipo);
        return sb.toString();
    }
}
