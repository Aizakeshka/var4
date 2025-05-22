module com.example.var4 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.ooxml;


    opens com.example.var4 to javafx.fxml;
    exports com.example.var4;
}