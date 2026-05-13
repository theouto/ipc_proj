package ipc.project;

import java.io.IOException;
import java.io.File;
import javafx.fxml.FXML;

import upv.ipc.sportlib.*;

public class ActivityManagementController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("FXMLDocument");
    }
    
    @FXML
    private void importActivity() throws IOException 
    {
        Activity activity = App.sportApp.importActivity(new File("ruta.gpx"));
    }
}