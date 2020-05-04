import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class BoardBW extends JFrame implements Board {
	JFrame game; 
	JPanel gameInner;
	JPanel undoBar; //TODO add undo bar 
	
	
	//TODO override tags 
	public BoardBW(){
		
	}
	
	/***
	 * Creates the tictactoe
	 */
	public void createBoard() {
		game = new JFrame("Tic-Tac-Toe Game"); 
		gameInner = new JPanel(); 
		gameInner.setLayout(new GridLayout(3,3));
		//createButtons(); 
		
		gameInner.setSize(300, 300);
		game.add(gameInner);
		game.pack(); 
		game.setResizable(false); 
		game.setVisible(true);
	}
	
	public JButton makeBlankButton() {
		JButton button = new JButton(blankIcon);
		button.setPreferredSize(new Dimension(100, 100));
		return button; 
	}
	
	public JButton makeUndoButton() {
		JButton uButton = new JButton(undoButton);
		uButton.setPreferredSize(new Dimension(300,25));
		return uButton; 
	}
	

	@Override
	public void drawX(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawO(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}