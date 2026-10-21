public abstract class Usuario {
    
    private int id;
    private String nombre;
    private String correo;
    private int edad;
    
    public Usuario() {
    }

    public Usuario(int id, String nombre, String correo, int edad) {
        setId(id);
        setNombre(nombre);
        setCorreo(correo);
        setEdad(edad);
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public int getEdad() { return edad; }

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("El id debe ser mayor a 0");
        this.id = id;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("Dame el nombre");
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        if (correo == null || correo.trim().isEmpty())
            throw new IllegalArgumentException("Dame el correo");
        this.correo = correo;
    }

    public void setEdad(int edad) {
        if (edad < 0) throw new IllegalArgumentException("La edad no puede ser negativa");
        this.edad = edad;
    }

    public abstract String getRol();

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nombre='" + nombre + "', correo='" + correo +
               "', edad=" + edad + ", rol=" + getRol() + "}";
    }
}