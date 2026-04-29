public class Nodo {

    private int matricula;
    private String nombre;
    private double promedio;
    private Nodo siguiente;

    public Nodo(int matricula, String nombre, double promedio) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.promedio = promedio;
        this.siguiente = null;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return String.format("Matrícula: %d | Nombre: %s | Promedio: %.2f", matricula, nombre, promedio);
    }
}
