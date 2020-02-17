package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.Dbconnect;

public class Menu 
{
	private int menu_id,resturant_id;
	private String menuname;
	
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public int getResturant_id() {
		return resturant_id;
	}
	public void setResturant_id(int resturant_id) {
		this.resturant_id = resturant_id;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public int addMenu() throws SQLException
	{
		
		Connection con = Dbconnect.dbconnect();
		
		String sql = "insert into menu(resturant_id,menuname) values(?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, resturant_id);
		ps.setString(2, menuname);
		
		
		int res = ps.executeUpdate();
		
		return res;
		
		
	}
	public int updateMenu() throws SQLException
	{

	
		
		Connection con = Dbconnect.dbconnect();
		
		//Sql Query
		String sql="update menu set menuname=? where menu_id=?";
		
		//PrepareStatement
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(2, menu_id );
		ps.setString(1,menuname);
		
		int res=ps.executeUpdate();
		
		return res;
    }
	public int deleteMenu() throws SQLException
	{

		Connection con = Dbconnect.dbconnect();
		
		//Sql Query
		String sql="delete from menu where  menu_id=? ";
		
		//PrepareStatement
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1, menu_id );
		
		
		
		int res=ps.executeUpdate();
		
		return res;
	}
	public ArrayList<Menu> showAllMenuById() throws SQLException
	{

		Connection con = Dbconnect.dbconnect();
		//Sql Query
		String sql="select *from menu where resturant_id=?";
		
		//PrepareStatement
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, resturant_id);
	
		
		//Execute
		
		ResultSet res=ps.executeQuery();
		
		ArrayList<Menu> allRest = new ArrayList<Menu>();
		
		while(res.next())
		{
			Menu m =new Menu();
			int m_id=res.getInt("menu_id");
			int r_id=res.getInt("resturant_id");
			String m_name=res.getString("menuname");
			
			
			
			m.setMenu_id(m_id);
			m.setResturant_id(r_id);
			m.setMenuname(m_name);
			
			
			
			allRest.add(m);
			
		}
		
		return allRest;
	}

}
