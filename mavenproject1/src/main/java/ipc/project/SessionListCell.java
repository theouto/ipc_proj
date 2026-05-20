package ipc.project;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import upv.ipc.sportlib.*;

public class SessionListCell extends ListCell<Session> {

  private Node nodeVisual;
  private SessionRowController rowController;

  public SessionListCell() {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("SessionRowItem.fxml"));
      nodeVisual = loader.load();
      rowController = loader.getController();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void updateItem(Session item, boolean empty) {
    super.updateItem(item, empty);

    if (empty || item == null) {
      setText(null);
      setGraphic(null);
    } else {
      rowController.setSessionData(item);
      setGraphic(nodeVisual);
    }
  }
}
