/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoborrador1;

/**
 *
 * @author danid
 */
public class Nodo {

    private Tiquete tiquete;
    private Nodo atras;

    public Nodo(Tiquete tiquete, Nodo atras) {
        this.tiquete = tiquete;
        this.atras = atras;
    }

    
    public Nodo() {
    }

    public Tiquete getTiquete() {
        return tiquete;
    }

    public void setTiquete(Tiquete tiquete) {
        //asigna un nuevo tiquete
        this.tiquete = tiquete;
    }

    public Nodo getAtras() {
        return atras;
    }

    public void setAtras(Nodo atras) {
        this.atras = atras;
    }

    @Override
    public String toString() {
        return tiquete.toString();
    }
}
