/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal_poo;

import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class Gimnasio {

    private static final String[] HORARIOS = {"2 pm", "3 pm", "4 pm", "5 pm", "6 pm", "7 pm"};
    private static final Empleado[] RESERVAS = new Empleado[HORARIOS.length];

    public static void SelectGym() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Sistema de Reservas del Gimnasio ---");
            System.out.println("1. Reservar cita con el entrenador");
            System.out.println("2. Consultar citas");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            //Menu del apartado de uso del gym
            switch (opcion) {
                case 1:
                    realizarReserva(scanner);
                    break;
                case 2:
                    consultarCitas();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }
    }

    //Instancia que permite realizar una reserva en el gym
    private static void realizarReserva(Scanner scanner) {
        System.out.print("Ingrese el ID del empleado: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();

        //Muestra los horarios disponibles 
        System.out.println("Horarios disponibles:");
        for (int i = 0; i < HORARIOS.length; i++) {
            if (RESERVAS[i] == null) {
                System.out.println((i + 1) + ". " + HORARIOS[i]);
            }
        }
        //Permite a la recepcionista realizar la eleccion del horario
        System.out.print("Seleccione un horario: ");
        int seleccion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        if (seleccion > 0 && seleccion <= HORARIOS.length) {
            int index = seleccion - 1;
            if (RESERVAS[index] == null) {
                RESERVAS[index] = new Empleado(id, nombre);
                System.out.println("¡Reserva realizada con éxito!");
            } else {
                System.out.println("Ese horario ya está reservado.");
            }
        } else {
            System.out.println("Selección inválida.");
        }
    }

    //Instancia que permite consultar las citas ya agendadas
    private static void consultarCitas() {
        System.out.println("\n--- Citas Programadas ---");
        boolean hayCitas = false;

        for (int i = 0; i < HORARIOS.length; i++) {
            if (RESERVAS[i] != null) {
                System.out.println("Horario: " + HORARIOS[i] + " - Empleado: " + RESERVAS[i].getNombre());
                hayCitas = true;
            }
        }

        if (!hayCitas) {
            System.out.println("No hay citas programadas.");
        }
    }

}
