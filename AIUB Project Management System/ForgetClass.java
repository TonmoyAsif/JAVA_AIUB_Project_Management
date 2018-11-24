import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPasswordField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.sql.*;
 
public class ForgetClass extends JFrame
{
	JLabel question1Label;
	JLabel question2Label;
	JLabel emailLabel;
	JButton submitButton;
	JButton cancleButton;
	JTextField question1Text;
	JTextField question2Text;
    JTextField emailText;	
	
	public ForgetClass()
	{
		this.setTitle("Forget Password");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,450);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		addComponentToFrame();
		this.setVisible(true);
	}
	
	public void addComponentToFrame()
	{
		this.emailLabel=new JLabel("Email");
		this.emailLabel.setForeground(Color.BLUE);
        this.emailLabel.setBounds(100, 40, 100, 30);
		this.add(emailLabel);
		
		this.emailText= new JTextField();
		this.emailText.setBounds(100, 70, 150, 30);
		this.emailText.setForeground(Color.BLUE);
		
		this.question1Label = new JLabel("What's your first Teacher's Name?");
		this.question1Label.setForeground(Color.BLUE);
        this.question1Label.setBounds(100, 120, 300, 30);
		
		this.question1Text= new JTextField(20);
		this.question1Text.setBounds(100, 150, 180, 30);
		this.question1Text.setForeground(Color.BLUE);
		
		this.question2Label = new JLabel("What is the name of your childhood friend?");
		this.question2Label.setForeground(Color.BLUE);
		this.question2Label.setBounds(100, 200, 300, 30);
		
		this.question2Text= new JTextField();
		this.question2Text.setBounds(100, 230, 180, 30);
		this.question2Text.setForeground(Color.BLUE);
		
		this.submitButton=new JButton("SUBMIT");
		this.submitButton.setBounds(100, 300, 100, 30);
		
		this.cancleButton=new JButton("Cancel");
		this.cancleButton.setBounds(250, 300, 100, 30);	
	
		this.add(question1Label);
		this.add(question1Text);
		this.add(question2Label);
		this.add(question2Text);
		this.add(submitButton);
		this.add(cancleButton);
		this.add(emailText);
		
		submitButton.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Connection conn;
				PreparedStatement pst;
				ResultSet rs;
				String email1 = emailText.getText();
				String q1 = question1Text.getText();
				String q2 = question2Text.getText();

				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagementsystem","root","");
					String query = "select * from verification WHERE email='" +email1+ "' and question1='" + q1 + "' and question2='" + q2 + "'";
					pst = (PreparedStatement) conn.prepareStatement(query);
					rs = (ResultSet) pst.executeQuery(query);
					int count = 0;
					while (rs.next()) 
					{  String a= "Username: "+rs.getString("username")+"\n"+"Password: "+rs.getString("password")+"\n"+"Use above Information to login to your Account";
					   JOptionPane.showMessageDialog(null,a);
						count = count + 1;
					}
					if (count == 1)
					{
						dispose();
						Verification verify = new Verification();
						//JOptionPane.showMessageDialog(null,a);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Wrong Answer");
					}
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}					
			}
		});
		
		cancleButton.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
				dispose();
				Verification verify = new Verification();
			}
		});
	}
}