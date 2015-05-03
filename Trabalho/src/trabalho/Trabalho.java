/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ra143759
 */
public class Trabalho extends Application {
    
    public static String screen1ID = "FXMLPrincipal";
    public static String screen1File = "FXMLPrincipal.fxml";
    public static String screen2ID = "FXMLDocumentCliente";
    public static String screen2File = "FXMLDocumentCliente.fxml";
    public static String screen3ID = "FXMLPedido";
    public static String screen3File = "FXMLPedido.fxml";
    public static String screen4ID = "FXMLAgenda";
    public static String screen4File = "FXMLAgenda.fxml";

    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        
        ScreensController mainContainer = new ScreensController();
        mainContainer.loadScreen(Trabalho.screen1ID, Trabalho.screen1File);
        mainContainer.loadScreen(Trabalho.screen2ID, Trabalho.screen2File);
        mainContainer.loadScreen(Trabalho.screen3ID, Trabalho.screen3File);
        mainContainer.loadScreen(Trabalho.screen4ID, Trabalho.screen4File);
       
        mainContainer.setScreen(Trabalho.screen1ID);
        
        
        
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
