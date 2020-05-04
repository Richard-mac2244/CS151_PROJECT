import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class BoardCW implements Board{
	@Override
	public void drawBoard(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D spotOne = new Rectangle2D.Double(0, 0, 5, 5);
		Rectangle2D spotTwo = new Rectangle2D.Double(5, 0, 5, 5);
		Rectangle2D spotThree = new Rectangle2D.Double(10, 0, 5, 5);
		Rectangle2D spotFour = new Rectangle2D.Double(0, 5, 5, 5);
		Rectangle2D spotFive = new Rectangle2D.Double(5, 5, 5, 5);
		Rectangle2D spotSix = new Rectangle2D.Double(10, 5, 5, 5);
		Rectangle2D spotSeven = new Rectangle2D.Double(0, 10, 5, 5);
		Rectangle2D spotEight = new Rectangle2D.Double(5, 10, 5, 5);
		Rectangle2D spotNine = new Rectangle2D.Double(10, 10, 5, 5);
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
	}

	@Override
	public void drawX(Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		Line2D lineOne = new Line2D.Double(x, y, x+2, y + 2);
		Line2D lineTwo = new Line2D.Double(x + 2, y, x , y + 2);
		g2.setColor(Color.YELLOW);
		g2.draw(lineOne);
		g2.draw(lineTwo);
		
	}

	@Override
	public void drawO(Graphics g, int x, int y) {
		Graphics2D g2 = (Graphics2D) g;
		Ellipse2D circle = new Ellipse2D.Double(x - 1, y - 1, 2, 2);
		g2.setColor(Color.BLUE);
		g2.draw(circle);
	}

}
