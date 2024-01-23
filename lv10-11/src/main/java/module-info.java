module ba.unsa.etf.rpr.lv1011 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires java.sql;


    opens ba.unsa.etf.rpr.lv1011 to javafx.fxml;
    exports ba.unsa.etf.rpr.lv1011;
}