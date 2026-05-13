package ipc.project;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


import upv.ipc.sportlib.*;

public class UserLoginController {
    
    @FXML
    private TextField Usuario;
    
    @FXML
    private TextField Password;
    
    @FXML
    private void gotoRegisterFunction() throws IOException {
        App.setRoot("UserCreation");
    }
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("FXMLDocument");
    }
  
    @FXML
    private void login()
    {
        if (App.sportApp.login(Usuario.getCharacters().toString(), Password.getCharacters().toString()))
        {
            App.loggedIn = true;
            try { App.setRoot("FXMLDocument");
            } catch (IOException e) {System.out.println(e);}
        }
        else System.out.println("another thing");
    }
    
    @FXML
    private void logout()
    {
        App.sportApp.logout();
    }
}