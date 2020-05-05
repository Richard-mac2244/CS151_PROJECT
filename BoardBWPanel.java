package Tictac;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

public class BoardBWPanel extends JPanel {
	//contains all X and O icons (model)
	private ArrayList<xBWIcon> allX = new ArrayList<>();
	private ArrayList<oBWIcon> allO = new ArrayList<>();

	public BoardBWPanel() {
		initComponents();
	}

	//user input (controller)
	private void initComponents() {
		JButton oButton = new JButton("O");
		JButton xButton = new JButton("X");
		super.add(oButton);
		super.add(xButton);
		
		oButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				super.mouseClicked(me);
				oButton.setEnabled(false);
				xButton.setEnabled(true);
			}
		});
		xButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				super.mouseClicked(me);
				xButton.setEnabled(false);
				oButton.setEnabled(true);
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				super.mouseClicked(me);
				if (!xButton.isEnabled()) {
					addX(new xBWIcon(me.getPoint().x, me.getPoint().y));
					repaint();
				}
				else if(!oButton.isEnabled()) {
					addO(new oBWIcon(me.getPoint().x, me.getPoint().y));
					repaint();
				}
			}
		});
	}

	public void addX(xBWIcon rec) {
		allX.add(rec);
	}
	
	public void addO(oBWIcon rec) {
		allO.add(rec);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D spotOne = new Rectangle2D.Double(0, 0, 100, 100);
		Rectangle2D spotTwo = new Rectangle2D.Double(100, 0, 100, 100);
		Rectangle2D spotThree = new Rectangle2D.Double(200, 0, 100, 100);
		Rectangle2D spotFour = new Rectangle2D.Double(0, 100, 100, 100);
		Rectangle2D spotFive = new Rectangle2D.Double(100, 100, 100, 100);
		Rectangle2D spotSix = new Rectangle2D.Double(200, 100, 100, 100);
		Rectangle2D spotSeven = new Rectangle2D.Double(0, 200, 100, 100);
		Rectangle2D spotEight = new Rectangle2D.Double(100, 200, 100, 100);
		Rectangle2D spotNine = new Rectangle2D.Double(200, 200, 100, 100);
		g2.setColor(Color.BLACK);
		g2.draw(spotOne);
		g2.draw(spotTwo);
		g2.draw(spotThree);
		g2.draw(spotFour);
		g2.draw(spotFive);
		g2.draw(spotSix);
		g2.draw(spotSeven);
		g2.draw(spotEight);
		g2.draw(spotNine);
		for (xBWIcon i : allX) {
			i.paintIcon(this, g, i.getIconWidth(), i.getIconHeight());
			System.out.println("redrawn X");
		}
		for (oBWIcon i : allO) {
			i.paintIcon(this, g, i.getIconWidth(), i.getIconHeight());
			System.out.println("redrawn O");
		}
	}
}
