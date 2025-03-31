package gameUI.components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CardComponent extends JLabel {
	private boolean selected = false;

	public CardComponent(ImageIcon icon) {
		// Resize image
		Image scaled = icon.getImage().getScaledInstance(60, 90, Image.SCALE_SMOOTH);
		setIcon(new ImageIcon(scaled));

		// Set border and mouse cursor style
		setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// Add click event
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				toggleSelect();
			}
		});
	}

	// Toggle selection state
	private void toggleSelect() {
		selected = !selected;
		if (selected) {
			setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
		} else {
			setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
		}
	}

	public boolean isSelected() {
		return selected;
	}

	public ImageIcon getCardIcon() {
		return (ImageIcon) getIcon();
	}
}