import java.sql.*;
import java.util.ArrayList;

public class CreateGroupClass
{
	String groupNumberx;
	public CreateGroupClass()
	{	
		
	}
	
	public void getGroupNumber(String x)
	{
		this.groupNumberx=x;
	}	
	public void createGroup(String name, String id, String sec,String part,String gno,int markx,int serialx,String semesterChoose)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagementsystem","root","");
			Statement stmt = con.createStatement();
			String sql2 = "INSERT INTO `create_group`(`sname`, `sid`, `ssec`, `spart`, `sgroupno`,`mark`,`serial`,`semester`) VALUES ('"+name+"','"+id+"','"+sec+"','"+part+"','"+gno+"','"+markx+"','"+serialx+"','"+semesterChoose+"')";
			int rs   = stmt.executeUpdate(sql2);
			serialx++;
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void createGroupInfo(String gname, String gno, String ptitle,int totalmembr,String semesterc)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagementsystem","root","");
			Statement stmt = con.createStatement();
			String sql1 = "INSERT INTO `create_group_info`(`groupname`, `groupnumber`, `projecttitle`, `totalmember`, `semester`) VALUES ('"+gname+"','"+gno+"','"+ptitle+"','"+totalmembr+"','"+semesterc+"')";
			int rs   = stmt.executeUpdate(sql1);
			con.close();
		}	
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public ArrayList<EditGroupClass> EditGroupList()
	{
		ArrayList<EditGroupClass> EditGroupList = new ArrayList<EditGroupClass>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagementsystem","root","");
			Statement stmt = con.createStatement();
			String sql= "select * from create_group where sgroupno='"+groupNumberx+"'";
			ResultSet rs   = stmt.executeQuery(sql);
			EditGroupClass tableList;	
			while(rs.next())
			{
				tableList = new EditGroupClass(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4));
				EditGroupList.add(tableList);
			}
			con.close();
		}	
		catch(Exception e)
		{
			System.out.println(e);
		}
		return EditGroupList;
	}
}