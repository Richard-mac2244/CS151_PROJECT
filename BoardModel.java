import java.util.Observable;

/***
 * 
 * @author Lauren MacPherson
 * 
 * This is the data model for the game 
 *
 */
public class BoardModel extends Observable {
	public static int turnNumber = 1;
	private int[] boardValues; 
	//3 is blank, 1 is X, 0 is O
	
	public BoardModel () {
		boardValues = new int[9];
		
		for (int i = 0; i < 9; i++) {
			boardValues[i] = 3;
		}	//board has been initialized to 9 values, filled with 3s
	}
	
	/**
	 * Sets the value of the provided position 
	 * 
	 * @param row the row of the button
	 * @param column the row of the column
	 * @param value the value to set this position to (should be 0, 1, or 2)
	 */
	@SuppressWarnings("deprecation")
	public void setValue(int index, int value) {
		boardValues[index] = value; 
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
	public int getValue(int index) {
		return boardValues[index];
	}
}
