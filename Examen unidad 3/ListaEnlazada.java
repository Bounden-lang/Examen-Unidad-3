public class ListaEnlazada {
    private Nodo cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    public void insertar(int matricula, String nombre, double promedio) {
        Nodo nuevoNodo = new Nodo(matricula, nombre, promedio);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    public boolean eliminar(int matricula) {
        if (cabeza == null) return false;
        if (cabeza.getMatricula() == matricula) {
            cabeza = cabeza.getSiguiente();
            return true;
        }
        Nodo actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getMatricula() == matricula) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public Nodo buscar(int matricula) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getMatricula() == matricula) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        Nodo actual = cabeza;
        int contador = 1;
        System.out.println();
        while (actual != null) {
            System.out.println(contador + ". " + actual);
            actual = actual.getSiguiente();
            contador++;
        }
        System.out.println();
    }

    public double calcularPromedioGeneral() {
        if (cabeza == null) return 0.0;
        double suma = 0;
        int contador = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            suma += actual.getPromedio();
            contador++;
            actual = actual.getSiguiente();
        }
        return suma / contador;
    }

    public void mostrarAprobados() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        System.out.println("\nESTUDIANTES APROBADOS (promedio >= 6.0)");
        Nodo actual = cabeza;
        int contador = 1;
        boolean encontrados = false;
        while (actual != null) {
            if (actual.getPromedio() >= 6.0) {
                System.out.println(contador + ". " + actual);
                contador++;
                encontrados = true;
            }
            actual = actual.getSiguiente();
        }
        if (!encontrados) {
            System.out.println("No hay estudiantes aprobados.");
        }
        System.out.println();
    }

    public int contar() {
        int contador = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public Nodo getUltimo() {
        if (cabeza == null) return null;
        Nodo actual = cabeza;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        return actual;
    }
}
