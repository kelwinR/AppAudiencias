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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Audiencias;
//import model.Usuario;

/**
 *
 * @author 
 */
public class AudienciasController {
    
    public Audiencias buscar(String codigo)
    {
        Audiencias objAudiencias = null;
        try {
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
           
            String wSQL = " SELECT * FROM audiencia WHERE id = ? ";
            stmt = con.prepareStatement(wSQL);
            stmt.setInt(1, Integer.parseInt(codigo));   
    
            rs = stmt.executeQuery();
            
            if(rs.next()){
                objAudiencias = new Audiencias();
                
                objAudiencias.setId(rs.getInt("id"));
                objAudiencias.setData(rs.getString("data"));
                objAudiencias.setId_processo(rs.getInt("id_processo"));
                objAudiencias.setId_sala(rs.getInt("id_sala"));
                objAudiencias.setId_status(rs.getInt("id_status"));
                objAudiencias.setId_evento(rs.getInt("id_evento"));

            }
              
        } catch (SQLException ex ){
            System.out.println("ERRO de SQL: " + ex.getMessage());
            return null;
        }catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
        
        return objAudiencias;
		
    }
    
    public boolean verificaExistencia(Audiencias objeto)
    {
        try {
            //Conexao.abreConexao();
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
           
            String wSQL = " SELECT id FROM audiencia WHERE data = ? AND id_processo = ?";
            stmt = con.prepareStatement(wSQL);
            stmt.setString(1, objeto.getData());
            stmt.setInt(2, objeto.getId_processo()); 
    
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
    
    public String incluir(Audiencias objeto)
    {
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
            
            //VALIDAR SE O LOGIN EXISTE
            if(verificaExistencia(objeto) == true){
                return "Audiência já Existe";
            }else{
           
                String wSQL = " INSERT INTO audiencia VALUES(DEFAULT, ?, ?, ?, ?, ?)";
                stmt = con.prepareStatement(wSQL);
              Date date = java.sql.Date.valueOf(objeto.getData());
                stmt.setDate(1, (java.sql.Date) date);   
                stmt.setInt(2, objeto.getId_processo());  
                stmt.setInt(3, objeto.getId_sala());  
                stmt.setInt(4, objeto.getId_status());  
                stmt.setInt(5, objeto.getId_evento()); 
                
                
                   


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
    
    public boolean alterar(Audiencias objeto){
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
            
            //VALIDAR SE O LOGIN EXISTE
                String wSQL = " UPDATE audiencia SET data = ?, id_processo = ? WHERE id = ?";
                stmt = con.prepareStatement(wSQL);
                stmt.setString(1, objeto.getData());               
                stmt.setInt(2, objeto.getId_processo());
                stmt.setInt(3, objeto.getId());
                

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
              
            String wSQL = " UPDATE audiencia SET excluido = true WHERE id = ? ";
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
        cabecalhos.add("Processo");
        cabecalhos.add("Exc");
             
        ResultSet result = null;
        
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT a.id, p.num FROM audiencia a, processo p ORDER BY id");
           
            
            result = Conexao.stmt.executeQuery(sql.toString());
            
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
