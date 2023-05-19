module AppFotosDGaite {

    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires org.apache.logging.log4j;
    requires lombok;

    exports fotos.dao;
    exports fotos.domain;
    exports fotos.service;
    exports fotos.console;
    exports fotos.ui;
    opens fotos.ui to javafx.fxml, org.apache.logging.log4j;
    opens fotos.console to org.apache.logging.log4j, lombok;

}