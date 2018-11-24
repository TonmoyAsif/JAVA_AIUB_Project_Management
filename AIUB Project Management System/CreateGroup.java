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

public class CreateGroup extends JPanel
{
	JButton cSaveButton;
	JTextField groupNumberField;
	JTextField groupNameField;
	JTextField projectTitleField;
	JLabel groupNumberLabel;
	JLabel groupNameLabel;
	JLabel projectTitleLabel;
	JLabel numberOfMember;
	JTextField numberOfMemberField;
	JTable cTable;
	JScrollPane sp;
	ProjectFrame frame;
	JComboBox<String> cSemesterChoose;
	CreateGroupClass g1;
	public int serialx=1;
	public int markx=0;
	private String semesterNames[]={"2017-18,FALL","2017-18,SUMMER","2017-18,SPRING","2018-19,FALL","2018-19,SUMMER","2018-19,SPRING"};
	String data[][]={ {"","","",""},{"","","",""},{"","","",""},{"","","",""},{"","","",""}};
	String column[]={"NAME","ID","SECTION","PART"};
	
	public CreateGroup()
	{
		
	}
	public CreateGroup(ProjectFrame frame,CreateGroupClass g1)
	{
		this.g1=g1;
		this.frame = frame;
		this.setLayout(null);
		this.setBackground(new Color( 38, 116, 93 ));
		addComponentToPanel();
	}
	public void addComponentToPanel()
	{
		Icon image=new ImageIcon(getClass().getResource("SAVE.png"));
		this.cSaveButton = new JButton();
		cSaveButton.setIcon(image);
		this.cSaveButton.setBounds(333, 470, 100, 30);
		this.add(cSaveButton);
		this.groupNumberLabel=new JLabel("Group Number");
		this.groupNumberLabel.setFont(new Font("Arrus BT",Font.BOLD,14));
	    this.groupNameLabel=new JLabel("Group Name");
		this.groupNameLabel.setFont(new Font("Arrus BT",Font.BOLD,14));
	    this.projectTitleLabel=new JLabel("Project Title");
		this.projectTitleLabel.setFont(new Font("Arrus BT",Font.BOLD,14));
		this.numberOfMember=new JLabel("No. of Member");
		this.numberOfMember.setFont(new Font("Arrus BT",Font.BOLD,14));
		this.groupNumberField=new JTextField(30);
	    this.groupNameField=new JTextField(70);
	    this.projectTitleField=new JTextField(70);
		this.numberOfMemberField=new JTextField(30);
		this.groupNumberLabel.setBounds(50, 25, 120, 30);
	    this.groupNameLabel.setBounds(50, 80, 120, 30);
	    this.projectTitleLabel.setBounds(50, 130, 120, 30);
		this.groupNumberField.setBounds(300, 25, 60, 30);
	    this.groupNameField.setBounds(300, 80, 300, 30);
	    this.projectTitleField.setBounds(300, 130, 300, 30);
		this.numberOfMember.setBounds(50, 190, 120, 30);
		this.numberOfMemberField.setBounds(300, 190, 50, 30);
		this.add(groupNumberLabel);
		this.add(groupNameLabel);
		this.add(projectTitleLabel);
		this.add(groupNumberField);
		this.add(groupNameField);
		this.add(projectTitleField);
		this.add(numberOfMember);
		this.add(this.numberOfMemberField);
		this.cSemesterChoose=new JComboBox<>(semesterNames);
		this.cSemesterChoose.setMaximumRowCount(3);
		this.cSemesterChoose.setBounds(50, 250, 150, 30);
		this.add(cSemesterChoose);
		this.cTable=new JTable(data,column);
		this.sp=new JScrollPane(cTable);
		this.sp.setBounds(60,330,650,100);
		this.add(sp);
		this.cSaveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String stdnumbr=numberOfMemberField.getText();
				int stdNum;
				stdNum = Integer.valueOf(stdnumbr);
				String gno=groupNumberField.getText();
				String gname=groupNameField.getText();
				String ptitle=projectTitleField.getText();
				String semesterChoose = cSemesterChoose.getSelectedItem().toString();
				g1.createGroupInfo(gname,gno,ptitle,stdNum,semesterChoose);
				try
				{
					serialx=1;
					markx=0;
					int rows=cTable.getRowCount();
					for(int row = 0; row<stdNum; row++)
					{
						String name = (String)cTable.getValueAt(row, 0);
						String id = (String)cTable.getValueAt(row, 1);
						String sec = (String)cTable.getValueAt(row, 2);
						String part = (String)cTable.getValueAt(row, 3);
						
						g1.createGroup(name,id,sec,part,gno,markx,serialx,semesterChoose);
						serialx++;
					}
					JOptionPane.showMessageDialog(null, "Group Created to DATABASE Successfully");
				}
				catch(Exception e2)
				{
					System.out.println(e2);
				}
			}
		});
	}
}