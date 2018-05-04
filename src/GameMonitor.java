
/**
 * Write a description of class GameMonitor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameMonitor implements GameObserver
{
    private String gameState;
    private GameBoard gameBoard;
    /**
     * Constructor for objects of class GameMonitor
     */
    public GameMonitor(GameBoard newGameBoard)
    {
        // initialise instance variables
        gameBoard = newGameBoard;
    }
    public void update()
    {
        gameState = gameBoard.getStateDisplay();
    }
    public void showGameState()
    {
        
    }
}
