package fotos.dao;

import fotos.domain.Camara;
import fotos.domain.Lugar;

import java.util.List;
import java.util.Map;

public interface DaoLugar {
    Map<String, Lugar> getListaLugares();
    boolean addLugar(Lugar lugar);
    boolean addLugar(String idLugar, String nombreLugar, String pais, String localidad);
    boolean actualizarLugar(String idLugar);
    Lugar buscaLugarPorId (String idLugar);
    boolean removeLugar(Lugar lugar);
    boolean removeLugar(String idLugar);
    boolean clearLugares();
}
