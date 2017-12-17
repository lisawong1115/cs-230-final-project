/** 
* CatifyGUI.java
* 
* @author Lisa Huang (rhuang2), Huihan Li (hli3) and Tina Zhang (yzhang16)
* @since 12-08-2017
*/
import javax.swing.*;
import java.awt.*;

public class CatifyGUI {

  public static void main (String[] args) {
    JFrame frame = new JFrame("CatifyGUI");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setPreferredSize(new Dimension(800,600));
    frame.setMaximumSize(new Dimension(800,600));
    frame.setMinimumSize(new Dimension(800,600));
    
    CatifyGame catify = new CatifyGame();
    
    JPanel cardHolder = new JPanel();
    cardHolder.setLayout(new CardLayout());

    MainPanel mainP = new MainPanel(cardHolder);
    
    GamePanel gameP = new GamePanel(cardHolder, catify);
    SettingPanel settingP = new SettingPanel(cardHolder, catify, gameP);
    ResultPanel resultP = new ResultPanel(cardHolder, catify);
    HelpPanel helpP = new HelpPanel(cardHolder);
    
    cardHolder.add(mainP, "Main Panel");
    cardHolder.add(settingP, "Setting Panel");
    cardHolder.add(gameP, "Game Panel");
    cardHolder.add(resultP, "Result Panel");
    cardHolder.add(helpP, "Help Panel");

    frame.getContentPane().add(cardHolder);
    
    frame.pack();
    frame.setVisible(true);
  }
}