/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author kelwin.rodrigues
 */
public class TeclasPermitidas extends PlainDocument {
    public void insertString(int offset, String str, javax.swing.text.AttributeSet attr)
    throws BadLocationException{
        super.insertString(offset, str.replaceAll("[^a-z|^A-Z]", ""), attr);
    }
    
    public void replace(int offset, String str, javax.swing.text.AttributeSet attr)
    throws BadLocationException{
        super.insertString(offset, str.replaceAll("[^a-z|^A-Z]", ""), attr);
    }
    
}
