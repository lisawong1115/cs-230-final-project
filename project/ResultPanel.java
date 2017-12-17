/** 
 * ResutltPanel.java
 * 
 * @author Lisa Huang (rhuang2), Huihan Li (hli3) and Tina Zhang (yzhang16)
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
    
    public ResultPanel (JPanel parent, CatifyGame game) {
    this.catify = game;
    this.parent = parent;
    
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
    
    JPanel buttonsPanel = ButtonsPanel();
    
    this.add(buttonsPanel);
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
    
    
  }
  
  public JPanel ButtonsPanel () {
    JPanel result = new JPanel();
    
    restart = new JButton("Restart");
    restart.addActionListener(new Switcher("Game Panel", this.parent));
    restart.addActionListener(new ButtonListener());
    home = new JButton("Home");
    home.addActionListener(new Switcher("Main Panel", this.parent));
    home.addActionListener(new ButtonListener());
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
  
  private class ButtonListener implements ActionListener {
    
    public void actionPerformed (ActionEvent e) {
      if (e.getSource() == quit) {
        System.out.println("Goodbye!");
        System.exit(0);
      }
      if (e.getSource() == restart) {
        catify.setGame(catify.getNumPics());
        System.out.println("Restart a new game");       
      }
      
      if (e.getSource() == home) {
        System.out.println("Going back to main panel");
      }
      
      
    }
    
    
  }
}