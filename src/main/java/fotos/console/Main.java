package fotos.console;


import java.util.Scanner;
import fotos.ui.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

    public static void main(String[] args) {

        Logger logger = LogManager.getRootLogger();
        logger.debug("se puede meter el json en la grafica");
        Scanner scanner = new Scanner(System.in);
        logger.info("0 consola, 1 grafico");
        int int1 = scanner.nextInt();
        if(int1 == 1){
            MainUI.main();
        }
        else {
            ConsoleUI.ui();
        }
    }

}
