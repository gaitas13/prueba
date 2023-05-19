package fotos.dao;


import fotos.domain.Lugar;

import java.util.*;

public class Lugares {

    private final Map<String, Lugar> lugares;

    public Lugares(){

        this.lugares = new HashMap<>();
    }

    public Lugares(Map<String, Lugar> lugares){
        this.lugares = lugares;
    }

    public Map<String, Lugar> getListaLugares(){
        return lugares;
    }

    public  void setListaLugares(Map<String, Lugar> lugares){
        this.lugares.clear();
        this.lugares.putAll(lugares);
    }


}
