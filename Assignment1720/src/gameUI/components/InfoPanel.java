package gameUI.components;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {
    private JLabel roundLabel;
    private JLabel playerLabel;
    private JLabel cardCountLabel;

    public InfoPanel() {
        setLayout(new GridLayout(1, 3, 20, 0)); // 横向3列布局，带间距
        setOpaque(false); // 背景透明

        roundLabel = createLabel("Round: 1");
        playerLabel = createLabel("Player: Wesley");
        cardCountLabel = createLabel("Cards Left: 13");

        add(roundLabel);
        add(playerLabel);
        add(cardCountLabel);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        return label;
    }

    // --- 提供更新方法，便于外部调用 ---
    public void setRound(int round) {
        roundLabel.setText("Round: " + round);
    }

    public void setPlayerName(String name) {
        playerLabel.setText("Player: " + name);
    }

    public void setCardCount(int count) {
        cardCountLabel.setText("Cards Left: " + count);
    }
}
