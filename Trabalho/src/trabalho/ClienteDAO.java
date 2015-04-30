/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ra143759
 */
class ClienteDAO {
    
    Connection conexao;

    public ClienteDAO() {
        conexao = ConexaoUtil.getConnection();
    }

    public Cliente buscarPorId(Integer id) {
        String sql = "select * from cliente where id=?";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setInt(1, id);
            //Armazenando Resultado da consulta
            ResultSet resultado = preparadorSQL.executeQuery();
            if (resultado.next()) {
                //Instancia de cliente
                Cliente cli = new Cliente();

                //Atribuindo dados do resultado no objeto cliente
                cli.setId(id);
                cli.setNome(resultado.getString("nome"));
                cli.setFone(resultado.getString("fone"));
                preparadorSQL.close();
                return cli;
            } else {
                return null;
            }
        } catch (SQLException ex) {

            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public List<Cliente> buscarTodos() {
        String sql = "select * from cliente order by id";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            //Armazenando Resultado da consulta
            ResultSet resultado = preparadorSQL.executeQuery();
            List<Cliente> lista = new ArrayList<>();
            while (resultado.next()) {
                //Instancia de cliente
                Cliente cli = new Cliente();

                //Atribuindo dados do resultado no objeto cliente
                cli.setId(resultado.getInt("id"));
                cli.setNome(resultado.getString("nome"));
                cli.setFone(resultado.getString("fone"));
                //Adicionando cliente na lista
                lista.add(cli);
            }
            
            preparadorSQL.close();
            return lista;
        } catch (SQLException ex) {

            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public void salvar(Cliente cliente) {
        if (cliente.getId() == null) {
            cadastrar(cliente);
        } else {
            alterar(cliente);
        }
    }

    public void cadastrar(Cliente cliente) {
        String sql = "insert  into cliente (nome,fone) values (?,?)";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setString(1, cliente.getNome());
            preparadorSQL.setString(2, cliente.getFone());
            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void alterar(Cliente cliente) {
        String sql = "update cliente set nome=? ,fone=? where id=?";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setString(1, cliente.getNome());
            preparadorSQL.setString(2, cliente.getFone());
            preparadorSQL.setInt(3, cliente.getId());
            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void excluir(Integer id) {
        String sql = "delete from cliente where id=?";

        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setInt(1, id);

            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
