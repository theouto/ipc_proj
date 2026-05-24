/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ipc.project;

import java.net.URL;
import java.sql.SQLOutput;
import java.util.*;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.collections.ObservableList;
import upv.ipc.sportlib.*;

public class MapAdditionController implements Initializable {
    
  @FXML
  private Label filePathing;

  @FXML
  private TextField Named;
 
  @FXML
  private TextField minLat;
  
  @FXML
  private TextField maxLat;
  
  @FXML
  private TextField minLong;
  
  @FXML
  private TextField maxLong;
 
  private String filePathed;
  private File mapFile;

  @Override
  public void initialize(URL url, ResourceBundle rb) {
  }
  
  @FXML
  private void elegir() throws IOException {
      FileChooser fc = new FileChooser();
      fc.setInitialDirectory(new File(".")); // Empezamos en el directorio del proyecto

      File imgFile = fc.showOpenDialog(Named.getScene().getWindow());

      // FIX 3: showOpenDialog() devuelve null si el usuario cancela la selección
      if (imgFile == null) {
        filePathing.setText("invalid path");
        return;
      }
          
      filePathed = imgFile.getCanonicalPath();
        
      mapFile = imgFile;
      filePathing.setText(filePathed);
      }

  @FXML
  private void addMap() throws IOException
  {
    if (App.sportApp.addMapRegion(Named.getText(), mapFile,
                                  Double.parseDouble(minLat.getText()),
                                  Double.parseDouble(maxLat.getText()),
                                  Double.parseDouble(minLong.getText()),
                                  Double.parseDouble(maxLong.getText())) == null) 
    {
        System.out.println("Failed to add map region!");
        return;
    }
    
    back();
  }
  
  @FXML
  private void back() throws IOException {App.setRoot("FXMLDocument");}
}
