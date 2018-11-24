import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.table.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class EditGroup extends JPanel
{
	JButton eSaveButton,eGoButton;
	JTextField groupNumberField;
	JTextField groupNameField;
	JTextField projectTitleField;
	JLabel groupNumberLabel;
	JLabel groupNameLabel;
	JLabel projectTitleLabel;
	JLabel numberOfMember;
	JTextField numberOfMemberField;
	CreateGroupClass g1;
	EditGroupClass e1;
	EditGroup s1;
	public int serialx=1;
	//public int markx=0;
	
	DefaultTableModel model;
	JTable jtbl;
	JTable cTable;
	JTable tb;
	JScrollPane sp;
	static Object[][] databaseInfo;
	static DefaultTableModel dTableModel;
	
	ProjectFrame frame;
	JComboBox<String> cSemesterChoose;
	//JLabel label;
	
	private String semesterNames[]={"2017-18,FALL","2017-18,SUMMER","2017-18,SPRING","2018-19,FALL","2018-19,SUMMER","2018-19,SPRING"};
	
	String data[][]={ {"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""}};    
    String column[]={"NAME","ID","SECTION","PART"};
	
	public EditGroup()
	{
		
	}
	
	public EditGroup(ProjectFrame frame,CreateGroupClass g1,EditGroupClass e1,EditGroup s1)
	{
		this.g1=g1;
		this.s1=s1;
		this.e1=e1;
		this.frame = frame;
		this.setLayout(null);
		this.setBackground(new Color( 35, 155, 86 ));
		//setContentPane(new JLabel(new ImageIcon("C:\\Users\\Tonmoy\\Desktop\\Project Discription\\Project\\signup_Image.jpg")));
		//JLabel background=new JLabel(new ImageIcon("C:\\Users\\Tonmoy\\Desktop\\Project Discription\\Project\\signup_Image.jpg"));
		//this.add(background);
		//this.setLayout(new FlowLayout());
		//this.setLayout(null);
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
		Icon image1=new ImageIcon(getClass().getResource("GO.png"));
		this.eGoButton = new JButton();
		eGoButton.setIcon(image1);
		this.eGoButton.setBounds(600, 30, 80, 30);
		this.eSaveButton = new JButton();
		eSaveButton.setIcon(image);
		this.eSaveButton.setBounds(333, 450, 100, 30);
		this.add(eSaveButton);
		this.add(eGoButton);
		this.groupNumberLabel=new JLabel("Group Number");
		this.groupNumberLabel.setFont(new Font("Arrus BT",Font.BOLD,14));
	    this.groupNameLabel=new JLabel("Group Name");
		this.groupNameLabel.setFont(new Font("Arrus BT",Font.BOLD,14));
	    this.projectTitleLabel=new JLabel("Project Title");
		this.projectTitleLabel.setFont(new Font("Arrus BT",Font.BOLD,14));
		this.numberOfMember=new JLabel("No. of Member");
		this.numberOfMember.setFont(new Font("Arrus BT",Font.BOLD,14));
		this.groupNumberField=new JTextField(30);
	    this.groupNameField=new JTextField(50);
	    this.projectTitleField=new JTextField(50);
		this.numberOfMemberField=new JTextField(30);
		this.groupNumberLabel.setBounds(50, 30, 120, 30);
	    this.groupNameLabel.setBounds(50, 130, 120, 30);
	    this.projectTitleLabel.setBounds(50, 195, 120, 30);
		this.groupNumberField.setBounds(250, 30, 60, 30);
	    this.groupNameField.setBounds(250, 130, 300, 30);
	    this.projectTitleField.setBounds(250, 195, 300, 30);
		this.numberOfMember.setBounds(50, 260, 120, 30);
		this.numberOfMemberField.setBounds(250, 260, 50, 30);
		this.add(groupNumberLabel);
	    this.add(groupNumberField);
		
		this.add(groupNameLabel);
		this.add(groupNameField);
		this.groupNameField.setEditable(false);
		this.add(projectTitleLabel);
		this.add(projectTitleField);
		this.projectTitleField.setEditable(false);
		this.add(numberOfMember);
		this.add(numberOfMemberField);
		this.numberOfMemberField.setEditable(false);
	
		this.cSemesterChoose=new JComboBox<>(semesterNames);
		this.cSemesterChoose.setMaximumRowCount(3);
		this.cSemesterChoose.setBounds(390, 30, 150, 30);
		this.add(cSemesterChoose);
		
groupNameLabel.addMouseListener(new MouseAdapter()  
{  
    public void mouseClicked(MouseEvent e)  
    {  
       // you can open a new frame here as
       // i have assumed you have declared "frame" as instance variable
       System.out.println("HI");

    }  
}); 
		
	    /* this.cTable=new JTable(data,column);              
        this.sp=new JScrollPane(cTable);   
        this.sp.setBounds(60,330,650,100);  	
        this.add(sp); */  
		
		/* cSemesterChoose.addItemListener(
		new ItemListener()
		{
			public void itemStateChanged(ItemEvent event)
			{
				if(event.getStateChange()==ItemEvent.SELECTED)
					label.setIcon(icons[cSemesterChoose.getSelectedIndex()]);
				
			}
		}
	);   */
	//textfield.setText(null);
	    
		this.eSaveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//JTable x1=s1.getTable();
				String stdnumbr=numberOfMemberField.getText();
				int stdNum;
				stdNum = Integer.valueOf(stdnumbr);
				String gno=groupNumberField.getText();
				String gname=groupNameField.getText();
				String ptitle=projectTitleField.getText();
				//String semestr=cSemesterChoose.getText();
				String semesterChoose = cSemesterChoose.getSelectedItem().toString();
				e1.editGroupInfo(gname,gno,ptitle,stdNum,semesterChoose);
				
				try {
					//int rows=table.getRowCount();
					serialx=1;
					int i=0;
					for(int row = 0; row<stdNum; row++)
					{
						String name = (String)jtbl.getValueAt(row,0);
						String id = (String)jtbl.getValueAt(row,1);
						String sec = (String)jtbl.getValueAt(row,2);
						String part = (String)jtbl.getValueAt(row,3);
						//System.out.println(name);
						e1.editGroup(name,id,sec,part,gno,serialx,i,semesterChoose);
						serialx++;
					}
					JOptionPane.showMessageDialog(null, "Group Updated to DATABASE Successfully");
				}
					
				catch(Exception e2)
				{
					System.out.println(e2);
				}  
			}
		});
		
		this.eGoButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				groupNameField.setEditable(true);
				projectTitleField.setEditable(true);
				numberOfMemberField.setEditable(true);
				
				String groupNumber=groupNumberField.getText();
				g1.getGroupNumber(groupNumber);
				String semesterChoose = cSemesterChoose.getSelectedItem().toString();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagementsystem","root","");
					Statement stmt = con.createStatement();
					String sql1= "SELECT `groupname`,`projecttitle`,`totalmember` FROM `create_group_info` WHERE groupnumber='"+groupNumber+"' and semester='"+semesterChoose+"'";
					ResultSet rs1   =  stmt.executeQuery(sql1);
					/* String sql2= "select projecttitle from create_group_info where groupnumber='"+groupNumber+"'";
					PreparedStatement ps2 = con.prepareStatement(sql2);
					ResultSet rs2   =  ps2.executeQuery();
					String sql3= "select totalmember from create_group_info where groupnumber='"+groupNumber+"'";
					PreparedStatement ps3 = con.prepareStatement(sql3);
					ResultSet rs3   =  ps3.executeQuery(); */
			
					//groupNameField.setText(rs1.getString(1));
					//projectTitleField.setText(sql2);
					//numberOfMemberField.setText(sql3); 
			
					while(rs1.next())
					{
						groupNameField.setText(rs1.getString("groupname"));
						projectTitleField.setText(rs1.getString("projecttitle"));
						numberOfMemberField.setText(rs1.getString("totalmember"));
					}
					
					con.close();
				}
					
				catch(Exception e3)
				{
					System.out.println(e3);
				}
				
				model = new DefaultTableModel();
				//Container cnt = this.getContentPane();
				jtbl = new JTable(model);
				
				//DefaultTableModel dm = (DefaultTableModel)table.getModel();
                //model.getDataVector().removeAllElements();
               // model.fireTableDataChanged();
				//cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
				model.addColumn("NAME");
				model.addColumn("ID");
				model.addColumn("SECTION");
				model.addColumn("PART");
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection cont = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagementsystem","root","");
					PreparedStatement pstm = cont.prepareStatement("SELECT `sname`,`sid`,`ssec`,`spart` FROM `create_group` WHERE sgroupno='"+groupNumber+"' and semester='"+semesterChoose+"'");
					ResultSet Rs = pstm.executeQuery();
					model.setRowCount(0);
					while(Rs.next())
					{
						model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4)});
					}
				    //jtbl.repaint(); 
					//jtbl.invalidate();
					//model.fireTableDataChanged();
				}
				
				catch (Exception em)
				{
					System.out.println(em.getMessage());
				}
				
				JScrollPane pg = new JScrollPane(jtbl);
				pg.setBounds(60,330,650,100);
				add(pg);
				s1.addTable(jtbl);
				//pack();
			}
		});	
	}
}