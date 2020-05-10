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
public class BoardController extends JFrame implements Observer{
	BoardModel bModel = new BoardModel(); 
	JFrame game; 
	JPanel gameInner, startPanel, undoBar;
	Board board;
	JButton button; 
	int oUndo = 0, xUndo = 0, row, column; 
	JButton[] gameButtons = new JButton[9]; 
	
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
		  gameInner = new JPanel(); //to replace the old one 
		  undoBar = new JPanel(); 
		  
		  makeGameButtons(); //this gets a method to add to code readability?? 
		  //TODO evaluate if this is a good idea
		  makeUndo(); 
		  
		  game.setLayout(new BorderLayout());
		  game.add(undoBar, BorderLayout.PAGE_START);
		  game.add(gameInner, BorderLayout.CENTER); 
		  gameInner.setLayout(new GridLayout(3,3));
		  game.pack();
		  game.validate(); 
		  game.repaint(); 
	}
	
	//TODO this function does not correctly identify who last played. Will be easier once visual is working
	private void makeUndo() {
		button = board.makeUndoButton();
		button.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				  System.out.println("Undo Button clicked"); 
				  if (BoardModel.turnNumber%2 == 1) { //the current player is X, meaning the last one to remove is O
					  if (oUndo <3) {	//check how many times X has clicked undo in total 
						  System.out.println("Undid turn for O");
						  BoardModel.turnNumber--; 
						  oUndo++;
						  //TODO make undo unselectable until O makes their turn 
					  }
					  else{
						  System.out.println("Error! You're out of undos."); //already used up all undos
					  }
				  }
				  else {
					  if (xUndo <3) {	//check how many times X has clicked undo in total 
						  System.out.println("Undid turn for O");
						  BoardModel.turnNumber--; 
						  xUndo++;
						  //TODO make undo unselectable until X makes their turn 
					  }
					  else{
						  System.out.println("Error! You're out of undos."); //already used up all undos
					  }
				  }
			  }
			  });;
		undoBar.add(button); //TODO make the listener actually do something 
	}
	
	private void makeGameButtons() {
		for (int i = 0; i < 9; i++) {
			button = board.makeButton(i);
			gameButtons[i] = button; 
			gameInner.add(button);
		}
	}
	
	private void addStrategyButtons() {
		JButton BWButton = new JButton("Black and White");
		JButton colorButton = new JButton("Color");	
		
		BWButton.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				  System.out.println("Black and White"); //remove later 
				  board = new BoardBW(bModel); //board is now set to BW mode 
				  createGame();
			  }
			  });	
		
		colorButton.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				  System.out.println("Color");
				  //Board board = new BoardColor(); TODO when color mode is an option
			  }
			  });
		startPanel.add(BWButton);
		startPanel.add(colorButton);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		System.out.println("Something changed"); 
		board.changeIcons(gameButtons, bModel);
	}

}
