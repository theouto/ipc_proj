package ipc.project;

import java.io.IOException;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.AnchorPane;

import upv.ipc.sportlib.*;

public class ActivityManagementController implements Initializable {
    
    @FXML
    private VBox activityList;
    
    //Se asume que si el usuario está aquí, es porque está loggeado
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        if (App.sportApp.getCurrentUser() != null)
        {
           App.activities = App.sportApp.getUserActivities();
            for (int i = 0; i < App.activities.size(); i++)
            {
                Button activity = new Button(App.activities.get(i).getName());
                final int index = i;
                activity.setOnAction(e -> setAction(index));
                activityList.getChildren().add(activity);
            } 
        }
    }
    
    @FXML
    public void ImportActivity(ActionEvent event) throws IOException {App.setRoot("ActivityCreation");}
    
    @FXML
    private void back() throws IOException {App.setRoot("FXMLDocument");}
    
    private void setAction(int i)
    {
        App.mapPath = App.activities.get(i).getSuggestedMap().getImagePath();
        try {back();} catch (IOException e) {System.out.println("Could not go back!");}
    }
}