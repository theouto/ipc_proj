/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ipc.project;

import java.net.URL;
import java.sql.SQLOutput;
import java.util.*;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.collections.ObservableList;
import upv.ipc.sportlib.*;

public class ActivityManagementController implements Initializable {
    
  @FXML
  private Label lblTotalTime;
  
  @FXML
  private Label totalDistance;

  @FXML
  private Label totalDescent;

  @FXML
  private Label totalAscent;

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    List<Activity> listDB = App.sportApp.getUserActivities();
    calcTotals(listDB);
  }

  public void calcTotals(List<Activity> sessions) {
    long totalSeconds = 0;
    double totalAscenty = 0;
    double totalDescenty = 0;
    double totalDistancey = 0;

    for (Activity s : sessions) {
      totalSeconds += s.getDuration().toSeconds();
      totalDistancey += s.getTotalDistance();
      totalAscenty += s.getElevationGain();
      totalDescenty += s.getElevationLoss();
    }

    long h = totalSeconds / 3600;
    long m = (totalSeconds % 3600) / 60;
    lblTotalTime.setText(String.format("%02dh %02dm", h, m));
    totalDistance.setText(String.valueOf(totalDistancey));
    totalAscent.setText(String.valueOf(totalAscenty));
    totalDescent.setText(String.valueOf(totalDescenty));
  }
  
  @FXML
  private void back() throws IOException {App.setRoot("FXMLDocument");}
}
