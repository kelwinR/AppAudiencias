/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author kelwin.rodrigues
 */
public class LimiteDigitos extends PlainDocument {
    private int qtdMax;
    public LimiteDigitos(int maxLen){
        super();
        if(maxLen<=0)
            throw new IllegalArgumentException("Especifique a quantidade!");
        qtdMax=maxLen;
    }        
    
    public void insertString(int offset, String str, AttributeSet attr)
            throws BadLocationException{
        if(str==null || getLength()==qtdMax)
            return;
        int totqtd=(getLength()+str.length());
        if(totqtd<=qtdMax){
            super.insertString(offset, str.replaceAll("[^A-Z]", ""), attr);
            return;
        }
        String nova = str.substring(0, getLength()-qtdMax);
        super.insertString(offset, nova, attr);
    }
}
