package Tictac;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class tester {

	public static void main(String[] args) {
		Board newBoard = new BoardBW();
		JButton boardCW = new JButton("BoardCW");
		boardCW.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("BoardCW style selected");
				boardCW.setEnabled(false);
			}
		});
		JButton boardBW = new JButton("BoardBW");
		boardBW.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("BoardBW style selected");
				boardBW.setEnabled(false);
			}
		});
		BoardBW board = new BoardBW();
		JFrame frame = new JFrame(); // border layout is default
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(newBoard.drawBoard());
		frame.pack();
		frame.setVisible(true);
	}

}
