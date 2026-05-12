package ipc.project;

import java.io.IOException;
import javafx.fxml.FXML;

import upv.ipc.sportlib.*;

public class UserLoginController {
    
    @FXML
    private void gotoRegisterFunction() throws IOException {
        App.setRoot("UserCreation");
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