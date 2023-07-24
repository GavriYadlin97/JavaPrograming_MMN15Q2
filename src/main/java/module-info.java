module com.maman15q2.maman15q2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.maman15q2.maman15q2 to javafx.fxml;
    exports com.maman15q2.maman15q2;
}