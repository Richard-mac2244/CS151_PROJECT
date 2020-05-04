import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//TODO THIS IS MORE LIKE THE CONTROLLER CLASS THAN THE VIEW 
public class BoardController extends JFrame implements Observer{
	BoardModel model = new BoardModel(); 
	JFrame game; 
	JPanel gameInner;
	JPanel startPanel; 
	JPanel undoBar;
	Board board;
	JButton button; 
	
	//TODO create a button listener
	
	public BoardController(JFrame frame) {
		game = frame; 
		createStartMenu(); 
	}
	
	public void createStartMenu() {
		startPanel = new JPanel(); 
		startPanel.setSize(300, 350);
		addBWButton();
		addColorButton(); 
		game.add(startPanel);
		game.pack(); 
	}
	
	private void createGame() {
		  game.remove(startPanel); 
		  gameInner = new JPanel(); //to replace the old one 
		  undoBar = new JPanel(); 
		  
		  for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					button = board.makeBlankButton();
					button.addActionListener(new ActionListener(){
						  public void actionPerformed(ActionEvent e)
						  {
							  //TODO make it change the value of the model 
							  model.addObserver(o);
						  }
						  });
					gameInner.add(board.makeBlankButton()); //TODO button listeners
				
				}
			}
		  
		  undoBar.add(board.makeUndoButton()); //TODO create listener
		  game.setLayout(new BorderLayout());
		  game.add(undoBar, BorderLayout.PAGE_START);
		  game.add(gameInner, BorderLayout.CENTER); 
		  gameInner.setLayout(new GridLayout(3,3));
		  game.pack();
		  game.validate(); 
		  game.repaint(); 
	}
	
	private void addBWButton() {
		JButton BWButton = new JButton("Black and White");		
		
		BWButton.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				  System.out.println("Black and White"); //remove later 
				  board = new BoardBW(); //board is now set to BW mode 
				  createGame();
			  }
			  });
		startPanel.add(BWButton);
	}
	
	private void addColorButton() {
		JButton colorButton = new JButton("Color");		
		
		colorButton.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {
				  System.out.println("Color");
				  //Board board = new BoardColor(); TODO when color mode is an option
			  }
			  });
		startPanel.add(colorButton);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
