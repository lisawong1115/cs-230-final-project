/** 
 * <h1>Switcher.java</h1>
 * 
 * <p>
 * An ActionListener that switch between panels in the parent panel (the cardHolder) with a CardLayout when an event
 * is invoked.
 * 
 * @author Lisa Huang (MAIN AUTHOR) (rhuang2), Huihan Li (hli3) and Tina Zhang (yzhang16)
 * @since 12-16-2017
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Switcher implements ActionListener {
  
  // instance variables
  private JPanel cardHolder;
  private CardLayout cards;
  private String card;
  
  public Switcher (String card, JPanel holder) {
    this.card = card;
    cardHolder = holder;
    cards = (CardLayout)cardHolder.getLayout();
  }
  
  public void actionPerformed(ActionEvent e) {
    // shows a certain card in the cardHolder
    cards.show(cardHolder, card);
  }
}