
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
    
    public void setState(IGameState aState)
    {
        currentState = aState;
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
}
