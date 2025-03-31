package gameUI.components;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HandPanel extends JPanel {

    private ArrayList<CardComponent> cardComponents;

    public HandPanel(List<ImageIcon> cardIcons) {
        // Set layout
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        setOpaque(false);

        cardComponents = new ArrayList<>();

        // Create all card components
        for (ImageIcon icon : cardIcons) {
            CardComponent card = new CardComponent(icon);
            cardComponents.add(card);
            add(card);
        }
    }

    // Get selected cards
    public List<CardComponent> getSelectedCards() {
        List<CardComponent> selected = new ArrayList<>();
        for (CardComponent card : cardComponents) {
            if (card.isSelected()) {
                selected.add(card);
            }
        }
        return selected;
    }

    // Remove cards
    public void removeCards(List<CardComponent> toRemove) {
        for (CardComponent card : toRemove) {
            cardComponents.remove(card);
            remove(card);
        }
        revalidate();
        repaint();
    }
}