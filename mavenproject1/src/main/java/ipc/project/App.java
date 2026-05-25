package ipc.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.List;

import upv.ipc.sportlib.*;

/**
 * JavaFX App
 */
public class App extends Application {
    
    protected static boolean loggedIn = false; //Si está loggeado, en vez de mandar al usuario a crear una cuenta,
                                               //se manda a los ajustes de la cuenta. También cambiará otras cosas
    private static Scene scene;
    
    protected static SportActivityApp sportApp;
    protected static List<Activity> activities;
    protected static String mapPath = "maps/upv.jpg";

    @Override
    public void start(Stage stage) throws IOException {
        sportApp = SportActivityApp.getInstance(); 

        scene = new Scene(loadFXML("FXMLDocument"), 640, 480);
        //scene.getStylesheets().add(getClass().getResource("history.css").toExternalForm());

        stage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/logo.png")));
        stage.setTitle("Running la Safor");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}