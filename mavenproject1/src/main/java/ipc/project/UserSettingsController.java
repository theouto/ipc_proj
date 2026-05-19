package ipc.project;

import java.io.IOException;
import javafx.fxml.FXML;

import upv.ipc.sportlib.*;


public class UserSettingsController {

    @FXML
    private TextField Correo2;

    @FXML
    private TextField Nombre2;

    @FXML
    private TextField Passworten2;

    @FXML
    private DatePicker Calendar2;

    @FXML
    private ImageField Foto2;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Nombre2.setText(UserCreation.Nombre.getText());
        Passworten2.setText(UserCreation.Passworten.getText());
        Calendar2.setText(UserCreation.Calendar.getValue().toString());
        Foto2.setImage(UserCreation.Foto.getImage());
        
        
    }
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("FXMLDocument");
    }
    
     @FXML
    private void editCorreo(ActionEvent event) throws IOException {
        Correo2.setDisable(Correo2.isDisable());
    }
    
     @FXML
    private void editContraseña(ActionEvent event) throws IOException {
        Passworten2.setDisable(Passworten2.isDisable());
    }
    
     @FXML
    private void editCalendar(ActionEvent event) throws IOException {
        Calendar2.setDisable(Calendar2.isDisable());
    }
    
     @FXML
    private void editFoto(ActionEvent event) throws IOException {
        UserCreation.fotoPerfil(event);
        
    }
    
    
    
     @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("FXMLDocument");
    }
    
    
  
    private void login()
    {
        if (App.sportApp.login("name", "password")) System.out.println("one thing");
        else System.out.println("another thing");
    }
    
    private void logout()
    {
        App.sportApp.logout();
    }
    
    private void createAccount()
    {
        //App.sportApp.registerUser("nick", "email", "pass", LocalDate, "avatar/path");
    }



}