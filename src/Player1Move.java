public class Player1Move implements IGameState, IMove
{
    private GameBoard gameBoard;

    public Player1Move(GameBoard gameBoard)
    {
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
        return "Turn: Player 1 (X)";
    }
}
