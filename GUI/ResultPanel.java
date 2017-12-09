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
	private JTextArea textArea;
	private JButton restart;
	private JButton home;
	private JButton quit;

	public ResultPanel () {
		textArea = new JTextArea();
		String text = "Congratulations!\nYou found all pairs!";
		textArea.setText(text);
		add(textArea);

		restart = new JButton("Restart");
		home = new JButton("Home");
		quit = new JButton("Quit");

		add(restart);
		add(home);
		add(quit);

	}
}