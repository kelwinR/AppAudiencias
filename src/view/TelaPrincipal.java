/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Windows 10
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblFundo = new javax.swing.JLabel();
        jmBarra = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menEstados = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 510, 340));
        setMaximumSize(new java.awt.Dimension(510, 340));
        getContentPane().setLayout(null);

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("AUDIÊNCIAS");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(10, 11, 480, 14);

        lblFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fundo.jpg"))); // NOI18N
        getContentPane().add(lblFundo);
        lblFundo.setBounds(0, -30, 510, 370);

        jMenu1.setText("Cadastrar");

        menEstados.setText("Cad. Estados");
        menEstados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menEstadosMouseClicked(evt);
            }
        });
        menEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menEstadosActionPerformed(evt);
            }
        });
        jMenu1.add(menEstados);

        jMenu4.setText("jMenu4");
        jMenu1.add(jMenu4);

        jMenu5.setText("jMenu5");
        jMenu1.add(jMenu5);

        jmBarra.add(jMenu1);

        jMenu2.setText("Edit");
        jmBarra.add(jMenu2);

        setJMenuBar(jmBarra);

        setSize(new java.awt.Dimension(516, 380));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menEstadosActionPerformed
        // TODO add your handling code here:
        try{
            TelaEstados tela = new TelaEstados();
            tela.setVisible(true);

        }catch(Exception ex){
            // CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao sair do programa");
        }
    }//GEN-LAST:event_menEstadosActionPerformed

    private void menEstadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menEstadosMouseClicked
        // TODO add your handling code here:
        try{
            TelaEstados tela = new TelaEstados();
            tela.setVisible(true);

        }catch(Exception ex){
            // CaixaDeDialogo.obterinstancia().exibirMensagem("Erro ao sair do programa");
        }
    }//GEN-LAST:event_menEstadosMouseClicked

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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jmBarra;
    private javax.swing.JLabel lblFundo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JMenu menEstados;
    // End of variables declaration//GEN-END:variables
}