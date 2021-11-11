/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.Conexao;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.TipoParte;


/**
 *
 * @author Windows 10
 */
public class TipoParteController {
    
    public TipoParte buscar(String codigo)
    {
        TipoParte objTipoParte = null;
        try {
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
           
            String wSQL = " SELECT * FROM tipo_parte WHERE id = ? ";
            stmt = con.prepareStatement(wSQL);
            stmt.setInt(1, Integer.parseInt(codigo));   
    
            rs = stmt.executeQuery();
            
            if(rs.next()){
                objTipoParte = new TipoParte();
                
                objTipoParte.setId(rs.getInt("id"));
                objTipoParte.setTipo(rs.getString("tipo"));

            }
              
        } catch (SQLException ex ){
            System.out.println("ERRO de SQL: " + ex.getMessage());
            return null;
        }catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
        
        return objTipoParte;
		
    }
    
    public boolean verificaExistencia(TipoParte objeto)
    {
        try {
            //Conexao.abreConexao();
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
           
            String wSQL = " SELECT id FROM tipo_parte WHERE tipo = ?";
            stmt = con.prepareStatement(wSQL);
            stmt.setString(1, objeto.getTipo());  
    
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
    
    public String incluir(TipoParte objeto)
    {
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
            
            //VALIDAR SE O LOGIN EXISTE
            if(verificaExistencia(objeto) == true){
                return "Tipo de parte já Existe";
            }else{
           
                String wSQL = " INSERT INTO tipo_parte VALUES(DEFAULT, ?)";
                stmt = con.prepareStatement(wSQL);
                stmt.setString(1, objeto.getTipo());      


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
    
    public boolean alterar(TipoParte objeto){
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
            
            //VALIDAR SE O LOGIN EXISTE
                String wSQL = " UPDATE tipo_parte SET tipo = ? WHERE id = ?";
                stmt = con.prepareStatement(wSQL);
                stmt.setString(1, objeto.getTipo());               
                stmt.setInt(2, objeto.getId());
                

                stmt.executeUpdate();
              
        } catch (SQLException ex ){
            System.out.println("ERRO de SQL: " + ex.getMessage());
            return false;
        }catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return false;
        }finally{
            return true;
        }
    } 
    
    
    
    
    
    public boolean excluir(String codigo)
    {
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
              
            String wSQL = " DELETE FROM tipo_parte WHERE id = ? ";
            stmt = con.prepareStatement(wSQL);
            stmt.setInt(1, Integer.parseInt(codigo));

            stmt.executeUpdate();
            
            return true;
              
        } catch (SQLException ex ){
            System.out.println("ERRO de SQL: " + ex.getMessage());
            return false;
        }catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return false;
        }		
    }
    
    public void preencher(JTable jtbUsuarios) {

        Conexao.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector(); //receber os dados do banco
        
        cabecalhos.add("Id");
        cabecalhos.add("Tipo");
        cabecalhos.add("Exc");
             
        ResultSet result = null;
        
        try {

            String wSql = " SELECT id, tipo FROM tipo_parte ORDER BY tipo ";
            
            result = Conexao.stmt.executeQuery(wSql);
            
            Vector<Object> linha;
            while(result.next()) {
                linha = new Vector<Object>();
                
                linha.add(result.getInt(1));
                linha.add(result.getString(2));    

                linha.add("X");
                
                dadosTabela.add(linha);
            }
            
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }        

        jtbUsuarios.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {


            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }
            // permite seleção de apenas uma linha da tabela
        });


        // permite seleção de apenas uma linha da tabela
        jtbUsuarios.setSelectionMode(0);


        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i <= 2; i++) {
            column = 

            jtbUsuarios.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(60);//id 
                    break;
                case 1:
                    column.setPreferredWidth(200);//nome
                    break;
                case 2:
                    column.setPreferredWidth(10);//x do excluir
                    break;
            }
        }
        
        //função para deixar a tabela zebrada
        jtbUsuarios.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) 
            {
                super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                if (row % 2 == 0) {
                    setBackground(Color.GRAY);
                } else {
                    setBackground(Color.WHITE);
                }
                
                return this;
            }
        });
        //return (true);
    }
}
