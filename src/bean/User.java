package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import util.Dbconnect;

public class User { 
	
	private String user_id,user_name,user_email,user_state,user_city,user_address,user_password;
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_state() {
		return user_state;
	}
	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}
	public String getUser_city() {
		return user_city;
	}
	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public int userRegister() throws SQLException
	{
		
		Connection con = Dbconnect.dbconnect();
		
		String sql = "insert into user values(?,?,?,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user_id);
		ps.setString(2, user_name);
		ps.setString(3, user_email);
		ps.setString(4, user_state);
		ps.setString(5, user_city);
		ps.setString(6, user_address);
		ps.setString(7, user_password);
		
		int res = ps.executeUpdate();
		
		return res;
		
		
	}
	
	public int updateUser() throws SQLException
	{

	
		
		Connection con = Dbconnect.dbconnect();
		
		//Sql Query
		String sql="update user set user_name=?,user_email=?,user_state=?,user_city=?,user_address=?,user_password=? where  user_id=?";
		
		//PrepareStatement
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, user_name);
		ps.setString(2, user_email);
		
		ps.setString(3, user_state);
		ps.setString(4, user_city);
		ps.setString(5, user_address);
		ps.setString(6,user_password);
		ps.setString(7, user_id);
		//Execute
		
		int res=ps.executeUpdate();
		
		return res;
	}
	
	public int deleteUser() throws SQLException
	{

		Connection con = Dbconnect.dbconnect();
		
		//Sql Query
		String sql="delete from user where user_id=?";
		
		//PrepareStatement
		PreparedStatement ps=con.prepareStatement(sql);
		
		//ps.setString(1, name);
		//ps.setString(2, branch);
		ps.setString(1, user_id);
		
		//Execute
		
		int res=ps.executeUpdate();
		
		return res;
	}
	
	public ResultSet loginUser() throws SQLException
	{

		Connection con = Dbconnect.dbconnect();
		
		//Sql Query
		String sql="select *from user where user_id=? and user_password=?";
		
		//PrepareStatement
		PreparedStatement ps=con.prepareStatement(sql);
		
		//ps.setString(1, name);
		//ps.setString(2, branch);
		ps.setString(1, user_id);
		ps.setString(2, user_password);
		
		//Execute
		
		ResultSet res = ps.executeQuery();
		
		return res;
	}
	
	public ResultSet userLogin() throws SQLException
	{
		Connection con = Dbconnect.dbconnect();
		
		System.out.println("userid: "+user_id);
		System.out.println("Password: "+user_password);
		
		String sql = "Select *from user where user_id = ? and user_password = ?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user_id);
		ps.setString(2, user_password);
		
		ResultSet rs = ps.executeQuery();
		
		return rs;
		
	}
	public User showUserById() throws SQLException
	{

		Connection con = Dbconnect.dbconnect();
		//Sql Query
		String sql="select *from user where User_id=?";
		
		//PrepareStatement
		PreparedStatement ps=con.prepareStatement(sql);
		
	
		
		//Execute
		
		ResultSet res=ps.executeQuery();
		User u =new User();
			
		while(res.next())
		{
			
			String ui=res.getString("user_id");
			
			String un=res.getString("user_name");
			String ue=res.getString("user_email");
			
			String us=res.getString("user_state");
			String uc=res.getString("user_city");
			String ua=res.getString("user_address");
			String up=res.getString("user_password");
			
			
			u.setUser_id(ui);
			u.setUser_name(un);
			u.setUser_email(ue);
			u.setUser_state(us);
			u.setUser_city(uc);
			u.setUser_address(ua);
			u.setUser_password(up);
			
			
			
			
		}
		
		return u;
	}


}
