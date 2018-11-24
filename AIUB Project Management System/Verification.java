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
 
public class Verification extends JFrame
{
	JLabel userName;
	JLabel forgetPass;
	JLabel passWord;
	JLabel projectTitle;
	JButton loginButton;
	JButton createAccountButton;
	JTextField userNameText;
	JPasswordField passWordText;	
	
	public Verification()
	{
		this.setTitle("LOGIN VERIFICATION");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700,500);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		addComponentToFrame();
		this.setVisible(true);
	}
	
	public void addComponentToFrame()
	{
		Icon logo=new ImageIcon(getClass().getResource("AIUBlogo.png"));
		this.projectTitle=new JLabel("AIUB PROJECT MANAGEMENT SYSTEM");
		this.projectTitle.setFont(new Font("Arrus BT", Font.BOLD, 18));
		this.projectTitle.setForeground(Color.BLUE);
		this.projectTitle.setIcon(logo);
		this.projectTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		this.projectTitle.setVerticalTextPosition(SwingConstants.BOTTOM);
		this.projectTitle.setBounds(170, 000, 450, 300);
		this.projectTitle.setToolTipText("AMERICAN INTERNATIONAL UNIVERSITY,BANGLADESH");
		this.add(projectTitle);  
		this.userName = new JLabel("User Name");
		this.userName.setForeground(Color.BLUE);
        this.userName.setBounds(25,330, 90, 30);
		this.forgetPass = new JLabel("Forget Password? click HERE");
		this.forgetPass.setForeground(Color.BLUE);
        this.forgetPass.setBounds(25, 420, 180, 30);
		this.passWord = new JLabel("Password");
		this.passWord.setForeground(Color.BLUE);
		this.passWord.setBounds(25, 380, 90, 30);
		this.userNameText= new JTextField(20);
		this.userNameText.setBounds(120, 330, 120, 30);
		this.userNameText.setBackground(Color.YELLOW);
		this.userNameText.setForeground(Color.BLUE);
		this.passWordText= new JPasswordField();
		this.passWordText.setEchoChar('*');
		this.passWordText.setBounds(120, 380, 120, 30);
		this.passWordText.setBackground(Color.YELLOW);
		this.passWordText.setForeground(Color.BLUE);
		this.loginButton=new JButton("LOGIN");
		this.loginButton.setBounds(270, 350, 100, 30);
		this.createAccountButton=new JButton("Create New Account");
		this.createAccountButton.setBounds(430, 350, 180, 30);	
		this.add(userName);
		this.add(forgetPass);
		this.add(userNameText);
		this.add(passWord);
		this.add(passWordText);
		this.add(loginButton);
		this.add(createAccountButton);
		
		
		this.forgetPass.addMouseListener(new MouseAdapter()  
        {  
             public void mouseClicked(MouseEvent e)  
                {  
       
                dispose();
				ForgetClass f1 = new ForgetClass();

                }  
        }); 
		
		
		loginButton.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Connection conn;
				PreparedStatement pst;
				ResultSet rs;
				String pass=String.valueOf(passWordText.getPassword());

				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagementsystem","root","");
					String query = "select * from verification WHERE username='" + userNameText.getText() + "' and password='"
						+ pass + "'";
					pst = (PreparedStatement) conn.prepareStatement(query);
					rs = (ResultSet) pst.executeQuery(query);
					int count = 0;
					while (rs.next()) 
					{
						count = count + 1;
					}
					if (count == 1)
					{
						dispose();
						ProjectFrame frame = new ProjectFrame();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid Username or Password.");
					}
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}			
			}
		});
		
		createAccountButton.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
				dispose();
				Signup newUser = new Signup();
			}
		});
	}
}