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
import javax.swing.Timer;
import java.util.LinkedList;

public class GamePanel extends JPanel {
  // instance variables
  private JButton start;
  //private JButton restart;
  private JButton home;
  private JLabel info;
  private JLabel attempt;
  private JLabel pairsFound;
  private JPanel gridPanel;
  private JPanel parent;
  private CatifyGame catify;
  private OneLayeredPane[][] grids;
  private int size;
  private LinkedList<LinkedList<Integer>> clicks;
  
  
  public GamePanel (JPanel parent, CatifyGame game) {
    this.catify = game;
    this.parent = parent;
    this.clicks = new LinkedList<LinkedList<Integer>>();
    
    this.setLayout(new FlowLayout(0, 25, 0));
    this.setBorder(BorderFactory.createEmptyBorder(0,25,25,25));
    
    JPanel infoPanel = infoPanel();
    gridPanel = gridPanel();
    //gridPanel.setBackground(Color.green);
    
    this.add(gridPanel);
    this.add(infoPanel);    
    
  }
  
  
  /*
   * ==========================infoPanel()================================
   * */
  
  private JPanel infoPanel() {
    JPanel result = new JPanel();
    result.setPreferredSize(new Dimension(200,550));
    start = new JButton("Start");
    start.setAlignmentX(Component.CENTER_ALIGNMENT);
    //restart = new JButton("Restart");
    //restart.setAlignmentX(Component.CENTER_ALIGNMENT);
    home = new JButton("Home");
    home.setAlignmentX(Component.CENTER_ALIGNMENT);
    info = new JLabel("Find all the pairs!");
    info.setAlignmentX(Component.CENTER_ALIGNMENT);
    attempt = new JLabel("Attempts made: 0");
    attempt.setAlignmentX(Component.CENTER_ALIGNMENT);
    pairsFound = new JLabel("Pairs found: 0");
    pairsFound.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    start.addActionListener(new ButtonListener());
    home.addActionListener(new Switcher("Main Panel", this.parent));
    // FOR TESTING PURPOSE
    //restart.addActionListener(new ButtonListener());
    
    result.add(Box.createVerticalStrut(100));
    result.add(start);
    result.add(Box.createVerticalStrut(20));
    //result.add(restart);
    //result.add(Box.createVerticalStrut(20));
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
  
  /*
   * ===========================gridPanel()==========================
   * */
  
  private JPanel gridPanel(){
    JPanel result = new JPanel();
    result.setPreferredSize(new Dimension(475,475));
    return result;
  }
  
  public JPanel getGridPanel(){
    return gridPanel;
  }
  
  
  public void setBoard(int numOfPics){
    gridPanel.removeAll();
    size = (int)Math.sqrt(numOfPics*2);
    gridPanel.setLayout(new GridLayout(size, size));
    grids = new OneLayeredPane[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++){
        grids[i][j] = new OneLayeredPane(i,j,size);
        gridPanel.add(grids[i][j]);
      }
    }
    start.setText("Start");
    attempt.setText("Attempts made: 0");
    pairsFound.setText("Pairs found: 0");
  }

  
  /*
   * ===========================OneLayeredPane=================================
   * */
  
  private class OneLayeredPane extends JLayeredPane{
    private int x, y, size;
    private JLabel image;
    private JButton button;
    
    
    public OneLayeredPane(int x, int y, int size){
      super();
      this.x = x;
      this.y = y;
      this.size = size;
      
      
      this.setBounds((475/size)*y,(475/size)*x,475/size,475/size);
      this.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
      this.setVisible(true);
      this.setOpaque(true);
      this.setLayout(null);
      
      ImageIcon rawImage = new ImageIcon(new ImageIcon(catify.getBoard().getElement(x,y).getFileName()).getImage()
                                           .getScaledInstance(475/size, 475/size, Image.SCALE_DEFAULT));
      image = new JLabel(rawImage);
      image.setOpaque(true);
      image.setBounds(0, 0, 475/size, 475/size);
      
      
      button = new JButton();
      button.setPreferredSize(new Dimension(475/size, 475/size));
      button.setBackground(new Color(254, 238, 206));
      button.setBorder(new MatteBorder(1, 1, 1, 1, new Color(253, 166, 122)));
      button.setBounds(0, 0, 475/size,475/size);
      button.setOpaque(true);
      button.addActionListener(new ButtonListener());
      
      
      this.add(image, new Integer(2));
      //result.setLayer(image,new Integer(0));
      //System.out.println("Image layer: " + result.getLayer(image));
      this.add(button,new Integer(1));
      // result.setLayer(button,new Integer(1));
      //System.out.println("Button Layer: "+ result.getLayer(button));
    }
    
