/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.formdev.flatlaf.FlatDarculaLaf;
import controller.CidadesController;
import tools.Validacao;
import db.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.UIManager;
import model.Cidades;
import tools.CaixaDeDialogo;
import tools.Combo;

/**
 *
 * @author kelwin.rodrigues
 */
public class TelaCidades extends javax.swing.JFrame {
           CidadesController objCidadesController;
            Combo comboEstados;
    /**
     * Creates new form TelaUsuarios
     */
    public TelaCidades() {
        initComponents();
        
        
       try{ 
        comboEstados = new Combo(jcbEstado);
        comboEstados.preencheCombo("SELECT id, nome FROM estados ORDER BY nome");
        
        
       }catch(SQLException ex){
           CaixaDeDialogo.obterinstancia().exibirMensagem("Erro no init");
       }
        
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
        lbNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        jcbEstado = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jblSalvar = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCidades = new javax.swing.JTable();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Cidade", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

        lbNome.setText("Nome");

        btnLimpar.setText("LIMPAR");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Estado");

        jblSalvar.setText("SALVAR");
        jblSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jblSalvarActionPerformed(evt);
            }
        });

        lblId.setText("ID");

        jtbCidades.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbCidades.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtbCidadesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtbCidades);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNome)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jblSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 5, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblId)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(lblId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jblSalvar)
                    .addComponent(btnLimpar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(441, 339));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jblSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jblSalvarActionPerformed
        // TODO add your handling code here:
          boolean retorno = validarDados();
        if(retorno){
            
            Cidades cidades = guardarDados();
            //SALVAR NO BANCO DE DADOS
            
           CidadesController objCidadesController = new CidadesController();
           
           if(lblId.getText().equals("ID")){
               String ret = objCidadesController.incluir(cidades);
               if(ret.equals("")){
                   CaixaDeDialogo.obterinstancia().exibirMensagem("Cidades incluída com sucesso");
                   limparTela();
           }else{
                   CaixaDeDialogo.obterinstancia().exibirMensagem(ret);
               }
          
        }else{
           cidades.setId(Integer.parseInt(lblId.getText()));
           boolean ret = objCidadesController.alterar(cidades);
           if(ret){
               CaixaDeDialogo.obterinstancia().exibirMensagem("Cidade alterada com sucesso");
               limparTela();
           }else{
                CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao alterar cidade");
           }
        }
        }
        
        atualizarTabela();
    }//GEN-LAST:event_jblSalvarActionPerformed

    private void jtbCidadesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCidadesMousePressed
        // TODO add your handling code here:
         try {
            //pega a linha selecionada
            int linhaSelecionada = jtbCidades.getSelectedRow();

            // Primeira coluna da linha
            String codigo = jtbCidades.getModel().getValueAt(linhaSelecionada, 0).toString();

            //buscar no banco de dados o registro e preencher nos campos da tela
           CidadesController objCidadesController = new CidadesController();
            Cidades objeto = objCidadesController.buscar(codigo);
                
            //Verifica se clicou na coluna 2 => EXCLUIR
            if (jtbCidades.isColumnSelected(2)) {
                try {
                    boolean wPergunta = CaixaDeDialogo.obterinstancia()
                            .pedirConfirmacao("Tem certeza de que deseja excluir?", "", 'p');
                    if (wPergunta == true) {
                        //exclusão do registro selecionado
                        objCidadesController = new CidadesController();
                        boolean retorno = objCidadesController.excluir(codigo);
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
        
        
        
    }//GEN-LAST:event_jtbCidadesMousePressed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        // TODO add your handling code here:
        lblId.setText("ID");
        txtNome.setText("");
        jcbEstado.setSelectedIndex(0);
        atualizarTabela();
    }//GEN-LAST:event_btnLimparActionPerformed

    
    private void limparTela(){
        lblId.setText("ID");
        txtNome.setText("");;
        jcbEstado.setSelectedIndex(0);
        atualizarTabela();
    }
    
    private boolean validarDados(){
        if(txtNome.getText().trim().equals("")){ 
            CaixaDeDialogo.obterinstancia().exibirMensagem("Informe uma cidade");
            return false;
        }
        
        if(jcbEstado.getSelectedIndex() <= 0){
            CaixaDeDialogo.obterinstancia().exibirMensagem("Escolha um estado");
            return false;
        }
      
        return true;
    }
    
    private Cidades guardarDados(){
        try{
            Cidades objeto = new Cidades();
            
            objeto.setNome(txtNome.getText().trim());

            
            
            Combo c = (Combo) jcbEstado.getSelectedItem();
            int cod_estado = Integer.parseInt(c.getCodigo());
            objeto.setId_estado(cod_estado);
            
            return objeto;
            
        }catch(Exception ex){
            return null;
        }
    }
    
      private void preencherCampos(Cidades objeto){
        try{
            
            lblId.setText(String.valueOf(objeto.getId()));
            txtNome.setText(objeto.getNome());
            
            comboEstados.setaComboBox(String.valueOf(objeto.getId_estado()));
            
        }catch(Exception ex){
            CaixaDeDialogo.obterinstancia().exibirMensagem(ex.getMessage(), 'e');
        }
    }
      
      private void atualizarTabela() {
        try {
           CidadesController objCidadesController = new CidadesController();
            objCidadesController.preencher(jtbCidades);

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
            java.util.logging.Logger.getLogger(TelaCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new TelaCidades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jblSalvar;
    private javax.swing.JComboBox<String> jcbEstado;
    private javax.swing.JTable jtbCidades;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lblId;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
