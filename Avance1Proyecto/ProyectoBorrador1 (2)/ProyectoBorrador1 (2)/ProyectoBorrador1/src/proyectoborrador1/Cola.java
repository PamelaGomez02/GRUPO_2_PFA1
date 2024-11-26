/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoborrador1;

/**
 *
 * @author danid
 */
public class Cola {

    private Nodo frente;
    private Nodo ultimo;

    public Nodo getFrente() {
        return frente;
    }

    public void setFrente(Nodo frente) {
        this.frente = frente;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }

    public void hacerFila(Nodo elemento) {

        if (elemento == null) {
            System.out.println("El elemento a agregar es null. No se puede agregar.");
            return; // Manejo de caso en que el nodo nuevo es null
        }
        if (frente == null) { //Empieza la fila vacia o en null
            frente = elemento;
            ultimo = elemento;

        } else if (esMayorPrioridad(elemento, frente)) {

            // Si el nuevo elemento tiene MAYOR PRIORIDAD se convierte en el nuevo frente
            elemento.setAtras(frente);
            frente = elemento;
        } else {
            //Busco la posicion SEGUN SU TIPO
            Nodo actual = frente;
            while (actual.getAtras() != null & !esMayorPrioridad(elemento, actual.getAtras())) {
                actual = actual.getAtras();
            }
            elemento.setAtras(actual.getAtras());
            actual.setAtras(elemento);

            if (elemento.getAtras() == null) {
                ultimo = elemento;
            }
        }
    }

    //Metodo de si TIENE PRIORIDAD O NO
    private boolean esMayorPrioridad(Nodo nuevo, Nodo actual) {
        if (actual == null) {
            //System.out.println("El nodo actual es null. No se puede comparar.");
            return false; // O manejarlo de otra forma, según tu lógica

        }
        if (nuevo == null) {
            //System.out.println("El nodo nuevo es null. No se puede comparar.");
            return false; // O manejarlo de otra forma, según tu lógica
        }
        char tipoNuevo = nuevo.getTiquete().getTipo();
        char tipoActual = actual.getTiquete().getTipo();

        // Asignación de prioridad según el tipo
        int prioridadNuevo = obtenerPrioridad(tipoNuevo);
        int prioridadActual = obtenerPrioridad(tipoActual);

        return prioridadNuevo < prioridadActual; // Mayor prioridad tiene menor valor
    }
    //asigna valor de prioridad por cada TIPO

    //1. P: PREFERENCIAL
    //2. A: UN SOLO TRAMITE
    //3. B: DOS O MAS TRAMITES
    private int obtenerPrioridad(char tipo) {
        switch (tipo) {
            case 'P':
                return 1;
            case 'A':
                return 2;
            case 'B':
                return 3;
            default:
                throw new IllegalArgumentException("Tipo desconocido: " + tipo); // Excepción JEJE
        }
    }

    public Nodo atender() {
        
            Nodo actual = frente;
            frente = frente.getAtras(); // Cambia el frente
            if (frente == null) {
                ultimo = null; // Si la cola queda vacía, actualiza ultimo
            }
            actual.setAtras(null); // Limpia el puntero de atrás
            return actual;
        }
        //contar personas
    public int contarPersonas() {
        int cont = 0;
        Nodo aux = frente;
        while (aux != null) {
            cont++;
            aux = aux.getAtras();
        }
        return cont;
    }

    @Override
    public String toString() {
        String string = "";
        Nodo aux = frente;
        while (aux != null) {
            string = string + aux.getTiquete().toString();
            aux = aux.getAtras();
        }
        return string;
    }

}
