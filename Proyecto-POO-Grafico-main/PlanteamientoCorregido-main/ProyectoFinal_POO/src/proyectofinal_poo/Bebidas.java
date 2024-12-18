package proyectofinal_poo;

import javax.swing.JOptionPane;

public class Bebidas {
    // Traer contenido de clase Empleado
    private Empleado empleado;

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Bebidas() {

    }

    public Bebidas(Empleado empleado) {
        this.empleado = empleado;

    }

    @Override
    public String toString() {
        return "Bebidas{" + "empleado=" + empleado + '}';
    }

// Métodos para seleccionar bebida con empleados asignados y verificar si ya alguno tiene bebida
    
    
    // Método de selección de bebida por empleado
    public void selectBebida(Empleado empleado, Empleado empleado1, Empleado empleado2, Empleado empleado3, int empleadoBebida[], String seleccionInicial[]) {
        // Evitar que se repita empleado
        for (int i = 0; i < empleadoBebida.length; i++) {
            empleadoBebida[i] = Integer.parseInt(JOptionPane.showInputDialog("Seleccione empleado a asignar por ID:" + "\n" + empleado1 + "\n" + empleado2 + "\n" + empleado3));

            if (empleadoBebida[i] == 1 && seleccionInicial[0] != null) {
                JOptionPane.showMessageDialog(null, empleado1.getNombre() + "  ya tiene bebida asignada");
            } else if (empleadoBebida[i] == 2 && seleccionInicial[1] != null) {
                JOptionPane.showMessageDialog(null, empleado2.getNombre() + " ya tiene bebida asignada");
            } else if (empleadoBebida[i] == 3 && seleccionInicial[2] != null) {
                JOptionPane.showMessageDialog(null, empleado3.getNombre() + " ya tiene bebida asignada");
            } else {

                if (empleadoBebida[i] == 1) {
                    bebidaSelect(empleado1, seleccionInicial, 0);
                } else if (empleadoBebida[i] == 2) {
                    bebidaSelect(empleado2, seleccionInicial, 1);
                } else if (empleadoBebida[i] == 3) {
                    bebidaSelect(empleado3, seleccionInicial, 2);
                } else {
                    JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
                    return;
                }

            }
        }
    }
    // Switch para cada bebida
    private void bebidaSelect(Empleado empleado, String[] seleccionInicial, int longitud) {
        if (seleccionInicial[longitud] != null) {
            JOptionPane.showMessageDialog(null, empleado.getNombre() + "Empleado ya tiene bebida asignada");
            return;
        }

        int bebida = Integer.parseInt(JOptionPane.showInputDialog("Selección de bebida para empleado: " + empleado + "\n 1 = Café Normal \n 2 = Capuchino\n 3 = Capuchino con Vainilla\n 4 = Chocolate\n 5 = Moka\n 6 = Té Chai\n 7 = Café Frío"));
        int respuesta;
        switch (bebida) {
            case 1:

                seleccionInicial[longitud] = empleado.getNombre() + " " + "Café Normal\nEstará listo en 5 minutos";
                JOptionPane.showMessageDialog(null, seleccionInicial);

                break;
            case 2:

                seleccionInicial[longitud] = empleado.getNombre() + " " + "Capuchino\nSegún disponibilidad estará listo en 8 minutos";
                JOptionPane.showMessageDialog(null, seleccionInicial);

                break;
            case 3:

                seleccionInicial[longitud] = empleado.getNombre() + " " + "Capuchino con Vainilla\nEstará listo en 9 minutos";
                JOptionPane.showMessageDialog(null, seleccionInicial);

                break;
            case 4:

                seleccionInicial[longitud] = empleado.getNombre() + " " + "Chocolate\nEstará listo mañana, no más chocolate en stock";
                JOptionPane.showMessageDialog(null, seleccionInicial);

                break;
            case 5:

                seleccionInicial[longitud] = empleado.getNombre() + " " + "Mocha\nEstará listo en 4 minutos";
                JOptionPane.showMessageDialog(null, seleccionInicial);

                break;
            case 6:

                seleccionInicial[longitud] = empleado.getNombre() + " " + "Te Chai\nEstará listo en 7 minutos";
                JOptionPane.showMessageDialog(null, seleccionInicial);

                break;
            case 7:

                seleccionInicial[longitud] = empleado.getNombre() + " " + "Café Frío\nEstará listo en 10 minutos";
                JOptionPane.showMessageDialog(null, seleccionInicial);

                break;
            default:
                JOptionPane.showMessageDialog(null, "No seleccionó una bebida de la lista, ordene de nuevo");
                return;

        }
    }
    // Método para repetir la asignación de bebida
    public void repetirCiclo(Empleado empleado, Empleado empleado1, Empleado empleado2, Empleado empleado3, int empleadoBebida[], String seleccionInicial[]) {

        int respuesta;
        do {
            respuesta = Integer.parseInt(JOptionPane.showInputDialog("Desea Continuar\n Sí-1\n No-2"));
            if (respuesta == 1) {
                selectBebida(empleado3, empleado1, empleado2, empleado3, empleadoBebida, seleccionInicial);
            }

        } while (respuesta != 2);

    }
    // Método de cambio de bebida
    public void cambioBebida(Empleado empleado, Empleado empleado1, Empleado empleado2, Empleado empleado3, int empleadoBebida[], String seleccionInicial[]) {
        int cambio;

        cambio = Integer.parseInt(JOptionPane.showInputDialog("Desea realizar cambio de bebida\n Sí-1\n No-2"));
        if (cambio == 1) {
            for (int i = 0; i < empleadoBebida.length; i++) {
                empleadoBebida[i] = Integer.parseInt(JOptionPane.showInputDialog("Seleccione empleado a cambiar bebida por ID:" + "\n" + empleado1 + "\n" + empleado2 + "\n" + empleado3));

                if (empleadoBebida[i] == 1) {
                    bebidaChange(empleado1, seleccionInicial, 0);
                } else if (empleadoBebida[i] == 2) {
                    bebidaChange(empleado2, seleccionInicial, 1);
                } else if (empleadoBebida[i] == 3) {
                    bebidaChange(empleado3, seleccionInicial, 2);
                } else {
                    JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
                    return;
                }

            }
        }
    }
    // Método privado para el switch de bebidas
    private void bebidaChange(Empleado empleado, String[] seleccionInicial, int longitud) {

        int bebida = Integer.parseInt(JOptionPane.showInputDialog("Selección de nueva bebida para empleado: " + empleado + "\n 1 = Café Normal \n 2 = Capuchino\n 3 = Capuchino con Vainilla\n 4 = Chocolate\n 5 = Moka\n 6 = Té Chai\n 7 = Café Frío"));
        int respuesta;
        switch (bebida) {
            case 1:

                seleccionInicial[longitud] = empleado.getNombre() + " " + "Nueva Bebida: Café Normal\nEstará listo en 5 minutos";
                JOptionPane.showMessageDialog(null, seleccionInicial);

                break;
            case 2:

                seleccionInicial[longitud] = empleado.getNombre() + " " + "Nueva Bebida: Capuchino\nSegún disponibilidad estará listo en 8 minutos";
                JOptionPane.showMessageDialog(null, seleccionInicial);

                break;
            case 3:

                seleccionInicial[longitud] = empleado.getNombre() + " " + "Nueva Bebida: Capuchino con Vainilla\nEstará listo en 9 minutos";
                JOptionPane.showMessageDialog(null, seleccionInicial);

                break;
            case 4:

                seleccionInicial[longitud] = empleado.getNombre() + " " + "Nueva Bebida: Chocolate\nEstará listo mañana, no más chocolate en stock";
                JOptionPane.showMessageDialog(null, seleccionInicial);

                break;
            case 5:

                seleccionInicial[longitud] = empleado.getNombre() + " " + "Nueva Bebida: Mocha\nEstará listo en 4 minutos";
                JOptionPane.showMessageDialog(null, seleccionInicial);

                break;
            case 6:

                seleccionInicial[longitud] = empleado.getNombre() + " " + "Nueva Bebida: Te Chai\nEstará listo en 7 minutos";
                JOptionPane.showMessageDialog(null, seleccionInicial);

                break;
            case 7:

                seleccionInicial[longitud] = empleado.getNombre() + " " + "Nueva Bebida: Café Frío\nEstará listo en 10 minutos";
                JOptionPane.showMessageDialog(null, seleccionInicial);

                break;
            default:
                JOptionPane.showMessageDialog(null, "No seleccionó una bebida de la lista, ordene de nuevo");
                return;

        }
    }
    // Método para repetir el cambio
    public void repetirCambio(Empleado empleado, Empleado empleado1, Empleado empleado2, Empleado empleado3, int empleadoBebida[], String seleccionInicial[]) {

        int respuesta;
        do {
            respuesta = Integer.parseInt(JOptionPane.showInputDialog("Desea Cambiar Otra Bebida a otro empleado\n Sí-1\n No-2"));
            if (respuesta == 1) {
                cambioBebida(empleado3, empleado1, empleado2, empleado3, empleadoBebida, seleccionInicial);
            }

        } while (respuesta != 2);

    }
}
