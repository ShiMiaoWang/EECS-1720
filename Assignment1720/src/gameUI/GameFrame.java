package gameUI;

import gameUI.components.HandPanel;
import gameUI.components.InfoPanel;
import gameUI.components.CardComponent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameFrame extends JFrame {

    private InfoPanel infoPanel;
    private HandPanel handPanel;
    private JPanel playAreaPanel;

    public GameFrame() {
        setTitle("Super Madiao - Game On");
        setSize(1152, 864);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(34, 45, 65));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // === 1~3 顶部 InfoPanel ===
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        infoPanel = new InfoPanel();
        mainPanel.add(infoPanel, gbc);
        gbc.gridwidth = 1;

        // === 4 HandPanel（玩家手牌） ===
        gbc.gridx = 0;
        gbc.gridy = 1;
        List<ImageIcon> sampleCards = loadSampleHand();
        handPanel = new HandPanel(sampleCards);
        JScrollPane handScrollPane = new JScrollPane(handPanel);
        handScrollPane.setPreferredSize(new Dimension(300, 120));
        handScrollPane.setOpaque(false);
        handScrollPane.getViewport().setOpaque(false);
        handScrollPane.setBorder(null);
        mainPanel.add(handScrollPane, gbc);

        // === 5 Play Area ===
        gbc.gridx = 1;
        playAreaPanel = new JPanel(new FlowLayout());
        playAreaPanel.setPreferredSize(new Dimension(250, 100));
        playAreaPanel.setBackground(new Color(55, 66, 88));
        mainPanel.add(playAreaPanel, gbc);

        // === 6 Deck ===
        gbc.gridx = 2;
        mainPanel.add(createPlaceholderPanel("Deck"), gbc);

        // === 7 Declare ===
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        mainPanel.add(createPlaceholderPanel("Declare Area"), gbc);
        gbc.gridwidth = 1;

        // === 8 Challenge Button ===
        gbc.gridx = 2;
        JButton challengeBtn = new JButton("Challenge");
        mainPanel.add(challengeBtn, gbc);

        // === 临时出牌按钮：测试用 ===
        gbc.gridy = 3;
        gbc.gridx = 1;
        JButton playBtn = new JButton("Play Selected");
        playBtn.addActionListener(e -> {
            List<CardComponent> selected = handPanel.getSelectedCards();
            for (CardComponent card : selected) {
                playAreaPanel.add(new JLabel(card.getIcon()));
            }
            handPanel.removeCards(selected);
            playAreaPanel.revalidate();
            playAreaPanel.repaint();
        });
        mainPanel.add(playBtn, gbc);

        setContentPane(mainPanel);
        setVisible(true);
    }

    private List<ImageIcon> loadSampleHand() {
        List<ImageIcon> hand = new ArrayList<>();
        String[] cardNames = {"chalices", "coins", "swords", "wands"};
        for (int i = 0; i < 8; i++) {
            String name = cardNames[i % cardNames.length];
            hand.add(new ImageIcon(getClass().getResource("/icons/cards/" + name + ".png")));
        }
        return hand;
    }

    private JPanel createPlaceholderPanel(String text) {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(250, 100));
        panel.setBackground(new Color(55, 66, 88));
        JLabel label = new JLabel(text);
        label.setForeground(Color.WHITE);
        panel.add(label);
        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameFrame::new);
    }
}