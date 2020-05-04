package Tictac;

import javax.swing.*;

public class tester {

	public static void main(String[] args) {
		BoardBW board = new BoardBW();
		JFrame frame = new JFrame(); // border layout is default
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(board.drawBoard());	
		frame.pack();
		frame.setVisible(true);
	}

}
