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


//TODO THIS IS MORE LIKE THE CONTROLLER CLASS THAN THE VIEW 
public class BoardView extends JFrame implements Observer{
	private BoardModel bModel; 
	
	public BoardView(BoardModel model) {
		bModel = model;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		//changeIcons(); 
	}

}