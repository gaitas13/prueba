package fotos.domain;

public class Foto implements Comparable<Foto>{

    private String idFoto;
    private String nombre;
    private boolean color;
    private int fecha;
    private Lugar lugar;
    private Fotografo fotografo;


    public String getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(String idFoto) {
        this.idFoto = idFoto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public Fotografo getFotografo() {
        return fotografo;
    }

    public void setFotografo(Fotografo fotografo) {
        this.fotografo = fotografo;
    }

    public Foto(String idFoto, String nombre, boolean color, int fecha, Lugar lugar, Fotografo fotografo) {
        this.idFoto = idFoto;
        this.nombre = nombre;
        this.color = color;
        this.fecha = fecha;
        this.lugar = lugar;
        this.fotografo = fotografo;
    }

    public Foto() {
    }

    @Override
    public String toString() {
        return "Foto{" +
                "idFoto='" + idFoto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", color=" + color +
                ", fecha=" + fecha +
                ", lugar=" + lugar +
                ", fotografo=" + fotografo +
                '}';
    }

    @Override
    public int compareTo(Foto otraFoto) {
        return this.idFoto.compareTo(otraFoto.idFoto);
    }
}
