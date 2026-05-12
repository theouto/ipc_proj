package ipc.project;

import java.io.IOException;
import javafx.scene.control.DatePicker;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import upv.ipc.sportlib.*;

public class UserCreationController {
    /*
    private String name;
    private String email;
    private String password; //YYEEAHHHH, PLAINTEXT STORAGE WOOOO
    private int year, month, day;
    
    No se necesita nada de esto, sacamos los valores directamente de lo que ya tenemos
    */
    
    @FXML
    private TextField Nombre;

    @FXML
    private TextField Correo;
    
    @FXML
    private TextField Passworten;
    
    @FXML
    private DatePicker Calendar;
    
    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("UserLogin");
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
    
    @FXML
    private void createAccount()
    {
        if (User.checkNickName(Nombre.getCharacters().toString())) return;
        if (User.checkEmail(Correo.getCharacters().toString())) return;
        if (User.checkPassword(Passworten.getCharacters().toString())) return;
        if (User.isOlderThan(Calendar.getValue(), 13)) return;
        
        System.out.println(Nombre.getCharacters());
    }
}