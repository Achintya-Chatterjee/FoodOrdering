package bean;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.Dbconnect;

public class MenuItem {
	
	private int menuitem_id,menu_id,resturant_id;
	private String itemname,image,description;
	private double price;
	
	public int getMenuitem_id() {
		return menuitem_id;
	}
	public void setMenuitem_id(int menuitem_id) {
		this.menuitem_id = menuitem_id;
	}
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
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int addMenuItem() throws SQLException
	{
		
		Connection con = Dbconnect.dbconnect();
		
		String sql = "insert into menuitem(resturant_id,menu_id,itemname,image,description,price) values(?,?,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, resturant_id);
		ps.setInt(2, menu_id );
		ps.setString(3, itemname);
		ps.setString(4, image);
		ps.setString(5, description);
		ps.setDouble(6, price);
		int res = ps.executeUpdate();
		
		return res;
		
		
	}
	public int updateMenuItem() throws SQLException
	{

	
		
		Connection con = Dbconnect.dbconnect();
		
		//Sql Query
		String sql="update menuitem set itemname=?, image=?,description=?,price=? where menuitem_id=? ";
		
		//PrepareStatement
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1, itemname);
		ps.setString(2, image);
		ps.setString(3, description);
		ps.setDouble(4, price);
		ps.setInt(5, menuitem_id);
		
		int res=ps.executeUpdate();
		
		return res;
    }
	public int deleteMenuItem() throws SQLException
	{

		Connection con = Dbconnect.dbconnect();
		
		//Sql Query
		String sql="delete from menuitem where menuitem_id=?  ";
		
		//PrepareStatement
		PreparedStatement ps=con.prepareStatement(sql);
		
		
		ps.setInt(1, menuitem_id );

		
		int res=ps.executeUpdate();
		
		return res;
	}
	public ArrayList<MenuItem> showAllMenuItem() throws SQLException
	{

		Connection con = Dbconnect.dbconnect();
		//Sql Query
		String sql="select *from menuitem";
		
		//PrepareStatement
		PreparedStatement ps=con.prepareStatement(sql);
		
	
		
		//Execute
		
		ResultSet res=ps.executeQuery();
		
		ArrayList<MenuItem> allRest = new ArrayList<MenuItem>();
		
		while(res.next())
		{
			MenuItem m =new MenuItem();
			int menuitem_id=res.getInt("menuitem_id");
			int r_id=res.getInt("resturant_id");
			int m_id=res.getInt("menu_id");
			String m_name=res.getString("itemname");
			String m_image=res.getString("image");
			String	m_des=res.getString("description");
			double m_price=res.getDouble("price");
			
			
			m.setMenuitem_id(menuitem_id);
			m.setResturant_id(r_id);
			m.setMenu_id(m_id);
			m.setItemname(m_name);
			m.setImage(m_image);
			m.setDescription(m_des);
			m.setPrice(m_price);
			allRest.add(m);
			
		}
		
		return allRest;
	}
	public ArrayList<MenuItem> showMenuByResturantId() throws SQLException
	{

		Connection con = Dbconnect.dbconnect();
		//Sql Query
		String sql="select *from menuitem where resturant_id=?";
		
		//PrepareStatement
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, resturant_id);
	
		
		//Execute
		
		ResultSet res=ps.executeQuery();
		
		ArrayList<MenuItem> allRest = new ArrayList<MenuItem>();
		
		while(res.next())
		{
			MenuItem m =new MenuItem();
			int menuitem_id=res.getInt("menuitem_id");
			int r_id=res.getInt("resturant_id");
			int m_id=res.getInt("menu_id");
			String m_name=res.getString("itemname");
			String m_image=res.getString("image");
			String	m_des=res.getString("description");
			double m_price=res.getDouble("price");
			
			
			m.setMenuitem_id(menuitem_id);
			m.setResturant_id(r_id);
			m.setMenu_id(m_id);
			m.setItemname(m_name);
			m.setImage(m_image);
			m.setDescription(m_des);
			m.setPrice(m_price);
			allRest.add(m);
			
		}
		
		return allRest;
	}
	public ResultSet showAllMenuItemByItemId() throws SQLException
	{

		Connection con = Dbconnect.dbconnect();
		//Sql Query
		String sql="select *from menuitem where menuitem_id=?";
		
		//PrepareStatement
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, menuitem_id);
	
		
		//Execute
		
		ResultSet res=ps.executeQuery();
		
		/*
		 * MenuItem m =new MenuItem();
		 * 
		 * while(res.next()) {
		 * 
		 * int menuitem_id=res.getInt("menuitem_id"); int
		 * r_id=res.getInt("resturant_id"); int m_id=res.getInt("menu_id"); String
		 * m_name=res.getString("itemname"); String m_image=res.getString("image");
		 * String m_des=res.getString("description"); double
		 * m_price=res.getDouble("price");
		 * 
		 * 
		 * m.setMenuitem_id(menuitem_id); m.setResturant_id(r_id); m.setMenu_id(m_id);
		 * m.setItemname(m_name); m.setImage(m_image); m.setDescription(m_des);
		 * m.setPrice(m_price);
		 * 
		 * 
		 * 
		 * }
		 */
		
		return res;
	}
	
}
