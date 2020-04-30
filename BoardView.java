import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Window;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/***
 * 
 * @author Lauren MacPherson
 * 
 *BoardView works as both the controller (the listeners) 
 *and the view (JFrame) of the program
 */
public class BoardView extends JFrame implements Observer{
	BoardModel model = new BoardModel(); 
	JFrame game; 
	JPanel gameInner;
	//TODO create a button listener
	public BoardView () {
		super("Tic-Tac-Toe Game");
		//TODO start with the opening menu screen, then REDRAW frame to create new buttons and such 
		
		game = new JFrame(); 
		gameInner = new JPanel(); 
		gameInner.setLayout(new GridLayout(3,3));
		createButtons(); 
		
		game.add(gameInner);
		game.pack(); 
		game.setResizable(false); 
		game.setVisible(true);
	}
	/* don't know if we'll need this and move the upper functions down
	private void createBoard(){
		
	}*/
	
	private void createButtons() {
        gameInner.setPreferredSize(new Dimension(400, 300));
		//TODO Create BLANK buttons in a loop

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				gameInner.add(new JButton("1").addActionListener(new ActionListener(){
					  public void actionPerformed(ActionEvent e)
					  {
						  model.set;
					  }
					  });
			}
		}
		
	}
	
	/*
	private void updateBoard(int index) {
		//index is the array index that got changed?
	}*/
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		gameInner.repaint();
	}

	
	
}
