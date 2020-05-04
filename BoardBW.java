import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class BoardBW extends JFrame implements Board {
	JFrame game; 
	JPanel gameInner;
	JPanel undoBar; 
	BoardModel bModel;
	int turn;
	//TODO add undo bar 
	//JButton[] buttons; 
	
	
	//TODO override tags 
	public BoardBW(BoardModel model){
		bModel = model; 
	}
	
	/***
	 * Creates the tictactoe
	 */
	public void createBoard() {
		game = new JFrame("Tic-Tac-Toe Game"); 
		gameInner = new JPanel(); 
		gameInner.setLayout(new GridLayout(3,3));
		//createButtons(); 
		
		gameInner.setSize(300, 300);
		game.add(gameInner);
		game.pack(); 
		game.setResizable(false); 
		game.setVisible(true);
	}
	
	//all blank icons, as that's how its currently being used
	public JButton makeButton(int index) {
		JButton button = new JButton(); 
		button.setPreferredSize(new Dimension(100, 100));
		button.setIcon(blankIcon);
		
		button.addActionListener(new ActionListener(){
			  public void actionPerformed(ActionEvent e)
			  {	//TODO make a button unclickable once it is set to something other than 3
				  System.out.println("Index: " + index + ", Turn number: " + BoardModel.turnNumber + ", Value being passed: " 
						  + (BoardModel.turnNumber%2));
				  bModel.setValue(index, (BoardModel.turnNumber%2));
				  BoardModel.turnNumber++;
				  
				  for (int j = 0; j <9; j++) {
					  System.out.print(bModel.getValue(j) + ","); //observing how the model changes
				  }
			  }
			  });
		return button; 
	}
	
	public void changeIcons(JButton[] buttons, BoardModel model) {
		for (int i = 0; i < 9; i++) {
			if (model.getValue(i) == 3) {
				buttons[i].setIcon(blankIcon);
			}
			else if (model.getValue(i) == 1) {
				buttons[i].setIcon(xIcon);
			}
			else {
				buttons[i].setIcon(oIcon);
			}
		}
	}
	
	public JButton makeUndoButton() {
		JButton uButton = new JButton(undoButton);
		uButton.setPreferredSize(new Dimension(300,25));
		return uButton; 
	}
	

	@Override
	public void drawX(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawO(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}