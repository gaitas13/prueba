package fotos.dao;

import fotos.domain.Camara;
import fotos.domain.Encargado;

import java.util.*;

public class Encargados {

    private final SortedSet<Encargado> encargados;

    public Encargados(){
        this.encargados = new TreeSet<>();
    }

    public Encargados(SortedSet<Encargado> encargados){
        this.encargados = encargados;
    }

    public SortedSet<Encargado> getListaEncargados(){
        return encargados;
    }

    public  void setListaEncargados(SortedSet<Encargado> encargados){
        this.encargados.clear();
        this.encargados.addAll(encargados);
    }
}
