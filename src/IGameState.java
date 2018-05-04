public interface IGameState
{
  public void resume();             
  public void initGame();                   // setState from NewGame to Player1Move
  public void switchPlayer();               // setState from a Player Move to another Player Move
  public void endGame(boolean hasWon);      // setState from Player Move to Player Win or Player Move to Tie
  public String getStateDisplay();          // return a content of the state

}
