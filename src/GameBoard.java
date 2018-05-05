
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
    private IPlayer player;
    private IGameState player1Move;
    private IGameState player2Move;
    private IGameState player1Win;
    private IGameState player2Win;
    private IGameState tie;

    private int numMoves = 0 ;
    private int maxMoves = 0;
    private int[] board;
    private int[] start;
    private int[] increment;
    private int size;
    private ArrayList<GameObserver> observers;
    private JButton buttons[];
    private GameStrategy moveStrategy;
    private boolean isMultiPlayer;

    /**
     * Constructor for objects of class GameBoard
     */
    public GameBoard(int size, boolean isMultiPlayer)
    {
        // initialise instance variables
        this.isMultiPlayer = isMultiPlayer;
        this.size = size;
        newGame = new NewGame(this);
        resume = new Resume(this);
        player = new Player();
        player1Move = new Player1Move(this, player);
        player2Move = new Player2Move(this, player);
        player1Win = new Player1Win(this, player);
        player2Win = new Player2Win(this, player);
        tie = new Tie(this);
        currentState = player1Move;

        setUpBoard();
        setLayout(new GridLayout(size,size));
        observers = new ArrayList();
        initializebuttons();
    }

    public void setUpBoard()
    {
        maxMoves = size*size;

        board = new int[maxMoves];
        // number of possible way to win the game
        start = new int[size*2+2];
        increment = new int[size*2+2];

        for (int i = 0; i < board.length; i++)
        {
            board[i] = 0;
        }

        // setup int[] start
        for (int i = 0 ; i < size; i++)
        {
            start[i] = i * size;
        }

        for (int i = size; i < size * 2; i++)
        {
            start[i] = i - size;
        }

        start[start.length - 2] = 0;
        start[start.length - 1] = size - 1;

        // setup int[] increment
         for (int i = 0 ; i < size; i++)
        {
            increment[i] = 1;
        }

        for (int i = size; i < size * 2; i++)
        {
            increment[i] = size;
        }

        increment[increment.length - 2] = size + 1;
        increment[increment.length - 1] = size - 1;
    }

    public void initializebuttons()
    {
        buttons = new JButton[maxMoves];
        for(int i = 0; i < maxMoves; i++)
        {
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].setName(Integer.toString(i));
            if ((!isMultiPlayer) && size == 3)
                buttons[i].addActionListener(new AIStrategy(this));
            else
                buttons[i].addActionListener(new PlayerStrategy(this));
            add(buttons[i]); //adds this button to JPanel (note: no need for JPanel.add(...)
                                //because this whole class is a JPanel already
        }
    }
/*
      private class buttonListener implements ActionListener
    {
          public void actionPerformed(ActionEvent e)
        {

            JButton buttonClicked = (JButton)e.getSource(); //get the particular button that was clicked
            if (currentState != player1Move && currentState != player2Move)
                return;
            if (checkMove(buttonClicked.getText()))
            {
                String symbol = ((IMove)currentState).getSymbol();
                int position = Integer.parseInt(((JButton)e.getSource()).getName());
                buttonClicked.setText(symbol);
                if ( symbol.equals("X") )
                    board[position] = 1;
                else
                    board[position] = -1;
                numMoves++;

                if (checkWin())
                {
                    currentState.endGame(true);
                    System.out.println(currentState.getStateDisplay());
                }
                else if(numMoves >= maxMoves)
                {
                    currentState.endGame(false);
                    System.out.println(currentState.getStateDisplay());
                }
                else
                    currentState.switchPlayer();
            }
            notifyObs();
        }
    }
*/
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
        int sum = 0;
        for (int i = 0; i < start.length; i++)
        {
            sum = 0;
            for (int j = 0; j < size; j++)
            {
                sum += board[start[i] + j * increment[i]];
            }
            if (Math.abs(sum) == size)
              return true;
        }
        return false;
    }

    public String getCurrMoves()
    {
        String currMoves = "";
        for (int i=0; i < board.length; i++)
        {
            currMoves += board[i] + " ";
        }
        return currMoves.trim();
    }

    public void setBoard(int index, int value)
    {
        board[index] = value;
    }

    public void increNumMoves()
    {
        numMoves++;
    }

    public int getNumMoves()
    {
        return numMoves;
    }

    public int getMaxMoves()
    {
        return maxMoves;
    }

    public JButton getButton(int index)
    {
        return buttons[index];
    }

    public boolean isMoveableState()
    {
        if ( currentState == player1Move || currentState == player2Move )
            return true;

        return false;
    }
}
