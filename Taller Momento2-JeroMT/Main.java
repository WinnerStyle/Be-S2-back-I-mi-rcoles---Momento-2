import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {
        cargarDatosDePrueba();
        int opcion;
        do {
            mostrarMenuPrincipal();
            opcion = leerEntero("Seleccione una opción: ");
            switch (opcion) {
                case 1 -> menuLibros();
                case 2 -> menuUsuarios();
                case 3 -> menuEmpleados();
                case 4 -> menuReservas();
                case 5 -> listarTodo();
                case 0 -> System.out.println("Saliendo del sistema.");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
        sc.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\nBIBLIOTECA MENU");
        System.out.println("1. Gestionar Libros");
        System.out.println("2. Gestionar Usuarios");
        System.out.println("3. Gestionar Empleados");
        System.out.println("4. Gestionar Reservas");
        System.out.println("5. Listar TODO");
        System.out.println("0. Salir");
    }

    private static void menuLibros() {
        int op;
        do {
            System.out.println("\nLIBROS");
            System.out.println("1. Crear  2. Listar  3. Buscar  4. Eliminar  0. Volver");
            op = leerEntero("Opción: ");
            switch (op) {
                case 1 -> crearLibro();
                case 2 -> listar(biblioteca.getLibroService().listar(), "LIBROS");
                case 3 -> {
                    int id = leerEntero("ID del libro: ");
                    Libro l = biblioteca.getLibroService().buscar(id);
                    System.out.println(l != null ? l : "No encontrado");
                }
                case 4 -> {
                    int id = leerEntero("ID a eliminar: ");
                    System.out.println(biblioteca.getLibroService().eliminar(id)
                            ? "Eliminado" : "No encontrado");
                }
            }
        } while (op != 0);
    }

    private static void menuUsuarios() {
        int op;
        do {
            System.out.println("\nUSUARIOS");
            System.out.println("1. Crear  2. Listar  3. Buscar  4. Eliminar  0. Volver");
            op = leerEntero("Opción: ");
            switch (op) {
                case 1 -> crearUsuario();
                case 2 -> listarUsuariosPolimorfico();
                case 3 -> {
                    int id = leerEntero("ID del usuario: ");
                    Usuario u = biblioteca.getUsuarioService().buscar(id);
                    System.out.println(u != null ? u : "No encontrado");
                }
                case 4 -> {
                    int id = leerEntero("ID a eliminar: ");
                    System.out.println(biblioteca.getUsuarioService().eliminar(id)
                            ? "Eliminado" : "No encontrado");
                }
            }
        } while (op != 0);
    }

    private static void menuEmpleados() {
        int op;
        do {
            System.out.println("\nEMPLEADOS");
            System.out.println("1. Crear  2. Listar  3. Buscar  4. Eliminar  0. Volver");
            op = leerEntero("Opción: ");
            switch (op) {
                case 1 -> crearEmpleado();
                case 2 -> listar(biblioteca.getEmpleadoService().listar(), "EMPLEADOS");
                case 3 -> {
                    int id = leerEntero("ID del empleado: ");
                    Empleado e = biblioteca.getEmpleadoService().buscar(id);
                    System.out.println(e != null ? e : "No encontrado");
                }
                case 4 -> {
                    int id = leerEntero("ID a eliminar: ");
                    System.out.println(biblioteca.getEmpleadoService().eliminar(id)
                            ? "Eliminado" : "No encontrado");
                }
            }
        } while (op != 0);
    }

    private static void menuReservas() {
        int op;
        do {
            System.out.println("\nRESERVAS");
            System.out.println("1. Crear  2. Listar  3. Buscar  4. Eliminar  0. Volver");
            op = leerEntero("Opción: ");
            switch (op) {
                case 1 -> crearReserva();
                case 2 -> listar(biblioteca.getReservaService().listar(), "RESERVAS");
                case 3 -> {
                    int id = leerEntero("ID de la reserva: ");
                    Reserva r = biblioteca.getReservaService().buscar(id);
                    System.out.println(r != null ? r : "No encontrada");
                }
                case 4 -> {
                    int id = leerEntero("ID a eliminar: ");
                    System.out.println(biblioteca.getReservaService().eliminar(id)
                            ? "Eliminada" : "No encontrada");
                }
            }
        } while (op != 0);
    }

    private static void crearLibro() {
        try {
            int id = leerEntero("ID: ");
            System.out.print("Título: ");
            String titulo = sc.nextLine();
            System.out.print("Autor: ");
            String autor = sc.nextLine();
            int anio = leerEntero("Año de publicación: ");
            System.out.print("¿Disponible? (s/n): ");
            boolean disp = sc.nextLine().equalsIgnoreCase("s");
            biblioteca.getLibroService().guardar(new Libro(id, titulo, autor, anio, disp));
            System.out.println("Libro creado.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void crearUsuario() {
        try {
            System.out.println("Tipo: 1) Cliente  2) Administrador");
            int tipo = leerEntero("Opción: ");
            int id = leerEntero("ID: ");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Correo: ");
            String correo = sc.nextLine();
            int edad = leerEntero("Edad: ");

            Usuario u;
            if (tipo == 1) {
                System.out.print("Dirección: ");
                String dir = sc.nextLine();
                u = new Cliente(id, nombre, correo, edad, dir);
            } else {
                System.out.print("Nivel de acceso: ");
                String nivel = sc.nextLine();
                u = new Administrador(id, nombre, correo, edad, nivel);
            }
            biblioteca.getUsuarioService().guardar(u);
            System.out.println("Usuario creado.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void crearEmpleado() {
        try {
            int id = leerEntero("ID: ");
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            int edad = leerEntero("Edad: ");
            System.out.print("Cargo: ");
            String cargo = sc.nextLine();
            biblioteca.getEmpleadoService().guardar(new Empleado(id, nombre, edad, cargo));
            System.out.println("Empleado creado.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void crearReserva() {
        try {
            int id = leerEntero("ID reserva: ");
            int idUsuario = leerEntero("ID usuario: ");
            Usuario u = biblioteca.getUsuarioService().buscar(idUsuario);
            if (u == null) { System.out.println("Usuario no existe."); return; }

            int idLibro = leerEntero("ID libro: ");
            Libro l = biblioteca.getLibroService().buscar(idLibro);
            if (l == null) { System.out.println("Libro no existe."); return; }

            System.out.print("Fecha (dd/mm/aaaa): ");
            String fecha = sc.nextLine();
            System.out.print("Estado (Activa/Cancelada): ");
            String estado = sc.nextLine();

            biblioteca.getReservaService().guardar(new Reserva(id, u, l, fecha, estado));
            System.out.println("Reserva creada.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void listarUsuariosPolimorfico() {
        List<Usuario> usuarios = biblioteca.getUsuarioService().listar();
        if (usuarios.isEmpty()) { System.out.println("(Sin usuarios)"); return; }

        System.out.println("\nUSUARIOS (POLIMORFISMO)");
        for (Usuario u : usuarios) {
            System.out.println("- [" + u.getRol() + "] " + u.getNombre() +
                               " (ID " + u.getId() + ")");
        }
    }

    private static void listarTodo() {
        listar(biblioteca.getLibroService().listar(), "LIBROS");
        listarUsuariosPolimorfico();
        listar(biblioteca.getEmpleadoService().listar(), "EMPLEADOS");
        listar(biblioteca.getReservaService().listar(), "RESERVAS");
    }

    private static <T> void listar(List<T> lista, String titulo) {
        System.out.println("\n" + titulo);
        if (lista.isEmpty()) { System.out.println("(vacío)"); return; }
        for (T item : lista) {
            System.out.println(item);
        }
    }

    private static int leerEntero(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }

    private static void cargarDatosDePrueba() {
        biblioteca.getLibroService().guardar(new Libro(1, "Cien años de soledad",
                "Gabriel García Márquez", 1967, true));
        biblioteca.getLibroService().guardar(new Libro(2, "Don Quijote de la Mancha",
                "Miguel de Cervantes", 1605, true));

        biblioteca.getUsuarioService().guardar(new Cliente(1, "Carlos",
                "carlos@gmail.com", 18, "Calle 123"));
        biblioteca.getUsuarioService().guardar(new Administrador(2, "Laura",
                "laura@gmail.com", 20, "TOTAL"));

        biblioteca.getEmpleadoService().guardar(new Empleado(1, "Pedro", 30, "Bibliotecario"));

        biblioteca.getReservaService().guardar(new Reserva(1,
                biblioteca.getUsuarioService().buscar(1),
                biblioteca.getLibroService().buscar(1),
                "14/09/2026", "Activa"));
    }
}