package ipc.project;

import java.io.File;
import java.io.IOException;
import javafx.fxml.FXML;

import upv.ipc.sportlib.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class UserSettingsController implements Initializable {
  @FXML
  private Button btnBack;

  @FXML
  private Button btnChangeAvatar;

  @FXML
  private Button btnSave;

  @FXML
  private DatePicker dpBirthDate;

  @FXML
  private Circle imgAvatar;

  @FXML
  private Label lblStatus;

  @FXML
  private TextField txtEmail;

  @FXML
  private TextField txtNickname;

  @FXML
  private PasswordField txtPassword;

  private SportActivityApp app;
  private User currentUser;
  private String selectedAvatarPath = "";

  @Override
  public void initialize(URL url, ResourceBundle rb) {
    app = SportActivityApp.getInstance();
    currentUser = app.getCurrentUser();
    if (currentUser != null) {
      txtNickname.setText(currentUser.getNickName());
      txtEmail.setText(currentUser.getEmail());
      dpBirthDate.setValue(currentUser.getBirthDate());
      selectedAvatarPath = currentUser.getAvatarPath();
        System.out.println("\n\nAVATAR INIT\n\n");
        System.out.println("test: " + selectedAvatarPath);
    }
    loadAvatarImage();
  }

  private void loadAvatarImage() {
    System.out.println("\n\nLOAD IMAGE\n\n");
    if (currentUser != null && selectedAvatarPath != null && selectedAvatarPath.length() > 0) {
      imgAvatar.setFill(new ImagePattern(new Image(selectedAvatarPath)));
    } else {
      imgAvatar.setFill(new ImagePattern(new Image(getClass().getResourceAsStream("resources/user.png"))));
    }
  }

  @FXML
  void goBack(ActionEvent event) {
    try {
      App.setRoot("FXMLDocument");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @FXML
  void handleChangeAvatar(ActionEvent event) {
    FileChooser fc = new FileChooser();
    fc.setInitialDirectory(new File("."));

    fc.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg", "*.gif"));

    File imgFile = fc.showOpenDialog(txtNickname.getScene().getWindow());

    if (imgFile != null) {
        selectedAvatarPath = imgFile.toURI().toString();
        System.out.println("\n\nAVATAR CHANGE\n\n");
        System.out.println(selectedAvatarPath);
        
      Image img = new Image(selectedAvatarPath);

      imgAvatar.setFill(new ImagePattern(img));
    }
  }

  @FXML
  void handleSave() {
    lblStatus.getStyleClass().removeAll("text-error", "text-success");
    String email = txtEmail.getText().trim();
    String password = txtPassword.getText();
    LocalDate birthDate = dpBirthDate.getValue();

    if (!User.checkEmail(email)) {
      lblStatus.setText("El correo es inválido");
      lblStatus.getStyleClass().add("text-error");
      return;
    }
    
    if (password.length() == 0) {
        password = App.sportApp.getCurrentUser().getPassword();
    }
    
    if (password.length() < 8) {
      lblStatus.setText("La contraseña es demasiado corta");
      lblStatus.getStyleClass().add("text-error");
      return;
    }

    if (password.length() > 20) {
      lblStatus.setText("La contraseña es demasiado larga");
      lblStatus.getStyleClass().add("text-error");
      return;
    }

    boolean hasUpper = false;
    boolean hasLower = false;
    boolean hasDigit = false;
    boolean hasSymbol = false;

    String symbols = "!@#$%&*()-+=";

    for (int i = 0; i < password.length(); i++) {
      if (Character.isLetter(password.charAt(i))) {
        if (Character.isUpperCase(password.charAt(i)))
          hasUpper = true;
        else if (Character.isLowerCase(password.charAt(i)))
          hasLower = true;
      } else if (Character.isDigit(password.charAt(i))) {
        hasDigit = true;
      } else {
        for (int j = 0; j < symbols.length() && !hasSymbol; j++) {
          if (password.charAt(i) == symbols.charAt(j)) {
            hasSymbol = true;
            break;
          }
        }
      }
    }

    if (!hasUpper) {
      lblStatus.setText("La contraseña debe contener al menos una letra mayúscula");
      lblStatus.getStyleClass().add("text-error");
      return;
    }

    if (!hasLower) {
      lblStatus.setText("La contraseña debe contener al menos una letra minúscula");
      lblStatus.getStyleClass().add("text-error");
      return;
    }

    if (!hasDigit) {
      lblStatus.setText("La contraseña debe contener al menos un dígito");
      lblStatus.getStyleClass().add("text-error");
      return;
    }

    if (!hasSymbol) {
      lblStatus.setText("La contraseña debe contener al menos un símbolo");
      lblStatus.getStyleClass().add("text-error");
      return;
    }

    if (!User.checkPassword(password)) {
      lblStatus.setText("La contraseña es inválida");
      lblStatus.getStyleClass().add("text-error");
      return;
    }
    

    if (!User.isOlderThan(dpBirthDate.getValue(), 12)) {
      lblStatus.setText("La edad mínima es de 12 años");
      lblStatus.getStyleClass().add("text-error");
      return;
    }

    try {
      boolean correct = app.updateCurrentUser(email, password, birthDate, selectedAvatarPath);

      if (correct) {
        lblStatus.setText("Perfil actualizado con éxito");
        lblStatus.getStyleClass().add("text-success");
        txtPassword.clear();
      } else {
        lblStatus.setText("Error al actualizar los datos en el sistema");
        lblStatus.getStyleClass().add("text-error");
      }

    } catch (Exception e) {
      lblStatus.setText("Ocurrió un error inesperado al guardar.");
      lblStatus.getStyleClass().add("text-error");
      e.printStackTrace();
    }

  }

}
