import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class Client here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Client
{
    public static void main(String[] args)
    {
        JFrame window = new JFrame("Tic-Tac-Toe Options");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OptionsPanel options = new OptionsPanel();
        window.getContentPane().add(options, BorderLayout.PAGE_START);
        window.setBounds(300,200,300,300);
        window.setVisible(true);
    }
}
