package fotos.dao;

import fotos.domain.Camara;
import fotos.domain.Foto;
import fotos.domain.Fotografo;

import java.util.List;

public interface DaoFotografo {

    List<Fotografo> getListaFotografos();
    boolean addFotografo(Fotografo fotografo);
    boolean addFotografo(String dniFotografo, String nombre, String apellido, String direccion, String idCamara);
    boolean actualizarFotografo(String idFotografo);
    Fotografo buscaFotografoPorId (String dniFotografo);
    boolean removeFotografo(Fotografo fotografo);
    boolean removeFotografo(String idFotografo);
    boolean clearFotografos();
}
