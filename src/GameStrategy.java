import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public abstract class GameStrategy implements ActionListener
{
    private GameBoard gameBoard;
    
    public GameStrategy(GameBoard gameBoard)
    {
        this.gameBoard = gameBoard;
    }
    
    public void actionPerformed(ActionEvent e)
    {

        JButton buttonClicked = (JButton)e.getSource(); //get the particular button that was clicked

        if (!gameBoard.isMoveableState())
            return;
            
        if (gameBoard.checkMove(buttonClicked.getText()))
        {
            String symbol = ((IMove)gameBoard.getState()).getSymbol();
            int position = Integer.parseInt(((JButton)e.getSource()).getName());
            buttonClicked.setText(symbol);
            if ( symbol.equals("X") )
                gameBoard.setBoard(position, 1);
            else
                gameBoard.setBoard(position, -1);
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
        predict();
    }
    
    abstract public void predict();
}
