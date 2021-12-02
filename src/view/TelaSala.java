/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.formdev.flatlaf.FlatDarculaLaf;
import controller.SalaController;
import tools.Validacao;
import db.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UIManager;
import model.Sala;
import tools.CaixaDeDialogo;
import tools.Combo;
import tools.LimiteDigitos;

/**
 *
 * @author kelwin.rodrigues
 */
public class TelaSala extends javax.swing.JFrame {
            SalaController objSalaController;

    /**
     * Creates new form TelaUsuarios
     */
    public TelaSala() {
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
        jtbSala = new javax.swing.JTable();
        btnLimpar = new javax.swing.JButton();
        txtNum = new javax.swing.JTextField();
        lbNome = new javax.swing.JLabel();
        txtSala = new javax.swing.JTextField();
        lbLogin = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Sala", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        jblSalvar.setText("SALVAR");
        jblSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jblSalvarActionPerformed(evt);
            }
        });

        lblId.setText("ID");

        jtbSala.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbSala.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbSalaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbSala);

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        lbNome.setText("Sala");

        lbLogin.setText("Número");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbLogin)
                        .addComponent(lbNome)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                        .addComponent(txtSala))
                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(txtSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jblSalvar)
                    .addComponent(btnLimpar)
                    .addComponent(lblId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        setSize(new java.awt.Dimension(416, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jblSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jblSalvarActionPerformed
        // TODO add your handling code here:
          boolean retorno = validarDados();
        if(retorno){
            
            Sala sala = guardarDados();
            //SALVAR NO BANCO DE DADOS
            
          SalaController objSalaController = new SalaController();
           
           if(lblId.getText().equals("ID")){
               String ret = objSalaController.incluir(sala);
               if(ret.equals("")){
                   CaixaDeDialogo.obterinstancia().exibirMensagem("Sala incluída com sucesso");
                   limparTela();
           }else{
                   CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao incluir sala");
               }
          
        }else{
           sala.setId(Integer.parseInt(lblId.getText()));
           boolean ret = objSalaController.alterar(sala);
           if(ret){
               CaixaDeDialogo.obterinstancia().exibirMensagem("Sala alterada com sucesso");
               limparTela();
           }else{
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao alterar sala");
           }
        }
        }
        
        atualizarTabela();
    }//GEN-LAST:event_jblSalvarActionPerformed

    private void jtbSalaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbSalaMousePressed
        // TODO add your handling code here:
         try {
            //pega a linha selecionada
            int linhaSelecionada = jtbSala.getSelectedRow();

            // Primeira coluna da linha
            String codigo = jtbSala.getModel().getValueAt(linhaSelecionada, 0).toString();

            //buscar no banco de dados o registro e preencher nos campos da tela
           SalaController objSalaController = new SalaController();
            Sala objeto = objSalaController.buscar(codigo);
                
            //Verifica se clicou na coluna 2 => EXCLUIR
            if (jtbSala.isColumnSelected(2)) {
                try {
                    boolean wPergunta = CaixaDeDialogo.obterinstancia()
                            .pedirConfirmacao("Tem certeza de que deseja excluir?", "", 'p');
                    if (wPergunta == true) {
                        //exclusão do registro selecionado
                        objSalaController = new SalaController();
                        boolean retorno = objSalaController.excluir(codigo);
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
        
        
        
    }//GEN-LAST:event_jtbSalaMousePressed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        lblId.setText("ID");
        txtSala.setText("");
        txtNum.setText("");
        atualizarTabela();
    }//GEN-LAST:event_btnLimparActionPerformed

    
    private void limparTela(){
        lblId.setText("ID");
        txtSala.setText("");
        txtNum.setText("");
        atualizarTabela();
    }
    
    private boolean validarDados(){
        if(txtSala.getText().equals("")){ 
            CaixaDeDialogo.obterinstancia().exibirMensagem("Informe uma sala");
            return false;
        }
        
        
        if(txtNum.getText().trim().equals("")){ 
            CaixaDeDialogo.obterinstancia().exibirMensagem("Informe o número da sala");
            return false;
        }
        
        int indice = txtNum.getText().indexOf(" ");
        if(indice >= 0){ 
            CaixaDeDialogo.obterinstancia().exibirMensagem("Retire os espaços");
            return false;
        }   
        return true;
    }
    
    private Sala guardarDados(){
        try{
            Sala objeto = new Sala();
            
            objeto.setNum(Integer.parseInt(txtNum.getText().trim()));
            objeto.setNome(txtSala.getText().trim());
            
            return objeto;
            
        }catch(Exception ex){
            return null;
        }
    }
    
      private void preencherCampos(Sala objeto){
        try{
            
            lblId.setText(String.valueOf(objeto.getId()));
            txtNum.setText(String.valueOf(objeto.getNum()));
            txtSala.setText(objeto.getNome());

            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
        }
    }
      
      private void atualizarTabela() {
        try {
           SalaController objSalaController = new SalaController();
            objSalaController.preencher(jtbSala);

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
            java.util.logging.Logger.getLogger(TelaSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaSala.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new TelaSala().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jblSalvar;
    private javax.swing.JTable jtbSala;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtSala;
    // End of variables declaration//GEN-END:variables
}