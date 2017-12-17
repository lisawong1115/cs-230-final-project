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
  private JPanel gridPanel;
  private JPanel parent;
  private CatifyGame catify;
  
  
  public GamePanel (JPanel parent, CatifyGame game) {
    this.catify = game;
    this.parent = parent;
    
    this.setLayout(new FlowLayout(0, 25, 0));
    this.setBorder(BorderFactory.createEmptyBorder(0,25,25,25));
    
    JPanel infoPanel = infoPanel();
    gridPanel = gridPanel();
    
    this.add(gridPanel);
    this.add(infoPanel);
    
    
    
  }
  
  private JPanel infoPanel() {
    JPanel result = new JPanel();
    result.setPreferredSize(new Dimension(200,550));
    restart = new JButton("Restart");
    restart.setAlignmentX(Component.CENTER_ALIGNMENT);
    home = new JButton("Home");
    home.setAlignmentX(Component.CENTER_ALIGNMENT);
    info = new JLabel("Find all the pairs!");
    info.setAlignmentX(Component.CENTER_ALIGNMENT);
    attempt = new JLabel("Attempts made: 0");
    attempt.setAlignmentX(Component.CENTER_ALIGNMENT);
    pairsFound = new JLabel("Pairs found: 0");
    pairsFound.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    home.addActionListener(new Switcher("Main Panel", this.parent));
    // FOR TESTING PURPOSE
    restart.addActionListener(new Switcher("Result Panel", this.parent));
    
    result.add(Box.createVerticalStrut(100));
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
  
  private JPanel gridPanel(){
    JPanel result = new JPanel();
    result.setPreferredSize(new Dimension(475,475));
    return result;
  }
  
  public JPanel getGridPanel(){
    return gridPanel;
  }
    
    public static void setBoard(int numOfPics, JPanel panel){

    int size = (int)Math.sqrt(numOfPics*2);
    panel.setLayout(new GridLayout(size, size));
    JButton[][] buttons = new JButton[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++){
        buttons[i][j] = new JButton();
        buttons[i][j].setPreferredSize(new Dimension(475/size, 475/size));
        buttons[i][j].setBackground(new Color(254, 238, 206));
        buttons[i][j].setBorder(new MatteBorder(1, 1, 1, 1, new Color(253, 166, 122)));
        buttons[i][j].setOpaque(true);
        panel.add(buttons[i][j]);
      }
    }
    }
    
  }
  
  
