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
  	private JButton newGame;
  	private JButton help;
  	private JButton quit;
  	
	  /*Intro panel that displays introduction about 
	 * the Grad School GUI function
	 */

	public MainPanel () {

		l1 = new JLabel ("Catify ");
		l2 = new JLabel ("The next killer app designed by LHT INC.");
		newGame = new JButton ("New Game");
		help = new JButton ("? Help");
		quit = new JButton ("Quit");


		l1.setAlignmentX(Component.CENTER_ALIGNMENT);
	  	this.add(l1);

	  	l2.setAlignmentX(Component.CENTER_ALIGNMENT);
	  	this.add(l2);

	  	JPanel buttonsPanel = ButtonsPanel();

	  	this.add(buttonsPanel);

	  	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	}
  
  	public JPanel ButtonsPanel(){
	
		JPanel result = new JPanel();

		newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		result.add(newGame);

		help.setAlignmentX(Component.CENTER_ALIGNMENT);
		result.add(help);

		quit.setAlignmentX(Component.CENTER_ALIGNMENT);
		result.add(quit);

		result.setLayout(new BoxLayout(result, BoxLayout.Y_AXIS));

		return result;
  
}

}