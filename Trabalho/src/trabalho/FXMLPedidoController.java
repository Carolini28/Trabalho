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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Carolini
 */
public class FXMLPedidoController implements Initializable,  ControlledScreen {

    ScreensController myController;
    
     @FXML
     private TextField origemPedido;
     
     @FXML
     private TextField dataPedido;
             
     @FXML
     private TextField cerimonial;
             
     @FXML
     private TextField dataEvento;
             
     @FXML
     private TextField  HoraEvento;
             
     @FXML
     private TextField indicacao;
     
     @FXML
     private TextField endereco;
             
     @FXML
     private TextField observacao;
              
     @FXML
     private TextField LocalEvento;
     
     @FXML
     private ComboBox evento;
     
     @FXML
     private ComboBox cliente;
     
     @FXML
     private ComboBox produto;
     
     @FXML
     private TextField quantidade;
     
     @FXML
     private TableView<ItemPedido> tvItemPedido;
     
    
    PedidoService pedidoService = new PedidoService();
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
    
    @FXML
    public void aoClicarBtnSalvarPedido (ActionEvent event) {
    
    
    
    }
}
