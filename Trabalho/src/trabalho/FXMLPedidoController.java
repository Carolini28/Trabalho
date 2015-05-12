/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
     
     @FXML
     private TextField TotalPedido;
     
     @FXML
     private Label lbmsg;
     
    
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
    public void aoClicarBtnSalvarPedido (ActionEvent event) throws ServiceException, ParseException {
        
        Pedido pedido = new Pedido();
        int Idevento, Idcliente;
        
        pedido.setOrigempedido(origemPedido.getText());
        pedido.setDatapedido(dataPedido.getText());
        pedido.setCerimonial(cerimonial.getText());
        pedido.setDataevento(dataEvento.getText());
        pedido.setHoraevento(HoraEvento.getText());
        pedido.setIndicacao(indicacao.getText());
        pedido.setEndereco(endereco.getText());
        pedido.setObservacao(observacao.getText());
        pedido.setLocalevento(LocalEvento.getText());
        pedido.setCliente(cliente.getValue().toString());
        pedido.setEvento(evento.getValue().toString());
        
        Idevento = pedidoService.buscaIdEvento(evento.toString());
        Idcliente = pedidoService.buscaIdcliente(cliente.toString());
        
        pedido.setIdCliente(Idcliente);
        pedido.setIdEvento(Idevento);
        
        tvItemPedido.setEditable(true);
            
            TableColumn descricao = new TableColumn("Descricao");
            descricao.setMinWidth(100);
            descricao.setCellValueFactory(
                    new PropertyValueFactory<ItemPedido, String>("descricao"));

            TableColumn quantidade = new TableColumn("Quantidade");
            quantidade.setMinWidth(100);
            quantidade.setCellValueFactory(
                    new PropertyValueFactory<Cliente, String>("quantidade"));

            TableColumn valor = new TableColumn("Valor");
            valor.setMinWidth(200);
            valor.setCellValueFactory(
                    new PropertyValueFactory<Cliente, String>("valor"));
            
            TableColumn status = new TableColumn("Status");
            status.setMinWidth(100);
            status.setCellValueFactory(
                    new PropertyValueFactory<ItemPedido, String>("status"));
        
        
            tvItemPedido.getColumns().addAll(descricao, quantidade, valor, status);
            
        
        
        try {
            pedidoService.salvarPedido(pedido);
            //Mensagem
            lbmsg.setText("Pedido Salvo com Sucesso!");
            System.out.println("Salvo com Sucesso!");
        } catch (ServiceException ex) {
            
            Logger.getLogger(FXMLPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    @FXML
    public void aoClicarBtnAdicionar (ActionEvent event) throws ServiceException{
    
        ItemPedido item = new  ItemPedido();
        int IdProduto;
        
        IdProduto = pedidoService.buscaIdProduto(produto.getValue().toString());
        
        System.out.println("Idproduto: " + IdProduto);
        System.out.println("produto: " + produto.getValue().toString());
        System.out.println("Quantidade: " + quantidade.getText());

        item.setIdproduto(IdProduto);
        item.setDescricao(produto.toString().toString());
        item.setQuantidade(Integer.parseInt(quantidade.getText()));
        
        try{
            pedidoService.salvarItem(item);

            //Aparecer valor total
            TotalPedido.setText(String.valueOf(pedidoService.ValorTotal()));
          
            //Aparecer itens na tabela
            List<ItemPedido> listaItens =  pedidoService.buscarItensPedido();
            //Inserindo a lista de um Observable
            final ObservableList<ItemPedido> dados = FXCollections.observableArrayList(listaItens);
        
            
            tvItemPedido.setItems(dados);
            
            
            System.out.println("Item Salvo com Sucesso!");
            lbmsg.setText("Item Salvo com Sucesso!");
        } catch (ServiceException ex){
           
            Logger.getLogger(FXMLPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
