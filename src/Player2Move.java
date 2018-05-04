public class Player2Move implements IGameState
{
    private GameBoard gameBoard;
    
    public Player2Move(GameBoard gameBoard)
    {
        this.gameBoard = gameBoard;
    }
    
    public void resume()
    {
    }
    
    public void initGame()
    {
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
        return "Turn: Player 2 (O)";
    }
}
