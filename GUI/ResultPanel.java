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

		JPanel buttonsPanel = ButtonsPanel();

		add(buttonsPanel);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	}

	public JPanel ButtonsPanel () {
		JPanel result = new JPanel();

		restart.setAlignmentX(Component.CENTER_ALIGNMENT);
		result.add(restart);

		home.setAlignmentX(Component.CENTER_ALIGNMENT);
		result.add(home);

		quit.setAlignmentX(Component.CENTER_ALIGNMENT);
		result.add(quit);

		result.setLayout(new BoxLayout(result, BoxLayout.Y_AXIS));

		return result;
	}
}