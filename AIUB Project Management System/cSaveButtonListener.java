import java.awt.event.*;
import javax.swing.*;

public class cSaveButtonListener implements ActionListener
{
	ProjectFrame frame;
	
	public cSaveButtonListener()
	{
		
	}
	
	public cSaveButtonListener(ProjectFrame frame)
	{
		this.frame = frame;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		this.frame.dispose();
		JFrame frame2 = new JFrame();
		frame2.setTitle("Student Deshbord");
		frame2.setSize(800, 600);
		frame2.setLocationRelativeTo(null);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setVisible(true);
	}
}