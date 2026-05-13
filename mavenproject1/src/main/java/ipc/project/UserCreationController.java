package ipc.project;

import java.io.IOException;
import javafx.scene.control.DatePicker;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

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
    private Label nERR;
            
    @FXML        
    private Label cERR;
         
    @FXML
    private Label pERR;
           
    @FXML        
    private Label fERR;
    
    @FXML
    private void switchToMainScreen() throws IOException {
        App.setRoot("FXMLDocument");
    }
    
    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("UserLogin");
    }
    
    @FXML
    private void createAccount() throws IOException
    {
        nERR.setOpacity(0);
        cERR.setOpacity(0);
        pERR.setOpacity(0);
        fERR.setOpacity(0);
        
        if (!User.checkNickName(Nombre.getCharacters().toString()))
        {
            System.out.println("invalid nick");
            nERR.setOpacity(1);
            return;
        }
        
        if (!User.checkEmail(Correo.getCharacters().toString()))
        {
            System.out.println("invalid email");
            System.out.println(Correo.getCharacters());
            cERR.setOpacity(1);
            return;
        }
        
        if (!User.checkPassword(Passworten.getCharacters().toString()))
        {
            System.out.println("invalid password");
            pERR.setOpacity(1);
            return;
        }
        
        if (!User.isOlderThan(Calendar.getValue(), 12))
        {
            System.out.println("invalid age");
            fERR.setOpacity(1);
            return;
        }
        
        System.out.println(Nombre.getCharacters());
        
        if (!App.sportApp.registerUser(Nombre.getCharacters().toString(),
                                  Correo.getCharacters().toString(),
                                  Passworten.getCharacters().toString(),
                                  Calendar.getValue(),
                                  "logo.png"))
        {
            System.out.println("Unable to register user!");
        } else { 
            System.out.println("Sucessfully registered user");
            App.sportApp.login(Nombre.getCharacters().toString(),
                               Passworten.getCharacters().toString());
            App.loggedIn = true;
            App.setRoot("FXMLDocument");
        }
        
    }
}