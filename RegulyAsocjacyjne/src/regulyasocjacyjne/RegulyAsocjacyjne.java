/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regulyasocjacyjne;

import java.io.File;
import java.io.IOException;
import weka.associations.Apriori;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ArffLoader;

/**
 *
 * @author Dominika
 */
public class RegulyAsocjacyjne {

    
    //Odczytanie tablicy danych z dysku w formacie ARFF
    public static Instances loadData(String fileName)
    throws IOException
    {
        ArffLoader loader = new ArffLoader(); //Utworzenie obiektu czytajacego dane z formatu ARFF
        loader.setFile(new File(fileName)); //Ustawienie pliku do odczytania
        return loader.getDataSet(); //Odczytanie danych z pliku
    }

    public static void infoObj()
    throws Exception
    {
        Instances data = loadData("./src/date/irysy.arff");

        for (int i=0; i<data.numInstances(); i++) //Przegladanie obiektow
        {
            System.out.println("Wiersz numer " + i + ":");
            
            Instance instance = data.instance(i); //Pobranie obiektu (wiersza danych) o podanym numerze
            
            for (int j = 0; j < instance.numAttributes(); j++) //Przegladanie atrybutow w obiekcie
            {
                String textValue = instance.toString(j); //Pobranie wartosci atrybutu o podanym numerze (tzn. pobranie tekstowej reprezentacji wartosci)
                System.out.print(textValue + ", ");
            }
            System.out.println();
        }
    }
    
     
    //Generowanie regul asocjacyjnych
    public static void regulyAsocjacyjne()
    throws Exception
    {
        Instances data = loadData("./src/date/irysy.arff");
        data.setClassIndex(data.numAttributes() - 1);
        
        //-N ->Liczba regul do policzenia (standardowo: 10)
        //-C ->Minmalna ufnosc reguly (standardowo: 0.9).
        
        String[] options = Utils.splitOptions("-N 20 -C 0.6");
        Apriori apriori = new Apriori();
        apriori.setOptions(options);
        apriori.buildAssociations(data); //Generowanie regul asocjacyjnych

        System.out.println("Liczba regul=" + apriori.getNumRules());

        System.out.println(apriori.toString()); //Wypisanie informacji o regulach
    }

    public static void main(String[] args) throws Exception {
        
        
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Windows.WindowMain().setVisible(true);
            }
        });
         
         try {  String fileName = "./src/date/irysy.arff"; //Lokalizacja pliku z danymi
            Instances dataSet = loadData(fileName);
            int noObj = dataSet.numInstances(); //Pobranie informacji o liczbie obiektow
            int noAttr = dataSet.numAttributes(); //Pobranie informacji o liczbie atrybutow
            System.out.println("Liczba obiektow=" + noObj);
            System.out.println("Liczba atrybutow="+noAttr);     
            regulyAsocjacyjne();
            infoObj();
            
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
          
    }
    
}
