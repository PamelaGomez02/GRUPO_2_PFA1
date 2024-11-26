/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoborrador1;

/**
 *
 * @author danid
 */
public class ControlCajas {
    //creación de colas

    private Cola caja1;
    private Cola caja2;
    private Cola caja3;
    private Cola cajaRapida;
    private Cola cajaPreferencial;

    public ControlCajas(Cola caja1, Cola caja2, Cola caja3, Cola cajaRapida, Cola cajaPreferencial) {
        this.caja1 = caja1;
        this.caja2 = caja2;
        this.caja3 = caja3;
        this.cajaRapida = cajaRapida;
        this.cajaPreferencial = cajaPreferencial;
    }

    public void agregarCliente(Tiquete tiquete) {
        if (tiquete.getTipo() == 'P') {
            // Si es preferencial, se asigna a la caja preferencial
            cajaPreferencial.hacerFila(new Nodo(tiquete, null));
            System.out.println("Cliente preferencial agregado a la cola preferencial.");
        } else if (tiquete.getTipo() == 'A') {
            // Si es un solo trámite, se asigna a la caja rápida
            cajaRapida.hacerFila(new Nodo(tiquete, null));
            System.out.println("Cliente con un solo trámite agregado a la caja rápida.");
        } else if (tiquete.getTipo() == 'B') {
            // Si tiene dos o más trámites, se asigna a la primera caja disponible
            if (caja1.contarPersonas() <= caja2.contarPersonas() && caja1.contarPersonas() <= caja3.contarPersonas()) {
                caja1.hacerFila(new Nodo(tiquete, null));
                System.out.println("Cliente con dos o más trámites agregado a la caja 1.");
            } else if (caja2.contarPersonas() <= caja1.contarPersonas() && caja2.contarPersonas() <= caja3.contarPersonas()) {
                caja2.hacerFila(new Nodo(tiquete, null));
                System.out.println("Cliente con dos o más trámites agregado a la caja 2.");
            } else {
                caja3.hacerFila(new Nodo(tiquete, null));
                System.out.println("Cliente con dos o más trámites agregado a la caja 3.");
            }
        } else {
            System.out.println("Tipo de cliente no válido. No se puede agregar.");
        }
    }

    

    public String mostrarColas() {
        StringBuilder s = new StringBuilder();
        s.append("\nCaja Preferencial:").append(cajaPreferencial.toString()).append("\n");
        s.append("\nCaja Rápida:").append(cajaRapida.toString()).append("\n");
        s.append("\nCaja 1:").append(caja1.toString()).append("\n");
        s.append("\nCaja 2:").append(caja2.toString()).append("\n");
        s.append("\nCaja 3: ").append(caja3.toString()).append("\n");
        
        

        return s.toString();
    }
}
