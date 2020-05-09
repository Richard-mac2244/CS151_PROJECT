package Tictac;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//TODO Check if all these are needed; 
public class BoardController extends JFrame implements Observer {
	BoardModel bModel;
	JFrame game;
	JPanel gameInner, startPanel, undoBar;
	Board board;
	JButton button;
	JButton[][] gameButtons = new JButton[3][3];

	public BoardController(JFrame frame, BoardModel model) {
		game = frame;
		bModel = model;
		startPanel = new JPanel();
		startPanel.setSize(300, 350);
		addStrategyButtons();
		game.add(startPanel);
		game.pack();
	}

	private void createGame() {
		game.remove(startPanel);
		gameInner = new JPanel(); // to replace the old one
		undoBar = new JPanel();

		makeGameButtons(); // this gets a method to add to code readability??
		// TODO evaluate if this is a good idea
		makeUndo();

		game.setLayout(new BorderLayout());
		game.add(undoBar, BorderLayout.PAGE_START);
		game.add(gameInner, BorderLayout.CENTER);
		gameInner.setLayout(new GridLayout(3, 3));
		game.pack();
		game.validate();
		game.repaint();
	}

	// TODO this function does not correctly identify who last played. Will be
	// easier once visual is working
	private void makeUndo() {
		button = board.makeUndoButton();
		undoBar.add(button); // TODO make the listener actually do something
	}

	private void makeGameButtons() {
		for (int row = 0; row < gameButtons.length; row++) {
			for (int col = 0; col < gameButtons[row].length; col++) {
				button = board.makeButton(row, col);
				gameButtons[row][col] = button;
				gameInner.add(button);
			}

		}
	}

	private void addStrategyButtons() {
		JButton BWButton = new JButton("Black and White");
		JButton CWButton = new JButton("Color");

		BWButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Black and White"); // remove later
				board = new BoardBW(bModel); // board is now set to BW mode
				createGame();
			}
		});

		CWButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Color");
				board = new BoardCW(bModel); // when color mode is an option
				createGame();
			}
		});
		startPanel.add(BWButton);
		startPanel.add(CWButton);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		System.out.println("Something changed");
		board.changeIcons(gameButtons, bModel);
	}

}
