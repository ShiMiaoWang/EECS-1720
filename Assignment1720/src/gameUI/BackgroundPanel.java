package gameUI;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
	private Image backgroundImage;

	public BackgroundPanel() {
		// load background: title.png
		backgroundImage = new ImageIcon(getClass().getResource("/icons/title.png")).getImage();
		setLayout(new BorderLayout());
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

	}
}