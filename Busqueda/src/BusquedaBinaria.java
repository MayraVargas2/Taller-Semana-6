public class BusquedaBinaria implements Busqueda {
    @Override
    public int buscar(int[] array, int valor) {
        int inicio = 0;
        int fin = array.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (array[medio] == valor) {
                return medio; // Retorna el índice
            }

            if (array[medio] < valor) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return -1; // Retorna -1 si no se encuentra
    }
}
