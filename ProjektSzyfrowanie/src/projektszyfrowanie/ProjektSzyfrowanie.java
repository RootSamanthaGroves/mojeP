/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projektszyfrowanie;

import static com.sun.org.apache.xml.internal.serialize.LineSeparator.Windows;
import java.awt.Window;

/**
 *
 * @author Dominika
 */
public class ProjektSzyfrowanie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       java.awt.EventQueue.invokeLater(() -> {
            new okno().setVisible(true);
        });
    }
    
}
