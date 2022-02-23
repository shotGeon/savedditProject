package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC4 {

	public static void main(String[] args) {
		String url ="jdbc:oracle:thin:@localhost:1521:xe";//주소
		String user ="KG96";
		String password ="java";
		
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		try {
			con=DriverManager.getConnection(url,user,password);
			String sql="insert into cart values('a001','2021080500005','P201000018','15')";
			
			
			
			
			/*String sql="insert into buyer"
					+ " values('P40204','맥도날드','P402','기재은행','666-888-789456','오기재',"
					+ " '307-789','대전대덕구 오정동 운동빌딩','1008호','042-888-7894','042-888-7894',"
					+ "'kanggeon@naver.com','하기재','')";*/
			ps=con.prepareStatement(sql);
			
			int result=ps.executeUpdate();
			System.out.println(result);
			
	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null)try{rs.close();}catch(Exception e){}
			if(ps!=null)try{ps.close();}catch(Exception e){}
			if(con!=null)try{con.close();}catch(Exception e){}
		}


	}

}
