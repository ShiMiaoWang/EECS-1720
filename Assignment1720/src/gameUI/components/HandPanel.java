package gameUI.components;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HandPanel extends JPanel {

    private final List<CardComponent> cardComponents;

    public HandPanel(List<ImageIcon> cardIcons) {
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        setOpaque(false);

        cardComponents = new java.util.ArrayList<>();

        for (ImageIcon icon : cardIcons) {
            CardComponent card = new CardComponent(icon);
            cardComponents.add(card);
            add(card);
        }
    }

    public List<CardComponent> getSelectedCards() {
        List<CardComponent> selected = new java.util.ArrayList<>();
        for (CardComponent card : cardComponents) {
            if (card.isSelected()) {
                selected.add(card);
            }
        }
        return selected;
    }

    public void removeCards(List<CardComponent> toRemove) {
        for (CardComponent card : toRemove) {
            remove(card);
        }
        cardComponents.removeAll(toRemove);
        revalidate();
        repaint();
    }
}
