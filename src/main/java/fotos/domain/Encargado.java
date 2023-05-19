package fotos.domain;

public class Encargado implements Comparable{

    private String idEncargado;
    private String nombre;
    private String apellido;
    private String direccion;
    private Fotografo fotografo;


    public String getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(String idEncargado) {
        this.idEncargado = idEncargado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Fotografo getFotografo() {
        return fotografo;
    }

    public void setFotografo(Fotografo fotografo) {
        this.fotografo = fotografo;
    }

    public Encargado(String idEncargado, String nombre, String apellido, String direccion, Fotografo fotografo) {
        this.idEncargado = idEncargado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.fotografo = fotografo;
    }

    public Encargado() {
    }

    @Override
    public String toString() {
        return "Encargado{" +
                "idEncargado='" + idEncargado + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fotografo=" + fotografo +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
