package fotos.domain;

public class Camara implements Comparable<Camara>{

    private String idCamara;
    private String nombre;
    private int fechaFabricacion;
    private int precio;

    public String getIdCamara() {
        return idCamara;
    }

    public void setIdCamara(String idCamara) {
        this.idCamara = idCamara;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(int fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }


    public Camara(String idCamara, String nombre, int fechaFabricacion, int precio) {
        this.idCamara = idCamara;
        this.nombre = nombre;
        this.fechaFabricacion = fechaFabricacion;
        this.precio = precio;
    }

    public Camara() {
    }

    @Override
    public String toString() {
        return "Camara{" +
                "idCamara='" + idCamara + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaFabricacion=" + fechaFabricacion +
                ", precio=" + precio +
                '}';
    }

    @Override
    public int compareTo(Camara otraCamara) {
        return this.nombre.compareTo(otraCamara.idCamara);
    }
}
