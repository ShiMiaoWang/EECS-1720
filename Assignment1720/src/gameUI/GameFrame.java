package gameUI;

import gameUI.components.HandPanel;
import gameUI.components.InfoPanel;
import gameUI.components.CardComponent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameFrame extends JFrame {

    private InfoPanel infoPanel;         // Information panel
    private HandPanel handPanel;         // Hand panel
    private JPanel playAreaPanel;        // Play area

    public GameFrame() {
        // Set window properties
        setTitle("SuperMadiao!");
        setSize(1152, 864);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create main panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(34, 45, 65));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // === Top information panel ===
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        infoPanel = new InfoPanel();
        mainPanel.add(infoPanel, gbc);
        gbc.gridwidth = 1;

        // === Player hand area ===
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

        // === Play area ===
        gbc.gridx = 1;
        playAreaPanel = new JPanel(new FlowLayout());
        playAreaPanel.setPreferredSize(new Dimension(250, 100));
        playAreaPanel.setBackground(new Color(55, 66, 88));
        mainPanel.add(playAreaPanel, gbc);

        // === Deck area ===
        gbc.gridx = 2;
        mainPanel.add(createPlaceholderPanel("Deck"), gbc);

        // === Declaration area ===
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        mainPanel.add(createPlaceholderPanel("Declaration Area"), gbc);
        gbc.gridwidth = 1;

        // === Challenge button ===
        gbc.gridx = 2;
        JButton challengeBtn = new JButton("Challenge");
        mainPanel.add(challengeBtn, gbc);

        // === test ===
        gbc.gridy = 3;
        gbc.gridx = 1;
        JButton playBtn = new JButton("Play Selected Cards");
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
        ArrayList<ImageIcon> hand = new ArrayList<>();
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