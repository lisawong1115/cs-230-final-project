/** 
 * SettingPanel.java
 * 
 * @author Lisa Huang (rhuang2), Huihan Li (hli3) and Tina Zhang (yzhang16)
 * @since 12-08-2017
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SettingPanel extends JPanel {
  //instance vars
  private JButton easyButton,mediumButton,hardButton;
  
  public SettingPanel(){
    this.setLayout(new BorderLayout());
    
    this.add(ButtonPanel(),BorderLayout.CENTER);
  }
  
  private JPanel ButtonPanel(){
    JPanel buttons = new JPanel();
    
    easyButton = new JButton("EASY");
    easyButton.addActionListener (new ButtonListener());
    mediumButton = new JButton("MEDIUM");
    mediumButton.addActionListener (new ButtonListener());
    hardButton = new JButton("HARD");
    hardButton.addActionListener (new ButtonListener());
    
    buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
    
    easyButton.setAlignmentX(buttons.CENTER_ALIGNMENT);

    mediumButton.setAlignmentX(buttons.CENTER_ALIGNMENT);

    hardButton.setAlignmentX(buttons.CENTER_ALIGNMENT);
    
    buttons.add(Box.createRigidArea(new Dimension(0,300)));
    buttons.add(easyButton);
    buttons.add(Box.createRigidArea(new Dimension(0,100)));
    
    buttons.add(mediumButton);
    buttons.add(Box.createRigidArea(new Dimension(0,100)));
    
    buttons.add(hardButton);
    buttons.add(Box.createRigidArea(new Dimension(0,100)));
    
    return buttons;
  }
  
  private class ButtonListener implements ActionListener {
    
    /* 
     * Invoked when an action occurs.
     * @param event The ActionEvent
     */
    public void actionPerformed (ActionEvent event) {
      if (event.getSource() == easyButton){
        easyButton.setBackground(Color.green);
      }
      if (event.getSource() == mediumButton){
        mediumButton.setBackground(Color.yellow);
      }
      if (event.getSource() == hardButton){
        hardButton.setBackground(Color.red);
      }
    }
    
  }
}