/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code_lines_counter;

import code_lines_counter.gui.FormMain;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Alfonso
 */
public class CodeLinesCounter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here    
        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName()
            );
        } 
        catch (
                UnsupportedLookAndFeelException |
                        ClassNotFoundException |
                        InstantiationException |
                        IllegalAccessException e
        ) { }

        FormMain formMain = new FormMain();
        formMain.setLocationRelativeTo(null);
        formMain.setVisible(true);
    }
    
}
