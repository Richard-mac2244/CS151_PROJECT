package Tictac;


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
		ImageIcon xIconCW = new ImageIcon("xblock_color.png"); 
		ImageIcon oIconCW = new ImageIcon("oblock_color.png"); 
		ImageIcon blankIconCW = new ImageIcon("blank_color.png"); 
		ImageIcon undoButtonCW = new ImageIcon("undobutton_color.png"); 

		public JButton makeUndoButton(); 
		public JButton makeButton(int rowIndex, int colIndex); //draws a blank button
		public void changeIcons(JButton[][] buttons, BoardModel model);
}
