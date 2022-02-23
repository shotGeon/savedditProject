package depart.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import util.SqlMapClientFactory;

public class DepartmentDelete {
	
	private SqlMapClient smc;
	
	private int deleteDepart() throws SQLException {
		smc = SqlMapClientFactory.getInstance();
		int deptno = 1;
		
		return smc.delete("depart.deleteDepart", deptno);
	}
	
	public static void main(String[] args) {
		DepartmentDelete dd = new DepartmentDelete();
		int result=0;
		
		try {
			result=dd.deleteDepart();
			System.out.println("result:"+result);
			if(result>0) {
				System.out.println("삭제성공");
			}else {
				System.out.println("삭제실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
