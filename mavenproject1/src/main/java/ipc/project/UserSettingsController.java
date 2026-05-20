package ipc.project;

import java.io.IOException;
import javafx.fxml.FXML;

import upv.ipc.sportlib.*;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.DatePicker;
import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.net.URL;
import java.util.ResourceBundle;



/** esta realizado de forma diferente a como se menciona en la practica, se puede editar por separado */

public class UserSettingsController {

    @FXML
    private Label Correo2;

    @FXML
    private Label Nombre2;

    @FXML
    private Label Passworten2;

    @FXML
    private Label Calendar2;

    //@FXML
    //private ImageView Foto2;
        
    public void initialize(URL url, ResourceBundle rb)
    {
      Nombre2.setText(App.sportApp.getCurrentUser().getNickName());
      Correo2.setText(App.sportApp.getCurrentUser().getEmail());
      Passworten2.setText(App.sportApp.getCurrentUser().getPassword());
      Calendar2.setText(App.sportApp.getCurrentUser().getBirthDate().toString());
    }
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("FXMLDocument");
    }
   /** 
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
*/
    
    // @FXML
    
    //private void editFoto(ActionEvent event) throws IOException {
     //   UserCreationController.fotoPerfil(event);
        
    //}
     
    // Foto2.setImage(UserCreationController.Foto.getImage()); 
    
    @FXML
    private void nombreText(ActionEvent event) throws IOException {
         
    }
    
      @FXML
    private void correoText(ActionEvent event) throws IOException {
         
    }
      @FXML
    private void contraseñaText(ActionEvent event) throws IOException {
       
           }
    
      @FXML
    private void dateText(ActionEvent event) throws IOException {
         

           
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