/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

package ipc.project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import upv.ipc.sportlib.*;


public class SessionRowController implements Initializable {

    @FXML
    private HBox cardContainer;

    @FXML
    private ImageView iconAnotation;

    @FXML
    private ImageView iconImport;

    @FXML
    private ImageView iconView;

    @FXML
    private Label lblAnotation;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblDuration;

    @FXML
    private Label lblImport;

    @FXML
    private Label lblTime;

    @FXML
    private Label lblView;
    
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd MMM YYYY");
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm'h'");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadIcons();
    }
    
    
    private void loadIcons() {
        try {
            Image imgImport = new Image(getClass().getResourceAsStream("resources/import.png"));
            Image imgView = new Image(getClass().getResourceAsStream("resources/view.png"));
            Image imgEdit = new Image(getClass().getResourceAsStream("resources/edit.png"));
            
            iconImport.setImage(imgImport);
            iconView.setImage(imgView);
            iconAnotation.setImage(imgEdit);
        } catch (Exception e) {
            System.out.println("Error on loading icon for history session card");
        }
    }
    
    public void setSessionData(Session session) {
        if (session == null) return;
        
        if (session.getStartTime() != null) {
            lblDate.setText(session.getStartTime().format(dateFormatter));
            lblTime.setText("Inicio: " + session.getStartTime().format(timeFormatter));
            
        }
        
        long totalSeconds = session.getDuration().toSeconds();
        long hours = totalSeconds / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long seconds = totalSeconds % 60;
        lblDuration.setText(String.format("%02dh %02dm %02ds", hours, minutes, seconds));
        
        lblImport.setText(session.getImportedActivities() + " Importadas");
        lblView.setText(session.getViewedActivities() + " Vistas");
        lblAnotation.setText(session.getAnnotationsCreated() + " Anotaciones");
    }
    
    

}

