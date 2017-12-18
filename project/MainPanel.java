/** 
 * <h1>MainPanel.java</h1>
 * 
 * <p>
 * The Home Screen for the game, contains the name of a game, a very cute picture, and three buttons: New Game, ? Help, 
 * and Quit.
 * 
 * @author Lisa Huang (rhuang2), Huihan Li (hli3) and Tina Zhang (yzhang16)
 * @since 12-08-2017
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MainPanel extends JPanel {
  
  // instance variables
  private JLabel l1;
  private JLabel l2;
  private JLabel img;
  private JButton newGame;
  private JButton help;
  private JButton quit;
  private JPanel myParent;
  
  /** 
   * Constructor
   * @param parent the parent panel (cardHolder/container) of this panel
   */
  public MainPanel (JPanel parent) {
    
    // the parent panel (the card holder) of this panel
    myParent = parent;
    
    l1 = new JLabel ("Catify ");
    l2 = new JLabel ("The next killer app designed by LHT INC.");
    img = new JLabel (new ImageIcon("../cat_pics/pic3.jpg"));
    
    
    l1.setAlignmentX(Component.CENTER_ALIGNMENT);
    l1.setFont(new Font("Chalkduster", Font.PLAIN, 80));
    this.add(l1);
    
    this.add(Box.createVerticalStrut(20));
    
    l2.setAlignmentX(Component.CENTER_ALIGNMENT);
    this.add(l2);
    
    this.add(Box.createVerticalStrut(20));
    
    img.setAlignmentX(Component.CENTER_ALIGNMENT);
    this.add(img);
    
    this.add(Box.createVerticalStrut(20));
    
    // A panel with merely buttons
    JPanel buttonsPanel = ButtonsPanel();
    this.add(buttonsPanel);
    
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
  }
  
  /**
   * Returns a JPanel with three buttons.
   * @return the result JPanel with three buttons
   */
  private JPanel ButtonsPanel(){
    
    JPanel result = new JPanel();
    
    newGame = new JButton ("New Game");
    help = new JButton ("? Help");
    quit = new JButton ("Quit");
    
    newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
    newGame.setPreferredSize(new Dimension(200, 100));
    newGame.setFont(new Font("Arial", Font.PLAIN, 24));
    newGame.addActionListener(new ButtonListener());
    // add a switcher to the newGame button that guides the user to the setting panel before starting the game
    newGame.addActionListener(new Switcher("Setting Panel", myParent));
    result.add(newGame);
    
    help.setAlignmentX(Component.CENTER_ALIGNMENT);
    help.setPreferredSize(new Dimension(200, 100));
    help.setFont(new Font("Arial", Font.PLAIN, 24));
    help.addActionListener(new ButtonListener());
    // add a switcher to the newGame button that guides the user to the setting panel before starting the game
    help.addActionListener(new Switcher("Help Panel", myParent));
    result.add(help);
    
    
    quit.setAlignmentX(Component.CENTER_ALIGNMENT);
    quit.setPreferredSize(new Dimension(200, 100));
    quit.setFont(new Font("Arial", Font.PLAIN, 24));
    quit.addActionListener(new ButtonListener());
    result.add(quit);
    
    result.setLayout(new FlowLayout());
    
    return result;
    
  }
  
  
  /**
   * A private ButtonListener class used as ActionListeners for the buttons in this class.
   */
  private class ButtonListener implements ActionListener {
    
    /**
     * Invoked when an action occurs.
     * @param e The action event that occurs
     */
    public void actionPerformed (ActionEvent e) {
      if (e.getSource() == quit) {
        System.out.println("Goodbye!");
        System.exit(0);
      }
      if (e.getSource() == newGame) {
        System.out.println("Setting up the new game");      
      }
      
      if (e.getSource() == help) {
        System.out.println("Showing instructions of the game");
      }
    } 
  }
}