    public JLabel getImage(){
      return image; 
    }
    
    public JButton getButton(){
      return button; 
    }

    
    public void flip(int layer){
      this.setLayer(image, new Integer(layer));
    }
    
  }
  
  /*
   * ====================Listeners==========================
   * */
  
  private class ButtonListener implements ActionListener {
    
    /* 
     * Invoked when an action occurs.
     * @param event The ActionEvent
     */
    public void actionPerformed (ActionEvent event) {

      JButton source = (JButton) event.getSource();
      if (source == start) {

        if (start.getText().equals("Start")) {
          //Thread thread = new Thread();
            System.out.println("Waiting...");
            //thread.sleep(3000);
            for (int i = 0; i < size; i++) {
              for (int j = 0; j < size; j++){
                grids[i][j].flip(0);
              }
            }
            start.setText("Restart");
          }

        else if (start.getText().equals("Restart")) {
          System.out.println("I'm in restart");
          catify.setGame(size*size/2);
          //start.setText("Start");
          setBoard(size*size/2);
        }
      }

      else {
        OneLayeredPane container = (OneLayeredPane) source.getParent();
        container.setLayer(container.getImage(), new Integer(2)); 
        
        for (int i = 0; i < size; i++){
          for (int j = 0; j < size; j++){
            if (event.getSource() == grids[i][j].getButton()){
              //grids[i][j].setLayer(grids[i][j].getImage(), new Integer(2)); 
              grids[i][j].flip(2);
              System.out.println("Flipping!");
              System.out.println("x: " + i);
              System.out.println("y: " + j);
              
              LinkedList<Integer> oneClick = new LinkedList<Integer>();
              oneClick.add(new Integer(i));
              oneClick.add(new Integer(j));
              clicks.add(oneClick);

              catify.takeOneClick(i,j);
              System.out.println("Now total clicks: " + catify.getClick());

              //Thread thread = new Thread();
            }
          }
        }
              
        if (catify.getClick() == 2){
          boolean foundOnePair = catify.findOnePair();
          System.out.println("line 245");
          if (foundOnePair){
            pairsFound.setText("Pairs found: " + catify.getPairsFound());
            System.out.println("Line 248");
          }
          else {
            int x1 = clicks.get(0).get(0);
            int y1 = clicks.get(0).get(1);
            int x2 = clicks.get(1).get(0);
            int y2 = clicks.get(1).get(1);

            Timer flipTimer = new Timer(1000, new Flipper(grids[x1][y1], grids[x2][y2]));
            flipTimer.setRepeats(false);
            flipTimer.restart();

           }
          clicks.clear();
          catify.clearChoices();
          attempt.setText("Attempts made: " + catify.getAttempts());
        }
       
       if (catify.isFinish()) {
        Timer stayTimer = new Timer(1500, new StayAndSwitch());
        stayTimer.setRepeats(false);
        stayTimer.restart();
       }       
    } 
        
  }
}

private class Flipper implements ActionListener {

  private OneLayeredPane pane1, pane2;

  public Flipper (OneLayeredPane p1, OneLayeredPane p2) {
    super();
    pane1 = p1;
    pane2 = p2;
  }

    public void actionPerformed(ActionEvent e) {
        pane1.flip(0);
        pane2.flip(0);
    }
}

private class StayAndSwitch implements ActionListener {

  public void actionPerformed(ActionEvent e) {
    CardLayout cards = (CardLayout)parent.getLayout();
    cards.show(parent, "Result Panel");
  }
}
    
    /*private class TimeListener implements */
}


