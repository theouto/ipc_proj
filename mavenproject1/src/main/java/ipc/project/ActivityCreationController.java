package ipc.project;

import java.io.IOException;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import upv.ipc.sportlib.*;

public class ActivityCreationController {
    
    @FXML
    private Label filePath;
    
    @FXML
    private TextField ActivityName;
    
    private String truFile;
    
    @FXML
    private void gpxImport(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(".")); // Empezamos en el directorio del proyecto

        File imgFile = fc.showOpenDialog(filePath.getScene().getWindow());

        if (imgFile != null) {
            System.out.println("Mapa seleccionado: " + imgFile.getCanonicalPath());
            filePath.setText(imgFile.getCanonicalPath());
            truFile = imgFile.getCanonicalPath();
        }
    }
    
    @FXML
    private void ImportActivity(ActionEvent event) throws IOException 
    {
        Activity activity = App.sportApp.importActivity(new File(truFile));
        if (!ActivityName.getCharacters().toString().isEmpty())
        {
            App.sportApp.renameActivity(activity, ActivityName.getCharacters().toString());
        }
        back();
    }
    
    @FXML
    private void back() throws IOException {App.setRoot("ActivityManagement");}
}