/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.dao;

import erp.jdbc.ConnectionFactory;
import erp.objects.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Neto
 */
public class ProdutoDAO {
    
    private Connection con;
    
    public ProdutoDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void adicionarProduto(Produto obj){
        try {
            String sql = "insert into produto (nome, precodecompra, precodevenda, fornecedor, estoque, unidade) values (?,?,?,?,?,?)";
            
            PreparedStatement stm = con.prepareStatement(sql);
            //stm.setString(1, obj.getNome());
            stm.setString(1, obj.getNome());
            stm.setInt(2, obj.getPrecoComp());
            stm.setDouble(3, obj.getPrecoVend());
            stm.setInt(4, obj.getFornecedor());
            stm.setString(5, obj.getEstoque());
            stm.setString(6, obj.getUnidade());
         
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    public void updateProduto(Produto obj){
        try {
            String sql = "update produto set nome=?, precodecompra=?, precodevenda=?, fornecedor=?,"
                    + " estoque=?, estoque=? where id=?";
            
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, obj.getNome());
            stm.setInt(2, obj.getPrecoComp());
            stm.setDouble(3, obj.getPrecoVend());
            stm.setInt(4, obj.getFornecedor());
            stm.setString(5, obj.getEstoque());
            stm.setString(6, obj.getUnidade());
            stm.setInt(7, obj.getId());
            
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    public void deleteProduto(Produto obj){
        
        try {
            String sql = "delete from produto where id=?";
            
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, obj.getId());
            
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Excluido");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    public List<Produto> listarProduto(){
        try {
            List<Produto> lista = new ArrayList<>();
            
            String sql = "select * from produto";
            
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            
            while (rs.next()){
                Produto obj = new Produto();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setPrecoComp(rs.getInt("precodecompra"));
                obj.setPrecoVend(rs.getDouble("precodevenda"));
                obj.setFornecedor(rs.getInt("fornecedor"));
                obj.setEstoque(rs.getString("estoque"));
                obj.setUnidade(rs.getString("unidade"));
                
                
                lista.add(obj);
                     
            }
            
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
            return null;
        }
    }
    
    public List<Produto> buscarProdutoPorNome(String nome){
        try {
            List<Produto> lista = new ArrayList<>();
            
            String sql = "select * from produto where nome like  ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Produto obj = new Produto();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setPrecoComp(rs.getInt("precodecompra"));
                obj.setPrecoVend(rs.getDouble("precodevenda"));
                obj.setFornecedor(rs.getInt("fornecedor"));
                obj.setEstoque(rs.getString("estoque"));
                obj.setUnidade(rs.getString("unidade"));
               
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"Erro " + e);
            return null;
        }
    }
    
    public void baixaEstoque(int id, int qtd_nova){
      try {

            String sql = "update produto  set estoque= ?  where id=?";
            
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();

         

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro : " + erro);

        }
    }
    
     public void adicionarEstoque(int id, int qtd_nova) {
        try {

            String sql = "update produto  set estoque= ?  where id=?";
           
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();

          

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro : " + erro);

        }

    }
     
      public int retornaEstoqueAtual(int id) {
        try {
            int qtd_estoque = 0;

            String sql = "SELECT estoque from produto where id = ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {           
                qtd_estoque = (rs.getInt("estoque"));    
            }

            return qtd_estoque;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    } }
    

       
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

