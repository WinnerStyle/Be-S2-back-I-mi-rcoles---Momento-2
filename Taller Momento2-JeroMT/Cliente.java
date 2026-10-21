public class Cliente extends Usuario {

    private String direccion;

    public Cliente() {
        super();
    }

    public Cliente(int id, String nombre, String correo, int edad, String direccion) {
        super(id, nombre, correo, edad);
        setDireccion(direccion);
    }

    public String getDireccion() { return direccion; }

    public void setDireccion(String direccion) {
        if (direccion == null || direccion.trim().isEmpty())
            throw new IllegalArgumentException("Dame la dirección");
        this.direccion = direccion;
    }

    @Override
    public String getRol() {
        return "CLIENTE";
    }

    @Override
    public String toString() {
        return "Cliente{" + super.toString() + ", direccion='" + direccion + "'}";
    }
}