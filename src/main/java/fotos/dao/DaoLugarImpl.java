package fotos.dao;



import fotos.domain.Lugar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class DaoLugarImpl implements DaoLugar{

    protected final Lugares listaLugares;

    Logger logger = LogManager.getRootLogger();

    public DaoLugarImpl() {
        this.listaLugares = new Lugares();
    }

    @Override
    public Map<String, Lugar> getListaLugares(){
        return listaLugares.getListaLugares();
    }
    @Override
    public boolean addLugar(Lugar lugar){
        listaLugares.getListaLugares().put(lugar.getIdLugar(), lugar);
        return true;
    }
    @Override
    public boolean addLugar(String idLugar, String nombreLugar, String pais, String localidad) {

        if (buscaLugarPorId(idLugar) == null){

            listaLugares.getListaLugares().put(idLugar, new Lugar(idLugar, nombreLugar, pais, localidad));
            return true;
        }
            else{
                logger.info("el lugar ya existe");
                return false;
        }

    }
    @Override
    public boolean actualizarLugar(String idLugar){
        Scanner scanner = new Scanner(System.in);
        boolean salirForActu = false;
        Lugar aux = buscaLugarPorId(idLugar);
        if (aux != null){
            logger.info(aux);
            logger.info("elige nuevo id");
            String  auxIdLugar = scanner.nextLine();
            logger.info("elige nuevo nombre");
            String  auxNombreLugar = scanner.nextLine();
            logger.info("elige nuevo pais");
            String auxPais = scanner.nextLine();
            logger.info("elige nueva localidad");
            String auxLicalidad = scanner.nextLine();
            aux.setIdLugar(auxIdLugar);
            aux.setNombre(auxNombreLugar);
            aux.setPais(auxPais);
            aux.setLocalidad(auxLicalidad);
            salirForActu = true;
        }
        else {
            logger.info("el lugar no existe");
        }


        return salirForActu;
    }

    @Override
    public Lugar buscaLugarPorId(String idLugar) {
        Lugar aux = null;
        for (int i = 0; i < listaLugares.getListaLugares().size() && aux == null; i++) {
            if (listaLugares.getListaLugares().get(i).getIdLugar().equals(idLugar)) {
                //aux es un puntero, si se cambia, cambia el valor de la ram original
                aux = listaLugares.getListaLugares().get(i);
            }

        }
        return aux;
    }
    @Override
    public boolean removeLugar(Lugar lugar){
        listaLugares.getListaLugares().remove(lugar.getIdLugar(), lugar);
        return true;
    }

    @Override
    public boolean removeLugar(String idLugar){
        boolean booleanCheck = false;
        Lugar aux = buscaLugarPorId(idLugar);
        if (aux == null){
            logger.info("el lugar no existe");
        }
        else {
            listaLugares.getListaLugares().remove(aux.getIdLugar(), aux);
            booleanCheck = true;
        }

        return booleanCheck;
    }

    @Override
    public boolean clearLugares (){
        listaLugares.getListaLugares().clear();
        return true;
    }

}
