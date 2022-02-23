package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC3 {

	public static void main(String[] args) {
		String url ="jdbc:oracle:thin:@localhost:1521:xe";//주소
		String user ="KG96";
		String password ="java";
		
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		try {
			con=DriverManager.getConnection(url,user,password);
			String sql="select *"
					+ " from member"
					+ " where mem_id = ?";
			ps=con.prepareStatement(sql);
			ps.setString(1, "a001");
			rs=ps.executeQuery();
			
			while(rs.next()){
			  	String memadd=rs.getString("MEM_ADD1");
				String memadd2=rs.getString("MEM_ADD2");
				String memname=rs.getString("MEM_NAME");
				System.out.println("이름은 "+memname+"입니다");
				System.out.println("주소는 "+memadd+memadd2+"입니다.");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally{
			
			if(rs!=null)try{rs.close();}catch(Exception e){}
			if(ps!=null)try{ps.close();}catch(Exception e){}
			if(con!=null)try{con.close();}catch(Exception e){}
			
		}

	}

}
