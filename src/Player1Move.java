public class Player1Move extends PlayerDecorator implements IGameState, IMove
{
    private GameBoard gameBoard;

    public Player1Move(GameBoard gameBoard, IPlayer p)
    {
        super(p);
        this.gameBoard = gameBoard;
    }
    
    public void resume()
    {
    }
    
    public void initGame()
    {
    }
    public String getSymbol()
    {
        return "X";
    }
    public void switchPlayer()
    {
        gameBoard.setState(GameState.Player2Move);
    }
    
    public void endGame(boolean hasWon)
    {
        if ( hasWon )
            gameBoard.setState(GameState.Player1Win);
        else
            gameBoard.setState(GameState.Tie);
    }
    
    public String getStateDisplay()
    {
        return addedString(super.getStateDisplay());
    }
    
    public String addedString(String s)
    {
        return s + "1's move";
    }
}
