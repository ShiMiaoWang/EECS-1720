package gameUI;

import main.Game;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {

	public Home() {
		setTitle("Super Madiao");
		setSize(1152, 864);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		BackgroundPanel background = new BackgroundPanel();
		setContentPane(background);

		JPanel buttonPanel = new JPanel(new GridBagLayout());
		buttonPanel.setOpaque(false);

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 0, 10, 0);

		// load start button
		HomePageButtons startButton = new HomePageButtons("/icons/start.png", 200, 60, e -> {
			JOptionPane.showMessageDialog(Home.this, "Game started!");
			Home.this.dispose();
//            new Game(null); 
		});

		// add button to panel
		gbc.gridx = 0;
		gbc.gridy = 0;
		buttonPanel.add(startButton, gbc);

		// set help button
		HomePageButtons helpButton = new HomePageButtons("/icons/help.png", 200, 60, e -> {
			String helpMessage = "Super Madiao Game Rules:\n"
					+ "1. Each player takes turns playing cards, declaring the rank of the card.\n"
					+ "2. Other players can challenge; if the declaration is incorrect, the liar takes all cards in the pile.\n"
					+ "3. If the challenge fails, the challenger takes the cards in the pile.\n"
					+ "4. The first player to empty their hand wins!";
			JOptionPane.showMessageDialog(Home.this, helpMessage, "Game Help", JOptionPane.INFORMATION_MESSAGE);
		});

		// add button to panel
		gbc.gridy = 1;
		buttonPanel.add(helpButton, gbc);

		// button layout
		background.add(Box.createVerticalStrut(350), BorderLayout.NORTH);
		background.add(buttonPanel, BorderLayout.CENTER);

		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Home::new);
	}
}
