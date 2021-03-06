/** 
 * <h1>ResutltPanel.java</h1>
 * 
 * <p>
 * Displays information that congratulates the user on winning the game, and provides the user with options to play 
 * again, to return to the home screen and to quit the game.
 * 
 * @author Lisa Huang (MAIN AUTHOR) (rhuang2), Huihan Li (MAIN AUTHOR) (hli3) and Tina Zhang (yzhang16)
 * @since 12-08-2017
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ResultPanel extends JPanel {
  
  // instance variables
  private JLabel l1;
  private JLabel l2;
  private JButton restart;
  private JButton home;
  private JButton quit;
  private JPanel parent;
  private CatifyGame catify;
  private GamePanel gp;
  
  /** 
   * Constructor
   * Needs these parameter to establish connections between the ResultPanel and other panels
   * @param parent the parent panel (cardHolder/container) of this panel
   * @param game the CatifyGame instance
   * @param gp the Game Panel in the GUI
   */
  public ResultPanel (JPanel parent, CatifyGame game, GamePanel gp) {
    this.catify = game;
    this.parent = parent;
    this.gp = gp;
    
    l1 = new JLabel("Congratulations!");
    l2 = new JLabel("You found all pairs!");
    
    l1.setAlignmentX(Component.CENTER_ALIGNMENT);
    l1.setFont(new Font("Chalkduster", Font.PLAIN, 60));
    this.add(l1);
    
    this.add(Box.createVerticalStrut(20));
    
    l2.setAlignmentX(Component.CENTER_ALIGNMENT);
    l2.setFont(new Font("Chalkduster", Font.PLAIN, 40));
    this.add(l2);
    
    this.add(Box.createVerticalStrut(150));
    
    // a JPanel that contains merely buttons
    JPanel buttonsPanel = ButtonsPanel();
    
    this.add(buttonsPanel);
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
    
    
  }
  
  /**
   * Creates a JPanel with three buttons
   * @return the created JPanel with three buttons
   */
  private JPanel ButtonsPanel () {
    JPanel result = new JPanel();
    
    restart = new JButton("Restart");
    // the restart and home buttons need two listeners, respectively, to not only restart the game but also switch 
    // to a different panel outside of this panel
    restart.addActionListener(new ButtonListener());
    restart.addActionListener(new Switcher("Game Panel", this.parent));
    home = new JButton("Home");
    home.addActionListener(new Switcher("Main Panel", this.parent));
    home.addActionListener(new ButtonListener());
    // the quit button only needs one ButtonListener because it only performs one action - quit
    quit = new JButton("Quit");
    quit.addActionListener(new ButtonListener());
    
    restart.setAlignmentX(Component.CENTER_ALIGNMENT);
    restart.setPreferredSize(new Dimension(200, 100));
    restart.setFont(new Font("Arial", Font.PLAIN, 24));
    result.add(restart);
    
    home.setAlignmentX(Component.CENTER_ALIGNMENT);
    home.setPreferredSize(new Dimension(200, 100));
    home.setFont(new Font("Arial", Font.PLAIN, 24));
    result.add(home);
    
    quit.setAlignmentX(Component.CENTER_ALIGNMENT);
    quit.setPreferredSize(new Dimension(200, 100));
    quit.setFont(new Font("Arial", Font.PLAIN, 24));
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
      if (e.getSource() == restart) {
        // restarts the game in the back end
        catify.setGame(catify.getNumPics());
        // restarts the game in the front end (the Game Panel)
        gp.setBoard(catify.getNumPics());
        System.out.println("Restart a new game");       
      }
      
      if (e.getSource() == home) {
        System.out.println("Going back to main panel");
      }
    }
  }
}