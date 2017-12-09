/** 
* CatifyGUI.java
* 
* @author Lisa Huang (rhuang2), Huihan Li (hli3) and Tina Zhang (yzhang16)
* @since 12-08-2017
*/
import javax.swing.*;

public class CatifyGUI {

  public static void main (String[] args) {
    JFrame frame = new JFrame("CatifyGUI");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    //Create tab panels
    JTabbedPane tp = new JTabbedPane();
    tp.addTab("Main", new MainPanel());
    tp.addTab("Setting", new SettingPanel());
    tp.addTab("Game", new GamePanel());
    tp.addTab("Result", new ResultPanel());
    tp.addTab("Help", new HelpPanel());
    
    //adds the whole panel to the frame
    frame.getContentPane().add(tp);
    
    frame.pack();
    frame.setVisible(true);
  }
}