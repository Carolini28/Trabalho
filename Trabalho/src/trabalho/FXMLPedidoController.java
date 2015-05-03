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
public class FXMLPedidoController implements Initializable,  ControlledScreen {

    ScreensController myController;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
     public void goToScreenP(ActionEvent event){
        myController.setScreen(Trabalho.screen1ID);
    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
         myController = screenParent;
    }
}
