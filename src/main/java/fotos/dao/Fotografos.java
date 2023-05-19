package fotos.dao;

import fotos.domain.Camara;
import fotos.domain.Fotografo;

import java.util.ArrayList;
import java.util.List;

public class Fotografos {

    private final ArrayList<Fotografo> fotografos;

    public Fotografos(){
        this.fotografos = new ArrayList<>();
    }

    public Fotografos(ArrayList<Fotografo> fotografos){
        this.fotografos = fotografos;
    }

    public List<Fotografo> getListaFotografos(){
        return fotografos;
    }

    public  void setListaFotografos(List<Fotografo> fotografos){
        this.fotografos.clear();
        this.fotografos.addAll(fotografos);
    }
}
