public class NewGame implements IGameState
{
    private GameBoard gameBoard;
    
    public NewGame(GameBoard gameBoard)
    {
        this.gameBoard = gameBoard;
    }
    
    public void resume()
    {
    }
    
    public void initGame()
    {
        gameBoard.setState(GameState.Player1Move);
    }
    
    public void switchPlayer()
    {
    }
    public void endGame(boolean hasWon)
    {
    }
    
    public String getStateDisplay()
    {
        return "";
    }
}
