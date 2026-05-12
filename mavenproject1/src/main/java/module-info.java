module ipc.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens ipc.project to javafx.fxml;
    exports ipc.project;
}
