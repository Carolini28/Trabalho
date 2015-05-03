/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Carolini
 */
public class FXMLPrincipalController implements Initializable, ControlledScreen{

    ScreensController myController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }
    
    @FXML
    public void goToScreen2(ActionEvent event){
        myController.setScreen(Trabalho.screen2ID);
    }
    
    @FXML
    public void goToScreen3(ActionEvent event){
         myController.setScreen(Trabalho.screen3ID);
    }
    @FXML
    public void goToScreen4(ActionEvent event){
         myController.setScreen(Trabalho.screen4ID);
    }
    
}
