package gameUI;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {

	public Home() {
		// Set window properties
		setTitle("Super MaDiao");
		setSize(1152, 864);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create background panel
		BackgroundPanel background = new BackgroundPanel();
		setContentPane(background);

		// Create button panel
		JPanel buttonPanel = new JPanel(new GridBagLayout());
		buttonPanel.setOpaque(false);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 0, 10, 0);

		HomePageButtons startButton = new HomePageButtons("/icons/start.png", 200, 60, e -> {
			JOptionPane.showMessageDialog(Home.this, "Game Started!");
			Home.this.dispose();
			new GameFrame();
			// Game start here
		});

		// Add start button
		gbc.gridx = 0;
		gbc.gridy = 0;
		buttonPanel.add(startButton, gbc);

		// Create help button
		HomePageButtons helpButton = new HomePageButtons("/icons/help.png", 200, 60, e -> {
			String helpMessage = "Super Mahjong Game Rules:\n"
					+ "1. Each player takes turns playing cards and declaring card points.\n"
					+ "2. Other players can challenge; if the declaration is incorrect, the liar takes all cards from the pile.\n"
					+ "3. If the challenge fails, the challenger takes all cards from the pile.\n"
					+ "4. The first player to empty their hand wins!";
			JOptionPane.showMessageDialog(Home.this, helpMessage, "Game Help", JOptionPane.INFORMATION_MESSAGE);
		});

		// Add help button
		gbc.gridy = 1;
		buttonPanel.add(helpButton, gbc);

		// Set button layout
		background.add(Box.createVerticalStrut(350), BorderLayout.NORTH);
		background.add(buttonPanel, BorderLayout.CENTER);

		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Home::new);
	}
}