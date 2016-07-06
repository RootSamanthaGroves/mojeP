/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package naukajavy;

import java.math.BigInteger;
import static java.util.Arrays.equals;
import static java.util.Arrays.equals;
import java.util.Scanner;

/**
 *
 * @author Dominika
 */
public class NaukaJavy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i = 0; // zmienna w jawie musi bys zainicjalizowania bo bedzie blond
        System.out.println(i);

        //[][] int t;   zle
        int[][] t = null;  //mozna
        //  t [0][0]=1;  
        
        
        int[] tablica = {1,2,3,4};// mozna

        int ta[][] = new int[1][1];
        System.out.println(ta[0][0]);

        int l = 0;
        int k = 0;

        System.out.println(++k + " " + l++);

        int a = 17;
        int b = 4;
        int c = a + b; //=21
        c = a - b;     //=13
        c = a * b;     //=68
        c = a / b;     //=4 ponieważ 4*4=16 i zostaje reszty 1
        c = a % b;     //=1 reszta z dzielenia

  //    int a = 5;
//int b = 3;
        boolean prawda = a > b; //prawda=true
        boolean falsz = a < b;  //falsz=false
        boolean porownanie = a == b;  //porownanie=false
        boolean koniunkcja = (a > b) && (a != b); //true prawda i prawda = prawda
        System.out.println(falsz);

        System.out.println(Math.abs(a));
        BigInteger wielkaLiczba = new BigInteger("12312312312312312312");
        System.out.println(wielkaLiczba.toString());
        //=============================================
        BigInteger q = new BigInteger("123123123123123123123123123123");
        BigInteger w = new BigInteger("987654321987654321987654321987");
        BigInteger suma = q.add(w);
        System.out.println("Suma " + suma.toString());
        System.out.println(wielkaLiczba.toString());
    //=============================================

        int aa = 5;
        double bb = 13.5;
        //  int c = bb/aa;               //TAK NIE MOŻNA ZROBIĆ!
    double cc;
        
        c = (int) (bb/aa);
        cc=bb/aa;
        System.out.println(c+" "+cc);
        //=================================
//        String imie;
//       Scanner skaner = new Scanner(System.in);
//       imie= skaner.nextLine();
       
       
    //---------------------------------------------
      // class NazwaMojejKlasy{ ... }    klasy z duze
     //void toMojaMetoda(){ ... }   metody z małej
         int jakasZmienna;    // zmienne z malej
   
    //=================================================
            int[] taa = new int[10];
        //wypełnienie tablicy
        for( i=0; i<10; i++)
            taa[i] = i+1;
 
        //wyświetlenie przy użyciu pętli for each
        for(int x : tablica)
            System.out.println(x);
    
    
    }

}
