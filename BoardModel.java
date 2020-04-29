import java.util.Observable;

/***
 * 
 * @author Lauren MacPherson
 * 
 * This is the data model for the game 
 *
 */
public class BoardModel extends Observable {
	private int[][] boardValues; 
	//0 is blank, 1 is X, 2 is O
	
	public BoardModel () {
		boardValues = new int[3][3];
		
		for (int i = 0; i<3; i++) {
			for (int j = 0; j<3; j++) {
				boardValues[i][j] = 0;
			}
		}	//board has been initialized to 3x3, filled with 0s
	}
	
	/**
	 * Sets the value of the provided position 
	 * 
	 * @param row the row of the button
	 * @param column the row of the column
	 * @param value the value to set this position to (should be 0, 1, or 2)
	 */
	public void setValue(int row, int column, int value) {
		boardValues[row][column] = value; 
		setChanged(); 
		notifyObservers(); 
	}
	
	/**
	 *  Gets the value of the provided position 
	 *  
	 * @param row the row of the position
	 * @param column the column of that position
	 * @return the value at that location 
	 */
	public int getValue(int row, int column) {
		return boardValues[row][column];
	}
}
