
/**
 * Write a description of class GameBoard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameBoard extends JPanel implements GameSubject
{
    private IGameState currentState;
    private IGameState newGame;
    private IGameState resume;
    private IGameState player1Move;
    private IGameState player2Move;
    private IGameState player1Win;
    private IGameState player2Win;
    private IGameState tie;

    int numMoves = 0 ;
    int maxMoves = 0;
    ArrayList<GameObserver> observers;
    JButton buttons[] = new JButton[9];
    
    /**
     * Constructor for objects of class GameBoard
     */
    public GameBoard(int size)
    {
        // initialise instance variables
        newGame = new NewGame(this);
        resume = new Resume(this);
        player1Move = new Player1Move(this);
        player2Move = new Player2Move(this);
        player1Win = new Player1Win(this);
        player2Win = new Player2Win(this);
        tie = new Tie(this);
        currentState = player1Move;
        
        maxMoves = size*size;
        setLayout(new GridLayout(size,size));
        initializebuttons(); 
    }
    public void initializebuttons()
    {
        for(int i = 0; i <= 8; i++)
        {
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].addActionListener(new buttonListener());
            
            add(buttons[i]); //adds this button to JPanel (note: no need for JPanel.add(...)
                                //because this whole class is a JPanel already           
        }
    }
    
      private class buttonListener implements ActionListener
    {
          public void actionPerformed(ActionEvent e) 
        {
            
            JButton buttonClicked = (JButton)e.getSource(); //get the particular button that was clicked
            if (checkMove(buttonClicked.getText()))
            {
                buttonClicked.setText(((IMove)currentState).getSymbol());
                numMoves++;
                if (checkWin())
                    currentState.endGame(true);
                else if(numMoves >= maxMoves)
                    currentState.endGame(false);
                else
                    currentState.switchPlayer();
            }
            
        }
    }
    
    public void setState(GameState aState)
    {
        switch(aState)
        {
            case NewGame:
                currentState = newGame;
                break;
            case Resume:
                currentState = resume;
                break;
            case Player1Move:
                currentState = player1Move;
                break;
            case Player2Move:
                currentState = player2Move;
                break;
            case Player1Win:
                currentState = player1Win;
                break;
            case Player2Win:
                currentState = player2Win;
                break;
            case Tie:
                currentState = tie;
                break;
            default:;
        }

    }

    public IGameState getState()
    {
        return currentState;
    }

    public void attach(GameObserver obs)
    {
        observers.add(obs);
    }

    public void notifyObs()
    {
        for (GameObserver obs: observers)
        {
            obs.update();
        }
    }
    public String getStateDisplay()
    {
        return currentState.getStateDisplay();
    }

    public boolean checkMove(String currText)
    {
        if (currText.isEmpty())
            return true;
        return false;
    }

    public boolean checkWin()
    {
        boolean result = false;
        return result;
    }
}
