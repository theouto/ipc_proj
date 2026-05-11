package ipc.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import upv.ipc.sportlib.*;

/**
 * JavaFX App
 */
public class App extends Application {
    
    protected static boolean loggedIn; //Si está loggeado, en vez de mandar al usuario a crear una cuenta,
                                       //se manda a los ajustes de la cuenta. También cambiará otras cosas
    
    private static Scene scene;
    private static Scene secondaryScene;
    //private static Stage secondaryStage = new Stage(); //placeholder para cuando se use de verdad
                                                       //la idea actual es usarlo para ajustes de cuenta
                                                       //o cualquier otra ventana emergente con un 
                                                       //cierto grado de complejidad
    
    protected static SportActivityApp sportApp;
    protected static User currentUser;
    
    

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("FXMLDocument"), 640, 480);
        secondaryScene = new Scene(loadFXML("UserSettings"), 500, 500); //placeholder para cuando se use de verdad
        //sportApp = SportActivityApp.getInstance(); //arreglar java.sql.SQLException classnotfoundexception
        /*
        secondaryStage.setTitle("Yay!");
        secondaryStage.setScene(secondaryScene);
        */
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/logo.png")));
        stage.setTitle("Demo mapas - IPC");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    //public static void showWindow

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}