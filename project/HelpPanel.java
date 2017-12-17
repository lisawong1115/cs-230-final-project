/** 
* HelpPanel.java
* 
* @author Lisa Huang (rhuang2), Huihan Li (hli3) and Tina Zhang (yzhang16)
* @since 12-08-2017
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class HelpPanel extends JPanel {
  
  private JPanel parent;
  private JTextPane text;
  private JPanel buttonPanel;
  private JButton home;
  /** Constructor*/
  public HelpPanel(JPanel parent){

    this.parent = parent;
    this.setLayout(new BorderLayout());
    this.setBorder(BorderFactory.createEmptyBorder(20,50,20,50));

    buttonPanel = new JPanel();
    home = new JButton("Home");
    home.setPreferredSize(new Dimension(120, 60));
    home.setFont(new Font("Arial", Font.PLAIN, 18));
    home.addActionListener(new Switcher("Main Panel", this.parent));
    buttonPanel.add(home);
        
    text = new JTextPane();
    text.setContentType("text/html");
    text.setText("<html><body bgcolor=\"#eeeeee\"><div align=\"center\"><h1>Instructions</h1></div>" +
        "<font size=5><p><b>Catify</b> is a memory game where you will see a grid of cat pictures, all faced down, and " + 
        "try to find all the pairs of identical pictures within the least possible clicks.<br><br>" +
        "The game contains three levels of difficulty: EASY (8-pairs), MEDIUM (18-pairs), and HARD (32-pairs). <br><br>" +
        "At the start of the game, you have 3 seconds to memorize the location of all the pairs. Then the pictures " +
        "will turn around. When you click on two pictures, they must form a pair to stay faced up. Otherwise, the pictures turn around again. <br><br>" +
        "Your total attempts and valid attempts (those find pairs) are tracked. When all the pairs are found, you win the game!<br><br>" +
        "If you want to play another game within the same level of difficulty, simply press <b>Restart</b>. The <b>Home</b> button will guide you " +
        "back to the home screen. Also, please feel free to restart the game or go back to the home screen in the middle of a game " + 
        "if you find it too challenging. <br><br>Enjoy!</p></font></body>");


    this.add(text, BorderLayout.NORTH);
    this.add(buttonPanel);
  }
}