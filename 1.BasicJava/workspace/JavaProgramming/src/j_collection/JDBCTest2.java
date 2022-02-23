package j_collection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest2 {

	public static void main(String[] args) {
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user="KG96";
		String password="java";
		
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con=DriverManager.getConnection(url,user,password);
			/*String sql="insert into cart(cart_member,cart_prod,cart_qty,cart_no)"
					+ " values(?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1,"a001");
			ps.setString(2, "P101000001");
			ps.setInt(3, 20);
			ps.setString(4, "2021080500001");*/
			String sql="delete from cart"
					+ " where cart_no= ?";
			ps=con.prepareStatement(sql);
			ps.setString(1,"2021080500001");
			int result =ps.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
			if(rs!=null)try{rs.close();}catch(Exception e){};
			if(ps!=null)try{ps.close();}catch(Exception e){};
			if(con!=null)try{con.close();}catch(Exception e){};
			
		}
		

	}

}
