/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal_poo;

/**
 *
 * @author Joseph
 */
import java.util.Scanner;

public class Clases {

    private int espaciosYoga = 30;
    private int espaciosBaile = 30;  // Se crean los 30 espacios para la clase de Baile

    public void reservarEspacioYoga(Empleado empleado) {
        if (espaciosYoga > 0) {
            espaciosYoga--;
            System.out.println("Espacio reservado para Yoga por " + empleado.getNombre() + ". Espacios restantes: " + espaciosYoga);
        } else {
            System.out.println("No hay mas espacios disponibles para Yoga.");
        }
    }

    public void liberarEspacioYoga() {
        if (espaciosYoga < 30) {
            espaciosYoga++;
            System.out.println("Espacio liberado para Yoga. Espacios restantes: " + espaciosYoga);
        } else {
            System.out.println("No se pueden liberar mas espacios para Yoga.");
        }
    }

    public void reservarEspacioBaile(Empleado empleado) {
        if (espaciosBaile > 0) {
            espaciosBaile--;
            System.out.println("Espacio reservado para Baile por " + empleado.getNombre() + ". Espacios restantes: " + espaciosBaile);
        } else {
            System.out.println("No hay mas espacios disponibles para Baile.");
        }
    }

    public void liberarEspacioBaile() {
        if (espaciosBaile < 30) {
            espaciosBaile++;
            System.out.println("Espacio liberado para Baile. Espacios restantes: " + espaciosBaile);
        } else {
            System.out.println("No se pueden liberar mas espacios para Baile.");
        }
    }

    public void iniciarMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el ID del empleado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        Empleado empleado = new Empleado(id, nombre);

        boolean salir = false;
        while (!salir) {
            System.out.println("\nMenu Principal:");
            System.out.println("1. Gestion de Clases");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    boolean regresar = false;
                    while (!regresar) {
                        System.out.println("\nGestion de Clases:");
                        System.out.println("1. Reservar espacio en Yoga");
                        System.out.println("2. Liberar espacio en Yoga");
                        System.out.println("3. Reservar espacio en Baile");
                        System.out.println("4. Liberar espacio en Baile");
                        System.out.println("5. Regresar al Menú Principal");
                        System.out.print("Seleccione una opción: ");

                        int opcionClase = scanner.nextInt();

                        switch (opcionClase) {
                            case 1:
                                reservarEspacioYoga(empleado);
                                break;
                            case 2:
                                liberarEspacioYoga();
                                break;
                            case 3:
                                reservarEspacioBaile(empleado);
                                break;
                            case 4:
                                liberarEspacioBaile();
                                break;
                            case 5:
                                regresar = true;
                                break;
                            default:
                                System.out.println("Opcion no valida");
                        }
                    }
                    break;
                case 2:
                    salir = true;
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }

        scanner.close();
    }
}
