import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.table.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectMarking extends JPanel
{	
	JButton eSaveButton,eGoButton;
	JTextField groupNumberField;
	JTextField groupNameField;
	JTextField projectTitleField,totalMarksField;
	JLabel groupNumberLabel,totalMarks;
	JLabel groupNameLabel;
	JLabel projectTitleLabel;
	JLabel studentIdLabel;
	JLabel studentNameLabel;
	JTextField studentIdField;
	JTextField studentNameField;
	JCheckBox inheritanceBox,polymorphismBox,abstractionBox,encapsulationBox,exceptionBox,jdbcBox,guiBox,packageBox,overlrBox,threadBox,streamBox,staticBox,objectBox;
	CreateGroupClass g1;
	EditGroupClass e1;
	ProjectManagement s1;
	public int serialx=1;
	DefaultTableModel model;
	JTable jtbl;
	JTable cTable;
	JTable tb;
	JScrollPane sp;
	static Object[][] databaseInfo;
	static DefaultTableModel dTableModel;
	ProjectFrame frame;
	JComboBox<String> cSemesterChoose;
	private String semesterNames[]={"2017-18,FALL","2017-18,SUMMER","2017-18,SPRING","2018-19,FALL","2018-19,SUMMER","2018-19,SPRING"};
	String data[][]={ {"","","","",""},    
                          {"","","","",""},    
                          {"","","","",""},{"","","","",""},{"","","","",""}};    
    String column[]={"NAME","ID","SECTION","PART","MARK"};
	public ProjectMarking()
	{
		
	}
	
	public ProjectMarking(ProjectFrame frame,CreateGroupClass g1,EditGroupClass e1,ProjectManagement s1)
	{
		this.g1=g1;
		this.s1=s1;
		this.e1=e1;
		this.frame = frame;
		this.setLayout(null);
		this.setBackground(new Color( 82, 144, 78 ));
		addComponentToPanel();
	}
	
	public void addTable(JTable s)
	{
		this.tb=s;
	}
	
	public JTable getTable()
	{
		return tb;
	}
	
	public void addComponentToPanel()
	{
	Icon image=new ImageIcon(getClass().getResource("SAVE.png"));
	this.eSaveButton = new JButton();
		Icon image1=new ImageIcon(getClass().getResource("GO.png"));
		this.eGoButton = new JButton();
		eGoButton.setIcon(image1);
		this.eGoButton.setBounds(640, 25, 80, 30);
		eSaveButton.setIcon(image);
		this.eSaveButton.setBounds(333, 470, 100, 30);
		this.add(eSaveButton);
		this.add(eGoButton);
		this.groupNumberLabel=new JLabel("Group Number");
		this.groupNumberLabel.setFont(new Font("Arrus BT",Font.BOLD,14));
		this.studentNameLabel=new JLabel("Student Name");
		this.studentNameLabel.setFont(new Font("Arrus BT",Font.BOLD,14));
	    this.groupNameLabel=new JLabel("Group Name");
		this.groupNameLabel.setFont(new Font("Arrus BT",Font.BOLD,14));
	    this.projectTitleLabel=new JLabel("Project Title");
		this.projectTitleLabel.setFont(new Font("Arrus BT",Font.BOLD,14));
		this.studentIdLabel=new JLabel("Student ID");
		this.studentIdLabel.setFont(new Font("Arrus BT",Font.BOLD,14));
		this.groupNumberField=new JTextField(30);
	    this.groupNameField=new JTextField(50);
		this.studentNameField=new JTextField(50);
	    this.projectTitleField=new JTextField(50);
		this.studentIdField=new JTextField(30);
		this.groupNumberLabel.setBounds(30, 25, 120, 30);
		this.groupNumberField.setBounds(150, 25, 60, 30);
		this.studentIdLabel.setBounds(235, 25, 120, 30);
		this.studentIdField.setBounds(325, 25, 100, 30);
		this.studentNameLabel.setBounds(50, 90, 120, 30);
		this.studentNameField.setBounds(250, 90, 300, 30);
		this.groupNameLabel.setBounds(50, 150 , 120, 30);
		this.groupNameField.setBounds(250, 150 , 300, 30);
	    this.projectTitleLabel.setBounds(50, 210, 120, 30);
		this.projectTitleField.setBounds(250, 210, 300, 30);
		this.add(groupNumberLabel);
		this.add(groupNameLabel);
		this.add(projectTitleLabel);
		this.add(groupNumberField);
		this.add(groupNameField);
		this.add(projectTitleField);
		this.add(studentIdLabel);
		this.add(studentIdField);
		this.add(studentNameField);
		this.add(studentNameLabel);
		this.cSemesterChoose=new JComboBox<>(semesterNames);
		this.cSemesterChoose.setMaximumRowCount(3);
		this.cSemesterChoose.setBounds(460, 25, 150, 30);
		this.add(cSemesterChoose);
		this.inheritanceBox = new JCheckBox("    Inheritance");
		this.inheritanceBox.setFont(new Font("Arrus BT",Font.BOLD,14));
		this.inheritanceBox.setBounds(120, 265, 150, 30);
		this.inheritanceBox.setBackground(new Color( 82, 144, 78 ));		
		this.add(inheritanceBox);
		this.polymorphismBox = new JCheckBox("    Polymorphism");
		this.polymorphismBox.setFont(new Font("Arrus BT",Font.BOLD,14));
		this.polymorphismBox.setBounds(120, 295, 150, 30);
		this.polymorphismBox.setBackground(new Color( 82, 144, 78 ));
		this.add(polymorphismBox);
		this.abstractionBox = new JCheckBox("    Abstraction");
		this.abstractionBox.setFont(new Font("Arrus BT",Font.BOLD,14));
		this.abstractionBox.setBounds(120, 325, 150, 30);
		this.abstractionBox.setBackground(new Color( 82, 144, 78 ));
		this.add(abstractionBox);
		this.encapsulationBox = new JCheckBox("    Encapsulation");
		this.encapsulationBox.setFont(new Font("Arrus BT",Font.BOLD,14));
		this.encapsulationBox.setBounds(120, 355, 150, 30); 
		this.encapsulationBox.setBackground(new Color( 82, 144, 78 ));
		this.add(encapsulationBox);
		this.exceptionBox = new JCheckBox("    Exception Handling");
		this.exceptionBox.setFont(new Font("Arrus BT",Font.BOLD,14));
		this.exceptionBox.setBounds(120, 385, 220, 30); 
		this.exceptionBox.setBackground(new Color( 82, 144, 78 ));
		this.add(exceptionBox);
		this.jdbcBox = new JCheckBox("    JDBC");
		this.jdbcBox.setFont(new Font("Arrus BT",Font.BOLD,14));
		this.jdbcBox.setBounds(120, 415, 150, 30);
		this.jdbcBox.setBackground(new Color( 82, 144, 78 ));
		this.add(jdbcBox);
		this.guiBox = new JCheckBox("    GUI");
		this.guiBox.setFont(new Font("Arrus BT",Font.BOLD,14));
		this.guiBox.setBounds(120, 445, 150, 30); 
		this.guiBox.setBackground(new Color( 82, 144, 78 ));
		this.add(guiBox);
		this.packageBox = new JCheckBox("    Package");
		this.packageBox.setFont(new Font("Arrus BT",Font.BOLD,14));
		this.packageBox.setBounds(440, 265, 150, 30);
		this.packageBox.setBackground(new Color( 82, 144, 78 ));
		this.add(packageBox);
		this.overlrBox = new JCheckBox("    Overloading/Overriding");
		this.overlrBox.setFont(new Font("Arrus BT",Font.BOLD,14));
		this.overlrBox.setBounds(440, 295, 220, 30);
		this.overlrBox.setBackground(new Color( 82, 144, 78 ));		
		this.add(overlrBox);
		this.threadBox = new JCheckBox("    Thread");
		this.threadBox.setFont(new Font("Arrus BT",Font.BOLD,14));
		this.threadBox.setBounds(440, 325, 150, 30); 
		this.threadBox.setBackground(new Color( 82, 144, 78 ));		
		this.add(threadBox);
		this.streamBox = new JCheckBox("    Stream IO");
		this.streamBox.setFont(new Font("Arrus BT",Font.BOLD,14));
		this.streamBox.setBounds(440, 355, 150, 30); 
		this.streamBox.setBackground(new Color( 82, 144, 78 ));		
		this.add(streamBox);
		this.staticBox = new JCheckBox("    Static,Super,Final");
		this.staticBox.setFont(new Font("Arrus BT",Font.BOLD,14));
		this.staticBox.setBounds(440, 385, 220, 30); 
		this.staticBox.setBackground(new Color( 82, 144, 78 ));		
		this.add(staticBox);
		this.objectBox = new JCheckBox("    Object & Class");
		this.objectBox.setFont(new Font("Arrus BT",Font.BOLD,14));
		this.objectBox.setBounds(440, 415, 150, 30); 
		this.objectBox.setBackground(new Color( 82, 144, 78 ));		
		this.add(objectBox);
		this.eSaveButton.addActionListener(new ActionListener()
		{
			int totalmark=0;
			public void actionPerformed(ActionEvent e)
			{
				if (inheritanceBox.isSelected()==true)
					{totalmark=totalmark+2;}
				if (polymorphismBox.isSelected()==true)
						{totalmark=totalmark+2;}
				if (abstractionBox.isSelected()==true)
				{totalmark=totalmark+2;}
				if (encapsulationBox.isSelected()==true)
				{totalmark=totalmark+2;}
				if (exceptionBox.isSelected()==true)
				{totalmark=totalmark+2;}
				if (jdbcBox.isSelected()==true)
				{totalmark=totalmark+2;}
				if (guiBox.isSelected()==true)
				{totalmark=totalmark+2;}
				if (packageBox.isSelected()==true)
				{totalmark=totalmark+2;}
				if (overlrBox.isSelected()==true)
				{totalmark=totalmark+2;}
				if (threadBox.isSelected()==true)
				{totalmark=totalmark+2;}
				if (streamBox.isSelected()==true)
				{totalmark=totalmark+2;}
				if (staticBox.isSelected()==true)
				{totalmark=totalmark+2;}
				if (objectBox.isSelected()==true)
				{totalmark=totalmark+2;}
				 
				String stdnumbr=studentIdField.getText();
				String gno=groupNumberField.getText();
				String stdid=studentIdField.getText();
				String semesterChoose = cSemesterChoose.getSelectedItem().toString();
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagementsystem","root","");
					Statement stmt = con2.createStatement();
					String sql2 = "UPDATE create_group SET mark='"+totalmark+"' WHERE sgroupno='"+gno+"' and sid='"+stdid+"' and semester='"+semesterChoose+"'";
					int rs2   = stmt.executeUpdate(sql2);
			con2.close();
			JOptionPane.showMessageDialog(null, "Group Updated to DATABASE Successfully");
			}
			
		catch(Exception e5)
		{
			System.out.println(e5);
		}
			
			}
		});
		 
		this.eGoButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				inheritanceBox.setSelected(false);
				polymorphismBox.setSelected(false);
				abstractionBox.setSelected(false);
				encapsulationBox.setSelected(false);
				exceptionBox.setSelected(false);
				jdbcBox.setSelected(false);
				guiBox.setSelected(false);
				packageBox.setSelected(false);
				overlrBox.setSelected(false);
				threadBox.setSelected(false);
				streamBox.setSelected(false);
				staticBox.setSelected(false);
				objectBox.setSelected(false);	
				String groupNumber=groupNumberField.getText();
				g1.getGroupNumber(groupNumber);
				String semesterChoose = cSemesterChoose.getSelectedItem().toString();
				String getId = studentIdField.getText();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagementsystem","root","");
					Statement stmt = con.createStatement();
					String sql1= "SELECT `groupname`,`projecttitle` FROM `create_group_info` WHERE groupnumber='"+groupNumber+"' and semester='"+semesterChoose+"'";
					ResultSet rs1   =  stmt.executeQuery(sql1);
					
			
					while(rs1.next())
					{
						groupNameField.setText(rs1.getString("groupname"));
						projectTitleField.setText(rs1.getString("projecttitle"));
		
					}
					
					con.close();
				}
					
				catch(Exception e3)
				{
					System.out.println(e3);
				}
				
				String semesterChoose1 = cSemesterChoose.getSelectedItem().toString();
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cont = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagementsystem","root","");
					PreparedStatement pstm = cont.prepareStatement("SELECT `sname`,`ssec`,`mark` FROM `create_group` WHERE sgroupno='"+groupNumber+"' and semester='"+semesterChoose1+"' and sid='"+getId+"'");
					ResultSet Rs = pstm.executeQuery();
					
					while(Rs.next())
					{
						studentNameField.setText(Rs.getString("sname"));
					}
				}
				
				catch (Exception em)
				{
					System.out.println(em.getMessage());
				}
			}
		});	
	}
}
