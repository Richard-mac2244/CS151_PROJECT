import java.util.Arrays;

import javax.swing.JFrame;

public class TicTacToeTest { 
	public static void main(String[] args) {
		JFrame game = new JFrame("Tic-Tac-Toe Game"); 
		game.setResizable(false);
		
		BoardModel model = new BoardModel(); 
		BoardView board = new BoardView(game, model); //the parameter passed in will be the strategy that will be used
		
		model.addObserver(board);
		
		
		game.setVisible(true);
		System.out.println(5%2);
	}
}
