package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import util.Dbconnect;

public class Resturant {
	private int resturant_id;
	private String resturant_name,owner_name,email_id,resturant_type,state,city,address,password;
	
	public int getResturant_id() {
		return resturant_id;
	}
	public void setResturant_id(int resturant_id) {
		this.resturant_id = resturant_id;
	}
	public String getResturant_name() {
		return resturant_name;
	}
	public void setResturant_name(String resturant_name) {
		this.resturant_name = resturant_name;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getResturant_type() {
		return resturant_type;
	}
	public void setResturant_type(String resturant_type) {
		this.resturant_type = resturant_type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int register() throws SQLException
	{
		
		Connection con = Dbconnect.dbconnect();
		
		String sql = "insert into resturant values(?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, resturant_id);
		ps.setString(2, resturant_name);
		ps.setString(3, owner_name);
		ps.setString(4, email_id);
		ps.setString(5, resturant_type);
		ps.setString(6, state);
		ps.setString(7, city);
		ps.setString(8, address);
		ps.setString(9, password);
		
		int res = ps.executeUpdate();
		
		return res;
		
		
	}
	public int updateResturant() throws SQLException
	{

	
		
		Connection con = Dbconnect.dbconnect();
		
		//Sql Query
		String sql="update resturant set resturant_name=?,owner_name=?,email_id=?,resturant_type=?,state=?,city=?,address=?,password=? where  resturant_id=?";
		
		//PrepareStatement
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, resturant_name);
		ps.setString(2, owner_name);
		ps.setString(3, email_id);
		ps.setString(4, resturant_type);
		ps.setString(5, state);
		ps.setString(6, city);
		ps.setString(7, address);
		ps.setString(8, password);
		//Execute
		
		int res=ps.executeUpdate();
		
		return res;
}
	public int deleteResrurant() throws SQLException
	{

		Connection con = Dbconnect.dbconnect();
		
		//Sql Query
		String sql="delete from resturant where resturant_id=?";
		
		//PrepareStatement
		PreparedStatement ps=con.prepareStatement(sql);
		
		//ps.setString(1, name);
		//ps.setString(2, branch);
		ps.setInt(1, resturant_id);
		
		//Execute
		
		int res=ps.executeUpdate();
		
		return res;
	}
	public ResultSet loginResturant() throws SQLException
	{

		Connection con = Dbconnect.dbconnect();
		
		//Sql Query
		String sql="select * from resturant where email_id=? and password=?";
		
		//PrepareStatement
		PreparedStatement ps=con.prepareStatement(sql);
		
		//ps.setString(1, name);
		//ps.setString(2, branch);
		ps.setString(1, email_id);
		ps.setString(2, password);
		
		//Execute
		
		ResultSet res = ps.executeQuery();
		
		return res;
	}
	public ResultSet showResturantById() throws SQLException
	{
		Connection con = Dbconnect.dbconnect();
		String sql="select *from resturant where resturant_id=?";
		
		//PrepareStatement
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, resturant_id);
		
		//Execute
		
		ResultSet res=ps.executeQuery();
		
		return res;
	}
	
	public int getRestId() throws SQLException
	{
		Connection con = Dbconnect.dbconnect();
		String sql="select *from resturant where email_id=?";
		
		//PrepareStatement
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, email_id);
		
		//Execute
		
		ResultSet res=ps.executeQuery();
		
		int restid = 0;
		
		if(res.next())
		{
			restid = res.getInt("resturant_id");
		}
		
		return restid;
	}
	
	
	public ArrayList<Resturant> showAllresturant() throws SQLException
	{

		Connection con = Dbconnect.dbconnect();
		//Sql Query
		String sql="select *from resturant";
		
		//PrepareStatement
		PreparedStatement ps=con.prepareStatement(sql);
		
	
		
		//Execute
		
		ResultSet res=ps.executeQuery();
		
		ArrayList<Resturant> allRest = new ArrayList<Resturant>();
		
		while(res.next())
		{
			Resturant r =new Resturant();
			int r1=res.getInt("resturant_id");
			String rn=res.getString("resturant_name");
			String on=res.getString("owner_name");
			String e1=res.getString("email_id");
			String rt=res.getString("resturant_type");
			String s1=res.getString("state");
			String c1=res.getString("city");
			String a1=res.getString("address");
			String p1=res.getString("password");
			
			
			r.setResturant_id(r1);
			r.setResturant_name(rn);
			r.setOwner_name(on);
			r.setEmail_id(e1);
			r.setResturant_type(rt);
			r.setState(s1);
			r.setCity(c1);
			r.setAddress(a1);
			r.setPassword(p1);
			
			
			
			allRest.add(r);
			
		}
		
		return allRest;
	}

}

