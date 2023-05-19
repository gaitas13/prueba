package fotos.dao;


import fotos.domain.Encargado;
import fotos.domain.Fotografo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class DaoEncargadoImpl implements DaoEncargado {

    Logger logger = LogManager.getRootLogger();

    protected final Encargados listaEncargados;

    private final DaoFotografoImpl daoFotografo = new DaoFotografoImpl();

    public DaoEncargadoImpl() {
        this.listaEncargados = new Encargados();
    }

    @Override
    public SortedSet<Encargado> getListaEncargados() {
        return listaEncargados.getListaEncargados();
    }

    @Override
    public boolean addEncargado(Encargado encargado) {
        return listaEncargados.getListaEncargados().add(encargado);
    }

    @Override
    public boolean addEncargado(String idEncargado, String nombreEncargado, String apellido, String direccion, String dniFotografo) {
        if (buscaEncargadoPorId(idEncargado)== null){
            Fotografo auxFotografo = daoFotografo.buscaFotografoPorId(dniFotografo);
            return listaEncargados.getListaEncargados().add(new Encargado(idEncargado, nombreEncargado, apellido, direccion, auxFotografo));
        }
        else{
            logger.info("el encargado ya existe");
            return false;
        }
    }

    @Override
    public boolean actualizarEncargado(String idEncargado) {
        Scanner scanner = new Scanner(System.in);
        boolean boolActu = false;
        Encargado aux = buscaEncargadoPorId(idEncargado);
        if (aux != null){
            logger.info("elige nuevo id");
            String auxIdEncargado = scanner.nextLine();
            logger.info("elige nuevo nombre");
            String auxNombre = scanner.nextLine();
            logger.info("elige nueva fecha");
            String auxApellido = scanner.nextLine();
            logger.info("elige nuevo precio");
            String auxDireccion = scanner.nextLine();
            logger.info("elige nuevo fotografo (id fotografo)");
            Fotografo auxFotografo = daoFotografo.buscaFotografoPorId(scanner.nextLine());
            aux.setIdEncargado(auxIdEncargado);
            aux.setNombre(auxNombre);
            aux.setApellido(auxApellido);
            aux.setDireccion(auxDireccion);
            aux.setFotografo(auxFotografo);
            boolActu = true;
        }
        else {
            logger.info("el encargado no existe");
        }


        return boolActu;
    }

    @Override
    public boolean removeEncargado(Encargado encargado) {
        return listaEncargados.getListaEncargados().remove(encargado);
    }

    @Override
    public Encargado buscaEncargadoPorId(String idEncargado) {
        Encargado aux = null;
        Iterator<Encargado> iter = listaEncargados.getListaEncargados().iterator();
        while (iter.hasNext()) {
            Encargado objectAux = iter.next();
            if(objectAux.getIdEncargado().equals(idEncargado)){
                // find it
                aux = objectAux;
            }

        }
        return aux;
    }

    @Override
    public boolean removeEncargado (String idEncargado){
        boolean booleanCheck = false;
        Encargado auxRemove = buscaEncargadoPorId(idEncargado);
        if (auxRemove == null){
            logger.info("el encargado no existe");
        }
        else {
            listaEncargados.getListaEncargados().remove(auxRemove);
            booleanCheck = true;
        }


        return booleanCheck;
    }

    @Override
    public boolean clearEncargados(){
        listaEncargados.getListaEncargados().clear();
        return true;
    }

}
