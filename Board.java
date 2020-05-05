package Tictac;

import java.awt.Graphics;

import javax.swing.JPanel;

public interface Board {
	public JPanel drawBoard(); //draws tic tac toe board 
	public void drawX(int x); //draws X on board
	public void drawO(int x); //draws O on board
}
