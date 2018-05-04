public class Player2Win implements IGameState
{
    private GameBoard gameBoard;
    
    public Player2Win(GameBoard gameBoard)
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
        return "Player 2 win!!!";
    }
}
