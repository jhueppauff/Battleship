/*
 * Copyright (C) Julian Hüppauff 2016
 * MIT Licence
 * See https://github.com/jhueppauff/Battleship/blob/master/LICENSE for more Information
 */
package BattleShip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BattleShip {

    static String[][] board = new String[5][5];
    static String[][] modBoard = new String[5][5];
    static boolean victory = false;
  
    public static void main(String[] args) {
        
        LoadGame();        
        LoadBoard();
        
        while (!victory) {              
            gameTick();
        }   
    }
    
    public static void gameTick()
    {
        usingBufferedReader();
    }
    
    public static void Move(String target)
    { 
        if ("Show Board".equals(target)) {
            ShowBoard();
        }
        else 
        {
        System.out.println("Fire at "+ target);
        
        List<String> splitList = Arrays.asList(target.split(","));
        
        int x = Integer.parseInt( splitList.get(0));
        int y = Integer.parseInt( splitList.get(1));
        
        x--;
        y--;

        if ("X".equals(board[x][y])) {
           victory = true;
           System.out.println("Treffer");
          System.out.println("Gewonnen");
          modBoard[x][y] = "X";
          Update();
        }
        else
        {
        modBoard[x][y] = "/";
        Update();
        
        }        
    }
    }  
    
    public static  void LoadGame()
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "O";   
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                modBoard[i][j] = "O";   
            }
        }
    }
    
    private static void usingBufferedReader(){
        System.out.println("Select your target: x,y ");
        try{
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String inputString = bufferRead.readLine();
            Move(inputString);
         }
         catch(IOException ex)
         {
            ex.printStackTrace();
         }
    }   
    
    public static void LoadBoard()
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]); 
            }
            System.out.println("");
        }
        CreateEnenmy();
    }
    
    public static int randInt(int min, int max) {

    // Usually this can be a field rather than a method variable
    Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
    }
    
    private static void CreateEnenmy()
    {
        int x = randInt(0,4);
        int y = randInt(0,4);
        
        board[x][y] = "X";
    }
    
    public static void ShowBoard()
    {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);                
            }
            System.out.println(""); 
        }
    }
    
    public static void Update()
    {
        for (int i = 0; i < modBoard.length; i++) {
            for (int j = 0; j < modBoard.length; j++) {
                System.out.print(modBoard[i][j]);    
            }
            System.out.println("");
        }
    }
}
