/** 
* ParentPanel.java
* 
* @author Lisa Huang (rhuang2), Huihan Li (hli3) and Tina Zhang (yzhang16)
* @since 12-14-2017
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ParentPanel extends JPanel{

	// instance variables
	private JPanel mainPanel;
	private JPanel settingPanel;
	private JPanel gamePanel;
	private JPanel resultPanel;
	private JPanel helpPanel;

	public ParentPanel () {
		mainPanel = new MainPanel();
		settingPanel = new SettingPanel();
		gamePanel = new GamePanel();
		resultPanel = new ResultPanel();
		helpPanel = new HelpPanel();
		
		this.setLayout(new CardLayout());

		this.add(mainPanel, "Main Panel");
		this.add(settingPanel, "Setting Panel");
		this.add(gamePanel, "Game Panel");
		this.add(resultPanel, "Result Panel");
		this.add(helpPanel, "Help Panel");



	}
}