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
import model.Processo;
//import model.Usuario;

/**
 *
 * @author jonas
 */
public class ProcessoController {
    
    public Processo buscar(String codigo)
    {
        Processo objProcesso = null;
        try {
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
           
            String wSQL = " SELECT * FROM processo WHERE id = ? ";
            stmt = con.prepareStatement(wSQL);
            stmt.setInt(1, Integer.parseInt(codigo));   
    
            rs = stmt.executeQuery();
            
            if(rs.next()){
                objProcesso = new Processo();
                
                objProcesso.setId(rs.getInt("id"));
                objProcesso.setNum(rs.getInt("num"));
                objProcesso.setId_org_julg(rs.getInt("id_org_julg"));
                objProcesso.setId_comp(rs.getInt("id_comp"));
                objProcesso.setId_class_acao(rs.getInt("id_clas_acao"));
                objProcesso.setId_magistrado(rs.getInt("id_magistrado"));

            }
              
        } catch (SQLException ex ){
            System.out.println("ERRO de SQL: " + ex.getMessage());
            return null;
        }catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            return null;
        }
        
        return objProcesso;
		
    }
    
    public boolean verificaExistencia(Processo objeto)
    {
        try {
            //Conexao.abreConexao();
            Connection con = Conexao.getConnection();
            ResultSet rs = null;
            PreparedStatement stmt = null;
           
            String wSQL = " SELECT id FROM processo WHERE num = ?";
            stmt = con.prepareStatement(wSQL);
            stmt.setInt(1, objeto.getNum()); 
    
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
    
    public String incluir(Processo objeto)
    {
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
            
            //VALIDAR SE O LOGIN EXISTE
            if(verificaExistencia(objeto) == true){
                return "Processo já Existe";
            }else{
           
                String wSQL = " INSERT INTO processo VALUES(DEFAULT, ?, ?, ?, ?, ?)";
                stmt = con.prepareStatement(wSQL);   
                stmt.setInt(1, objeto.getNum());  
                stmt.setInt(2, objeto.getId_org_julg());
                stmt.setInt(3, objeto.getId_comp());
                stmt.setInt(4, objeto.getId_class_acao());
                stmt.setInt(5, objeto.getId_magistrado());


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
    
    public boolean alterar(Processo objeto){
        try {
            Connection con = Conexao.getConnection();
            PreparedStatement stmt = null;
            
            //VALIDAR SE O LOGIN EXISTE
                String wSQL = " UPDATE processo SET num = ?, id_org_julg = ?, id_comp = ?, id_class_acao = ?, id_magistrado = ? WHERE id = ?";
                stmt = con.prepareStatement(wSQL);                
                stmt.setInt(1, objeto.getNum());  
                stmt.setInt(2, objeto.getId_org_julg());
                stmt.setInt(3, objeto.getId_comp());
                stmt.setInt(4, objeto.getId_class_acao());
                stmt.setInt(5, objeto.getId_magistrado());
                

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
              
            String wSQL = " DELETE FROM processo WHERE id = ? ";
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
        cabecalhos.add("Número Processo");
        cabecalhos.add("Exc");
             
        ResultSet result = null;
        
        try {

            String wSql = " SELECT id, num FROM processo ORDER BY num ";
            
            result = Conexao.stmt.executeQuery(wSql);
            
            Vector<Object> linha;
            while(result.next()) {
                linha = new Vector<Object>();
                
                linha.add(result.getInt(1));
                linha.add(result.getInt(2));    

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
