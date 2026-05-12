package ipc.project;

import java.io.IOException;
import java.time.LocalDate;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import upv.ipc.sportlib.*;

public class UserCreationController {
    
    private String name;
    private String email;
    private String password; //YYEEAHHHH, PLAINTEXT STORAGE WOOOO
    private int year, month, day;
    
    @FXML
    private TextField Nombre;

    @FXML
    private TextField Correo;
    
    @FXML
    private TextField Passworten;
    
    
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
    
    private void createAccount()
    {
        if (User.checkNickName(name)) return;
        if (User.checkEmail(email)) return;
        if (User.checkPassword(password)) return;
        if (User.isOlderThan(LocalDate.of(year, month, day), 13)) return;
        
        //App.sportApp.registerUser("nick", "email", "pass", LocalDate, "avatar/path");
    }
}