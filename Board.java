import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public interface Board {

	//TODO note that the buttons below are ALL for the BW board
	//so we should change them in some way so they are not here
	ImageIcon xIcon = new ImageIcon("xblock.png"); 
	ImageIcon oIcon = new ImageIcon("oblock.png"); 
	ImageIcon blankIcon = new ImageIcon("blank.png"); 
	ImageIcon undoButton = new ImageIcon("undobutton.png"); 

	public JButton makeUndoButton(); 
	public JButton makeButton(int index); //draws a blank button
	public void changeIcons(JButton[] buttons, BoardModel model);
	public void drawX(Graphics g); //draws X on board
	public void drawO(Graphics g); //draws O on board
}