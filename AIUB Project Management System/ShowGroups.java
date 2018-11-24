import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class ShowGroups extends JPanel
{
	JButton sGoButton;
	JTable cTable;
	JScrollPane sp;
	JLabel projectTitle;
	DefaultTableModel model;
	JTable jtbl;
	ProjectFrame frame;
	JComboBox<String> cSemesterChoose;
	private String semesterNames[]={"2017-18,FALL","2017-18,SUMMER","2017-18,SPRING","2018-19,FALL","2018-19,SUMMER","2018-19,SPRING"};
	String data[][]={ {"","","",""},    
                          {"","","",""},    
                          {"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""}};    
    String column[]={"Group No","Group Name","No of Member","Project Name"};	
	public ShowGroups()
	{
		
	}
	
	public ShowGroups(ProjectFrame frame)
	{	
		Icon logo=new ImageIcon(getClass().getResource("AIUBlogo.png"));
		this.projectTitle=new JLabel();
		this.projectTitle.setIcon(logo);
		this.projectTitle.setHorizontalTextPosition(SwingConstants.CENTER);
		this.projectTitle.setVerticalTextPosition(SwingConstants.BOTTOM);
		this.projectTitle.setBounds(290, -40, 450, 300);
		this.projectTitle.setToolTipText("AMERICAN INTERNATIONAL UNIVERSITY,BANGLADESH");	
		this.frame = frame;
		this.setLayout(null);
		this.setBackground(new Color( 95, 106, 106 ));
		addComponentToPanel();
	}
	
	public void addComponentToPanel()
	{	
		this.add(projectTitle);
		Icon image1=new ImageIcon(getClass().getResource("GO.png"));
		this.sGoButton = new JButton();
		sGoButton.setIcon(image1);
		this.sGoButton.setBounds(450, 255, 80, 30);
		this.add(sGoButton);
		this.cSemesterChoose=new JComboBox<>(semesterNames);
		this.cSemesterChoose.setMaximumRowCount(3);
		this.cSemesterChoose.setBounds(200, 255, 150, 30);
		this.add(cSemesterChoose);
		this.cTable=new JTable(data,column);          
		this.sp=new JScrollPane(cTable);   
		this.sp.setBounds(70,350,650,100);  	
 
		this.sGoButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String semesterChoose = cSemesterChoose.getSelectedItem().toString();
				model = new DefaultTableModel();
				jtbl = new JTable(model);
				model.addColumn("Group No");
				model.addColumn("Group Name");
				model.addColumn("No of Member");
				model.addColumn("Project Name");
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection cont = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagementsystem","root","");
					PreparedStatement pstm = cont.prepareStatement("SELECT `groupname`,`groupnumber`,`projecttitle`,`totalmember` FROM `create_group_info` WHERE semester='"+semesterChoose+"'");
					ResultSet Rs = pstm.executeQuery();
					while(Rs.next())
					{
					model.addRow(new Object[]{Rs.getString(2), Rs.getString(1),Rs.getString(4),Rs.getString(3)});
					}
				}
				catch (Exception em)
				{
					System.out.println(em.getMessage());
				}
				JScrollPane pg = new JScrollPane(jtbl);
				pg.setBounds(60,330,650,100); 
				add(pg);    
			}			
		});
	}
}