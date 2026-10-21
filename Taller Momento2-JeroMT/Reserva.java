public class Reserva {
    
    private int id;
    private Usuario usuario;
    private Libro libro;
    private String fechaReserva;
    private String estado;

    public Reserva() {}
    
    public Reserva(int id, Usuario usuario, Libro libro, String fechaReserva, String estado) {
        setId(id);
        setUsuario(usuario);
        setLibro(libro);
        setFechaReserva(fechaReserva);
        setEstado(estado);
    }

    public int getId() { return id; }
    public Usuario getUsuario() { return usuario; }
    public Libro getLibro() { return libro; }
    public String getFechaReserva() { return fechaReserva; }
    public String getEstado() { return estado; }

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("El id debe ser mayor que 0");
        this.id = id;
    }

    public void setUsuario(Usuario usuario) {
        if (usuario == null) throw new IllegalArgumentException("Dame el usuario");
        this.usuario = usuario;
    }

    public void setLibro(Libro libro) {
        if (libro == null) throw new IllegalArgumentException("Dame el libro");
        this.libro = libro;
    }

    public void setFechaReserva(String fechaReserva) {
        if (fechaReserva == null || fechaReserva.trim().isEmpty())
            throw new IllegalArgumentException("Dame la fecha de reserva");
        this.fechaReserva = fechaReserva;
    }

    public void setEstado(String estado) {
        if (estado == null || estado.trim().isEmpty())
            throw new IllegalArgumentException("Dame el estado");
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Reserva{id=" + id + ", usuario='" + usuario.getNombre() +
               "', libro='" + libro.getTitulo() + "', fecha='" + fechaReserva +
               "', estado='" + estado + "'}";
    }
}