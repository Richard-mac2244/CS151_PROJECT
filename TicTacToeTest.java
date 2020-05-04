import java.util.Arrays;

import javax.swing.JFrame;

public class TicTacToeTest {
	public static void main(String[] args) {
		JFrame game = new JFrame("Tic-Tac-Toe Game"); //set size?
		//game.setSize(300,350);
		game.setResizable(false);
		//StartMenu start = new StartMenu(game); 
		
		BoardModel model = new BoardModel(); 
		BoardView view = new BoardView(model); 
		BoardController board = new BoardController(game); //the parameter passed in will be the strategy that will be used
		
		model.addObserver(view);
		
		
		game.setVisible(true);
		
		//board.setVisible(true); TODO delete?
	}
}
