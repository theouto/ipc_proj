module ipc.project {
    requires javafx.controls;
    requires javafx.fxml;

    opens ipc.project to javafx.fxml;
    exports ipc.project;
}
