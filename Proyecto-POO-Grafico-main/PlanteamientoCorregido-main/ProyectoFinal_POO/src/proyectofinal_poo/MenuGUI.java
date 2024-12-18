package proyectofinal_poo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class MenuGUI extends JFrame {

    //Creacion de los botones 
    private JButton btnCine;
    private JButton btnGimnasio;
    private JButton btnClases;
    private JButton btnBebidas;
    private JButton btnSalir;
    
    //Informacion de los empleados precargada
    private static Empleado[] empleados = {
        new Empleado(1, "Tilin"),
        new Empleado(2, "Ana"),
        new Empleado(3, "David"),
        new Empleado(4, "Indefinido")
    };

    public MenuGUI() {
        setTitle("Menu de Actividades");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configurar el diseño del panel 
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10); // Espaciado entre botones

        // A los botones creados se les importa el diseno y titulos
        btnCine = new JButton("Cine");
        btnGimnasio = new JButton("Gimnasio");
        btnClases = new JButton("Clases");
        btnBebidas = new JButton("Bebidas");
        btnSalir = new JButton("Salir");

        // Asignar estilos a los botones
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        btnCine.setFont(buttonFont);
        btnGimnasio.setFont(buttonFont);
        btnClases.setFont(buttonFont);
        btnBebidas.setFont(buttonFont);
        btnSalir.setFont(buttonFont);

        btnCine.setBackground(Color.LIGHT_GRAY);
        btnGimnasio.setBackground(Color.LIGHT_GRAY);
        btnClases.setBackground(Color.LIGHT_GRAY);
        btnBebidas.setBackground(Color.LIGHT_GRAY);
        btnSalir.setBackground(Color.RED);
        btnSalir.setForeground(Color.WHITE);

        // Añadir botones al panel
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        panel.add(btnCine, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        panel.add(btnGimnasio, c);

        c.gridx = 1;
        c.gridy = 1;
        panel.add(btnClases, c);

        c.gridx = 0;
        c.gridy = 2;
        panel.add(btnBebidas, c);

        c.gridx = 1;
        c.gridy = 2;
        c.anchor = GridBagConstraints.SOUTHEAST;
        panel.add(btnSalir, c);
        
        //Al presionar el boton se llama las funciones para cada menu
        btnCine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarCine();
            }
        });

        btnGimnasio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarGimnasio();
            }
        });

        btnClases.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarClases();
            }
        });

        btnBebidas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarBebidas();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(panel);
    }

    private void ejecutarCine() {
        Cine cine = new Cine("Pelicula Default Sala 1", "Pelicula Default Sala 2");
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nMenu Cine:");
            System.out.println("1-Mostrar salas");
            System.out.println("2-Modificar pelicula");
            System.out.println("3-Asignar asiento");
            System.out.println("4-Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado de las salas:");
                    cine.mostrarSalas();
                    break;
                case 2:
                    System.out.print("Ingrese el numero de sala (1 o 2): ");
                    int sala = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el nuevo nombre de la pelicula: ");
                    String nuevaPelicula = scanner.nextLine();
                    cine.setPelicula(sala, nuevaPelicula);
                    break;
                case 3:
                    System.out.print("Ingrese el numero de sala (1 o 2): ");
                    int salaAsignar = scanner.nextInt();
                    System.out.print("Ingrese la fila (A-E): ");
                    char filaChar = scanner.next().toUpperCase().charAt(0);
                    System.out.print("Ingrese la columna (1-6): ");
                    int columna = scanner.nextInt();

                    int fila = filaChar - 'A';
                    System.out.print("Ingrese el ID del empleado: ");
                    int idEmpleado = scanner.nextInt();

                    Empleado empleado = buscarEmpleadoPorId(idEmpleado);
                    if (empleado != null) {
                        cine.asignarAsiento(salaAsignar, fila, columna - 1, empleado.getNombre());
                    } else {
                        System.out.println("Empleado no encontrado");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del menú cine...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo");
            }
        } while (opcion != 4);
    }

    private void ejecutarGimnasio() {
        Gimnasio gym = new Gimnasio();
        gym.SelectGym();
    }

    private void ejecutarClases() {
        Clases clases = new Clases();
        clases.iniciarMenu();
    }

    private void ejecutarBebidas() {
        Bebidas bebidas = new Bebidas();
        int[] empleadoBebida = new int[1];
        String[] seleccionInicial = new String[3];
        bebidas.selectBebida(new Empleado(3, "David"), new Empleado(1, "Tilin"), new Empleado(2, "Ana"), new Empleado(3, "David"), empleadoBebida, seleccionInicial);
        bebidas.repetirCiclo(new Empleado(3, "David"), new Empleado(1, "Tilin"), new Empleado(2, "Ana"), new Empleado(3, "David"), empleadoBebida, seleccionInicial);
        bebidas.cambioBebida(new Empleado(3, "David"), new Empleado(1, "Tilin"), new Empleado(2, "Ana"), new Empleado(3, "David"), empleadoBebida, seleccionInicial);
        bebidas.repetirCambio(new Empleado(3, "David"), new Empleado(1, "Tilin"), new Empleado(2, "Ana"), new Empleado(3, "David"), empleadoBebida, seleccionInicial);
    }

    private static Empleado buscarEmpleadoPorId(int id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id) {
                return empleado;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuGUI().setVisible(true);
            }
        });
    }
}
