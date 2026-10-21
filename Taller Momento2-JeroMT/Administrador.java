public class Administrador extends Usuario {

    private String nivelAcceso;

    public Administrador() {
        super();
    }

    public Administrador(int id, String nombre, String correo, int edad, String nivelAcceso) {
        super(id, nombre, correo, edad);
        setNivelAcceso(nivelAcceso);
    }

    public String getNivelAcceso() { return nivelAcceso; }

    public void setNivelAcceso(String nivelAcceso) {
        if (nivelAcceso == null || nivelAcceso.trim().isEmpty())
            throw new IllegalArgumentException("Dame el nivel de acceso");
        this.nivelAcceso = nivelAcceso;
    }

    @Override
    public String getRol() {
        return "ADMINISTRADOR";
    }

    @Override
    public String toString() {
        return "Administrador{" + super.toString() + ", nivelAcceso='" + nivelAcceso + "'}";
    }
}