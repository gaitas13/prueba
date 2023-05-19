package fotos.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class MainUIController implements Initializable {

    @FXML
    private TextArea fotosArea;

    @Override
    public void initialize(URL location, ResourceBundle resources){

        fotosArea.setEditable(false);
        System.out.println("hola");

    }
}
