import java.util.Scanner;

public class Main {
    static ListaEnlazada grupo1 = new ListaEnlazada();
    static ListaEnlazada grupo2 = new ListaEnlazada();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean ejecutar = true;
        while (ejecutar) {
            mostrarMenuPrincipal();
            int opcion = obtenerEntero("Elige una opción: ");
            switch (opcion) {
                case 1:
                    menuGrupo1();
                    break;
                case 2:
                    menuGrupo2();
                    break;
                case 3:
                    operacionesGlobales();
                    break;
                case 0:
                    ejecutar = false;
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
        scanner.close();
    }

    static void mostrarMenuPrincipal() {
        System.out.println("\nSISTEMA DE GESTIÓN DE ESTUDIANTES");
        System.out.println("1. Gestionar Grupo 1");
        System.out.println("2. Gestionar Grupo 2");
        System.out.println("3. Operaciones Globales");
        System.out.println("0. Salir");
    }

    static void menuGrupo1() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\nMENÚ GRUPO 1");
            System.out.println("1. Insertar estudiante");
            System.out.println("2. Eliminar estudiante");
            System.out.println("3. Buscar estudiante");
            System.out.println("4. Mostrar lista completa");
            System.out.println("5. Mostrar aprobados");
            System.out.println("6. Promedio general");
            System.out.println("0. Volver");
            int opcion = obtenerEntero("Elige una opción: ");
            switch (opcion) {
                case 1:
                    insertarEstudiante(grupo1, "Grupo 1");
                    break;
                case 2:
                    eliminarEstudiante(grupo1, "Grupo 1");
                    break;
                case 3:
                    buscarEstudiante(grupo1, "Grupo 1");
                    break;
                case 4:
                    System.out.println("\nLISTA COMPLETA - GRUPO 1");
                    grupo1.mostrar();
                    break;
                case 5:
                    grupo1.mostrarAprobados();
                    break;
                case 6:
                    if (grupo1.estaVacia()) {
                        System.out.println("El grupo 1 está vacío.");
                    } else {
                        System.out.printf("Promedio general Grupo 1: %.2f\n\n", grupo1.calcularPromedioGeneral());
                    }
                    break;
                case 0:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    static void menuGrupo2() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\nMENÚ GRUPO 2");
            System.out.println("1. Insertar estudiante");
            System.out.println("2. Eliminar estudiante");
            System.out.println("3. Buscar estudiante");
            System.out.println("4. Mostrar lista completa");
            System.out.println("5. Mostrar aprobados");
            System.out.println("6. Promedio general");
            System.out.println("0. Volver");
            int opcion = obtenerEntero("Elige una opción: ");
            switch (opcion) {
                case 1:
                    insertarEstudiante(grupo2, "Grupo 2");
                    break;
                case 2:
                    eliminarEstudiante(grupo2, "Grupo 2");
                    break;
                case 3:
                    buscarEstudiante(grupo2, "Grupo 2");
                    break;
                case 4:
                    System.out.println("\nLISTA COMPLETA - GRUPO 2");
                    grupo2.mostrar();
                    break;
                case 5:
                    grupo2.mostrarAprobados();
                    break;
                case 6:
                    if (grupo2.estaVacia()) {
                        System.out.println("El grupo 2 está vacío.");
                    } else {
                        System.out.printf("Promedio general Grupo 2: %.2f\n\n", grupo2.calcularPromedioGeneral());
                    }
                    break;
                case 0:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    static void operacionesGlobales() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\nOPERACIONES GLOBALES");
            System.out.println("1. Unir grupos y mostrar lista combinada");
            System.out.println("2. Mostrar reprobados de ambos grupos");
            System.out.println("3. Promedio general de ambos grupos");
            System.out.println("4. Contar total de estudiantes");
            System.out.println("0. Volver");
            int opcion = obtenerEntero("Elige una opción: ");
            switch (opcion) {
                case 1:
                    unirYMostrarGrupos();
                    break;
                case 2:
                    mostrarReprobados();
                    break;
                case 3:
                    promedioGlobalGrupos();
                    break;
                case 4:
                    contarTotalEstudiantes();
                    break;
                case 0:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    static void insertarEstudiante(ListaEnlazada grupo, String nombreGrupo) {
        System.out.println("\nINSERTAR ESTUDIANTE - " + nombreGrupo);
        int matricula = obtenerEntero("Ingresa matrícula: ");
        scanner.nextLine();
        if (grupo.buscar(matricula) != null) {
            System.out.println("La matrícula " + matricula + " ya existe.");
            return;
        }
        System.out.print("Ingresa nombre: ");
        String nombre = scanner.nextLine();
        double promedio = obtenerDouble("Ingresa promedio: ");
        if (promedio < 0 || promedio > 10) {
            System.out.println("El promedio debe estar entre 0 y 10.");
            return;
        }
        grupo.insertar(matricula, nombre, promedio);
        System.out.println("Estudiante insertado exitosamente.\n");
    }

    static void eliminarEstudiante(ListaEnlazada grupo, String nombreGrupo) {
        System.out.println("\nELIMINAR ESTUDIANTE - " + nombreGrupo);
        int matricula = obtenerEntero("Ingresa matrícula a eliminar: ");
        if (grupo.eliminar(matricula)) {
            System.out.println("Estudiante eliminado exitosamente.\n");
        } else {
            System.out.println("No se encontró estudiante con esa matrícula.\n");
        }
    }

    static void buscarEstudiante(ListaEnlazada grupo, String nombreGrupo) {
        System.out.println("\nBUSCAR ESTUDIANTE - " + nombreGrupo);
        int matricula = obtenerEntero("Ingresa matrícula a buscar: ");
        Nodo encontrado = grupo.buscar(matricula);
        if (encontrado != null) {
            System.out.println("\nEstudiante encontrado:");
            System.out.println(encontrado + "\n");
        } else {
            System.out.println("No se encontró estudiante con esa matrícula.\n");
        }
    }

    static void unirYMostrarGrupos() {
        if (grupo1.estaVacia() && grupo2.estaVacia()) {
            System.out.println("Ambos grupos están vacíos.\n");
            return;
        }
        System.out.println("\nLISTA COMBINADA (GRUPO 1 + GRUPO 2)");
        int contador = 1;
        Nodo actual = grupo1.getCabeza();
        while (actual != null) {
            System.out.println(contador + ". " + actual);
            contador++;
            actual = actual.getSiguiente();
        }
        actual = grupo2.getCabeza();
        while (actual != null) {
            System.out.println(contador + ". " + actual);
            contador++;
            actual = actual.getSiguiente();
        }
        System.out.println();
    }

    static void mostrarReprobados() {
        System.out.println("\nESTUDIANTES REPROBADOS (promedio < 6.0)");
        int contador = 1;
        boolean encontrados = false;
        Nodo actual = grupo1.getCabeza();
        while (actual != null) {
            if (actual.getPromedio() < 6.0) {
                System.out.println(contador + ". [GRUPO 1] " + actual);
                contador++;
                encontrados = true;
            }
            actual = actual.getSiguiente();
        }
        actual = grupo2.getCabeza();
        while (actual != null) {
            if (actual.getPromedio() < 6.0) {
                System.out.println(contador + ". [GRUPO 2] " + actual);
                contador++;
                encontrados = true;
            }
            actual = actual.getSiguiente();
        }
        if (!encontrados) {
            System.out.println("No hay estudiantes reprobados!");
        }
        System.out.println();
    }

    static void promedioGlobalGrupos() {
        int totalEstudiantes = grupo1.contar() + grupo2.contar();
        if (totalEstudiantes == 0) {
            System.out.println("No hay estudiantes en ningún grupo.\n");
            return;
        }
        double sumaTotal = 0;
        Nodo actual = grupo1.getCabeza();
        while (actual != null) {
            sumaTotal += actual.getPromedio();
            actual = actual.getSiguiente();
        }
        actual = grupo2.getCabeza();
        while (actual != null) {
            sumaTotal += actual.getPromedio();
            actual = actual.getSiguiente();
        }
        double promedioGlobal = sumaTotal / totalEstudiantes;
        System.out.printf("\nPROMEDIO GENERAL (AMBOS GRUPOS): %.2f\n\n", promedioGlobal);
    }

    static void contarTotalEstudiantes() {
        int total1 = grupo1.contar();
        int total2 = grupo2.contar();
        int totalGeneral = total1 + total2;
        System.out.println("\nESTADÍSTICAS DE ESTUDIANTES");
        System.out.printf("Grupo 1: %d estudiantes\n", total1);
        System.out.printf("Grupo 2: %d estudiantes\n", total2);
        System.out.printf("Total General: %d estudiantes\n\n", totalGeneral);
    }

    static int obtenerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada no válida. Intenta de nuevo: ");
            scanner.nextLine();
        }
        return scanner.nextInt();
    }

    static double obtenerDouble(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.print("Entrada no válida. Intenta de nuevo: ");
            scanner.nextLine();
        }
        return scanner.nextDouble();
    }
}
