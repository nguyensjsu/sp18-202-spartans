import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.io.*;

public class AIStrategy extends GameStrategy
{
    private GameBoard gameBoard;
    
    public AIStrategy(GameBoard gameBoard)
    {
        super(gameBoard);
        this.gameBoard = gameBoard;
    }
    
    public void predict()
    {
        int bestMove = getBestMove();
        JButton buttonAI = gameBoard.getButton(bestMove);
       
        buttonAI.setText("O");
        gameBoard.setBoard(bestMove, -1);
        gameBoard.increNumMoves();

        if (gameBoard.checkWin())
        {
            gameBoard.getState().endGame(true);
            System.out.println(gameBoard.getState().getStateDisplay());
        }
        else if(gameBoard.getNumMoves() >= gameBoard.getMaxMoves())
        {
            gameBoard.getState().endGame(false);
            System.out.println(gameBoard.getState().getStateDisplay());
        }
        else
            gameBoard.getState().switchPlayer();
        gameBoard.notifyObs();
    }
    
    public int getBestMove()
    {
        try{
            String currMoves = gameBoard.getCurrMoves();
            ProcessBuilder pb = new ProcessBuilder("python","NN_Classifier_model.py"," "+currMoves);
            Process p = pb.start();
             
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            
            String predict_proba = in.readLine();
            String[] proba = predict_proba.split(" ");
            System.out.println("Predict probability : ");
            
            for(int i = 0; i < proba.length; i++)
            {
                System.out.println("\t" + i + ": " + proba[i]);
            }
            
            int ret = new Integer(in.readLine()).intValue();
            System.out.println("Best position is : "+ret);
            return ret;
        } catch(Exception e)
        {
            System.out.println(e);
            return -1;
        }           
    }
}
