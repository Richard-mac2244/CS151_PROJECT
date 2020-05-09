package Tictac;

import java.util.Observable;

/***
 * 
 * @author Lauren MacPherson
 * 
 *         This is the data model for the game
 *
 */
public class BoardModel extends Observable {
	public static int turnNumber = 1;
	public static int oUndo = 0, xUndo = 0, row, column;
	private int[][] boardValues;
	private int currRowInd;
	private int currColInd;
	private boolean winX = false;
	private boolean winO = false;
	private boolean noWinner = false;
	

	public BoardModel() {
		boardValues = new int[3][3];

		for (int row = 0; row < boardValues.length; row++) {
			for (int col = 0; col < boardValues[row].length; col++) {
				boardValues[row][col] = 100;
			}

		} // board has been initialized to 9 values, filled with 3s
	}

	public void checkWin() {
		// Checking if Player X won row wise.
		for (int i = 0; i < boardValues.length; i++) {
			int winCount = 3;
			int sum = 0;
			for (int row = 0; row < boardValues.length; row++) {
				sum += boardValues[i][row];
			}
			if (sum == winCount) {
				winX = true;
			}
		}

		// Checking if Player O won row wise
		for (int i = 0; i < 3; i++) {
			int sum = 0;
			for (int row = 0; row < boardValues.length; row++) {
				sum += boardValues[i][row];
			}
			if (sum == 0) {
				winO = true;
			}
		}

		// Checking if Player X won column wise.
		for (int col = 0; col < boardValues.length; col++) {
			int winCount = 3;
			int sum = 0;
			for (int row = 0; row < boardValues.length; row++) {
				sum += boardValues[row][col];
			}
			if (sum == winCount) {
				winX = true;
			}
		}

		// Checking if Player O won column wise.
		for (int col = 0; col < boardValues.length; col++) {
			int sum = 0;
			for (int row = 0; row < boardValues.length; row++) {
				sum += boardValues[row][col];
			}
			if (sum == 0) {
				winO = true;
			}
		}

		int length = boardValues.length;
		int diagonalLines = (length + length) - 1;
		int midPoint = (diagonalLines / 2) + 1;
		int numberOfElements = 3;
		
		int diagLCounter = 0;
		for (int i = 0; i < 3; i++) {
	        int rowIndex = (numberOfElements - i) - 1;
	        int columnIndex = i;
	        diagLCounter += boardValues[rowIndex][columnIndex];
	    }
		if(diagLCounter == 3) {
			System.out.println("Player X wins!");
			winX = true;
		}
		else if(diagLCounter == 0) {
			System.out.println("Player O wins!");
			winO = true;
		}
		
		int diagRCounter = 0;
		int iCounter = 0;
		for (int i = 2; i >= 0; i--) {
	        int rowIndex = (numberOfElements - iCounter) - 1;
	        int columnIndex = i;
	        iCounter++;
	        diagRCounter += boardValues[rowIndex][columnIndex];
	    }
		// checks if X player won
		if(diagRCounter == 3) {
			winX = true;
		}
		//checks if O player won
		else if(diagRCounter == 0) {
			winO = true;
		}
		this.checkTurn();
	}
	
	public void checkTurn() {
		if(turnNumber == 9 && !winO && !winX) {
			noWinner = true;
		}
	}
	
	public String announceWinner() {
		if(noWinner) {
			return "No winner.";
		}
		else if(winX) {
			return "Player X wins!";
		}
		else if(winO) {
			return "Player O wins!";
		}
		return "No conditions met.";
	}
	
	public void setCurrentCoord(int rowInd, int colInd) {
		currRowInd = rowInd;
		currColInd = colInd;
	}
	
	public int getRowInd() {
		return currRowInd;	
	}
	
	public int getColInd() {
		return currColInd;	
	}

	/**
	 * Sets the value of the provided position
	 * 
	 * @param row    the row of the button
	 * @param column the row of the column
	 * @param value  the value to set this position to (should be 0, 1, or 2)
	 */
	@SuppressWarnings("deprecation")
	public void setValue(int rowIndex, int colIndex, int value) {
		boardValues[rowIndex][colIndex] = value;
		setChanged();
		notifyObservers();
	}

	/**
	 * Gets the value of the provided position
	 * 
	 * @param row    the row of the position
	 * @param column the column of that position
	 * @return the value at that location
	 */
	public int getValue(int rowIndex, int colIndex) {
		return boardValues[rowIndex][colIndex];
	}
}
