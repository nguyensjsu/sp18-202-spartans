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
        JFrame window = new JFrame("Tic-Tac-Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // window.getContentPane().setLayout(new GridLayout(2,1));
        GameBoard newBoard = new GameBoard(3);
        GameMonitor monitor = new GameMonitor(newBoard);
        newBoard.attach(monitor);
        
        window.getContentPane().add(monitor, BorderLayout.PAGE_START);
        window.getContentPane().add(newBoard, BorderLayout.CENTER);
        window.setBounds(300,200,300,300);
        window.setVisible(true);
    }
}
