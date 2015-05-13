/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class FXMLDocumentControllerCliente implements Initializable, ControlledScreen{

    ScreensController myController;
    
    @FXML
    private TextField tfnome;

    @FXML
    private TextField tffone;

    @FXML
    private TextField tfid;
    
    @FXML
    private TextField tfemail;

    @FXML
    private Label lbmsg;
    
    @FXML
    private TableView<Cliente> tvClientes;
    
    //Gerenciador de dados // CRUD
    ClienteService cliService = new ClienteService();
    
    
    public void setScreenParent(ScreensController screenParent){
        myController = screenParent;
    }

    @FXML
    private void aoClicarBtnSalvar(ActionEvent event) {
        System.out.println("Salvar1");
        Cliente cliente = new Cliente();
       
        cliente.setNome(tfnome.getText());
        cliente.setFone(tffone.getText());
        cliente.setEmail(tfemail.getText());

        try {
            cliService.salvar(cliente);
            //Mensagem
            lbmsg.setText("Salvo com Sucesso!");
        } catch (ServiceException ex) {
            lbmsg.setText(ex.getMessage());
            Logger.getLogger(FXMLDocumentControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void aoClicarBtnExcluir(ActionEvent event) {
        Integer id = Integer.parseInt(tfid.getText());
        cliService.excluir(id);
        lbmsg.setText("Excluído com Sucesso!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void aoClicarBtnBuscarPorId(){
        //Acessando ID da tela
        Integer id = Integer.parseInt(tfid.getText());
        Cliente clienteBuscado = cliService.buscarPorId(id);
        if(clienteBuscado!=null){
            tfnome.setText(clienteBuscado.getNome());
            tffone.setText(clienteBuscado.getFone());
            tfemail.setText(clienteBuscado.getEmail());
        }else{
            lbmsg.setText("Cliente nao encontrado!");
        }
    }
    
    @FXML
    public void aoClicarBtnBuscarTodos(){
        
       
        
        tvClientes.setEditable(true);
        
        TableColumn nome = new TableColumn("nome");
        nome.setMinWidth(100);
        nome.setCellValueFactory(
                new PropertyValueFactory<Cliente, String>("nome"));
 
        TableColumn fone = new TableColumn("fone");
        fone.setMinWidth(100);
        fone.setCellValueFactory(
                new PropertyValueFactory<Cliente, String>("fone"));
 
        TableColumn email = new TableColumn("email");
        email.setMinWidth(200);
        email.setCellValueFactory(
                new PropertyValueFactory<Cliente, String>("email"));
        
        
        tvClientes.getColumns().addAll(nome, fone, email);
        
        
        //Lista de Clientes
        List<Cliente> listaCliente =  cliService.buscarTodos();
        //Inserindo a lista de um Observable
        final ObservableList<Cliente> dados = FXCollections.observableArrayList(listaCliente);
        
        tvClientes.setItems(dados);
   
       
    }
    @FXML
     public void goToScreenP(ActionEvent event){
        myController.setScreen(Trabalho.screen1ID);
    }

}
