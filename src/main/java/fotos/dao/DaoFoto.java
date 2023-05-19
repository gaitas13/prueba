package fotos.dao;

import fotos.domain.Camara;
import fotos.domain.Foto;

import java.util.List;

public interface DaoFoto {
    List<Foto> getListaFotos();
    boolean addFoto(Foto foto);
    boolean addFoto(String idFoto, String nombreFoto, boolean booleanColor, int fechaFoto, String idLugar, String dniFotografo);
    boolean actualizarFoto(String idFoto);
    Foto buscaFotoPorId (String idFoto);
    boolean removeFoto(Foto foto);
    boolean removeFoto(String idFoto);
    boolean clearFotos();
}
