package fotos.console;

import fotos.common.Constantes;
import fotos.domain.Lugar;
import fotos.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {

    public static void ui() {
        boolean booleanoMain = false;
        Logger logger = LogManager.getLogger(ConsoleUI.class);
        logger.info("1 usuario, 2 admin, 0 salir");
        int chooseUsuario = objetoChoose();
        do {
            logger.info(Constantes.MENU_ELEGIR_OBJETO);
            switch (objetoChoose()){
                case 1:
                    camaraChoose(chooseUsuario);
                    break;
                case 2:
                    encargadoChoose(chooseUsuario);
                    break;
                case 3:
                    fotoChoose(chooseUsuario);
                    break;
                case 4:
                    fotografoChoose(chooseUsuario);
                    break;
                case 5:
                    lugarChoose(chooseUsuario);
                    break;
                case 0:
                    booleanoMain = chooseExit();
                    break;
                default:
                    booleanoMain = chooseBadInput();
                    break;
            }
        }while (!booleanoMain);
        logger = null;

    }

    private static int objetoChoose(){

        Scanner scanner = new Scanner(System.in);
        Logger logger = LogManager.getRootLogger();
        int numeroSwitch = 0;
        try {
            numeroSwitch = scanner.nextInt();
        }catch (InputMismatchException e){
            logger.info(Constantes.THE_INPUT_IS_MISMATCH);
        }

        scanner.nextLine();
        //scanner.close();
        //scanner = null;
        logger = null;
        return numeroSwitch;
    }

    private static void camaraChoose(int intUsuario){
        Scanner scanner = new Scanner(System.in);
        boolean booleanoCamara = false;
        ServicioAdminImpl servicioAdmin = new ServicioAdminImpl();
        Logger logger = LogManager.getRootLogger();
        do {
            switch (intUsuario){
                case 1:
                    logger.info(Constantes.MENU_CAMARAS_USUARIO);
                    switch (objetoChoose()){
                        case 1:
                            logger.info(servicioAdmin.getListaCamaras());
                            break;
                        case 0:
                            booleanoCamara = chooseExit();
                            break;
                        default:
                            booleanoCamara = chooseBadInput();
                            break;
                    }
                    break;

                case 2:
                    logger.info(Constantes.MENU_CAMARAS_ADMIN);
                    switch (objetoChoose()){
                        case 1:
                            logger.info(servicioAdmin.getListaCamaras());
                            break;
                        case 2:
                            logger.info("introduce id camara");
                            String idCam = scanner.nextLine();
                            logger.info("introduce nombre camara");
                            String nombreCam = scanner.nextLine();
                            logger.info("introduce fecha fabricacion");
                            int fechafabricacion = scanner.nextInt();
                            scanner.nextLine();
                            logger.info("introduce precio");
                            int precioCam = scanner.nextInt();
                            scanner.nextLine();
                            servicioAdmin.addCamara(idCam, nombreCam, fechafabricacion, precioCam);
                            break;
                        case 3:
                            logger.info("elige el id del elemento que quieres modificar");
                            String auxId = scanner.nextLine();
                            servicioAdmin.actualizarCamara(auxId);
                            break;
                        case 4:
                            logger.info("introduce id camara");
                            String idCamBuscaBorrar = scanner.nextLine();

                            servicioAdmin.borrarCamara(idCamBuscaBorrar);
                            break;
                        case 5:
                            servicioAdmin.borrarCamaraAll();
                            break;
                        case 0:
                            booleanoCamara = chooseExit();
                            break;
                        default:
                            booleanoCamara = chooseBadInput();
                            break;
                    }
                    break;
            }

        }while (!booleanoCamara);
        logger = null;
    }
    private static void encargadoChoose(int intUsuario){
        boolean booleanoEncargado = false;
        ServicioAdminImpl servicioAdmin = new ServicioAdminImpl();
        Logger logger = LogManager.getRootLogger();
        Scanner scanner = new Scanner(System.in);
        do {
            switch (intUsuario){
                case 1:
                    logger.info(Constantes.MENU_ENCARGADOS_USUARIO);
                    switch (objetoChoose()){
                        case 1:
                            logger.info(servicioAdmin.getListaEncargados());
                            break;
                        case 0:
                            booleanoEncargado = chooseExit();
                            break;
                        default:
                            booleanoEncargado = chooseBadInput();
                            break;
                    }
                    break;
                case 2:
                    logger.info(Constantes.MENU_ENCARGADOS_ADMIN);
                    switch (objetoChoose()){
                        case 1:
                            logger.info(servicioAdmin.getListaEncargados());
                            break;
                        case 2:
                            logger.info("introduce id encargado");
                            String idEncargado = scanner.nextLine();
                            logger.info("introduce nombre");
                            String nombreEncargado = scanner.nextLine();
                            logger.info("introduce apellido");
                            String apellidoEncargado = scanner.nextLine();
                            logger.info("introduce direccion");
                            String direccion = scanner.nextLine();
                            logger.info("introduce id fotografo");
                            String idFotografo = scanner.nextLine();
                            servicioAdmin.addEncargado(idEncargado, nombreEncargado, apellidoEncargado, direccion, idFotografo);
                            break;
                        case 3:
                            logger.info("elige el id del encargado que quieres modificar");
                            String auxId = scanner.nextLine();
                            servicioAdmin.actualizarEncargado(auxId);
                            break;
                        case 4:
                            logger.info("introduce id encargado");
                            String idEncargadoBuscaBorrar = scanner.nextLine();

                            servicioAdmin.borrarCamara(idEncargadoBuscaBorrar);
                            break;
                        case 5:
                            servicioAdmin.borrarEncargadoAll();
                            break;
                        case 0:
                            booleanoEncargado = chooseExit();
                            break;
                        default:
                            booleanoEncargado = chooseBadInput();
                            break;
                    }
                    break;
                case 0:
                    chooseExit();
                    break;
                default:
                    chooseBadInput();
                    break;
            }
        }while (!booleanoEncargado);
        logger = null;
        //servicioAdmin = null;
    }
    private static void fotoChoose(int intUsuario){
        boolean booleanoFoto = false;
        ServicioAdminImpl servicioAdmin = new ServicioAdminImpl();
        Logger logger = LogManager.getRootLogger();
        Scanner scanner = new Scanner(System.in);
        do {
            switch (intUsuario){
                case 1:
                    logger.info(Constantes.MENU_FOTOS_USUARIO);
                    switch (objetoChoose()){
                        case 1:
                            logger.info(servicioAdmin.getListaFotos());
                            break;
                        case 0:
                            booleanoFoto = chooseExit();
                            break;
                        default:
                            booleanoFoto = chooseBadInput();
                            break;
                    }
                    break;
                case 2:
                    logger.info(Constantes.MENU_FOTOS_ADMIN);
                    switch (objetoChoose()){
                        case 1:
                            logger.info(servicioAdmin.getListaFotos());
                            break;
                        case 2:
                            logger.info("introduce id foto");
                            String idFoto = scanner.nextLine();
                            logger.info("introduce nombre foto");
                            String nombreFoto = scanner.nextLine();
                            logger.info("introduce si la foto tiene color (0) o no (1)");
                            boolean booleanColor = scanner.nextBoolean();
                            scanner.nextLine();
                            logger.info("introduce fecha");
                            int fechaFoto = scanner.nextInt();
                            scanner.nextLine();
                            logger.info("introduce id lugar");
                            String idLugar = scanner.nextLine();
                            logger.info("introduce id fotografo");
                            String idFotografo = scanner.nextLine();
                            servicioAdmin.addFoto(idFoto, nombreFoto, booleanColor, fechaFoto, idLugar, idFotografo);
                            break;
                        case 3:
                            logger.info("elige el id del elemento que quieres modificar");
                            String auxId = scanner.nextLine();
                            servicioAdmin.actualizarFoto(auxId);
                            break;
                        case 4:
                            logger.info("introduce id camara");
                            String idFotoBuscaBorrar = scanner.nextLine();

                            servicioAdmin.borrarFoto(idFotoBuscaBorrar);
                            break;
                        case 5:
                            servicioAdmin.borrarFotoAll();
                            break;
                        case 0:
                            booleanoFoto = chooseExit();
                            break;
                        default:
                            booleanoFoto = chooseBadInput();
                            break;
                    }
                    break;
                case 0:
                    chooseExit();
                    break;
                default:
                    chooseBadInput();
                    break;
            }
        }while (!booleanoFoto);
        //servicioAdmin = null;
        logger = null;
    }
    private static void fotografoChoose(int intUsuario){
        boolean booleanoFotografo = false;
        ServicioAdminImpl servicioAdmin = new ServicioAdminImpl();
        Logger logger = LogManager.getRootLogger();
        Scanner scanner = new Scanner(System.in);
        do {
            switch (intUsuario){
                case 1:
                logger.info(Constantes.MENU_FOTOGRAFOS_USUARIO);
                switch (objetoChoose()){
                    case 1:
                        logger.info(servicioAdmin.getListaFotografos());
                        break;

                    case 0:
                        booleanoFotografo = chooseExit();
                        break;
                    default:
                        booleanoFotografo = chooseBadInput();
                        break;
                }
                break;
                case 2:
                System.out.println(Constantes.MENU_FOTOGRAFOS_ADMIN);
                switch (objetoChoose()){
                    case 1:
                        logger.info(servicioAdmin.getListaFotografos());
                        break;
                    case 2:
                        logger.info("introduce dni fotografo");
                        String dniFotografo = scanner.nextLine();
                        logger.info("introduce nombre fotografo");
                        String nombre = scanner.nextLine();
                        logger.info("introduce apellido");
                        String  apellido = scanner.nextLine();
                        logger.info("introduce direccion");
                        String direccion = scanner.nextLine();
                        logger.info("introduce id camara");
                        String idCamara = scanner.nextLine();
                        servicioAdmin.addFotografo(dniFotografo, nombre, apellido, direccion, idCamara);
                        break;
                    case 3:
                        logger.info("elige el id del elemento que quieres modificar");
                        String auxId = scanner.nextLine();
                        servicioAdmin.actualizarFotografo(auxId);
                        break;
                    case 4:
                        logger.info("introduce id fotografo");
                        String idFotografoBuscaBorrar = scanner.nextLine();

                        servicioAdmin.borrarFotografo(idFotografoBuscaBorrar);
                        break;
                    case 5:
                        servicioAdmin.borrarFotografoAll();
                        break;
                    case 0:
                        booleanoFotografo = chooseExit();
                        break;
                    default:
                        booleanoFotografo = chooseBadInput();
                        break;
                }
                break;
                case 0:
                    chooseExit();
                    break;
                default:
                    chooseBadInput();
                    break;
            }

        }while (!booleanoFotografo);
        //servicioAdmin = null;
        logger = null;
    }
    private static void lugarChoose(int intUsuario){
        boolean booleanoLugar = false;
        ServicioAdminImpl servicioAdmin = new ServicioAdminImpl();
        Scanner scanner = new Scanner(System.in);

        Logger logger = LogManager.getRootLogger();
        do {
            switch (intUsuario){
                case 1:
                    logger.info(Constantes.MENU_LUGARES_USUARIO);
                    switch (objetoChoose()){
                        case 1:
                            logger.info(servicioAdmin.getListaLugares());
                            break;
                        case 0:
                            booleanoLugar = chooseExit();
                            break;
                        default:
                            booleanoLugar = chooseBadInput();
                            break;
                    }
                    break;
                case 2:
                    logger.info(Constantes.MENU_LUGARES_ADMIN);
                    switch (objetoChoose()){
                        case 1:
                            logger.info(servicioAdmin.getListaLugares());
                            break;
                        case 2:
                            logger.info("introduce id lugar");
                            String idLugar = scanner.nextLine();
                            logger.info("introduce nombre lugar");
                            String nombreLugar = scanner.nextLine();
                            logger.info("introduce pais");
                            String pais = scanner.nextLine();
                            logger.info("introduce localidad");
                            String localidad = scanner.nextLine();
                            servicioAdmin.addLugar(new Lugar(idLugar, nombreLugar, pais, localidad));
                            break;
                        case 3:
                            logger.info("elige el id del elemento que quieres modificar");
                            String auxId = scanner.nextLine();
                            servicioAdmin.actualizarLugar(auxId);
                            break;
                        case 4:
                            logger.info("introduce id lugar");
                            String idLugarBuscaBorrar = scanner.nextLine();

                            servicioAdmin.borrarLugar(idLugarBuscaBorrar);
                            break;
                        case 5:
                            servicioAdmin.borrarLugarAll();
                            break;
                        case 0:
                            booleanoLugar = chooseExit();
                            break;
                        default:
                            booleanoLugar = chooseBadInput();
                            break;
                    }
                    break;
                case 0:
                    booleanoLugar = chooseExit();
                    break;
                default:
                    booleanoLugar = chooseBadInput();
                    break;
            }

        }while (!booleanoLugar);
        //servicioAdmin = null;
        logger = null;
    }

    protected static boolean chooseExit(){
        System.out.println(Constantes.SALIENDO_JUEGO);
        return true;
    }

    protected static boolean chooseBadInput(){
        System.out.println(Constantes.ERROR);
        return true;
    }
}
