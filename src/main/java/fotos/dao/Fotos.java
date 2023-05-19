package fotos.dao;

import fotos.domain.Camara;
import fotos.domain.Foto;

import java.util.ArrayList;
import java.util.List;

public class Fotos {

    private final ArrayList<Foto> fotos;

    public Fotos(){
        this.fotos = new ArrayList<>();

    }

    public Fotos(ArrayList<Foto> fotos){
        this.fotos = fotos;
    }

    public List<Foto> getListaFotos(){
        return fotos;
    }

    public  void setListaFotos(List<Foto> fotos){
        this.fotos.clear();
        this.fotos.addAll(fotos);
    }
}
