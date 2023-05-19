package fotos.domain;

public class Lugar implements Comparable{
    private String idLugar;
    private String nombre;
    private String pais;
    private String localidad;


    public String getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(String idLugar) {
        this.idLugar = idLugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Lugar(String idLugar, String nombre, String pais, String localidad) {
        this.idLugar = idLugar;
        this.nombre = nombre;
        this.pais = pais;
        this.localidad = localidad;
    }

    public Lugar() {
    }

    @Override
    public String toString() {
        return "Lugar{" +
                "idLugar='" + idLugar + '\'' +
                ", nombre='" + nombre + '\'' +
                ", pais=" + pais +
                ", localidad=" + localidad +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
