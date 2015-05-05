/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;

/**
 *
 * @author Carolini
 */
public class PedidoDAO {
    
    Connection conexao;

    public PedidoDAO() {
        conexao = ConexaoUtil.getConnection();
    }
    
    
    
    
    @FXML
    public void salvarItemPedido (ItemPedido item){
    
        String sql = "INSERT  INTO itempedido (quantidade, valor, idpedido, idproduto) values (?,?,?,?)";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setInt(1, item.getQuantidade());
            preparadorSQL.setDouble(2, item.getValor());
            preparadorSQL.setInt(3, item.getIdpedido());
            preparadorSQL.setInt(4, item.getIdproduto());
            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
    @FXML
    public void salvarPedido (Pedido pedido) {
        
        String sql = "INSERT  INTO pedido (origempedido,datapedido,cerimonial, dataevento,"
                + " horaevento, indicacao, endereco, observacao, localevento, idcliente, idtipoevento)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setString(1, pedido.getOrigempedido());
            preparadorSQL.setString(2, pedido.getDatapedido());
            preparadorSQL.setString(3, pedido.getCerimonial());
            preparadorSQL.setString(4, pedido.getDataevento());
            preparadorSQL.setString(5, pedido.getHoraevento());
            preparadorSQL.setString(6, pedido.getIndicacao());
            preparadorSQL.setString(7, pedido.getEndereco());
            preparadorSQL.setString(8, pedido.getObservacao());
            preparadorSQL.setString(9, pedido.getLocalevento());
            preparadorSQL.setInt(10, pedido.getIdcliente());
            preparadorSQL.setInt(11, pedido.getIdtipoevento());
            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public int buscarPorIdPedido() {
        String sql = "SELECT MAX(idpedido) idpedido FROM pedido";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            //Armazenando Resultado da consulta
            ResultSet resultado = preparadorSQL.executeQuery();
            if (resultado.next()) {
                //Instancia de cliente
                int IdP;

                //Atribuindo dados do resultado no objeto cliente
               
                IdP = resultado.getInt("idpedido");
                preparadorSQL.close();
                return IdP + 1;
            } else {
                return 0;
            }
        } catch (SQLException ex) {

            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }

    }


    
}
