package depart.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import depart.vo.DepartVO;
import util.SqlMapClientFactory;

public class DepartmentUpdate {
	
	private SqlMapClient smc;
	
	private int updateDepart() throws SQLException {
		smc = SqlMapClientFactory.getInstance();
		DepartVO dv = new DepartVO();
		
		dv.setDeptno(2);
		dv.setDeptname("대덕인재개발원");;
		dv.setFloor(4);
		
		
		return smc.update("depart.updateDepart", dv);
	}
	
	public static void main(String[] args) {
		DepartmentUpdate du = new DepartmentUpdate();
		int result =0;
		
		try {
			result=du.updateDepart();
			System.out.println("result:"+result);
			
			if(result>0) {
				System.out.println("수정성공");
			}else {
				System.out.println("수정실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
