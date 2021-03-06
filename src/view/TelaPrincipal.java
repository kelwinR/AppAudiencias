/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AudienciasController;
import java.sql.SQLException;
import tools.CaixaDeDialogo;
import tools.Combo;
import db.Conexao;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Windows 10
 */
public class TelaPrincipal extends javax.swing.JFrame {
        
    Combo comboStatus;
    /**
     * Creates new form TelaPrincipal
     */
  /*  
    public void preencher(JTable jtbUsuarios) {

        Conexao.abreConexao();
        
        Vector<String> cabecalhos = new Vector<String>();
        Vector dadosTabela = new Vector(); //receber os dados do banco
        
        cabecalhos.add("Número");
        cabecalhos.add("Data");
        cabecalhos.add("Status");
        cabecalhos.add("Evento");
             
        ResultSet result = null;
        
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT p.num, a.data, s.status, e.evento\n" +
                        "FROM audiencia a, processo p, status s, eventos e\n" +
                        "WHERE p.id = a.id_processo\n" +
                        "AND s.id = a.id_status\n" +
                        "AND e.id = a.id_evento\n" +
                        "ORDER BY a.data");
           
            
            result = Conexao.stmt.executeQuery(sql.toString());
            
            Vector<Object> linha;
            while(result.next()) {
                linha = new Vector<Object>();
                
                linha.add(result.getInt(1));
                linha.add(result.getInt(2));
                linha.add(result.getString(3));
                linha.add(result.getString(4));
 
                
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
        for (int i = 0; i <= 4; i++) {
            column = 

            jtbUsuarios.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(60);//num 
                    break;
                case 1:
                    column.setPreferredWidth(100);//data
                    break;                   
                case 2:
                    column.setPreferredWidth(100);//status
                    break;
                case 3:
                    column.setPreferredWidth(100);//evento
                    break;
            }
        }
    }
    */
    
    
    
    
    
    
    
    
    
    
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtbAud = new javax.swing.JTable();
        jcbStatus = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmiCadastrar = new javax.swing.JMenu();
        jmiEstados = new javax.swing.JMenuItem();
        jmiCidades = new javax.swing.JMenuItem();
        jmiMagistrados = new javax.swing.JMenuItem();
        jmiTipoParte = new javax.swing.JMenuItem();
        jmiOrgJulg = new javax.swing.JMenuItem();
        jmiClassAcao = new javax.swing.JMenuItem();
        jmiComp = new javax.swing.JMenuItem();
        jmiStatus = new javax.swing.JMenuItem();
        jmiEventos = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jmiParte = new javax.swing.JMenuItem();
        jmiSala = new javax.swing.JMenuItem();
        jmiMarcaAud = new javax.swing.JMenu();
        jmiRelatorios = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jtbAud.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbAud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbAudMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbAud);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 80, 330, 240);

        jcbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbStatus);
        jcbStatus.setBounds(10, 50, 230, 20);

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(253, 50, 80, 23);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("AUDIÊNCIAS");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 10, 500, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fundo.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 340);

        jmiCadastrar.setText("Cadastrar");

        jmiEstados.setText("Estados");
        jmiEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEstadosActionPerformed(evt);
            }
        });
        jmiCadastrar.add(jmiEstados);

        jmiCidades.setText("Cidades");
        jmiCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCidadesActionPerformed(evt);
            }
        });
        jmiCadastrar.add(jmiCidades);

        jmiMagistrados.setText("Magistrados");
        jmiMagistrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMagistradosActionPerformed(evt);
            }
        });
        jmiCadastrar.add(jmiMagistrados);

        jmiTipoParte.setText("Tipo de parte");
        jmiTipoParte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTipoParteActionPerformed(evt);
            }
        });
        jmiCadastrar.add(jmiTipoParte);

        jmiOrgJulg.setText("Orgão Julgador");
        jmiOrgJulg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOrgJulgActionPerformed(evt);
            }
        });
        jmiCadastrar.add(jmiOrgJulg);

        jmiClassAcao.setText("Classe da Ação");
        jmiClassAcao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiClassAcaoActionPerformed(evt);
            }
        });
        jmiCadastrar.add(jmiClassAcao);

        jmiComp.setText("Competência");
        jmiComp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCompActionPerformed(evt);
            }
        });
        jmiCadastrar.add(jmiComp);

        jmiStatus.setText("Status");
        jmiStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiStatusActionPerformed(evt);
            }
        });
        jmiCadastrar.add(jmiStatus);

        jmiEventos.setText("Eventos");
        jmiEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEventosActionPerformed(evt);
            }
        });
        jmiCadastrar.add(jmiEventos);

        jMenuItem1.setText("Processo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmiCadastrar.add(jMenuItem1);

        jmiParte.setText("Parte");
        jmiParte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiParteActionPerformed(evt);
            }
        });
        jmiCadastrar.add(jmiParte);

        jmiSala.setText("Sala");
        jmiSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalaActionPerformed(evt);
            }
        });
        jmiCadastrar.add(jmiSala);

        jMenuBar1.add(jmiCadastrar);

        jmiMarcaAud.setText("Marcar/Alterar Audiência");
        jmiMarcaAud.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmiMarcaAudMouseClicked(evt);
            }
        });
        jMenuBar1.add(jmiMarcaAud);

        jmiRelatorios.setText("Relatórios");
        jmiRelatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jmiRelatoriosMouseClicked(evt);
            }
        });
        jmiRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRelatoriosActionPerformed(evt);
            }
        });
        jMenuBar1.add(jmiRelatorios);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(516, 399));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmiEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEstadosActionPerformed
        // TODO add your handling code here:
         try{
            TelaEstados tela = new TelaEstados();
            tela.setVisible(true);

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao sair do programa");
        }
    }//GEN-LAST:event_jmiEstadosActionPerformed

    private void jmiCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCidadesActionPerformed
        // TODO add your handling code here:
        try{
            TelaCidades tela = new TelaCidades();
            tela.setVisible(true);

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao sair do programa");
        }
    }//GEN-LAST:event_jmiCidadesActionPerformed

    private void jmiMagistradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMagistradosActionPerformed
        // TODO add your handling code here:
        try{
            TelaMagistrados tela = new TelaMagistrados();
            tela.setVisible(true);

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao sair do programa");
        }
    }//GEN-LAST:event_jmiMagistradosActionPerformed

    private void jmiTipoParteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTipoParteActionPerformed
        // TODO add your handling code here:
        try{
            TelaTipoParte tela = new TelaTipoParte();
            tela.setVisible(true);

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao sair do programa");
        }
    }//GEN-LAST:event_jmiTipoParteActionPerformed

    private void jmiCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCompActionPerformed
        // TODO add your handling code here:
      try{
            TelaComp tela = new TelaComp();
            tela.setVisible(true);

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao sair do programa");
        }
    }//GEN-LAST:event_jmiCompActionPerformed

    private void jmiOrgJulgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOrgJulgActionPerformed
        // TODO add your handling code here:
        try{
            TelaOrgJulg tela = new TelaOrgJulg();
            tela.setVisible(true);

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao sair do programa");
        }
    }//GEN-LAST:event_jmiOrgJulgActionPerformed

    private void jmiClassAcaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiClassAcaoActionPerformed
        // TODO add your handling code here:
        try{
            TelaClassAcao tela = new TelaClassAcao();
            tela.setVisible(true);

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao sair do programa");
        }
    }//GEN-LAST:event_jmiClassAcaoActionPerformed

    private void jmiStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiStatusActionPerformed
        // TODO add your handling code here:
        try{
            TelaStatus tela = new TelaStatus();
            tela.setVisible(true);

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao sair do programa");
        }
    }//GEN-LAST:event_jmiStatusActionPerformed

    private void jmiEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEventosActionPerformed
        // TODO add your handling code here:
         try{
            TelaEventos tela = new TelaEventos();
            tela.setVisible(true);

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao sair do programa");
        }
    }//GEN-LAST:event_jmiEventosActionPerformed

    private void jmiRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRelatoriosActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jmiRelatoriosActionPerformed

    private void jmiRelatoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiRelatoriosMouseClicked
        // TODO add your handling code here:
         try{
            TelaRelatorios tela = new TelaRelatorios();
            tela.setVisible(true);

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao sair do programa");
        }
    }//GEN-LAST:event_jmiRelatoriosMouseClicked

    private void jmiParteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiParteActionPerformed
        // TODO add your handling code here:
         try{
            TelaParte tela = new TelaParte();
            tela.setVisible(true);

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao sair do programa");
        }
    }//GEN-LAST:event_jmiParteActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        try{
            TelaProcesso tela = new TelaProcesso();
            tela.setVisible(true);

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao sair do programa");
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jmiSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalaActionPerformed
        // TODO add your handling code here:
        try{
            TelaSala tela = new TelaSala();
            tela.setVisible(true);

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao sair do programa");
        }
    }//GEN-LAST:event_jmiSalaActionPerformed

    private void jmiMarcaAudMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jmiMarcaAudMouseClicked
        // TODO add your handling code here:
        try{
            TelaAudiencias tela = new TelaAudiencias();
            tela.setVisible(true);

        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao sair do programa");
        }
    }//GEN-LAST:event_jmiMarcaAudMouseClicked

    private void jtbAudMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbAudMousePressed

    }//GEN-LAST:event_jtbAudMousePressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbStatus;
    private javax.swing.JMenu jmiCadastrar;
    private javax.swing.JMenuItem jmiCidades;
    private javax.swing.JMenuItem jmiClassAcao;
    private javax.swing.JMenuItem jmiComp;
    private javax.swing.JMenuItem jmiEstados;
    private javax.swing.JMenuItem jmiEventos;
    private javax.swing.JMenuItem jmiMagistrados;
    private javax.swing.JMenu jmiMarcaAud;
    private javax.swing.JMenuItem jmiOrgJulg;
    private javax.swing.JMenuItem jmiParte;
    private javax.swing.JMenu jmiRelatorios;
    private javax.swing.JMenuItem jmiSala;
    private javax.swing.JMenuItem jmiStatus;
    private javax.swing.JMenuItem jmiTipoParte;
    private javax.swing.JTable jtbAud;
    // End of variables declaration//GEN-END:variables
}
