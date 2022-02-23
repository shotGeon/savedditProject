package k_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBC2 {

	public static void main(String[] args) {
		//접속정보
		String url ="jdbc:oracle:thin:@localhost:1521:xe";//주소
		String user ="KG96";
		String password ="java";
		
		//변수를 미리 생성
		Connection con = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		try {
			con=DriverManager.getConnection(url,user,password);
			//?는 값만 대체가능(컬럼명이나 키워드는 불가능)
			String sql="select *"//띄어쓰기 주의 줄바꾸고 나서 띄어준다.
					+ " from cart"
					+ " where cart_member = ?"
					+ " and cart_qty > ?";
			ps=con.prepareStatement(sql);
			//?에 값을 넣는다
			ps.setString(1,"a001");//첫번째 물음표에 값
			ps.setInt(2,5);//두번째 물음표에 값(수량이니깐 숫자)
			
			rs=ps.executeQuery();
			
			//메타데이터:데이터에 의한 데이터 (컬럼이 몇개가 있는지, 컬럼의 이름이 무엇인지 등등)
			ResultSetMetaData metaData=rs.getMetaData();
			
			int columnCount=metaData.getColumnCount();
			
			for(int i=1; i<=columnCount; i++){
				System.out.print(metaData.getColumnName(i)+"  ");
			}
			System.out.println();
			
			while(rs.next()){
				
				for(int i=1; i<=columnCount; i++){
					Object value=rs.getObject(i);//타입을 모를때나 전부를 가져올때
					System.out.print(value+"\t");
				}
				System.out.println();
				
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
