/** 
* <h1>CatifyGUI.java</h1>
* <p>
* A GUI that allows one player to play the Catify Game at three different level, with instruction provided.<br>
* Connects with the backend program CatifyGame.java and provides pleasant game playing experience.
* 
* @author Lisa Huang (MAIN AUTHOR) (rhuang2), Huihan Li (hli3) and Tina Zhang (yzhang16)
* @since 12-08-2017
*/
import javax.swing.*;
import java.awt.*;

public class CatifyGUI {

  /**
   * Main method, used to test the program.
   * @param args unused.
   */
  public static void main (String[] args) {
    // creates and shows a frame
    JFrame frame = new JFrame("CatifyGUI");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // assigns the frame with a static size
    frame.setPreferredSize(new Dimension(800,600));
    frame.setMaximumSize(new Dimension(800,600));
    frame.setMinimumSize(new Dimension(800,600));
    
    // creates an instance of CatifyGame
    CatifyGame catify = new CatifyGame();
    
    // a cardHolder panel with CardLayout that allows user to switch between different panels by clicking certain buttons
    JPanel cardHolder = new JPanel();
    cardHolder.setLayout(new CardLayout());
    
    // all panels in this GUI
    MainPanel mainP = new MainPanel(cardHolder);
    GamePanel gameP = new GamePanel(cardHolder, catify);
    SettingPanel settingP = new SettingPanel(cardHolder, catify, gameP);
    ResultPanel resultP = new ResultPanel(cardHolder, catify, gameP);
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