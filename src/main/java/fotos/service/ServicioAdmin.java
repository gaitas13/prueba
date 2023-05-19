package fotos.service;

import fotos.domain.*;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;

public interface ServicioAdmin {

    List<Camara> getListaCamaras();
    boolean addCamara(Camara camara);
    boolean addCamara(String idCamara, String nombre, int fechaFabricacion, int precio);
    boolean actualizarCamara(String idCamara);
    boolean borrarCamara(String idCamara);
    boolean borrarCamaraAll();

    Map<String, Lugar> getListaLugares();
    boolean addLugar(Lugar lugar);
    boolean actualizarLugar(String idLugar);
    boolean borrarLugar(String idLugar);
    boolean borrarLugarAll();

    List<Foto> getListaFotos();
    boolean addFoto(Foto foto);
    boolean addFoto(String idFoto, String nombreFoto, boolean booleanColor, int fechaFoto, String idLugar, String idFotografo);
    boolean actualizarFoto(String idFoto);
    boolean borrarFoto(String idFoto);
    boolean borrarFotoAll();
    List<Fotografo> getListaFotografos();
    boolean addFotografo(Fotografo fotografo);
    boolean addFotografo(String dniFotografo, String nombre, String apellido, String direccion, String idCamara);
    boolean actualizarFotografo(String dniFotografo);
    boolean borrarFotografo(String dniFotografo);
    boolean borrarFotografoAll();

    SortedSet<Encargado> getListaEncargados();
    boolean addEncargado(Encargado encargado);
    boolean addEncargado(String idEncargado, String nombreEncargado, String apellido, String direccion, String idCamara);

    boolean actualizarEncargado(String idEncargado);
    boolean borrarEncargado(String idEncargado);
    boolean borrarEncargadoAll();

}
