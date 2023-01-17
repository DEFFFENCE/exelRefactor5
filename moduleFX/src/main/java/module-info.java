module com.example.modulefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.example.moduleOperatn;
    opens com.example.modulefx to javafx.fxml;
    exports com.example.modulefx;
}