package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC5 {

	public static void main(String[] args) {
		String url ="jdbc:oracle:thin:@localhost:1521:xe";//주소
		String user ="KG96";
		String password ="java";
		
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		try {
			con=DriverManager.getConnection(url,user,password);
			/*String sql="delete from buyer"
					+ " where buyer_id = ?";
			ps=con.prepareStatement(sql);
			ps.setString(1,"P40204");*/
			String sql="delete from cart"
					+ " where cart_no = ?";
			ps=con.prepareStatement(sql);
			ps.setString(1, "2021080500005");
			
			int result=ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(rs!=null)try{rs.close();}catch(Exception e){}
			if(ps!=null)try{ps.close();}catch(Exception e){}
			if(con!=null)try{con.close();}catch(Exception e){}
		}


	}

}
