public class Player1Win implements IGameState
{
    private GameBoard gameBoard;
    
    public Player1Win(GameBoard gameBoard)
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
        return "Player 1 win!!!";
    }
}
