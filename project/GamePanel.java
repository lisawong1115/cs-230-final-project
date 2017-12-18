/** 
 * GamePanel.java
 * The JPanel where the catify game takes place
 * BUG REPORT: If a button whose picture is revealed is clicked on again, the program will find a wrong pair.<br>
 * This bug only exists when playing the game with GUI. Only playing on backend is fine. (Details see line 273)
 * 
 * @author Lisa Huang (rhuang2), Huihan Li (hli3) and Tina Zhang (yzhang16)
 * @since 12-08-2017
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import javax.swing.Timer;
import java.util.LinkedList;

public class GamePanel extends JPanel {
  // instance variables
  private int size;
  // of infoPanel
  private JButton start;
  private JButton home;
  private JLabel info;
  private JLabel attempt;
  private JLabel pairsFound;
  // of gridPanel
  private JPanel gridPanel;
  private JPanel parent;
  private CatifyGame catify;
  private OneLayeredPane[][] grids;
  private LinkedList<LinkedList<Integer>> clicks;
  
  
  
  /*
   * Constructor
   * Constructs a JPanel with infoPanel and gridPanel as subpanels
   * @param JPanel parent - to which panel it belongs
   * @param CatifyGame game
   * */
  public GamePanel (JPanel parent, CatifyGame game) {
    // instantiate variables
    this.catify = game;
    this.parent = parent;
    this.clicks = new LinkedList<LinkedList<Integer>>();
    
    // set layout
    this.setLayout(new FlowLayout(0, 25, 0));
    this.setBorder(BorderFactory.createEmptyBorder(0,25,25,25));
    
    JPanel infoPanel = infoPanel();
    gridPanel = gridPanel();
    
    this.add(gridPanel);
    this.add(infoPanel);    
  }
  
  
  /*
   * Contains start button, home button, and information about attempts made and pairs found
   * @returns JPanel infoPanel
   * */
  private JPanel infoPanel() {
    JPanel result = new JPanel();
    result.setPreferredSize(new Dimension(200,550));
    
    start = new JButton("Start");
    start.setAlignmentX(Component.CENTER_ALIGNMENT);
    start.addActionListener(new ButtonListener());
    
    home = new JButton("Home");
    home.setAlignmentX(Component.CENTER_ALIGNMENT);
    home.addActionListener(new Switcher("Main Panel", this.parent));
    
    info = new JLabel("Find all the pairs!");
    info.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    attempt = new JLabel("Attempts made: 0");
    attempt.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    pairsFound = new JLabel("Pairs found: 0");
    pairsFound.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    // set layout
    result.setLayout(new BoxLayout(result, BoxLayout.Y_AXIS));
    result.add(Box.createVerticalStrut(100));
    result.add(start);
    result.add(Box.createVerticalStrut(20));
    result.add(home);
    result.add(Box.createVerticalStrut(20));
    result.add(info);
    result.add(Box.createVerticalStrut(20));
    result.add(attempt);
    result.add(Box.createVerticalStrut(20));
    result.add(pairsFound);
    
    return result;
  }
  
  /*
   * Initializes an empty JPanel at the start of the program
   * Will add buttons to it when the level is set
   * @returns JPanel gridPanel
   * */
  private JPanel gridPanel(){
    JPanel result = new JPanel();
    result.setPreferredSize(new Dimension(475,475));
    return result;
  }
  
  /*
   * Getter method for the board
   * @returns JPanel gridPanel
   * */
  public JPanel getGridPanel(){
    return gridPanel;
  }
  
  /*
   * Set the board according to the level selected
   * Use GridLayout to hold JLayeredPane's
   * Clear up the board and reset infoPanel before adding JLayeredPane's
   * @param int numOfPics - how many pairs of pictures in one game
   * */
  public void setBoard(int numOfPics){
    // first clear the panel
    gridPanel.removeAll();
    
    // calculate the side of grid matrix
    size = (int)Math.sqrt(numOfPics*2);
    gridPanel.setLayout(new GridLayout(size, size));
    
    // initialize the matrix of OneLayeredPane
    grids = new OneLayeredPane[size][size];
    
    // initialize each of the OneLayeredPane's
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++){
        grids[i][j] = new OneLayeredPane(i,j,size);
        gridPanel.add(grids[i][j]);
      }
    }
    
    // set informations
    start.setText("Start");
    attempt.setText("Attempts made: 0");
    pairsFound.setText("Pairs found: 0");
  }
  
  
  /*
   * A JLayeredPane that contains a JLabel with ImageIcon and a JButton
   * */
  private class OneLayeredPane extends JLayeredPane{
    // instance variables
    private int x, y, size;
    private JLabel image;
    private JButton button;
    
    /*
     * Constructs a OneLayeredPane at the x row y column of the grids with a side of calculated length
     * @param int x - which row
     * @param int y - which column
     * @param int size - will divide the size of the gridPanel to calculate the side of one OneLayeredPane
     * */
    public OneLayeredPane(int x, int y, int size){
      super();
      this.x = x;
      this.y = y;
      this.size = size;
      
      // set the size and place of the OneLayeredPane
      this.setBounds((475/size)*y,(475/size)*x,475/size,475/size);
      this.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
      this.setVisible(true);
      this.setOpaque(true);
      this.setLayout(null);
      
      // create a JLabel with an ImageIcon
      ImageIcon rawImage = new ImageIcon(new ImageIcon(catify.getBoard().getElement(x,y).getFileName()).getImage()
                                           .getScaledInstance(475/size, 475/size, Image.SCALE_DEFAULT));
      image = new JLabel(rawImage);
      image.setOpaque(true);
      image.setBounds(0, 0, 475/size, 475/size);
      
      // create a JButton with actionListener
      button = new JButton();
      button.setPreferredSize(new Dimension(475/size, 475/size));
      button.setBackground(new Color(254, 238, 206));
      button.setBorder(new MatteBorder(1, 1, 1, 1, new Color(253, 166, 122)));
      button.setBounds(0, 0, 475/size,475/size);
      button.setOpaque(true);
      button.addActionListener(new ButtonListener());
      
      // add image and button to OneLayeredPane
      this.add(image, new Integer(2));
      this.add(button,new Integer(1));
    }
    
    /*
     * @returns the JLabel containing the image
     * */
    public JLabel getImage(){
      return image; 
    }
    
    /*
     * @returns the JButton
     * */
    public JButton getButton(){
      return button; 
    }
    
    /*
     * Set the JLabel to the desired layer
     * @param int layer
     * */
    public void flip(int layer){
      this.setLayer(image, new Integer(layer));
    }
    
  }
  
  /*
   * Assigns actions to each button
   * */
  private class ButtonListener implements ActionListener { 
    /* 
     * Invoked when an action occurs.
     * @param ActionEvent event The ActionEvent
     */
    public void actionPerformed (ActionEvent event) {
      // remember the which button is clicked on
      JButton source = (JButton) event.getSource();
      
      // if Start button is clicked
      if (source == start) {
        
        // Hide the picture if the button says "Start"
        if (start.getText().equals("Start")) {
          // flip all JLabels to lower layer of the layout
          for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++){
              grids[i][j].flip(0);
            }
          }
          start.setText("Restart");
        }
        
        // Reset the board and information if the button says "Restart"
        else if (start.getText().equals("Restart")) {
          catify.setGame(size*size/2);
          setBoard(size*size/2);
        }
      }
      
      // if the buttons of gridPanel are clicked
      else {
        // get OneLayeredPane in which the clicked button is located
        OneLayeredPane container = (OneLayeredPane) source.getParent();
        
        // look for which button is clicked
        for (int i = 0; i < size; i++){
          for (int j = 0; j < size; j++){
            if (event.getSource() == grids[i][j].getButton()){
              // show the image of this button
              grids[i][j].flip(2);
              System.out.println("Clicked on Button (" + i + "," + j + ")");
              
              /**
               * THE FOLLOWING LINES INVOLVE A BUG
               * If the user click on an unrevealed picture as well as a revealed picture (which is really abnormal 
               * as nobody would pair a new picture up with a revealed picture), 
               * only the click on the unrevealed picture will be added to the LinkedList<LinkedList<Integer>> clicks 
               * because we actually click on the “picture” rather than the “button” of the revealed picture. 
               * Therefore, since only one click is tracked, the program will prompt the user to make a second click.
               */
              // Store the ID of the Picture of the clicked Button
              LinkedList<Integer> oneClick = new LinkedList<Integer>();
              oneClick.add(new Integer(i));
              oneClick.add(new Integer(j));
              clicks.add(oneClick);
              
              // Call takeOneClick in CatifyGame
              catify.takeOneClick(i,j);
              System.out.println("You have clicked " + catify.getClick() + " picture(s) so far");
            }
          }
        }
        
        // check if the user found one pair if they made two clickes
        if (catify.getClick() == 2){
          
          boolean foundOnePair = catify.findOnePair();
          if (foundOnePair)
            pairsFound.setText("Pairs found: " + catify.getPairsFound());
          else {
            // retrieve the information of the clicked button
            int x1 = clicks.get(0).get(0);
            int y1 = clicks.get(0).get(1);
            int x2 = clicks.get(1).get(0);
            int y2 = clicks.get(1).get(1);
            
            //wait for one second and hide the image
            Timer flipTimer = new Timer(1000, new Flipper(grids[x1][y1], grids[x2][y2]));
            flipTimer.setRepeats(false);
            flipTimer.restart();
          }
          
          // prepare for a new round
          clicks.clear();
          catify.clearChoices();
          //increment attempts
          attempt.setText("Attempts made: " + catify.getAttempts());
        }
        
        // wait for 1.5 seconds and turn to the ResultPanel if the game is finished
        if (catify.isFinish()) {
          Timer stayTimer = new Timer(1500, new StayAndSwitch());
          stayTimer.setRepeats(false);
          stayTimer.restart();
        }       
      }    
    }
  }
  
  /*
   * Helps hide the images of the two clicked buttons if they are different
   * */
  private class Flipper implements ActionListener {
    
    private OneLayeredPane pane1, pane2;
    /*
     * Constructor
     * @param OneLayeredPane p1
     * @param OneLayeredPane p2
     * */
    public Flipper (OneLayeredPane p1, OneLayeredPane p2) {
      super();
      pane1 = p1;
      pane2 = p2;
    }
    /* 
     * Flip both pictures
     * @param ActionEvent event The ActionEvent
     */
    public void actionPerformed(ActionEvent e) {
      pane1.flip(0);
      pane2.flip(0);
    }
  }
  
  /*
   * Helps switch to ResultPanel after the game has finished
   * */
  private class StayAndSwitch implements ActionListener {
    /* 
     * Invoked when the last pair of images is found.
     * @param ActionEvent event The ActionEvent
     */
    public void actionPerformed(ActionEvent e) {
      CardLayout cards = (CardLayout)parent.getLayout();
      //show the ResultPanel
      cards.show(parent, "Result Panel");
    }
  }
}