package Tictac;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class oBWIcon implements Icon {
	private int currX;
	private int currY;

	public oBWIcon(int newX, int newY) {
		currX = newX;
		currY = newY;
	}
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D newO = new Ellipse2D.Double(x, y, x, y);
		g2.setColor(Color.BLACK);
		g2.draw(newO);
		System.out.println("Painted O");
	}

	@Override
	public int getIconWidth() {
		// TODO Auto-generated method stub
		return currX;
	}

	@Override
	public int getIconHeight() {
		// TODO Auto-generated method stub
		return currY;
	}
}