/** 
 * <h1>SettingPanel.java</h1>
 * 
 * <p>
 * Allows user to choose from three levels of difficulty of the game by clicking on three different buttons.
 * 
 * @author Lisa Huang (rhuang2), Huihan Li (hli3) and Tina Zhang (yzhang16)
 * @since 12-08-2017
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SettingPanel extends JPanel {
  //instance variables
  private JButton easyButton,mediumButton,hardButton;
  private JLabel info;
  private JPanel parent;
  private JPanel gridPanel;
  private CatifyGame catify; 
  private GamePanel gp;
  
  /** 
   * Constructor
   * Needs these parameter to establish connections between this panel and other panels
   * @param parent the parent panel (cardHolder/container) of this panel
   * @param game the CatifyGame instance
   * @param gp the Game Panel in the GUI
   */
  public SettingPanel(JPanel parent, CatifyGame game, GamePanel gp){
    this.gp = gp;
    this.parent = parent;
    this.catify = game;    
    
    // gets specifically the grid panel in the game panel
    gridPanel = this.gp.getGridPanel();
    
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
    
    // a JPanel that contains merely JButtons
    JPanel buttonPanel = ButtonPanel();
    
    c.gridwidth = GridBagConstraints.REMAINDER;
    c.gridheight = GridBagConstraints.REMAINDER;
    gridbag.setConstraints(buttonPanel,c);
    
    this.add(ButtonPanel());
    
  }
  
  /**
   * Returns a JPanel that contains merely JButtons
   * @return the result panel with buttons
   */
  private JPanel ButtonPanel(){
    
    JPanel result = new JPanel();
    result.setPreferredSize(new Dimension(400,300));
    result.setMaximumSize(new Dimension(400,300));
    result.setMinimumSize(new Dimension(400,300));
    
    easyButton = new JButton("   EASY   ");
    easyButton.setFont(new Font("Forte", Font.PLAIN, 24));
    easyButton.addActionListener (new ButtonListener());
    easyButton.addActionListener(new Switcher("Game Panel", this.parent));
    
    mediumButton = new JButton("MEDIUM");
    mediumButton.setFont(new Font("Forte", Font.PLAIN, 24));
    mediumButton.addActionListener (new ButtonListener());
    mediumButton.addActionListener(new Switcher("Game Panel", this.parent));
    
    hardButton = new JButton("   HARD   ");
    hardButton.setFont(new Font("Forte", Font.PLAIN, 24));
    hardButton.addActionListener (new ButtonListener());
    hardButton.addActionListener(new Switcher("Game Panel", this.parent));
    
    result.setLayout(new BoxLayout(result, BoxLayout.Y_AXIS));
    
    easyButton.setAlignmentX(result.CENTER_ALIGNMENT);
    mediumButton.setAlignmentX(result.CENTER_ALIGNMENT);
    hardButton.setAlignmentX(result.CENTER_ALIGNMENT);
    
    result.add(Box.createRigidArea(new Dimension(0,60)));
    result.add(easyButton);
    result.add(Box.createRigidArea(new Dimension(0,50)));
    
    result.add(mediumButton);
    result.add(Box.createRigidArea(new Dimension(0,50)));
    
    result.add(hardButton);
    
    return result;
  }
  
  /**
   * A private ButtonListener class used as ActionListeners for the buttons in this class.
   */
  private class ButtonListener implements ActionListener {
    
    /* 
     * Invoked when an action occurs.
     * @param event The ActionEvent
     */
    public void actionPerformed (ActionEvent event) {
      
      // start the game both in the backend and in the frontend
      if (event.getSource() == easyButton){
        catify.setGame(8);
        gp.setBoard(8);
        System.out.println("Starting the game with 8 pairs");
        System.out.println(catify.getBoard());
      }
      if (event.getSource() == mediumButton){
        catify.setGame(18);
        gp.setBoard(18);
        System.out.println("Starting the game with 18 pairs");
        System.out.println(catify.getBoard());
      }
      if (event.getSource() == hardButton){
        catify.setGame(32);
        gp.setBoard(32);
        System.out.println("Starting the game with 32 pairs");
        System.out.println(catify.getBoard());
      }
    }
  }
}