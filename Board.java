package Tictac;

import java.awt.Graphics;

import javax.swing.JPanel;

public interface Board {
	//public JPanel drawBoard(); //draws tic tac toe board 
	public void drawX(Graphics g); //draws X on board
	public void drawO(Graphics g); //draws O on board
}
