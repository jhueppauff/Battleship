/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schiffeversenken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 *
 */
public class SchiffeVersenken {

    /**
     * @param args the command line arguments
     */
    
    
    static String[][] Spielfeld = new String[5][5];
    static String[][] Mod_Spielfeld = new String[5][5];
    static boolean gewonnen = false;
  
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        ladeSpiel();        
        ladeSpielfeld();
        
        while (!gewonnen) {            
            
            gameTick();
        }
        
        
        
    }
    
    public static void gameTick()
    {
        usingBufferedReader();
    }
    
    public static void Zug(String target)
    {
        
        if ("Zeige Feld".equals(target)) {
            zeigeSpielfeld();
        }
        else 
        {
        System.out.println("Feuer auf "+ target);
        
        List<String> splitList = Arrays.asList(target.split(","));
        
        int x = Integer.parseInt( splitList.get(0));
        int y = Integer.parseInt( splitList.get(1));
        
        x--;
        y--;
        
          
                
            
        
        if ("X".equals(Spielfeld[x][y])) {
           gewonnen = true;
           System.out.println("Treffer");
          System.out.println("Gewonnen");
          Mod_Spielfeld[x][y] = "X";
          Update();
        }
        else
        {
        Mod_Spielfeld[x][y] = "/";
        Update();
        
        }
            
          
    }
    }
    
    
    public static  void ladeSpiel()
    {
        for (int i = 0; i < Spielfeld.length; i++) {
            
            for (int j = 0; j < Spielfeld[i].length; j++) {
                
                Spielfeld[i][j] = "O";   
            }
        }
        
        for (int i = 0; i < Spielfeld.length; i++) {
            
            for (int j = 0; j < Spielfeld[i].length; j++) {
                
                Mod_Spielfeld[i][j] = "O";   
            }
        }
        
        
    }
    
    private static void usingBufferedReader()
{
  System.out.println("Select your target: x,y ");
  try{
     BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
     String inputString = bufferRead.readLine();
      
     Zug(inputString);
 }
 catch(IOException ex)
 {
    ex.printStackTrace();
 }
}   
    
    public static void ladeSpielfeld()
    {
        for (int i = 0; i < Spielfeld.length; i++) {
            for (int j = 0; j < Spielfeld.length; j++) {
                System.out.print(Spielfeld[i][j]);
                
                
            }
            System.out.println("");
            
            
            
        }
        
        erstelleFeind();
    }
    
    public static int randInt(int min, int max) {

    // Usually this can be a field rather than a method variable
    Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}
    
    private static void erstelleFeind()
    {
        int x = randInt(0,4);
        int y = randInt(0,4);
        
        Spielfeld[x][y] = "X";
    }
    
    public static void zeigeSpielfeld()
    {
        for (int i = 0; i < Spielfeld.length; i++) {
            for (int j = 0; j < Spielfeld.length; j++) {
                System.out.print(Spielfeld[i][j]);
                
                
            }
            System.out.println("");
            
            
            
        }
    }
    
    public static void Update()
    {
        for (int i = 0; i < Mod_Spielfeld.length; i++) {
            for (int j = 0; j < Mod_Spielfeld.length; j++) {
                System.out.print(Mod_Spielfeld[i][j]);
                
                
            }
            System.out.println("");
            
            
            
        }
    }
}
