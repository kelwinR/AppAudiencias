/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cidades;
import model.Estados;

/**
 *
 * @author kelwin.rodrigues
 */
public class CidadesController {
     public boolean verificaExistencia(Cidades objeto)
    {
        try {
            //Conexao.abreConexao();
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
           
            String wSQL = " SELECT id_cidade FROM cidade WHERE nome = ? ";
            stmt = con.prepareStatement(wSQL);
            stmt.setString(1, objeto.getNome());    
    
            rs = stmt.executeQuery();
            
            if(rs.next()){
                return true; //se existir, retorna TRUE
            }else{
                return false;
            }
              
        } catch (SQLException ex ){
            System.out.println("ERRO de SQL: " + ex.getMessage());
            return false;
        }catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return false;
        }
		
    }
    
    public String incluir(Cidades objeto)
    {
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
            
            //VALIDAR SE O LOGIN EXISTE
            if(verificaExistencia(objeto) == true){
                return "Cidade Existe";
            }else{
           
                String wSQL = "INSERT INTO cidade VALUES(DEFAULT, ?, ?, ?)";
                stmt = con.prepareStatement(wSQL);
                stmt.setString(1, objeto.getNome());    
                stmt.setString(2, objeto.getCep());
                stmt.setInt(3, objeto.getId_estado());

                stmt.executeUpdate();
                
                return "";
            
            }
              
        } catch (SQLException ex ){
            System.out.println("ERRO de SQL: " + ex.getMessage());
            return "Erro";
        }catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return "Erro";
        }finally{
            return "";
        }
		
    }
}
