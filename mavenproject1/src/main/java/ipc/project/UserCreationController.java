package ipc.project;

import java.io.IOException;
import java.util.Date;
import javafx.fxml.FXML;

import upv.ipc.sportlib.*;

public class UserCreationController {
    
    private String name;
    private String email;
    private String password; //YYEEAHHHH, PLAINTEXT STORAGE WOOOO
    private Date DoB;

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
        if (User.checkNickName(name)) return;
        if (User.checkEmail(email)) return;
        if (User.checkPassword(password)) return;
        if (User.isOlderThan(DoB, 13)) return;
        
        //App.sportApp.registerUser("nick", "email", "pass", LocalDate, "avatar/path");
    }
}