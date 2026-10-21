public class Empleado {
    
    private int id;
    private String nombre;
    private int edad;
    private String cargo;

    public Empleado() {}

    public Empleado(int id, String nombre, int edad, String cargo) {
        setId(id);
        setNombre(nombre);
        setEdad(edad);
        setCargo(cargo);
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getCargo() { return cargo; }

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("El id debe de ser mayor que 0");
        this.id = id;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("Dame el nombre");
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        if (edad < 0) throw new IllegalArgumentException("La edad no puede ser negativa");
        this.edad = edad;
    }

    public void setCargo(String cargo) {
        if (cargo == null || cargo.trim().isEmpty())
            throw new IllegalArgumentException("Dame el cargo");
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Empleado{id=" + id + ", nombre='" + nombre + "', edad=" + edad +
               ", cargo='" + cargo + "'}";
    }
}