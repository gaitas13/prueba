package fotos.dao;


import fotos.domain.Encargado;

import java.util.List;
import java.util.SortedSet;

public interface DaoEncargado {
    SortedSet<Encargado> getListaEncargados();
    boolean addEncargado(Encargado encargado);

    boolean addEncargado(String idEncargado, String nombreEncargado, String apellido, String direccion, String dniFotografo);
    boolean actualizarEncargado(String idEncargado);
    Encargado buscaEncargadoPorId(String idEncargado);
    boolean removeEncargado(Encargado encargado);
    boolean removeEncargado(String idEncargado);
    boolean clearEncargados();
}
