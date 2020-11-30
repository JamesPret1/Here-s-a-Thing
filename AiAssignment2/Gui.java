package gui; 
import java.util.Arrays;
import java.awt.*;
import javax.swing.*;

public class Gui {
        public static void main(String[] args) 
    { 
        String[][] board = {
            { "AW", "AH" , "AM" },
            { " 0", " 0", " 0" },
            { "PW", "PH", "PM" }
         };
         for (int i = 0; i < board.length; i++) { 
            for (int j = 0; j < board[i].length; j++) { 
               System.out.print(board[i][j] + " ");
            }
            System.out.println(); 
        }
    } 
}