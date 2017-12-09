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
  
  /** Constructor*/
  public HelpPanel(){
    
    setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    //this.setBackground (Color.green);
    
    //creates labels to display messages
    JLabel l1 = new JLabel ("?Help");
    JLabel l2 = new JLabel ("There are three levels: 8-pairs, 18-pairs, and 32-pairs to delete.");
    JLabel l3 = new JLabel ("At the start of the game, you have 3 seconds to memorize the location of the pairs."); 
    JLabel l4 = new JLabel ("Afterwards, the pictures will turn around.");
    JLabel l5 = new JLabel ("When you click on two pictures, they must form a pair to disappear. Otherwise, the pictures remain.");
    JLabel l6 = new JLabel ("There is also a counter that keeps track of how many tries the you made and how many pairs you have deleted.");
    JLabel l7 = new JLabel ("When all pairs are deleted, you win the game!."); 
    JLabel l8 = new JLabel ("If you want to play another game, please press Restart.");

   
    //adding all labels to the panel
    this.add (l1);
    this.add (l2);
    this.add (l3);
    this.add (l4);
    this.add (l5);
    this.add (l6);
    this.add (l7);
    this.add (l8);
  }
}