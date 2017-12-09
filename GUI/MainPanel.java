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

  	// instance variables
  	private JLabel l1;
  	private JLabel l2;
  	private JLabel img;
  	private JButton newGame;
  	private JButton help;
  	private JButton quit;
  	
	  /*Intro panel that displays introduction about 
	 * the Grad School GUI function
	 */

	public MainPanel () {

		l1 = new JLabel ("Catify ");
		l2 = new JLabel ("The next killer app designed by LHT INC.");
		img = new JLabel (new ImageIcon("../cat_pics/pic3.jpg"));
		newGame = new JButton ("New Game");
		help = new JButton ("? Help");
		quit = new JButton ("Quit");


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

	  	JPanel buttonsPanel = ButtonsPanel();

	  	this.add(buttonsPanel);

	  	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	}
  
<<<<<<< HEAD
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
=======
  	public JPanel ButtonsPanel(){
	
		JPanel result = new JPanel();

		newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		newGame.setPreferredSize(new Dimension(200, 100));
		newGame.setFont(new Font("Arial", Font.PLAIN, 24));
		result.add(newGame);

		help.setAlignmentX(Component.CENTER_ALIGNMENT);
		help.setPreferredSize(new Dimension(200, 100));
		help.setFont(new Font("Arial", Font.PLAIN, 24));
		result.add(help);


		quit.setAlignmentX(Component.CENTER_ALIGNMENT);
		quit.setPreferredSize(new Dimension(200, 100));
		quit.setFont(new Font("Arial", Font.PLAIN, 24));
		result.add(quit);

		//result.setLayout(new BoxLayout(result, BoxLayout.Y_AXIS));
		result.setLayout(new FlowLayout());

		return result;
  
>>>>>>> GUI_Lisa
}
