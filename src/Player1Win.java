public class Player1Win extends PlayerDecorator implements IGameState
{
    private GameBoard gameBoard;
    
    public Player1Win(GameBoard gameBoard, IPlayer p)
    {
        super(p);
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
        return addedString(super.getStateDisplay());
    }
    
    public String addedString(String s)
    {
        return s + "1 win";
    }
}
