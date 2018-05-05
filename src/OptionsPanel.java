import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.*;
import javax.swing.*;


public class OptionsPanel extends JPanel {
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
          singlePlayer.setEnabled(true);
        }
      }
    });

    fourXFour.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent event) {
        int state = event.getStateChange();
        if (state == ItemEvent.SELECTED) {
          multiPlayer.setSelected(true);
          singlePlayer.setEnabled(false);
        }
      }
    });

    JButton startGameButton = new JButton();
    startGameButton.setText("Start Game");


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
}
