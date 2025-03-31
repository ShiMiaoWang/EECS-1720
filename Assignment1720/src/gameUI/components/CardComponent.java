package gameUI.components;

import javax.swing.*;
import java.awt.*;

public class CardComponent extends JLabel {
	private boolean selected = false;

	public CardComponent(ImageIcon icon) {
		Image scaled = icon.getImage().getScaledInstance(60, 90, Image.SCALE_SMOOTH);
		setIcon(new ImageIcon(scaled));
		setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				toggleSelect();
			}
		});
	}

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
