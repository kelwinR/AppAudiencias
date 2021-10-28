package tools;

import db.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JComboBox;
import java.sql.ResultSet;

/**
 *
 * @author Jonas Dhein
 */
public class Combo {
    
    private String codigo;
    private String descricao;
    JComboBox cbCombo = null;
    ResultSet result = null;

    public Combo(JComboBox cbCombo) {
        this.cbCombo = cbCombo;
    }
    public Combo() {

    }
    /**
     * @return the coodigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString () {
        return descricao;
    }

    public int setaComboBox(String wValue){
        
        if(wValue.equals("0")){
            cbCombo.setSelectedIndex(0);
            return 0;
        }
        

        for(int i = 0; i < cbCombo.getItemCount() ;  i++ ){
            Combo c = new Combo();
            cbCombo.setSelectedIndex(i);
            c = (Combo) cbCombo.getSelectedItem();
            if (c.getCodigo().equals(wValue)){
                return 0;
            }
        }
        return 1;
    }

    public int preencheCombo(String wSQL) throws SQLException{
            
        Conexao.abreConexao();
        result = Conexao.stmt.executeQuery(wSQL);
        
        //ConnectionFactory.closeConnection(ConnectionFactory.con, ConnectionFactory.stmt);
        
        cbCombo.removeAllItems();

        Combo combo = new Combo();
        combo.setCodigo("");
        combo.setDescricao("Selecione...");
        cbCombo.addItem(combo);
        while (result.next()) {
            combo = new Combo();
            combo.setCodigo(result.getString(1));
            combo.setDescricao(result.getString(2));
            cbCombo.addItem(combo);
        }
        return 0;
    }

}
