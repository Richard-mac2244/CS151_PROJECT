package Tictac;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class xBWIcon implements Icon {
	private int currX;
	private int currY;

	public xBWIcon(int newX, int newY) {
		currX = newX;
		currY = newY;
	}
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		Line2D lineOne = new Line2D.Double(x, y, x + 50, y + 50);
		Line2D lineTwo = new Line2D.Double(x + 50, y, x, y + 50);
		g2.setColor(Color.BLACK);
		g2.draw(lineOne);
		g2.draw(lineTwo);
		System.out.println("Painted X");
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