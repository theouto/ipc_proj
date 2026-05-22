package ipc.project;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
<<<<<<< HEAD
    
=======
import javafx.scene.shape.Circle;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

>>>>>>> 4e0ea95 (fix register)
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
<<<<<<< HEAD
    protected TextField Nombre;

    @FXML
    protected TextField Correo;
=======
    private TextField nameTextField;

    @FXML
    private TextField mailTextField;
>>>>>>> 4e0ea95 (fix register)
    
    @FXML
    private Label profilePicturePath;
    
    @FXML
<<<<<<< HEAD
    protected PasswordField Passworten;
    
    @FXML
    protected DatePicker Calendar;
=======
    private PasswordField passTextField;
    
    @FXML
    private DatePicker birthdayPicker;
>>>>>>> 4e0ea95 (fix register)
    
    @FXML
    private Label nERR;
            
    @FXML        
    private Label cERR;
         
    @FXML
    private Label pERR;
           
    @FXML        
    private Label fERR;
    
    @FXML
    private Label wERR;
    
    @FXML
    private Circle circleAvatar;
    
    @FXML
    private void switchToMainScreen() throws IOException {
        App.setRoot("FXMLDocument");
    }
    
    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("UserLogin");
    }
    
    @FXML
    private void fotoPerfil() throws IOException {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("."));

        fc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        File imgFile = fc.showOpenDialog(nameTextField.getScene().getWindow());

        if (imgFile != null) {
            Image img = new Image(imgFile.toURI().toString());

            circleAvatar.setFill(new ImagePattern(img));
        }
    }
    
    @FXML
    private void createAccount() throws IOException {
        nERR.setOpacity(0);
        cERR.setOpacity(0);
        pERR.setOpacity(0);
        fERR.setOpacity(0);
        wERR.setOpacity(0);

        System.out.println(nameTextField.getText());
        
        String username = nameTextField.getText();
        if (username.length() < 6) {
            nERR.setText("El nombre es demasiado corto");
            nERR.setOpacity(1);
            return;
        }
        
        if (username.length() > 15) {
            nERR.setText("El nombre es demasiado largo");
            nERR.setOpacity(1);
            return;
        }
        
        if (!User.checkNickName(username)) {
            nERR.setText("Nombre de usuario inválido");
            nERR.setOpacity(1);
            return;
        }
        
        String mail = mailTextField.getText();
        
        if (!User.checkEmail(mail)) {
            cERR.setText("El correo es inválido");
            cERR.setOpacity(1);
            return;
        }
        
        String pass = passTextField.getText();
        
        if (pass.length() < 8) {
            pERR.setText("La contraseña es demasiado corta");
            pERR.setOpacity(1);
            return;
        }
        
        if (pass.length() > 20) {
            pERR.setText("La contraseña es demasiado larga");
            pERR.setOpacity(1);
            return;
        }
        
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;
        
        String symbols = "!@#$%&*()-+=";
        
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isLetter(pass.charAt(i))) {
                if (Character.isUpperCase(pass.charAt(i))) hasUpper = true;
                else if (Character.isLowerCase(pass.charAt(i))) hasLower = true;
            } else if (Character.isDigit(pass.charAt(i))) {
                hasDigit = true;
            } else {
                for (int j = 0; j < symbols.length() && !hasSymbol; j++) {
                    if (pass.charAt(i) == symbols.charAt(j)) {
                        hasSymbol = true;
                        break;
                    }
                }
            }
        }

        if (!hasUpper) {
            pERR.setText("La contraseña debe contener al menos una letra mayúscula");
            pERR.setOpacity(1);
            return;
        }
        
        if (!hasLower) {
            pERR.setText("La contraseña debe contener al menos una letra minúscula");
            pERR.setOpacity(1);
            return;
        }
        
        if (!hasDigit) {
            pERR.setText("La contraseña debe contener al menos un dígito");
            pERR.setOpacity(1);
            return;
        }
        
        if (!hasSymbol) {
            pERR.setText("La contraseña debe contener al menos un símbolo");
            pERR.setOpacity(1);
            return;
        }
        
        if (!User.checkPassword(pass)) {
            pERR.setText("La contraseña es inválida");
            pERR.setOpacity(1);
            return;
        }
        
        if (!User.isOlderThan(birthdayPicker.getValue(), 12)) {
            fERR.setText("La edad mínima es de 12 años");
            fERR.setOpacity(1);
            return;
        }
        
        if (!App.sportApp.registerUser(username, mail, pass, birthdayPicker.getValue(), profilePicturePath.getText())) {
            wERR.setText("No se ha podido registrar el usuario");
            wERR.setOpacity(1);
        } else { 
            App.sportApp.login(username, pass);
            App.loggedIn = true;
            App.setRoot("FXMLDocument");
        }
    }
    
    @FXML
    private void initialize() {
        Image noAvatarIMG = new Image("./resources/nopicture.png");
        circleAvatar.setFill(new ImagePattern(noAvatarIMG));
    }
}