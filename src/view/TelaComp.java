/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.formdev.flatlaf.FlatDarculaLaf;
import controller.CompController;
import tools.Validacao;
import db.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UIManager;
import model.Comp;
import tools.CaixaDeDialogo;
import tools.Combo;

/**
 *
 * @author kelwin.rodrigues
 */
public class TelaComp extends javax.swing.JFrame {
            CompController objCompController;

    /**
     * Creates new form TelaUsuarios
     */
    public TelaComp() {
        initComponents();
          atualizarTabela();
          limparTela();
          
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jblSalvar = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbComp = new javax.swing.JTable();
        btnLimpar = new javax.swing.JButton();
        lbNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Orgão Julgador", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jblSalvar.setText("SALVAR");
        jblSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jblSalvarActionPerformed(evt);
            }
        });

        lblId.setText("ID");

        jtbComp.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbComp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbCompMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbComp);

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        lbNome.setText("Nome");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbNome)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                        .addComponent(txtNome))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jblSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblId)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jblSalvar)
                    .addComponent(btnLimpar)
                    .addComponent(lblId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jblSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jblSalvarActionPerformed
        // TODO add your handling code here:
          boolean retorno = validarDados();
        if(retorno){
            
            Comp comp = guardarDados();
            //SALVAR NO BANCO DE DADOS
            
          CompController objCompController = new CompController();
           
           if(lblId.getText().equals("ID")){
               String ret = objCompController.incluir(comp);
               if(ret.equals("")){
                   CaixaDeDialogo.obterinstancia().exibirMensagem("Competência incluída com sucesso");
                   limparTela();
           }else{
                   CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao incluir competência");
               }
          
        }else{
           comp.setId(Integer.parseInt(lblId.getText()));
           boolean ret = objCompController.alterar(comp);
           if(ret){
               CaixaDeDialogo.obterinstancia().exibirMensagem("Competência alterada com sucesso");
               limparTela();
           }else{
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao alterar competência");
           }
        }
        }
        
        atualizarTabela();
    }//GEN-LAST:event_jblSalvarActionPerformed

    private void jtbCompMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCompMousePressed
        // TODO add your handling code here:
         try {
            //pega a linha selecionada
            int linhaSelecionada = jtbComp.getSelectedRow();

            // Primeira coluna da linha
            String codigo = jtbComp.getModel().getValueAt(linhaSelecionada, 0).toString();

            //buscar no banco de dados o registro e preencher nos campos da tela
           CompController objCompController = new CompController();
            Comp objeto = objCompController.buscar(codigo);
                
            //Verifica se clicou na coluna 2 => EXCLUIR
            if (jtbComp.isColumnSelected(2)) {
                try {
                    boolean wPergunta = CaixaDeDialogo.obterinstancia()
                            .pedirConfirmacao("Tem certeza de que deseja excluir?", "", 'p');
                    if (wPergunta == true) {
                        //exclusão do registro selecionado
                        objCompController = new CompController();
                        boolean retorno = objCompController.excluir(codigo);
                        if(retorno){
                            CaixaDeDialogo.obterinstancia().exibirMensagem("Registro excluído com sucesso");
                            atualizarTabela();
                        }else{
                            CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao excluir");
                        }
                    }                    

                } catch (Exception ex) {
                    CaixaDeDialogo.obterinstancia().exibirMensagem("Erro: " + ex.getMessage());
                }
            } else {
                if (objeto != null) {
                    preencherCampos(objeto);
                }
            }


        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
        }
        
        
        
    }//GEN-LAST:event_jtbCompMousePressed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        lblId.setText("ID");
        txtNome.setText("");
        atualizarTabela();
    }//GEN-LAST:event_btnLimparActionPerformed

    
    private void limparTela(){
        lblId.setText("ID");
        txtNome.setText("");
        atualizarTabela();
    }
    
    private boolean validarDados(){

        if(txtNome.getText().trim().equals("")){ 
            CaixaDeDialogo.obterinstancia().exibirMensagem("Informe uma competência");
            return false;
        } 
        return true;
    }
    
    private Comp guardarDados(){
        try{
            Comp objeto = new Comp();
            
            objeto.setNome(txtNome.getText().trim());
            
            return objeto;
            
        }catch(Exception ex){
            return null;
        }
    }
    
      private void preencherCampos(Comp objeto){
        try{
            
            lblId.setText(String.valueOf(objeto.getId()));
            txtNome.setText(objeto.getNome());

            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
        }
    }
      
      private void atualizarTabela() {
        try {
           CompController objCompController = new CompController();
            objCompController.preencher(jtbComp);

        } catch (Exception ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("ERRO:" + ex.getMessage());
        }
    }
      
    
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
            java.util.logging.Logger.getLogger(TelaComp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaComp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaComp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaComp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

       //CUSTOMIZAR TEMA
        try{
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        }catch(Exception ex){
            System.out.println("ERRO NA TROCA DE TEMA");
        }
        
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaComp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jblSalvar;
    private javax.swing.JTable jtbComp;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}