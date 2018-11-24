import javax.swing.*;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ProjectFrame extends JFrame
{
	CreateGroup cGroup;
	EditGroup eGroup;
	ProjectManagement pManagement;
	ShowGroups sGroups;
	JTabbedPane tab;
	CreateGroupClass g1;
	EditGroup s1;
	ProjectManagement p1;
	EditGroupClass e1;
	ProjectMarking f1;
	ProjectMarking pMarking;
	
	public ProjectFrame()
	{
		this.setTitle("AIUB PROJECT MANAGEMENT SYSTEM");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		addComponentToFrame();
		this.setVisible(true);
	}
	public void addComponentToFrame()
	{
		this.g1 = new CreateGroupClass();
		this.s1 = new EditGroup();
		this.p1 = new ProjectManagement();
		this.e1 = new EditGroupClass();
		this.f1 = new ProjectMarking();
		this.cGroup = new CreateGroup(this,g1);
		this.eGroup	= new EditGroup(this,g1,e1,s1);
		this.pManagement = new ProjectManagement(this,g1,e1,p1);
		this.pMarking = new ProjectMarking(this,g1,e1,p1);
		this.sGroups = new ShowGroups(this);
		this.tab = new JTabbedPane();
		this.tab.addTab("Create Group", this.cGroup);
		this.tab.addTab("Edit Group", this.eGroup);
		this.tab.addTab("Project Management",this.pManagement);
		this.tab.addTab("Show Groups",this.sGroups);
		this.tab.addTab("Student Marking",this.pMarking);
		this.add(tab);
	}
}