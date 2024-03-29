import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class OptionsPanel extends JPanel {

  private boolean isSmallboard = true;
  private boolean isMultiPlayer = true;

  public OptionsPanel() {
    JRadioButton threeXThree = new JRadioButton("3x3");
    JRadioButton fourXFour = new JRadioButton("4x4");
    JRadioButton singlePlayer = new JRadioButton("single player");
    JRadioButton multiPlayer = new JRadioButton("multi player");
    ButtonGroup boardSizeOptions = new ButtonGroup();
    ButtonGroup playModeOptions = new ButtonGroup();


    boardSizeOptions.add(threeXThree);
    boardSizeOptions.add(fourXFour);
    threeXThree.setSelected(true);

    playModeOptions.add(singlePlayer);
    playModeOptions.add(multiPlayer);
    multiPlayer.setSelected(true);

    threeXThree.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent event) {
        int state = event.getStateChange();
        if (state == ItemEvent.SELECTED) {
          isSmallboard = true;
          singlePlayer.setEnabled(true);
        }
      }
    });

    fourXFour.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent event) {
        int state = event.getStateChange();
        if (state == ItemEvent.SELECTED) {
          isSmallboard = false;
          multiPlayer.setSelected(true);
          singlePlayer.setEnabled(false);
        }
      }
    });

    multiPlayer.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent event) {
        int state = event.getStateChange();
        if (state == ItemEvent.SELECTED) {
          isMultiPlayer = true;
        }
      }
    });

    singlePlayer.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent event) {
        int state = event.getStateChange();
        if (state == ItemEvent.SELECTED) {
          isMultiPlayer = false;
        }
      }
    });

    JButton startGameButton = new JButton();
    startGameButton.setText("Start Game");
    startGameButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        startGame();
      }
    });

    setLayout(new GridBagLayout());

    GridBagConstraints gbc = new GridBagConstraints();

    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 0;
    this.add(threeXThree, gbc);

    gbc.gridx = 1;
    gbc.gridy = 0;
    this.add(fourXFour, gbc);

    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.ipady = 20;
    gbc.gridx = 0;
    gbc.gridy = 1;
    this.add(multiPlayer, gbc);

    gbc.gridx = 1;
    gbc.gridy = 1;
    this.add(singlePlayer, gbc);

    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridwidth = 2;
    this.add(startGameButton, gbc);

  }

  private void startGame() {
    if (isSmallboard) {
      JFrame window = new JFrame("Tic-Tac-Toe");
      // window.getContentPane().setLayout(new GridLayout(2,1));
      GameBoard newBoard = new GameBoard(3, isMultiPlayer);
      GameMonitor monitor = new GameMonitor(newBoard);
      newBoard.attach(monitor);

      window.getContentPane().add(monitor, BorderLayout.PAGE_START);
      window.getContentPane().add(newBoard, BorderLayout.CENTER);
      window.setBounds(300,200,300,300);
      window.setVisible(true);
    }
    else {
      JFrame window = new JFrame("Tic-Tac-Toe");
      // window.getContentPane().setLayout(new GridLayout(2,1));
      GameBoard newBoard = new GameBoard(4, isMultiPlayer);
      GameMonitor monitor = new GameMonitor(newBoard);
      newBoard.attach(monitor);

      window.getContentPane().add(monitor, BorderLayout.PAGE_START);
      window.getContentPane().add(newBoard, BorderLayout.CENTER);
      window.setBounds(300,200,300,300);
      window.setVisible(true);
    }
  }
}
