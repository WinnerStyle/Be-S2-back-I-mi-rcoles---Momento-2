public class Libro {
    
    private int id;
    private String titulo;
    private String autor;
    private int publicadoEn;
    private boolean disponible;

    public Libro() {}

    public Libro(int id, String titulo, String autor, int publicadoEn, boolean disponible) {
        setId(id);
        setTitulo(titulo);
        setAutor(autor);
        setPublicadoEn(publicadoEn);
        setDisponible(disponible);
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getPublicadoEn() { return publicadoEn; }
    public boolean isDisponible() { return disponible; }

    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("El id debe ser mayor a 0");
        this.id = id;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty())
            throw new IllegalArgumentException("Dame un titulo");
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty())
            throw new IllegalArgumentException("Dame el nombre del autor");
        this.autor = autor;
    }

    public void setPublicadoEn(int publicadoEn) {
        if (publicadoEn <= 0)
            throw new IllegalArgumentException("El año de publicación no puede ser negativo");
        this.publicadoEn = publicadoEn;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Libro{id=" + id + ", titulo='" + titulo + "', autor='" + autor +
               "', publicadoEn=" + publicadoEn + ", disponible=" + disponible + "}";
    }
}