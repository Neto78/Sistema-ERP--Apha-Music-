/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erp.dao;

import erp.jdbc.ConnectionFactory;
import erp.objects.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Neto
 */
public class FuncionarioDAO {
    
  private Connection con;
    
    public FuncionarioDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void adicionarFuncionario(Funcionario obj){
        try {
            String sql = "insert into funcionario (login, senha, nivelacesso, nome, rg, cpf, "
                    + "endereco, cep, cidade, uf, numero, bairro) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, obj.getLogin());
            stm.setString(2, obj.getSenha());
            stm.setString(3, obj.getNiveldeacesso());
            stm.setString(4, obj.getNome());
            stm.setString(5, obj.getRg());
            stm.setString(6, obj.getCpf());
            stm.setString(7, obj.getEndereco());
            stm.setString(8, obj.getCep());
            stm.setString(9, obj.getCidade());
            stm.setString(10, obj.getUf());
            stm.setString(11, obj.getNumero());
            stm.setString(12, obj.getBairro());
            
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    public void updateFuncionario(Funcionario obj){
        try {
            String sql = "update funcionario set login=?, senha=?, nivelacesso=?,"
                    + " nome=?, rg=?, cpf=?, endereco=?, cep=?, cidade=?, uf=?, numero=?, bairro=? where id=?";
            
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, obj.getLogin());
            stm.setString(2, obj.getSenha());
            stm.setString(3, obj.getNiveldeacesso());
            stm.setString(4, obj.getNome());
            stm.setString(5, obj.getRg());
            stm.setString(6, obj.getCpf());
            stm.setString(7, obj.getEndereco());
            stm.setString(8, obj.getCep());
            stm.setString(9, obj.getCidade());
            stm.setString(10, obj.getUf());
            stm.setString(11, obj.getNumero());
            stm.setString(12, obj.getBairro());
            stm.setInt(13, obj.getId());
            
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso");
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    public void deleteFuncionario(Funcionario obj){
        
        try {
            String sql = "delete from funcionario where id=?";
            
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, obj.getId());
            
            stm.execute();
            stm.close();
            
            JOptionPane.showMessageDialog(null, "Excluido");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
        }
    }
    
    public List<Funcionario> listarFuncionario(){
        try {
            List<Funcionario> lista = new ArrayList<>();
            
            String sql = "select * from funcionario";
            
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            
            
            while (rs.next()){
                Funcionario obj = new Funcionario();
                
                obj.setId(rs.getInt("id"));
                obj.setLogin(rs.getString("login"));
                obj.setSenha(rs.getString("senha"));
                obj.setNiveldeacesso(rs.getString("nivelacesso"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setCep(rs.getString("cep"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("uf"));
                obj.setNumero(rs.getString("numero"));
                obj.setBairro(rs.getString("bairro"));
                
                lista.add(obj);
                     
            }
            
            return lista;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e);
            return null;
        }
    }
    
    public List<Funcionario> buscarFuncionarioPorNome(String nome){
        try {
            List<Funcionario> lista = new ArrayList<>();
            
            String sql = "select * from funcionario where nome like  ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Funcionario obj = new Funcionario();
                
              obj.setId(rs.getInt("id"));
                obj.setLogin(rs.getString("login"));
                obj.setSenha(rs.getString("senha"));
                obj.setNiveldeacesso(rs.getString("nivelacesso"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setCep(rs.getString("cep"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("uf"));
                obj.setNumero(rs.getString("numero"));
                obj.setBairro(rs.getString("bairro"));
                
                lista.add(obj);
            }
            return lista;
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,"Erro " + e);
            return null;
        }
        
    }

   
    }

    
      
    

    
    

