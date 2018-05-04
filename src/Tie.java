public class Tie implements IGameState
{    private GameBoard gameBoard;
    
    public Tie(GameBoard gameBoard)
    {
        this.gameBoard = gameBoard;
    }
    
    public void resume()
    {
    }
    
    public void initGame()
    {
        gameBoard.setState(GameState.NewGame);
    }
    
    public void switchPlayer()
    {
    }
    
    public void endGame(boolean hasWon)
    {
    }
    
    public String getStateDisplay()
    {
        return "Game tie!!!";
    }
}
