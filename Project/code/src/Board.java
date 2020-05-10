import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public interface Board {

		public void createBoard(); 
		public JButton makeButton(int rowIndex, int colIndex); //draws a blank button
		public void changeIcons(JButton[][] buttons, BoardModel model);
		public JButton makeUndoButton();
}
