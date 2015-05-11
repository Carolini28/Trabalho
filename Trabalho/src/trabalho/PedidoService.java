/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.util.List;

/**
 *
 * @author Carolini
 */
public class PedidoService {
    
    private PedidoDAO  pedidoDAO;
    
    int idPedido;
    
    public PedidoService() {
        pedidoDAO = new PedidoDAO();
    }
    
    public void salvarPedido (Pedido pedido) throws ServiceException{
 
        if(pedido.getOrigempedido().isEmpty()) {
            throw new ServiceException("Campo Origem Pedido é obrigatório!");
        }

        if(pedido.getDatapedido().isEmpty()) {
            throw new ServiceException("Campo Data Pedido é obrigatório!");
        }
        
        if(pedido.getCerimonial().isEmpty()){
            throw new ServiceException("Campo Cerimonial é obrigatório!");
        }
        
        if(pedido.getDataevento().isEmpty()){
             throw new ServiceException("Campo Data Evento é obrigatório!");
        }
        
        if(pedido.getHoraevento().isEmpty()){
            throw new ServiceException("Campo Hora de Evento é obrigatório!");
        }
        
        if(pedido.getIndicacao().isEmpty()){
            throw new ServiceException("Campo Indicação é obrigatório!");
        }
        
        if(pedido.getEndereco().isEmpty()){
            throw new ServiceException("Campo Endereço é obrigatório!");
        }
        
        if(pedido.getObservacao().isEmpty()){
            throw new ServiceException("Campo Observação é obrigatório!");
        }
        
        if(pedido.getLocalevento().isEmpty()){
            throw new ServiceException("Campo Local Evento é obrigatório!");
        }
        
        if(pedido.getEvento().isEmpty()){
            throw new ServiceException("Selecionar Tipo do Evento!");
        } 
        
        if(pedido.getCliente().isEmpty()){
            throw new ServiceException("Selecionar Cliente!");
        }
        
       pedidoDAO.salvarPedido(pedido);
        
    }
    
 
    public void salvarItem (ItemPedido item) throws ServiceException{
        
       idPedido =  pedidoDAO.buscarPorIdPedido();
        
       
       double valorTotalItem;
       double valorProduto;
       
       if(item.getDescricao().isEmpty()){
            throw new ServiceException("Selecionar Produto!");
       }
       
       if(item.getQuantidade() == 0){
           throw new ServiceException("Campo Quantidade é obrigatório!");
       }
       
       System.out.println("Idpedido: "+ idPedido);
       
       
       valorProduto =  pedidoDAO.buscarPorIdProduto(item.getIdproduto());
       System.out.println("valorProduto: "+ valorProduto);
       valorTotalItem =  (valorProduto * item.getQuantidade());
       System.out.println("valorTotalItem: "+ valorTotalItem);
       
       
       item.setIdpedido(idPedido);
       item.setValor(valorTotalItem);
       
       pedidoDAO.salvarItemPedido(item);
       
        
    }
    
    
    public double ValorTotal (){
        idPedido =  pedidoDAO.buscarPorIdPedido();
        return pedidoDAO.buscarValorTotal(idPedido);
    
    }
    
    public List<ItemPedido> buscarItensPedido() {
            idPedido =  pedidoDAO.buscarPorIdPedido();
            return pedidoDAO.buscarItemPedido(idPedido);
    }
    
    public int buscaIdcliente(String nome){
        return pedidoDAO.buscarCliente(nome);
    
    }
    
    public int buscaIdEvento(String evento){
        return pedidoDAO.buscarEvento(evento);
    
    
    }
    
    public int buscaIdProduto(String produto){
        return pedidoDAO.buscarProduto(produto);
    }
    
    
    
    
}
