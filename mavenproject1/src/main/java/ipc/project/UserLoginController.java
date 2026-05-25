package ipc.project;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


import upv.ipc.sportlib.*;

public class UserLoginController {
    
    @FXML
    private TextField Usuario;
    
    @FXML
    private TextField Password;
    
    @FXML
    private Label nERR;
    
    @FXML
    private void gotoRegisterFunction() throws IOException {
        App.setRoot("UserCreation");
    }
    
    //Esta función ahora es inutil, por lo que la voy a hacer una herramienta para acelerar el debugging
    @FXML
    private void switchToSecondary() throws IOException {
        //Usuario.setText("aaaaaaa");
        //Password.setText("aaaAAA!!!111");
        //login();
        App.setRoot("FXMLDocument"); //para que siga sirviendo la vista de guest
    }
  
    @FXML
    private void login()
    {
         if (!User.checkNickName(Usuario.getCharacters().toString()))
        {
            System.out.println("Incorrect nickname or password"); //Es el mismo texto por razones de seguridad
            nERR.setOpacity(1);
            return;
        }
         
        if (!User.checkPassword(Password.getCharacters().toString()))
        {
            System.out.println("Incorrect nickname or password"); //Es el mismo texto por razones de seguridad
            nERR.setOpacity(1);
            return;
        }
        
        if (App.sportApp.login(Usuario.getCharacters().toString(), Password.getCharacters().toString()))
        {
            App.loggedIn = true;
            try { App.setRoot("FXMLDocument");
            } catch (IOException e) {System.out.println("Something went wrong! " + e);}
        }
        else System.out.println("another thing");
    }
    
    @FXML
    private void logout()
    {
        App.sportApp.logout();
    }
}