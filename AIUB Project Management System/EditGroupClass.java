import java.sql.*;
import java.util.ArrayList;
public class EditGroupClass
{
	public String 	name;
	public String 	id;
	public String 	sec;
	public String 	part;
	
	public String groupNumberx;
	
	public EditGroupClass()
	{
		this("undefined","undefined","undefined","undefined");
	}
	
	public EditGroupClass(String name, String id, String sec,String part)
	{
		this.name=name;
		this.id=id;
		this.sec=sec;
		this.part=part;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setId(String id)
	{
		this.id=id;
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public void setSec(String sec)
	{
		this.sec=sec;
	}
	
	public String getSec()
	{
		return this.sec;
	}
	
	public void setPart(String part)
	{
		this.part=part;
	}
	
	public String getPart()
	{
		return this.part;
	}
	
	public void getGroupNumber(String x)
	{
		this.groupNumberx=x;
	}
	
	public void editGroup(String name, String id, String sec,String part,String gno,int serialx,int markx,String semesterc)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagementsystem","root","");
			Statement stmt = con2.createStatement();
			String sql2 = "UPDATE create_group SET sname='"+name+"',sid='"+id+"',ssec='"+sec+"',spart='"+part+"',mark='"+markx+"' WHERE sgroupno='"+gno+"' and serial='"+serialx+"' and semester='"+semesterc+"'";
			int rs2   = stmt.executeUpdate(sql2);
			con2.close();
			}
			
		catch(Exception e5)
		{
			System.out.println(e5);
		}
	}
	
	public void editGroupInfo(String gname, String gno, String ptitle,int totalmembr,String semesterc)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectmanagementsystem","root","");
			Statement stmt = con.createStatement();
			String sql1 = "UPDATE create_group_info SET groupname='"+gname+"',projecttitle='"+ptitle+"',totalmember='"+totalmembr+"' WHERE groupnumber='"+gno+"' and semester='"+semesterc+"'";
			int rs   = stmt.executeUpdate(sql1);
			con.close();	
			}
			
		catch(Exception e4)
		{
			System.out.println(e4);
		}
	}
}