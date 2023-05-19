package fotos.dao;

import fotos.domain.Camara;

import java.util.ArrayList;
import java.util.List;

public class Camaras {
    private final ArrayList<Camara> camaras;

    public Camaras(){
        this.camaras = new ArrayList<>();
        camaras.add(new Camara("id", "nombre", 2000, 100));
    }

    public Camaras(ArrayList<Camara> camaras){
        this.camaras = camaras;
    }

    public List<Camara> getListaCamaras(){
        return camaras;
    }

    public  void setListaCamaras(List<Camara> camaras){
        this.camaras.clear();
        this.camaras.addAll(camaras);
    }
}
