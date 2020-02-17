package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.Dbconnect;

public class CartBean
{
	int cartid,quantity,menuitem_id;
	String userid;
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getMenuitem_id() {
		return menuitem_id;
	}
	public void setMenuitem_id(int menuitem_id) {
		this.menuitem_id = menuitem_id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public int addToCart() throws SQLException
	{
		
		Connection con = Dbconnect.dbconnect();
		
		String sql = "insert into cart(user_id,menuitem_id,quantity) values(?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		System.out.println("Userid in addToCart(): "+userid);
		ps.setString(1, userid);
		ps.setInt(2, menuitem_id);
		ps.setInt(3, 1);
		
		int res = ps.executeUpdate();
		
		return res;
				
	}
	
	public int updateCartItemQuantity() throws SQLException
	{
		
		Connection con = Dbconnect.dbconnect();
		
		String sql = "update cart set quantity=? where cartid=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, quantity);
		ps.setInt(2, cartid);
		
		int res = ps.executeUpdate();
		
		return res;
				
	}
	
	public int removeCartItem() throws SQLException
	{
		
		Connection con = Dbconnect.dbconnect();
		
		String sql = "delete from cart where cartid=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setInt(1, cartid);
		
		int res = ps.executeUpdate();
		
		return res;
				
	}
	
	public int getTotalCartByUserid() throws SQLException
	{
		Connection con = Dbconnect.dbconnect();
		
		String sql = "select *from cart where user_id=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userid);
		
		ResultSet rs = ps.executeQuery();
		
		int total_item = 0;
		
		while(rs.next())
		{
			total_item++;
		}
		//System.out.println("Total cart: "+total_item);
		return total_item;
	}
	
	public boolean checkItem() throws SQLException
	{
		Connection con = Dbconnect.dbconnect();
		
		String sql = "select *from cart where user_id=? and menuitem_id=?";
		
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, userid);
		ps.setInt(2,menuitem_id);
		
		ResultSet rs = ps.executeQuery();
		
		boolean res  = false;
		
		while(rs.next())
		{
			res  = true;
		}
		//System.out.println("Total cart: "+total_item);
		return res;
	}
	
	public ArrayList<CartBean> getCartItemByUserid() throws SQLException
	{

		Connection con = Dbconnect.dbconnect();
		//Sql Query
		String sql="select *from cart where user_id=?";
		
		//PrepareStatement
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, userid);
	
		//Execute
		
		ResultSet res=ps.executeQuery();
		
		ArrayList<CartBean> allitems = new ArrayList<CartBean>();
		
		while(res.next())
		{
			CartBean cb =new CartBean();
			int cid=res.getInt("cartid");
			int mid=res.getInt("menuitem_id");
			String userid=res.getString("user_id");
			int quantity=res.getInt("quantity");
			
			cb.setCartid(cid);
			cb.setUserid(userid);
			cb.setMenuitem_id(mid);
			cb.setQuantity(quantity);
			
			allitems.add(cb);
			
		}
		
		return allitems;
	}

	public static void main(String[] args) throws SQLException 
	{
		CartBean cb = new CartBean();
		cb.setUserid("subhajit10");
		int t = cb.getTotalCartByUserid();
		System.out.println(t);
		
		
	}
}
