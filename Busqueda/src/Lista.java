import javax.swing.*;

public class Lista {

    private Nodo inicio;
    private int tamano;

    public Lista() {
        inicio = null;
        tamano = 0;
    }

    // Método para agregar un valor entero al final de la lista
    public void agregar(int dato, JTextArea textArea) {
        Nodo nuevoNodo = new Nodo(dato);
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            Nodo actual = inicio;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamano++;
        actualizarTextArea(textArea);
    }

    // Método para eliminar un valor entero de la lista
    public boolean eliminar(int dato, JTextArea textArea) {
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "La lista está vacía.");
            return false;
        }
        if (inicio.dato == dato) {
            inicio = inicio.siguiente;
            tamano--;
            actualizarTextArea(textArea);
            return true;
        }
        Nodo actual = inicio;
        while (actual.siguiente != null && actual.siguiente.dato != dato) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            tamano--;
            actualizarTextArea(textArea);
            return true;
        }
        JOptionPane.showMessageDialog(null, "Elemento no encontrado en la lista.");
        return false;
    }

    // Método para realizar una búsqueda lineal
    public int buscarLineal(int dato,  JTextArea textArea) {
        Nodo actual = inicio;
        int posicion = 0;
        while (actual != null) {
            if (actual.dato == dato) {
                return posicion;
            }
            actual = actual.siguiente;
            posicion++;
        }
        return -1; // Retorna -1 si no se encuentra
    }

    // Método para ordenar la lista usando burbuja
    public void ordenarBurbuja(JTextArea textArea) {
        if (inicio == null || inicio.siguiente == null) return;

        boolean swapped;
        do {
            swapped = false;
            Nodo actual = inicio;
            Nodo siguiente = inicio.siguiente;
            while (siguiente != null) {
                if (actual.dato > siguiente.dato) {
                    int temp = actual.dato;
                    actual.dato = siguiente.dato;
                    siguiente.dato = temp;
                    swapped = true;
                }
                actual = siguiente;
                siguiente = siguiente.siguiente;
            }
        } while (swapped);

        actualizarTextArea(textArea); // Actualiza la vista en el JTextArea
    }

    // Método auxiliar para convertir la lista a un array
    public int[] convertirAArray() {
        int[] array = new int[tamano];
        Nodo actual = inicio;
        int i = 0;
        while (actual != null) {
            array[i++] = actual.dato;
            actual = actual.siguiente;
        }
        return array;
    }

    // Método para mostrar la lista en el JTextArea
    public void mostrarLista(JTextArea textArea) {
        if (inicio == null) {
            textArea.setText("La lista está vacía.");
        } else {
            StringBuilder listaStr = new StringBuilder();
            Nodo actual = inicio;
            while (actual != null) {
                listaStr.append(actual.dato).append("\n");
                actual = actual.siguiente;
            }
            textArea.setText(listaStr.toString());
        }
    }

    // Método para actualizar el JTextArea cada vez que cambia la lista
    private void actualizarTextArea(JTextArea textArea) {
        mostrarLista(textArea);
    }
}
