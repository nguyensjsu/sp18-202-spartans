public class Player2Move extends PlayerDecorator implements IGameState, IMove
{
    private GameBoard gameBoard;
    
    public Player2Move(GameBoard gameBoard, IPlayer p)
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
        return "O";
    }
    public void switchPlayer()
    {
        gameBoard.setState(GameState.Player1Move);
    }
    
    public void endGame(boolean hasWon)
    {
        if ( hasWon )
            gameBoard.setState(GameState.Player2Win);
        else
            gameBoard.setState(GameState.Tie);
    }
    
    public String getStateDisplay()
    {
        return addedString(super.getStateDisplay());
    }
    
    public String addedString(String s)
    {
        return s + "2's move";
    }
}
