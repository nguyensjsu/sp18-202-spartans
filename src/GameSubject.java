
/**
 * Write a description of interface GameSubject here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface GameSubject
{
    public void attach(GameObserver obs);
    public void notifyObs();
}
