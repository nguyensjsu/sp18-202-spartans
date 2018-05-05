
/**
 * Write a description of class PlayerDecorator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PlayerDecorator implements IPlayer
{
    private IPlayer player;
    /**
     * Constructor for objects of class PlayerDecorator
     */
    public PlayerDecorator(IPlayer p)
    {
        // initialise instance variables
        player = p;
    }

    public String getStateDisplay()
    {
        return player.getStateDisplay();
    }
}
