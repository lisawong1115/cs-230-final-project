/** 
* GamePanel.java
* 
* @author Lisa Huang (rhuang2), Huihan Li (hli3) and Tina Zhang (yzhang16)
* @since 12-08-2017
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;

public class GamePanel extends JPanel {
	// instance variables
	private JButton restart;
	private JButton home;
	private JLabel info;
	private JLabel attempt;
	private JLabel pairsFound;

	private String name;

	public GamePanel () {
		name = "Game Panel";

		this.setLayout(new FlowLayout(0, 60, 0));
		this.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));

		JPanel infoPanel = infoPanel();
		JPanel gamePanel = gamePanel();

		this.add(gamePanel);
		this.add(infoPanel);



	}

	private JPanel infoPanel() {
		JPanel result = new JPanel();
		
		restart = new JButton("Restart");
		home = new JButton("Home");
		info = new JLabel("Find all the pairs!");
		attempt = new JLabel("Attempts made: 0");
		pairsFound = new JLabel("Pairs found: 0");

		result.add(restart);
		result.add(Box.createVerticalStrut(20));
		result.add(home);

		result.add(Box.createVerticalStrut(20));
		result.add(info);

		result.add(Box.createVerticalStrut(20));
		result.add(attempt);

		result.add(Box.createVerticalStrut(20));
		result.add(pairsFound);

		result.setLayout(new BoxLayout(result, BoxLayout.Y_AXIS));



		return result;
	}

	private JPanel gamePanel() {
		JPanel result = new JPanel();

		// THIS IS HARD CODE
		result.setLayout(new GridLayout(4, 4));
		JButton[] buttons = new JButton[16];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setPreferredSize(new Dimension(100, 100));
			buttons[i].setBackground(new Color(254, 238, 206));
			buttons[i].setBorder(new MatteBorder(1, 1, 1, 1, new Color(253, 166, 122)));
			buttons[i].setOpaque(true);
			result.add(buttons[i]);
		}

		return result;

	}

	public String getName() {

		return this.name;
	}
}