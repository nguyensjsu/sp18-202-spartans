
/**
 * Write a description of class GameBoard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;


public class GameBoard implements GameSubject
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

    /**
     * Constructor for objects of class GameBoard
     */
    public GameBoard(IGameState aState, int max)
    {
        // initialise instance variables
        currentState = aState;
        maxMoves = max;
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

    public boolean checkMove(int position)
    {
        boolean result = false;
        return result;
    }

    public boolean checkWin()
    {
        boolean result = false;
        return result;
    }

    public void placeMove(int position)
    {
    }
}
