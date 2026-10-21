import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private final LibroService libroService;
    private final UsuarioService usuarioService;
    private final EmpleadoService empleadoService;
    private final ReservaService reservaService;

    public Biblioteca() {
        this.libroService = new LibroService();
        this.usuarioService = new UsuarioService();
        this.empleadoService = new EmpleadoService();
        this.reservaService = new ReservaService();
    }

    public LibroService getLibroService() { return libroService; }
    public UsuarioService getUsuarioService() { return usuarioService; }
    public EmpleadoService getEmpleadoService() { return empleadoService; }
    public ReservaService getReservaService() { return reservaService; }

    public static class LibroService implements IOperaciones<Libro> {
        private final List<Libro> libros = new ArrayList<>();

        @Override
        public void guardar(Libro libro) {
            if (libro == null) throw new IllegalArgumentException("El libro no puede ser nulo");
            if (buscar(libro.getId()) != null)
                throw new IllegalArgumentException("Ya existe un libro con ese id");
            libros.add(libro);
        }

        @Override
        public Libro buscar(int id) {
            return libros.stream().filter(l -> l.getId() == id).findFirst().orElse(null);
        }

        @Override
        public boolean eliminar(int id) {
            return libros.removeIf(l -> l.getId() == id);
        }

        @Override
        public List<Libro> listar() { return libros; }
    }

    public static class UsuarioService implements IOperaciones<Usuario> {
        private final List<Usuario> usuarios = new ArrayList<>();

        @Override
        public void guardar(Usuario usuario) {
            if (usuario == null) throw new IllegalArgumentException("El usuario no puede ser nulo");
            if (buscar(usuario.getId()) != null)
                throw new IllegalArgumentException("Ya existe un usuario con ese id");
            usuarios.add(usuario);
        }

        @Override
        public Usuario buscar(int id) {
            return usuarios.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
        }

        @Override
        public boolean eliminar(int id) {
            return usuarios.removeIf(u -> u.getId() == id);
        }

        @Override
        public List<Usuario> listar() { return usuarios; }
    }

    public static class EmpleadoService implements IOperaciones<Empleado> {
        private final List<Empleado> empleados = new ArrayList<>();

        @Override
        public void guardar(Empleado empleado) {
            if (empleado == null) throw new IllegalArgumentException("El empleado no puede ser nulo");
            if (buscar(empleado.getId()) != null)
                throw new IllegalArgumentException("Ya existe un empleado con ese id");
            empleados.add(empleado);
        }

        @Override
        public Empleado buscar(int id) {
            return empleados.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        }

        @Override
        public boolean eliminar(int id) {
            return empleados.removeIf(e -> e.getId() == id);
        }

        @Override
        public List<Empleado> listar() { return empleados; }
    }

    public static class ReservaService implements IOperaciones<Reserva> {
        private final List<Reserva> reservas = new ArrayList<>();

        @Override
        public void guardar(Reserva reserva) {
            if (reserva == null) throw new IllegalArgumentException("La reserva no puede ser nula");
            if (buscar(reserva.getId()) != null)
                throw new IllegalArgumentException("Ya existe una reserva con ese id");
            reservas.add(reserva);
        }

        @Override
        public Reserva buscar(int id) {
            return reservas.stream().filter(r -> r.getId() == id).findFirst().orElse(null);
        }

        @Override
        public boolean eliminar(int id) {
            return reservas.removeIf(r -> r.getId() == id);
        }

        @Override
        public List<Reserva> listar() { return reservas; }
    }
}