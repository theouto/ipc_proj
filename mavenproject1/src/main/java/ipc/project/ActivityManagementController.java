package ipc.project;

import java.io.IOException;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

import upv.ipc.sportlib.*;

public class ActivityManagementController {
    
    @FXML
    private AnchorPane activityPane;
    
    //Se asume que si el usuario está aquí, es porque está loggeado
    public void initialize(URL url, ResourceBundle rb) 
    {
            App.activities = App.sportApp.getUserActivities();
            for (int i = 0; i < App.activities.size(); i++)
            {
                Button activity = new Button(App.activities.get(i).getName());
                activityPane.getChildren().add(activity);
            }
    }
    
    @FXML
    public void ImportActivity(ActionEvent event) throws IOException {App.setRoot("ActivityCreation");}
    
    @FXML
    private void back() throws IOException {App.setRoot("FXMLDocument");}
}