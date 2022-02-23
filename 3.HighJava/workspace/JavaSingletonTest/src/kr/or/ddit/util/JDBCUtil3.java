package kr.or.ddit.util;
/**
 * db.properties파일의 내용으로 DB정보를 설정하는 방법
 * 방법1) Properties객체 이용하기
 * 방법2) ResourceBundle 객체 이용하기
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtil3 {
	static ResourceBundle bundle; // ResourceBundle 객체변수 선언
	
	static {
		bundle = ResourceBundle.getBundle("db");
		
		try {
			Class.forName(bundle.getString("driver"));
		}catch(ClassNotFoundException ex) {
			System.out.println("드라이버 로딩 실패!!!");
			ex.printStackTrace();
		}
	}
	
	/**
	 * 커넥션 객체 생성
	 * @return
	 */
	public static Connection getConnection() {
		
		try {
			return DriverManager.getConnection
					      (bundle.getString("url"),
					       bundle.getString("user"),
					       bundle.getString("pass"));
		}catch(SQLException ex) {
			System.out.println("DB 연결 실패!!!");
			ex.printStackTrace();
			
			return null;
		}
	}
	
	/**
	 * 자원반납
	 * @param conn
	 * @param stmt
	 * @param pstmt
	 */
	public static void disConnect(
			Connection conn,
			Statement stmt,
			PreparedStatement pstmt,
			ResultSet rs
			) {
		if(rs!=null)try {rs.close();}catch(SQLException ex) {}
		if(pstmt!=null)try {pstmt.close();}catch(SQLException ex) {}
		if(stmt!=null)try {stmt.close();}catch(SQLException ex) {}
		if(conn!=null)try {conn.close();}catch(SQLException ex) {}
	}
}
