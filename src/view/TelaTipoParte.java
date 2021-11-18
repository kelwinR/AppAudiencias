/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.formdev.flatlaf.FlatDarculaLaf;
import controller.TipoParteController;
import tools.Validacao;
import db.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UIManager;
import model.TipoParte;
import tools.CaixaDeDialogo;
import tools.Combo;

/**
 *
 * @author kelwin.rodrigues
 */
public class TelaTipoParte extends javax.swing.JFrame {
            TipoParteController objTipoParteController;

    /**
     * Creates new form TelaUsuarios
     */
    public TelaTipoParte() {
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
        jtbTipoParte = new javax.swing.JTable();
        btnLimpar = new javax.swing.JButton();
        lbNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Tipo de Parte", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jblSalvar.setText("SALVAR");
        jblSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jblSalvarActionPerformed(evt);
            }
        });

        lblId.setText("ID");

        jtbTipoParte.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbTipoParte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbTipoParteMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbTipoParte);

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        lbNome.setText("Tipo");

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(416, 324));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jblSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jblSalvarActionPerformed
        // TODO add your handling code here:
          boolean retorno = validarDados();
        if(retorno){
            
            TipoParte tipo_parte = guardarDados();
            //SALVAR NO BANCO DE DADOS
            
          TipoParteController objTipoParteController = new TipoParteController();
           
           if(lblId.getText().equals("ID")){
               String ret = objTipoParteController.incluir(tipo_parte);
               if(ret.equals("")){
                   CaixaDeDialogo.obterinstancia().exibirMensagem("Tipo de parte incluído com sucesso");
                   limparTela();
           }else{
                   CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao incluir tipo de parte");
               }
          
        }else{
           tipo_parte.setId(Integer.parseInt(lblId.getText()));
           boolean ret = objTipoParteController.alterar(tipo_parte);
           if(ret){
               CaixaDeDialogo.obterinstancia().exibirMensagem("Tipo de parte alterado com sucesso");
               limparTela();
           }else{
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao alterar tipo de parte");
           }
        }
        }
        
        atualizarTabela();
    }//GEN-LAST:event_jblSalvarActionPerformed

    private void jtbTipoParteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTipoParteMousePressed
        // TODO add your handling code here:
         try {
            //pega a linha selecionada
            int linhaSelecionada = jtbTipoParte.getSelectedRow();

            // Primeira coluna da linha
            String codigo = jtbTipoParte.getModel().getValueAt(linhaSelecionada, 0).toString();

            //buscar no banco de dados o registro e preencher nos campos da tela
           TipoParteController objTipoParteController = new TipoParteController();
            TipoParte objeto = objTipoParteController.buscar(codigo);
                
            //Verifica se clicou na coluna 2 => EXCLUIR
            if (jtbTipoParte.isColumnSelected(2)) {
                try {
                    boolean wPergunta = CaixaDeDialogo.obterinstancia()
                            .pedirConfirmacao("Tem certeza de que deseja excluir?", "", 'p');
                    if (wPergunta == true) {
                        //exclusão do registro selecionado
                        objTipoParteController = new TipoParteController();
                        boolean retorno = objTipoParteController.excluir(codigo);
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
        
        
        
    }//GEN-LAST:event_jtbTipoParteMousePressed

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
            CaixaDeDialogo.obterinstancia().exibirMensagem("Informe um tipo de parte");
            return false;
        } 
        return true;
    }
    
    private TipoParte guardarDados(){
        try{
            TipoParte objeto = new TipoParte();
            
            objeto.setTipo(txtNome.getText().trim());
            
            return objeto;
            
        }catch(Exception ex){
            return null;
        }
    }
    
      private void preencherCampos(TipoParte objeto){
        try{
            
            lblId.setText(String.valueOf(objeto.getId()));
            txtNome.setText(objeto.getTipo());

            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
        }
    }
      
      private void atualizarTabela() {
        try {
           TipoParteController objTipoParteController = new TipoParteController();
            objTipoParteController.preencher(jtbTipoParte);

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
            java.util.logging.Logger.getLogger(TelaTipoParte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaTipoParte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaTipoParte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaTipoParte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new TelaTipoParte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jblSalvar;
    private javax.swing.JTable jtbTipoParte;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
