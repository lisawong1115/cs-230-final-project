/** 
 * SettingPanel.java
 * 
 * @author Lisa Huang (rhuang2), Huihan Li (hli3) and Tina Zhang (yzhang16)
 * @since 12-08-2017
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SettingPanel extends JPanel {
  //instance vars
  private JButton easyButton,mediumButton,hardButton;
  private JLabel info;
  private JPanel parent;
  private JPanel gridPanel;
  private CatifyGame game; 
  private GamePanel gp;
  
  public SettingPanel(JPanel parent, CatifyGame game, GamePanel gp){
    this.gp = gp;
    gridPanel = this.gp.getGridPanel();
    this.parent = parent;
    
    this.game = game;     
    
    GridBagLayout gridbag = new GridBagLayout();
    this.setLayout(gridbag);
    GridBagConstraints c = new GridBagConstraints();
    
    info = new JLabel("HOW MANY CATS CAN YOU FIND?");
    info.setFont(new Font("Algerian", Font.BOLD, 44));
    info.setHorizontalAlignment(JLabel.CENTER);
    c.gridwidth = GridBagConstraints.REMAINDER;
    c.gridheight = 3;
    gridbag.setConstraints(info,c);
    this.add(info);
    
    
    JPanel buttons = ButtonPanel();
    c.gridwidth = GridBagConstraints.REMAINDER;
    c.gridheight = GridBagConstraints.REMAINDER;
    gridbag.setConstraints(buttons,c);
    
    
    this.add(ButtonPanel());
    
  }
  
  private JPanel ButtonPanel(){
    JPanel buttons = new JPanel();
    buttons.setPreferredSize(new Dimension(400,300));
    buttons.setMaximumSize(new Dimension(400,300));
    buttons.setMinimumSize(new Dimension(400,300));
    
    easyButton = new JButton("    EASY    ");
    easyButton.setFont(new Font("Forte", Font.PLAIN, 24));
    easyButton.addActionListener (new ButtonListener());
    easyButton.addActionListener(new Switcher("Game Panel", this.parent));
    
    mediumButton = new JButton("MEDIUM");
    mediumButton.setFont(new Font("Forte", Font.PLAIN, 24));
    mediumButton.addActionListener (new ButtonListener());
    mediumButton.addActionListener(new Switcher("Game Panel", this.parent));
    
    hardButton = new JButton("    HARD    ");
    hardButton.setFont(new Font("Forte", Font.PLAIN, 24));
    hardButton.addActionListener (new ButtonListener());
    hardButton.addActionListener(new Switcher("Game Panel", this.parent));
    
    buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
    
    easyButton.setAlignmentX(buttons.CENTER_ALIGNMENT);
    
    mediumButton.setAlignmentX(buttons.CENTER_ALIGNMENT);
    
    hardButton.setAlignmentX(buttons.CENTER_ALIGNMENT);
    
    buttons.add(Box.createRigidArea(new Dimension(0,60)));
    buttons.add(easyButton);
    buttons.add(Box.createRigidArea(new Dimension(0,50)));
    
    buttons.add(mediumButton);
    buttons.add(Box.createRigidArea(new Dimension(0,50)));
    
    buttons.add(hardButton);
    
    return buttons;
  }
  
  
  private class ButtonListener implements ActionListener {
    
    /* 
     * Invoked when an action occurs.
     * @param event The ActionEvent
     */
    public void actionPerformed (ActionEvent event) {
      
      if (event.getSource() == easyButton){
        game.setGame(8);
        gp.setBoard(8);
        System.out.println("Starting the game with 8 pairs");
      }
      if (event.getSource() == mediumButton){
        game.setGame(18);
        gp.setBoard(18);
        System.out.println("Starting the game with 18 pairs");
      }
      if (event.getSource() == hardButton){
        game.setGame(32);
        gp.setBoard(32);
        System.out.println("Starting the game with 32 pairs");
      }
    }
    
    
  }
}