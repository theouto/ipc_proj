package ipc.project;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import upv.ipc.sportlib.*;

public class UserLoginController {
    
    @FXML
    private TextField userTextField;
    
    @FXML
    private TextField passTextField;
    
    @FXML
    private Label nERR;
    
    @FXML
    private Label pERR;
    
    @FXML
    private void gotoRegisterFunction() throws IOException {
        App.setRoot("UserCreation");
    }
    
    @FXML
    private void switchToMainScreen() throws IOException {
        App.setRoot("FXMLDocument");
    }
    
    @FXML
    private void login() {
        nERR.setOpacity(0);
        pERR.setOpacity(0);
        
        String username = userTextField.getText();
        if (!User.checkNickName(username)) {
            nERR.setText("Este usuario es inválido");
            nERR.setOpacity(1);
            return;
        }
        
        String pass = passTextField.getText();
        
        if (App.sportApp.login(username, pass)) {
            App.loggedIn = true;
            try { App.setRoot("FXMLDocument");
            } catch (IOException e) {System.out.println("Something went wrong! " + e);}
        } else {
            pERR.setText("Nombre de usuario y/o contraseña incorrectos");
            pERR.setOpacity(1);
            return;
        }
    }
    
    @FXML
    private void logout()
    {
        App.sportApp.logout();
    }
}