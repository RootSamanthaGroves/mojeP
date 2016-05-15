package pracamgr;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import weka.associations.Apriori;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ArffLoader;
import weka.filters.Filter;
import weka.filters.supervised.attribute.Discretize;



/**
 *
 * @author Dominika
 */
public class PracaMgr {

    public static Instances loadData(String fileName)
    throws IOException
    {
        ArffLoader loader = new ArffLoader(); //Utworzenie obiektu czytajacego dane z formatu ARFF
        loader.setFile(new File(fileName)); //Ustawienie pliku do odczytania
        return loader.getDataSet(); //Odczytanie danych z pliku
    }
    
    
    //Generowanie regul asocjacyjnych
    public static void regulyAsocjacyjne()
    throws Exception
    {
        Instances data = loadData("./src/data/osmolski.arff");
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


    //Generowanie regul asocjacyjnych z wczesniejsza dysretyzacja tablicy
    public static void regulyAsocjacyjneDyskret()
    throws Exception
    {
        Instances data = loadData("./src/data/irysy.arff");
        data.setClassIndex(data.numAttributes() - 1);

        Discretize filter = new Discretize();

        filter.setInputFormat(data);

        //Dyskretyzacja tablicy
        Instances trainDiscret = Filter.useFilter(data, filter);

        //Opcje liczenia regul asocjacyjnych
        String[] options = Utils.splitOptions("-N 10 -C 0.9");

        Apriori apriori = new Apriori();
        apriori.setOptions(options);
        apriori.buildAssociations(trainDiscret);

        System.out.println("Liczba regul=" + apriori.getNumRules());

        System.out.println(apriori.toString());

    }
    
    
    public static void main(String[] args) {
     
        
        
        
        
        
        System.out.println("What are your commands ?");
        
        
        try
        {
            String fileName = "./src/data/irysy.arff"; //Lokalizacja pliku z danymi
            Instances dataSet = loadData(fileName);
            int noObj = dataSet.numInstances(); //Pobranie informacji o liczbie obiektow
            int noAttr = dataSet.numAttributes(); //Pobranie informacji o liczbie atrybutow
            System.out.println("Liczba obiektow=" + noObj);
            System.out.println("Liczba atrybutow="+noAttr);             
                        
           

            regulyAsocjacyjne();
            regulyAsocjacyjneDyskret();
            
        }
        catch (Exception e)
        {
            System.out.println("ERROR: "+e.getMessage());
        }
        System.out.println("The End");
    }

}
    
    

