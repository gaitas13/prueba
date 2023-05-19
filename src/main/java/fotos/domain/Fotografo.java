package fotos.domain;

public class Fotografo implements Comparable{

    private String dniFotografo;
    private String nombre;
    private String apellido;
    private String direccion;
    private Camara camara;

    public String getDniFotografo() {
        return dniFotografo;
    }

    public void setDniFotografo(String dniFotografo) {
        this.dniFotografo = dniFotografo;
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

    public Camara getCamara() {
        return camara;
    }

    public void setCamara(Camara camara) {
        this.camara = camara;
    }

    public Fotografo(String dniFotografo, String nombre, String apellido, String direccion, Camara camara) {
        this.dniFotografo = dniFotografo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.camara = camara;
    }

    public Fotografo() {
    }

    @Override
    public String toString() {
        return "Fotografo{" +
                "dniFotografo='" + dniFotografo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", camara=" + camara +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
