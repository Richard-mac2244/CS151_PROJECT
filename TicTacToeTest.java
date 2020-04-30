import java.util.Arrays;

public class TicTacToeTest {
	public static void main(String[] args) {
		BoardModel model = new BoardModel(); 
		BoardView board = new BoardView(); //the parameter passed in will be the strategy that will be used
		
		model.addObserver(board);
		
		//board.setVisible(true); TODO delete?
	}
}
