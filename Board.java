import java.awt.Graphics;

public interface Board {
	public void drawBoard(Graphics g); //draws tic tac toe board
	public void drawX(Graphics g, int x, int y); //draws X on board
	public void drawO(Graphics g, int x, int y); //draws O on board
}
