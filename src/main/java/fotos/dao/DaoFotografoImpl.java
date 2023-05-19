package fotos.dao;

import fotos.domain.Camara;
import fotos.domain.Fotografo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class DaoFotografoImpl implements DaoFotografo{
    
    Logger logger = LogManager.getRootLogger();

    protected final Fotografos listaFotografos;

    private final DaoCamaraImpl daoCamara = new DaoCamaraImpl();

    public DaoFotografoImpl() {
        this.listaFotografos = new Fotografos();
    }

    @Override
    public List<Fotografo> getListaFotografos(){
        return listaFotografos.getListaFotografos();
    }
    @Override
    public boolean addFotografo(Fotografo fotografo){
        return listaFotografos.getListaFotografos().add(fotografo);
    }

    @Override
    public boolean addFotografo(String dniFotografo, String nombre, String apellido, String direccion, String idCamara){
        if (buscaFotografoPorId(dniFotografo) == null){
            Camara auxCamara = daoCamara.buscaCamaraPorId(idCamara);
            return listaFotografos.getListaFotografos().add(new Fotografo(dniFotografo, nombre, apellido, direccion, auxCamara));
        }
        else{
            logger.info("el fotografo ya existe");
            return false;
        }
    }
    @Override
    public boolean actualizarFotografo(String dniFotografo){
        Scanner scanner = new Scanner(System.in);
        boolean salirForActu = false;
        //aux es un puntero, si se cambia, cambia el valor de la ram original

        Fotografo aux = buscaFotografoPorId(dniFotografo);
        logger.info(aux);
        if (aux != null) {
            logger.info(aux);
            logger.info("elige nuevo dni");
            String auxDniFotogrado = scanner.nextLine();
            logger.info("elige nuevo nombre");
            String auxNombreFotografo = scanner.nextLine();
            logger.info("elige nuevo apellido");
            String auxApellidoFotogrado = scanner.nextLine();
            logger.info("elige nueva direccion");
            String auxDireccion = scanner.nextLine();
            logger.info("elige nueva camara (id camara)");
            Camara auxCamara = daoCamara.buscaCamaraPorId(scanner.nextLine());
            aux.setDniFotografo(auxDniFotogrado);
            aux.setNombre(auxNombreFotografo);
            aux.setApellido(auxApellidoFotogrado);
            aux.setDireccion(auxDireccion);
            aux.setCamara(auxCamara);
            salirForActu = true;
        }
        else{
            logger.info("el fotografo no existe");
        }



        return salirForActu;
    }

    @Override
    public Fotografo buscaFotografoPorId(String dniFotografo) {
        Fotografo aux = null;
        for (int i = 0; i < listaFotografos.getListaFotografos().size() && aux == null; i++) {
            if (listaFotografos.getListaFotografos().get(i).getDniFotografo().equals(dniFotografo)) {
                //aux es un puntero, si se cambia, cambia el valor de la ram original
                aux = listaFotografos.getListaFotografos().get(i);
            }

        }
        return aux;
    }
    @Override
    public boolean removeFotografo(Fotografo fotografo){
        return  listaFotografos.getListaFotografos().remove(fotografo);
    }

    @Override
    public boolean removeFotografo(String dniFotografo){
        boolean booleanCheck = false;

        Fotografo aux = buscaFotografoPorId(dniFotografo);
        if (aux == null) {
            logger.info("el fotografo no existe");
        }
        else {
            listaFotografos.getListaFotografos().remove(aux);
            booleanCheck = true;
        }

        return booleanCheck;
    }

    @Override
    public boolean clearFotografos(){
        listaFotografos.getListaFotografos().clear();
        return true;
    }
}
