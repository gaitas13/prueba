package fotos.dao;

import fotos.domain.Camara;

import java.util.List;

public interface DaoCamara {

    List<Camara> getListaCamaras();
    boolean addCamara(Camara camara);
    boolean addCamara(String idCamara, String nombre, int fechaFabricacion, int precio);
    boolean actualizarCamara(String idCamara);
    Camara buscaCamaraPorId(String idCamara);
    boolean removeCamara(Camara camara);
    boolean removeCamara(String idCamara);
    boolean clearCamaras();
}
