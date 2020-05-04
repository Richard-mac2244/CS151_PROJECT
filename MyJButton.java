package Tictac;

import java.awt.*;
import java.awt.geom.Line2D;

import javax.swing.*;

public class MyJButton extends JButton implements Board {
	public static boolean isClicked = false;
	public static int turn = 0;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(turn % 2 == 0) {
			this.drawX(g);
		}
		else if(turn % 2 != 0) {
			this.drawO(g);
		}
		System.out.println(turn);
	}

	@Override
	public void drawX(Graphics g) {
		Font X = new Font("SansSerif", Font.BOLD, 14);
		g.setFont(X);
		g.setColor(Color.BLUE);
		String text = "X";
		g.drawString(text, 5, 5);
	}

	@Override
	public void drawO(Graphics g) {
		Font O = new Font("SansSerif", Font.BOLD, 14);
		g.setFont(O);
		g.setColor(Color.YELLOW);
		String text = "O";
		g.drawString(text, 5, 5);
		turn++;
	}
}
