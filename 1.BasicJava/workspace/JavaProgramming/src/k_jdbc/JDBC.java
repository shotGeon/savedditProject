package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {

	public static void main(String[] args) {
		/*
		 * JDBC(Java DataBase Connectivity)
		 * 자바와 데이터베이스를 연결해주는 라이브러리
		 * ojbc: 오라클 JDBC
		 * 
		 * JDBC 작성 단계
		 * 1. Connection 생성(DB연결)
		 * 2. Statement 생성(쿼리작성)
		 * 3. Query 실행
		 * 4. ResultSet에서 결과 추출(select인 경우)
		 * 5. ResultSet, Statement, Connection 닫기
		 */
		
		//데이터베이스 접속 정보
		String url ="jdbc:oracle:thin:@localhost:1521:xe";//주소
		String user ="KG96";
		String password ="java";
		
		//변수를 미리 생성
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		//연결을 위해 드라이버매니저(드라이버들을 관리) 클래스 호출 (서로 다른 자바와 오라클의 소통을 위해 드라이버를 사용)
		//getConnection에 정보를 넘겨주고 con이라는 객체를 얻는다.
		try {
			con=DriverManager.getConnection(url,user,password);
			//문자열로 쿼리 작성,;넣으면 안됨
			//prepareSatement에 넘겨주고 ps객체를 얻는다.
			//1.String sql="insert into member values('','','')";
			//2.ps=con.prepareStatement(sql);
			String sql="select * from member";
			ps=con.prepareStatement(sql);
			
			//executeQery는 resultset타입을 리턴 executeUpdate는 int 타입을 리턴
			//select
			rs=ps.executeQuery();
			
			//insert,update,delete,영향받은 행의 개수를 리턴해준다.
//			3.int result=ps.executeUpdate();
			
			//결과를 뽑아내기,rs에서 next메소드 사용(아무것도 하지 않은 상태에서 next를 사용하면 next가 첫번째행을 바라본다.(결과가 있으면 true
			//없으면 false를 반환하면서 while문을 빠져나간다.)
			while(rs.next()){
				String memId=rs.getString("MEM_ADD1");//컬럼타입에 따라 get뒤에가 달라짐,(1)은 컬럼의 인덱스를 나타냄(첫번째 컬럼)
				String memPass=rs.getString("MEM_ADD2");//컬럼명을 직접작성한 것
				System.out.println("MEM_ADD:"+memId+memPass);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rs!=null)try{rs.close();}catch(Exception e){}
			if(ps!=null)try{ps.close();}catch(Exception e){}
			if(con!=null)try{con.close();}catch(Exception e){}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
