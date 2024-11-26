/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoborrador1;

import java.time.LocalDateTime;
import javax.swing.JOptionPane;

/**
 *
 * @author danid
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cola caja1 = new Cola();
        Cola caja2 = new Cola();
        Cola caja3 = new Cola();
        Cola cajaRapida = new Cola();
        Cola cajaPreferencial = new Cola();

        ControlCajas controlCajas = new ControlCajas(caja1, caja2, caja3, cajaRapida, cajaPreferencial);
        Login login = new Login();

        // Agregar datos iniciales
        //agregarDatosInicales(caja1);
        if (login.verificacion()) {
            JOptionPane.showMessageDialog(null, "Acceso concedido. Continuando el sistema...");
            JOptionPane.showMessageDialog(null, "¡Bienvenido al sistema de atención al cliente!");
            
            boolean bandera = true;
            while (bandera) {
                String opcion = JOptionPane.showInputDialog("Ingrese la opcion que desea realizar:"
                        + "\n1. Agregar nuevo cliente\n"
                        + "2. Imprimir cola\n"
                        + "3. Salir");

                switch (opcion) {
                    case "1":
                        agregarNuevoCliente(controlCajas);
                        break;
                    case "2":
                        System.out.println(controlCajas.mostrarColas());
                        break;
                    case "3":
                        JOptionPane.showMessageDialog(null, "¡Hasta la próxima!");
                        bandera = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no inválida. Por favor, intente de nuevo.");
                        break;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Acceso denegado. El ptrograma cerarrá en breve.");
            System.exit(0);
        }

    }

    /*
    private static void agregarDatosInicales(Cola cola) {
        agregarTiquete(cola, new Tiquete("Natalia Campos", 1, 24, LocalDateTime.now(), null, "Trámite 1", 'B'));
        agregarTiquete(cola, new Tiquete("Maria Jose Guadamuz", 2, 21, LocalDateTime.now(), null, "Trámite 2", 'A'));
        agregarTiquete(cola, new Tiquete("Daniela Diaz", 3, 21, LocalDateTime.now(), null, "Trámite 3", 'P'));
    }
     */
    private static void agregarNuevoCliente(ControlCajas controlCajas) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del cliente:"));
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del cliente:"));
        String tramite = JOptionPane.showInputDialog("Ingrese el trámite del cliente:");
        char tipo = JOptionPane.showInputDialog("Ingrese el tipo del cliente (P, A, B):").charAt(0);

        Tiquete nuevoTiquete = new Tiquete(nombre, id, edad, LocalDateTime.now(), null, tramite, tipo);
        controlCajas.agregarCliente(nuevoTiquete);
    }
    /*
    private static void agregarTiquete(Cola cola, Tiquete tiquete) {
        Nodo nuevoNodo = new Nodo(tiquete, null);
        cola.hacerFila(nuevoNodo);
    }*/
}
