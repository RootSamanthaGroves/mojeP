/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regulyasocjacyjne;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Dominika
 */
public class FileChooser {

    public static String showOpen(String comment, String extension) {
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                comment, extension);
        fc.setFileFilter(filter);
        fc.showOpenDialog(fc);
        return fc.getSelectedFile().getPath();
    }
}
