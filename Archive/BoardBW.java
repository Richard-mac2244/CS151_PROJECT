package Tictac;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class BoardBW extends JPanel implements Board{
	private int x = 0;
	private BoardBWPanel newBoard;
	

	@Override
	public JPanel drawBoard() {
		newBoard = new BoardBWPanel();
		return newBoard;
	}

	@Override
	public void drawX(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawO(int x) {
		// TODO Auto-generated method stub
		
	}

}
