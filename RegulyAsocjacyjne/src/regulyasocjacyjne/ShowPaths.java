/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pracamgr;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Dominika
 */
public class ShowPaths {
    public static String showpaths(String comment, String extension) throws FileNotFoundException, IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader("paths.txt"));

        String textLine = bufferedReader.readLine();
        do {
            System.out.println(textLine);

            textLine = bufferedReader.readLine();
        } while (textLine != null);

        bufferedReader.close();
        return null;
    }
}
