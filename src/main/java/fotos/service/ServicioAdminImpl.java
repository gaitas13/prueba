package fotos.service;

import fotos.dao.*;
import fotos.domain.*;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;

public class ServicioAdminImpl implements ServicioAdmin{
    private final DaoCamara daoCamara;
    private final DaoLugar daoLugar;
    private final DaoFoto daoFoto;
    private final DaoFotografo daoFotografo;
    private final DaoEncargado daoEncargado;

    public ServicioAdminImpl(){
        this.daoCamara = new DaoCamaraImpl();
        this.daoLugar = new DaoLugarImpl();
        this.daoFoto = new DaoFotoImpl();
        this.daoFotografo = new DaoFotografoImpl();
        this.daoEncargado = new DaoEncargadoImpl();
    }
    @Override
    public List<Camara> getListaCamaras() {
        return daoCamara.getListaCamaras();
    }

    @Override
    public boolean addCamara(Camara camara) {
        return daoCamara.addCamara(camara);
    }

    @Override
    public boolean addCamara(String idCamara, String nombre, int fechaFabricacion, int precio) {
        return daoCamara.addCamara(idCamara, nombre, fechaFabricacion, precio);
    }

    @Override
    public boolean actualizarCamara(String idCamara) {
        return daoCamara.actualizarCamara(idCamara);
    }

    @Override
    public boolean borrarCamara(String idCamara) {
        return daoCamara.removeCamara(idCamara);
    }

    @Override
    public boolean borrarCamaraAll(){
        return daoCamara.clearCamaras();
    }

    @Override
    public Map<String, Lugar> getListaLugares() {
        return daoLugar.getListaLugares();
    }

    @Override
    public boolean addLugar(Lugar lugar) {
        return daoLugar.addLugar(lugar);
    }

    @Override
    public boolean actualizarLugar(String idLugar) {
        return daoLugar.actualizarLugar(idLugar);
    }

    @Override
    public boolean borrarLugar(String idLugar) {
        return daoLugar.removeLugar(idLugar);
    }

    @Override
    public boolean borrarLugarAll(){
        return daoLugar.clearLugares();
    }

    @Override
    public List<Foto> getListaFotos() {
        return daoFoto.getListaFotos();
    }

    @Override
    public boolean addFoto(Foto foto) {
        return daoFoto.addFoto(foto);
    }

    @Override
    public boolean addFoto(String idFoto, String nombreFoto, boolean booleanColor, int fechaFoto, String idLugar, String idFotografo) {
        return daoFoto.addFoto(idFoto, nombreFoto, booleanColor, fechaFoto, idLugar, idFotografo);
    }

    @Override
    public boolean actualizarFoto(String idFoto) {
        return daoFoto.actualizarFoto(idFoto);
    }

    @Override
    public boolean borrarFoto(String idFoto) {
        return daoFoto.removeFoto(idFoto);
    }

    @Override
    public boolean borrarFotoAll(){
        return daoFoto.clearFotos();
    }

    @Override
    public List<Fotografo> getListaFotografos() {
        return daoFotografo.getListaFotografos();
    }

    @Override
    public boolean addFotografo(Fotografo fotografo) {
        return daoFotografo.addFotografo(fotografo);
    }

    @Override
    public boolean addFotografo(String dniFotografo, String nombre, String apellido, String direccion, String idCamara) {
        return daoFotografo.addFotografo(dniFotografo, nombre, apellido, direccion, idCamara);
    }

    @Override
    public boolean actualizarFotografo(String idFotografo) {
        return daoFotografo.actualizarFotografo(idFotografo);
    }

    @Override
    public boolean borrarFotografo(String idFotografo) {
        return daoFotografo.removeFotografo(idFotografo);
    }

    @Override
    public boolean borrarFotografoAll(){
        return daoFotografo.clearFotografos();
    }
    @Override
    public SortedSet<Encargado> getListaEncargados() {
        return daoEncargado.getListaEncargados();
    }

    @Override
    public boolean addEncargado(Encargado encargado) {
        return daoEncargado.addEncargado(encargado);
    }

    @Override
    public boolean addEncargado(String idEncargado, String nombreEncargado, String apellido, String direccion, String idCamara) {
        return daoEncargado.addEncargado(idEncargado, nombreEncargado, apellido, direccion, idCamara);
    }

    @Override
    public boolean actualizarEncargado(String idEncargado) {
        return daoEncargado.actualizarEncargado(idEncargado);
    }

    @Override
    public boolean borrarEncargado(String idEncargado) {
        return daoEncargado.removeEncargado(idEncargado);
    }

    @Override
    public boolean borrarEncargadoAll() {
        return daoEncargado.clearEncargados();
    }
}
