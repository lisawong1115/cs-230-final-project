/** 
* MainPanel.java
* 
* @author Lisa Huang (rhuang2), Huihan Li (hli3) and Tina Zhang (yzhang16)
* @since 12-08-2017
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class MainPanel extends JPanel {
  
  /*Intro panel that displays introduction about 
 * the Grad School GUI function
 */
  
  /** Constructor*/
  public MainPanel(){
    
    setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
    this.setBackground (Color.green);
    
    //creates labels to display messages
    JLabel l1 = new JLabel ("Catify ");
    JLabel l2 = new JLabel ("The next killer app designed by LHT INC.");
    JButton b1 = new JButton ("New Game");
    JButton b2 = new JButton ("?Help");
    JButton b3 = new JButton ("Quit");
   
    //adding all labels to the panel
    this.add (l1);
    this.add (l2);
    this.add (b1);
    this.add (b2);
    this.add (b3);
  }
}
