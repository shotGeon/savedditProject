import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCInsertTest {
	
	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String id ="KG96";
		String pwd ="java";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pwd);
			System.out.println("DB정상 연결");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("DB연결 실패");
		}
		
		try {
			String sql="INSERT INTO DEPARTMENT(deptno, deptname, floor) VALUES(?,?,?)";
			int deptno=1;
			String deptname="deptname";
			int floor=1;
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, deptno);
			pstm.setString(2, deptname);
			pstm.setInt(3, floor);
			
			pstm.executeUpdate();
			System.out.println("등록성공");
			
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("등록실패");
		}
		
	}
	
}
