package fotos.dao;

import fotos.domain.Camara;

import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DaoCamaraImpl implements DaoCamara{

    Logger logger = LogManager.getRootLogger();

    protected final Camaras listaCamaras;

    public DaoCamaraImpl() {
        this.listaCamaras = new Camaras();
    }

    @Override
    public List<Camara> getListaCamaras(){
        return listaCamaras.getListaCamaras();
    }
    @Override
    public boolean addCamara(Camara camara){
        return listaCamaras.getListaCamaras().add(camara);
    }
    @Override
    public boolean addCamara(String idCamara, String nombre, int fechaFabricacion, int precio){
        if(buscaCamaraPorId(idCamara) == null){
            return listaCamaras.getListaCamaras().add(new Camara(idCamara, nombre, fechaFabricacion, precio));
        }
        else {
            logger.info("la camara ya existe");
            return false;
        }
    }
    @Override
    public boolean actualizarCamara(String idCamara){
        Scanner scanner = new Scanner(System.in);
        boolean salirForActu = false;

                //aux es un puntero, si se cambia, cambia el valor de la ram original

        Camara aux = buscaCamaraPorId(idCamara);
        if (aux != null){
            logger.info(aux);
            logger.info("elige nuevo id");
            String  auxIdCamara = scanner.nextLine();
            logger.info("elige nuevo nombre");
            String  auxNombreCamara = scanner.nextLine();
            logger.info("elige nueva fecha");
            int auxFechaCamara = scanner.nextInt();
            scanner.nextLine();
            logger.info("elige nuevo precio");
            int auxPrecioCamara = scanner.nextInt();
            scanner.nextLine();
            aux.setIdCamara(auxIdCamara);
            aux.setNombre(auxNombreCamara);
            aux.setFechaFabricacion(auxFechaCamara);
            aux.setFechaFabricacion(auxPrecioCamara);
            salirForActu = true;
        }
        else {
            logger.info("la camara no existe");
        }


        return salirForActu;
    }

    @Override
    public Camara buscaCamaraPorId(String idCamara) {
        Camara aux = null;
        for (int i = 0; i < listaCamaras.getListaCamaras().size() && aux == null; i++) {
            if (listaCamaras.getListaCamaras().get(i).getIdCamara().equals(idCamara)) {
                //aux es un puntero, si se cambia, cambia el valor de la ram original
                aux = listaCamaras.getListaCamaras().get(i);
            }

        }
        return aux;
    }
    @Override
    public boolean removeCamara(Camara camara){
        return  listaCamaras.getListaCamaras().remove(camara);
    }

    @Override
    public boolean removeCamara(String idCamara){
        boolean booleanCheck = false;
        Camara aux = buscaCamaraPorId(idCamara);

        if (aux == null){
            logger.info("la camara no existe");
        }
        else {
            listaCamaras.getListaCamaras().remove(aux);
            booleanCheck = true;
        }

        return booleanCheck;
    }

    @Override
    public boolean clearCamaras(){
        listaCamaras.getListaCamaras().clear();
        return true;
    }

}
