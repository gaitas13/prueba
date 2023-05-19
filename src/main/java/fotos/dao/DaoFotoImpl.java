package fotos.dao;

import fotos.domain.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class DaoFotoImpl implements DaoFoto{
    
    Logger logger = LogManager.getRootLogger();

    protected final Fotos listaFotos;

    public DaoFotoImpl() {
        this.listaFotos = new Fotos();
    }

    private final DaoLugarImpl daoLugar = new DaoLugarImpl();
    private final DaoFotografoImpl daoFotografo = new DaoFotografoImpl();

    @Override
    public List<Foto> getListaFotos(){
        return listaFotos.getListaFotos();
    }
    @Override
    public boolean addFoto(Foto foto){
        return listaFotos.getListaFotos().add(foto);
    }
    @Override
    public boolean addFoto(String idFoto, String nombreFoto, boolean booleanColor, int fechaFoto, String idLugar, String dniFotografo) {
        if (buscaFotoPorId(idFoto) == null){
            Lugar auxLugar = daoLugar.buscaLugarPorId(idLugar);
            Fotografo auxFotoGrafo = daoFotografo.buscaFotografoPorId(dniFotografo);
            return listaFotos.getListaFotos().add(new Foto(idFoto, nombreFoto, booleanColor, fechaFoto, auxLugar, auxFotoGrafo));
        }
        else{
            logger.info("la foto ya existe");
            return false;
        }

    }
    @Override
    public boolean actualizarFoto(String idFoto){
        Scanner scanner = new Scanner(System.in);
        boolean salirForActu = false;

                //aux es un puntero, si se cambia, cambia el valor de la ram original
                Foto aux = buscaFotoPorId(idFoto);
                if (aux!= null){
                    logger.info(aux);
                    logger.info("elige nuevo id");
                    String  auxIdFoto = scanner.nextLine();
                    logger.info("elige nuevo nombre");
                    String  auxNombreCamara = scanner.nextLine();
                    logger.info("elige nueva fecha");
                    boolean auxColor = scanner.nextBoolean();
                    scanner.nextLine();
                    logger.info("elige nuevo precio");
                    int auxFecha = scanner.nextInt();
                    scanner.nextLine();
                    logger.info("elige nuevo lugar (id lugar)");
                    Lugar auxLugar = daoLugar.buscaLugarPorId(scanner.nextLine());
                    logger.info("elige nuevo fotografo (id fotografo)");
                    Fotografo auxFotografo = daoFotografo.buscaFotografoPorId(scanner.nextLine());
                    aux.setIdFoto(auxIdFoto);
                    aux.setNombre(auxNombreCamara);
                    aux.setColor(auxColor);
                    aux.setFecha(auxFecha);
                    aux.setLugar(auxLugar);
                    aux.setFotografo(auxFotografo);
                    salirForActu = true;
                }
                else {
                    logger.info("la foto no existe");
                }


        return salirForActu;
    }

    @Override
    public Foto buscaFotoPorId(String idFoto) {
        Foto aux = null;
        for (int i = 0; i < listaFotos.getListaFotos().size() && aux == null; i++) {
            if (listaFotos.getListaFotos().get(i).getIdFoto().equals(idFoto)) {
                //aux es un puntero, si se cambia, cambia el valor de la ram original
                aux = listaFotos.getListaFotos().get(i);
            }

        }
        return aux;
    }
    @Override
    public boolean removeFoto(Foto foto){
        return  listaFotos.getListaFotos().remove(foto);
    }

    @Override
    public boolean removeFoto(String idFoto){
        boolean booleanCheck = false;
        Foto aux = buscaFotoPorId(idFoto);
        if (aux == null){
            logger.info("la foto no existe");
        }
        else{
            listaFotos.getListaFotos().remove(aux);
            booleanCheck = true;
        }

        return booleanCheck;
    }

    @Override
    public boolean clearFotos(){
        listaFotos.getListaFotos().clear();
        return true;
    }
}
