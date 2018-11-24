import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.*;
import java.util.ArrayList;

public class Signup extends JFrame 
{
	public Signup()
	{
		JFrame j = new JFrame("SIGN UP");
		j.setSize(750, 550);
		j.setLayout(null);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setLocationRelativeTo(null);
		j.setBackground(Color.LIGHT_GRAY);
		j.setContentPane(new JLabel(new ImageIcon("D:\\Study\\AIUB\\7.Fall 17-3\\Java\\project\\Project\\2.drop_shape_bubbles_blue.jpg")));
		JLabel l1 = new JLabel("Name : ");
		l1.setBounds(50, 40, 120, 30);
		l1.setFont(new Font("Times new Rooman", Font.BOLD, 14));
		j.add(l1);
		JLabel l3 = new JLabel("Username : ");
		l3.setBounds(50, 85, 120, 30);
		l3.setFont(new Font("Times new Rooman", Font.BOLD, 14));
		j.add(l3);
		JLabel l4 = new JLabel("Password : ");
		l4.setBounds(50, 130, 120, 30);
		l4.setFont(new Font("Times new Rooman", Font.BOLD, 14));
		j.add(l4);
		JLabel l5 = new JLabel("Email : ");
		l5.setBounds(50, 220, 120, 30);
		l5.setFont(new Font("Times new Rooman", Font.BOLD, 14));
		j.add(l5);
		JLabel l6 = new JLabel("ReEnter Pass: ");
		l6.setBounds(50, 175, 120, 30);
		l6.setFont(new Font("Times new Rooman", Font.BOLD, 14));
		j.add(l6);
		JTextField text1 = new JTextField();
		text1.setBounds(200, 40, 180, 30);
		j.add(text1);
		JTextField text3 = new JTextField();
		text3.setBounds(200, 85, 180, 30);
		j.add(text3);
		JPasswordField text4 = new JPasswordField();
		text4.setBounds(200, 130, 180, 30);
		j.add(text4);
		JTextField text5 = new JTextField();
		text5.setBounds(200, 220, 180, 30);
		j.add(text5);
		JPasswordField text6 = new JPasswordField();
		text6.setBounds(200, 175, 180, 30);
		j.add(text6);	
		JTextArea ta1 = new JTextArea();
		String ta = ("1.Email Address Must be Vaild" + '\n' + "2.UserName(at least) 04 Characters" + '\n'
					 + "3.password(at least) 04 Characters" + '\n');
		ta1.setText(ta);
		ta1.setEditable(false);
		ta1.setForeground(Color.RED);
		ta1.setFont(new Font("Times new Rooman", Font.PLAIN, 14));
		ta1.setBounds(450, 50, 250, 75);
		j.add(ta1);
		ta1.setVisible(true);
		JLabel l7 = new JLabel("Security Question");
		l7.setBounds(50, 270, 220, 30);
		l7.setFont(new Font("Times new Rooman", Font.BOLD, 14));
		j.add(l7);
		JLabel l8 = new JLabel("What's your first Teacher's Name?");
		l8.setBounds(50, 310, 250, 30);
		l8.setFont(new Font("Times new Rooman", Font.BOLD, 13));
		j.add(l8);
		JLabel l9 = new JLabel("What is the name of your childhood friend?");
		l9.setBounds(50, 360, 280, 30);
		l9.setFont(new Font("Times new Rooman", Font.BOLD, 13));
		j.add(l9);
		JTextField text8 = new JTextField();
		text8.setBounds(340, 310, 220, 30);
		j.add(text8);
		JTextField text9 = new JTextField();
		text9.setBounds(340, 360, 220, 30);
		j.add(text9);
		JButton signup = new JButton("Sign up");
		signup.setBounds(100, 450, 150, 30);
		signup.setForeground(Color.black);
		signup.setBackground(Color.orange);
		j.add(signup);
		
		signup.addActionListener(e -> 
		{
			String name = text1.getText();
			String id = text3.getText();
			String qstn1 = text8.getText();
			String qstn2 = text9.getText();
			String pass=String.valueOf(text4.getPassword());
			String pass2=String.valueOf(text6.getPassword());
			String phone = text5.getText();
			String sub="ALL";
			if (!name.isEmpty() && !id.isEmpty() && !pass.isEmpty() && !phone.isEmpty() && !qstn1.isEmpty() && !qstn2.isEmpty())
			{
				if (id.length() >= 4 && pass.length() >= 4 ) 
				{
					try 
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagementsystem","root","");
						Statement stmt = con.createStatement();
						String sql1 = "INSERT INTO `verification`(`name`, `username`, `password`, `email`, `subject`,`question1`,`question2`) VALUES ('"+name+"','"+id+"','"+pass+"','"+phone+"','"+sub+"','"+qstn1+"','"+qstn2+"')";
						int rs   = stmt.executeUpdate(sql1);
						con.close();
						j.dispose();
						Verification verify = new Verification();
						JOptionPane.showMessageDialog(null,"Signed Up Successfuly. Now Login with your user ID & Password");
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null,"The UserName is TAKEN!!");
					}					
				}			
				else
				{
					JOptionPane.showMessageDialog(null, "You should follow the SignUp Rules:");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please Fill the blank fields & try again");
			}   
		});
	
		JButton c = new JButton("Cancel");
		c.setBounds(300, 450, 150, 30);
		c.setForeground(Color.black);
		c.setBackground(Color.orange);
		j.add(c);
		c.addActionListener(e -> 
		{
			j.dispose();
			Verification verify = new Verification();
		});
		j.setVisible(true);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}