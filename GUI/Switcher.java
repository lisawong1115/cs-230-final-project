import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Switcher implements ActionListener {

    private JPanel cardHolder;
    private CardLayout cards;
    private String card;

    public Switcher (String card, Container holder) {

        this.card = card;
        cardHolder = (JPanel)holder;
        cards = (CardLayout)cardHolder.getLayout();
    }

    public void actionPerformed(ActionEvent e) {
        cards.show(cardHolder, card);
    }
}