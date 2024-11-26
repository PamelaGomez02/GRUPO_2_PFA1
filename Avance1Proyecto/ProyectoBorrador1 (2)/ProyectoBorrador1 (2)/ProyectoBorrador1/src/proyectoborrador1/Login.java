/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoborrador1;

import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author marjo
 */
public class Login {

    private String nombreUsuario1 = "Usuario1";
    private String nombreUsuario2 = "Usuario2";
    private String contrasenaCorrecta = "usuario12";
    private int maximoIntentos = 3;

    public boolean verificacion() {
        int intentos = 0;

        while (intentos < maximoIntentos) {
            String usuario = JOptionPane.showInputDialog(null, "Ingrese su usuario asignado: ", "Sistema de Autenticación", JOptionPane.PLAIN_MESSAGE);
            String contrasena = JOptionPane.showInputDialog(null, "Ingrese su contraseña: ", "Sistema de Autenticación", JOptionPane.PLAIN_MESSAGE);

            if (usuario != null && contrasena != null && usuario.equals(nombreUsuario1) || usuario.equals(nombreUsuario2) && contrasena.equals(contrasenaCorrecta)) {
                JOptionPane.showMessageDialog(null, "Nos alegra tenerlo/tenerla de vuelta " + usuario + "\n¡El acceso le ha sido concedido!" + JOptionPane.INFORMATION_MESSAGE);
                return true;
            }else{
                intentos++;
                JOptionPane.showMessageDialog(null, "Usuario o contraseñas incorrectos. Intento " + intentos + " de " + maximoIntentos, "Error de Autenticación", JOptionPane.ERROR_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(null,"Excedió el límite de iuntentos permitidos" + "\nPor favor vuelva a intentarlo más tarde", "Acceso Restringido", JOptionPane.WARNING_MESSAGE);
        return false;
    }
}
