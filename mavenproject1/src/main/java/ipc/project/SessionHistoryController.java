/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ipc.project;

import java.net.URL;
import java.sql.SQLOutput;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.collections.ObservableList;
import upv.ipc.sportlib.*;

/**
 * FXML Controller class
 *
 * @author overh
 */

public class SessionHistoryController implements Initializable {

  @FXML
  ListView<Session> listViewSessions;

  @FXML
  private Label lblTotalTime;

  @FXML
  private Label lblTotalImported;

  @FXML
  private Label lblTotalAnnotations;

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    SportActivityApp sportApp = SportActivityApp.getInstance();
    List<Session> listDB = sportApp.getSessionsByUser(sportApp.getCurrentUser());

    ObservableList<Session> sessionList = FXCollections.observableArrayList(listDB);
    listViewSessions.setItems(sessionList);
    listViewSessions.setCellFactory(listView -> new SessionListCell());

    calcTotals(listDB);

  }

  public void calcTotals(List<Session> sessions) {
    long totalSeconds = 0;
    int totalImports = 0;
    int totalAnotations = 0;

    for (Session s : sessions) {
      totalSeconds += s.getDuration().toSeconds();
      totalImports += s.getImportedActivities();
      totalAnotations += s.getAnnotationsCreated();
    }

    long h = totalSeconds / 3600;
    long m = (totalSeconds % 3600) / 60;
    lblTotalTime.setText(String.format("%02dh %02dm", h, m));
    lblTotalImported.setText(String.valueOf(totalImports));
    lblTotalAnnotations.setText(String.valueOf(totalAnotations));

  }
}
