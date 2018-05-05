import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class GameMonitor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameMonitor extends JPanel implements GameObserver
{
    private String gameState;
    private GameBoard gameBoard;
    private JTextField monitor;
    /**
     * Constructor for objects of class GameMonitor
     */
    public GameMonitor(GameBoard newGameBoard)
    {
        // initialise instance variables
        gameBoard = newGameBoard;
        setLayout(new GridLayout(1,2));
        monitor = new JTextField(5);
        monitor.setVisible(true);
        monitor.setPreferredSize(new Dimension(30,30));
        add(monitor);

    }
    public void update()
    {
        gameState = gameBoard.getStateDisplay();
        showGameState();
    }
    public void showGameState()
    {
        monitor.setText(gameState);
    }
    
}
