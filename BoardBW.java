package Tictac;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class BoardBW extends JButton {

	public JPanel drawBoard() {
		String keyLabels = "123456789";
		JPanel keyPanel = new JPanel();
		keyPanel.setLayout(new GridLayout(4, 3));
		for (int i = 0; i < keyLabels.length(); i++) {
			MyJButton keyButton = new MyJButton();
			keyPanel.add(keyButton);
			keyButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MyJButton.isClicked = true;
					keyButton.repaint();
				}
			});
		}
		return keyPanel;
	}
}
