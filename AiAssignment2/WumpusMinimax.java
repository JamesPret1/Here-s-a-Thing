package AiAssignment2; 
import java.util.function.Function;
import java.lang.Math;


public class WumpusMinimax {

    //double numPieces = (d/3) * 3; //the total number of pieces. d is an input for size of grid.
    boolean gameover;
    double Pinfinity = Double.POSITIVE_INFINITY;    //Positve infinity
    double Ninfinity = Double.NEGATIVE_INFINITY;    //Negative infinity 
    double eval;
    double alpha = 0;
    double beta = 0;
    String[][] board = {    //initialize and create the starting board 
        { "AW", "AH" , "AM" },   //Agent Wumpus, Hero, and Mage
        { " 0", " 0", " 0" },
        { "PW", "PH", "PM" }     //Player Wumpus, Hero, and Mage
     };
    

    public double MiniMax(Node position, double depth, boolean isMaximizing){
        if (depth == 0){  //if we are at the bottom leaf nodes return the static position
            return position.value;
        }

        if (isMaximizing){   // the agent's turn (the maximizing player)
            alpha =  Ninfinity;
            
            eval = MiniMax(position.leftchild, depth - 1, false);   //Call minimax on both left & right child of the current node
            eval = MiniMax(position.rightchild, depth - 1, false);
            alpha = Math.max(alpha, eval); 
            if (alpha >= beta) return MiniMax(position, depth-1, true); //check to see if we can prune the part of the current subtree
            return alpha;
        }
        else{  // the player's turn (the minimizing player)
            beta = Pinfinity; 

            eval = MiniMax(position.leftchild, depth - 1, true);   //Call minimax on both left & right child of the current node
            eval = MiniMax(position.rightchild, depth - 1, true);
            beta = Math.min(beta, eval);
            if (alpha >= beta) return MiniMax(position, depth-1, false); //check to see if we can prune the part of the current subtree
            return beta; 
        }

    }
    

    public static void main(String []args){
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

