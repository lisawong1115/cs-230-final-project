/** 
* CatifyGUI.java
* 
* @author Lisa Huang (rhuang2), Huihan Li (hli3) and Tina Zhang (yzhang16)
* @since 12-08-2017
*/
import javax.swing.*;

public class CatifyGUI {

  public static void main (String[] args) {
    // creates and shows a Frame 
    JFrame frame = new JFrame("CATify");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    SettingPanel setting = new SettingPanel();
    frame.getContentPane().add(setting);
    
    frame.pack();
    frame.setVisible(true);

  }
}