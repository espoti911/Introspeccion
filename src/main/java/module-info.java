module es.ieslosmontecillos.introspeccion {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.introspeccion to javafx.fxml;
    exports es.ieslosmontecillos.introspeccion;
}