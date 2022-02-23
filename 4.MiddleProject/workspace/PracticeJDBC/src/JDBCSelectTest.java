import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCSelectTest {
	
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String id="KG96";
		String pwd="java";
		
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pwd);
			System.out.println("DB연결성공");
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("DB연결실패");
		}
		
		try {
			String sql="SELECT * FROM DEPARTMENT";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				int a = rs.getInt("deptno");
				String b = rs.getString("deptname");
				int c = rs.getInt("floor");
				
				System.out.println("deptno:"+a+" deptname:"+b+" floor:"+c);
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("조회실패");
		}
		
		
		
	}
	
	
	
	
}
