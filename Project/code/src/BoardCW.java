import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class BoardCW extends JFrame implements Board{
	ImageIcon xIconCW = new ImageIcon("xblock_color.png"); 
	ImageIcon oIconCW = new ImageIcon("oblock_color.png"); 
	ImageIcon blankIconCW = new ImageIcon("blank_color.png"); 
	ImageIcon undoButtonCW = new ImageIcon("undobutton_color.png"); 
	
	JFrame game;
	JPanel gameInner;
	JPanel undoBar;
	BoardModel bModel;
	int turn;
	
	public BoardCW(BoardModel model) {
		bModel = model;
	}

	/***
	 * Creates the tictactoe board
	 */
	public void createBoard() {
		game = new JFrame("Tic-Tac-Toe Game");
		gameInner = new JPanel();
		gameInner.setLayout(new GridLayout(3, 3));

		gameInner.setSize(300, 300);
		game.add(gameInner);
		game.pack();
		game.setResizable(false);
		game.setVisible(true);
	}

	// all blank icons
	public JButton makeButton(int rowIndex, int colIndex) {
		JButton button = new JButton();
		button.setPreferredSize(new Dimension(100, 100));
		button.setIcon(blankIconCW);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // TODO make a button unclickable once it is set to something
															// other than 3
				System.out.println("Row Index: " + rowIndex + " Column Index: " + colIndex + " Turn number: " + BoardModel.turnNumber
						+ ", Value being passed: " + (BoardModel.turnNumber % 2));
				bModel.setValue(rowIndex, colIndex, (BoardModel.turnNumber % 2));
				BoardModel.turnNumber++;

				for (int row = 0; row < 3; row++) {
					for (int col = 0; col < 3; col++) {
						System.out.print(bModel.getValue(row, col) + ","); // observing how the model changes
					}

				}
				System.out.println();
				bModel.setCurrentCoord(rowIndex, colIndex);
			}
		});
		return button;
	}

	public void changeIcons(JButton[][] buttons, BoardModel model) {
		bModel.checkWin();
		if (bModel.announceWinner().contains("winner") || bModel.announceWinner().contains("Player")) {
			for (int row = 0; row < buttons.length; row++) {
				for (int col = 0; col < buttons[row].length; col++) {
					if (model.getValue(row, col) == 100) {
						buttons[row][col].setIcon(blankIconCW);
					} else if (model.getValue(row, col) == 1) {
						buttons[row][col].setIcon(xIconCW);
					} else if (model.getValue(row, col) == 0) {
						buttons[row][col].setIcon(oIconCW);
					}
					buttons[row][col].setEnabled(false);
				}
			}
			JOptionPane.showMessageDialog(game, bModel.announceWinner());
		} else {
			for (int row = 0; row < buttons.length; row++) {
				for (int col = 0; col < buttons[row].length; col++) {
					if (model.getValue(row, col) == 100) {
						buttons[row][col].setIcon(blankIconCW);
					} else if (model.getValue(row, col) == 1) {
						buttons[row][col].setIcon(xIconCW);
					} else if (model.getValue(row, col) == 0) {
						buttons[row][col].setIcon(oIconCW);
					}
				}
			}
			System.out.println(bModel.announceWinner());
		}
	}

	public JButton makeUndoButton() {
		JButton uButton = new JButton(undoButtonCW);
		uButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Undo Button clicked");
				if (BoardModel.turnNumber % 2 == 0) { // the current player is X, meaning the last one to remove is O
					if (BoardModel.oUndo < 3) { // check how many times X has clicked undo in total
						System.out.println("Undid turn for O");
						BoardModel.turnNumber--;
						BoardModel.oUndo++;
						int currRow = bModel.getRowInd();
						int currCol = bModel.getColInd();
						System.out.println("Row Index Removed: " + currRow + " Column Index Renoved: " + currCol + " Turn number: " + BoardModel.turnNumber
								+ ", Value being passed: " + 100);
						bModel.setValue(currRow, currCol, 100);

						for (int row = 0; row < 3; row++) {
							for (int col = 0; col < 3; col++) {
								System.out.print(bModel.getValue(row, col) + ","); // observing how the model changes
							}

						}
						System.out.println();
						bModel.checkWin();
						// TODO make undo unselectable until O makes their turn
					} else {
						System.out.println("Error! You're out of undos."); // already used up all undos
					}
				} else {
					if (BoardModel.xUndo < 3) { // check how many times X has clicked undo in total
						System.out.println("Undid turn for X");
						BoardModel.turnNumber--;
						BoardModel.xUndo++;
						int currRow = bModel.getRowInd();
						int currCol = bModel.getColInd();
						System.out.println("Row Index Removed: " + currRow + " Column Index Renoved: " + currCol + " Turn number: " + BoardModel.turnNumber
								+ ", Value being passed: " + 100);
						bModel.setValue(currRow, currCol, 100);

						for (int row = 0; row < 3; row++) {
							for (int col = 0; col < 3; col++) {
								System.out.print(bModel.getValue(row, col) + ","); // observing how the model changes
							}

						}
						System.out.println();
						bModel.checkWin();
						// TODO make undo unselectable until X makes their turn
					} else {
						System.out.println("Error! You're out of undos."); // already used up all undos
					}
				}
			}
		});
		;
		uButton.setPreferredSize(new Dimension(300, 25));
		return uButton;
	}

}
