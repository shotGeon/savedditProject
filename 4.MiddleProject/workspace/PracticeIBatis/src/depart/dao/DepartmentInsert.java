package depart.dao;

import java.sql.Date;
import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import depart.vo.DepartVO;
import util.SqlMapClientFactory;

public class DepartmentInsert {
	private SqlMapClient smc;
	private DepartmentInsert di;
	
	
	private int insertDepart() throws SQLException {
		smc= SqlMapClientFactory.getInstance();
		di = new DepartmentInsert();
		java.util.Date d = new java.util.Date();
		
		
		d=di.transFormDate("2021", "11", "11");
		
		System.out.println("d"+d);

		DepartVO dv = new DepartVO();	
		dv.setDeptno(5);
		dv.setDeptname("5");
		dv.setFloor(5);
		dv.setDeday(d);
		
		return (Integer) smc.insert("depart.insertDepart", dv);
		
	}
	
	private Date transFormDate(String year, String month, String day) {
		
		String toDate = year+"-"+month+"-"+day;
		Date d = Date.valueOf(toDate);
		
		return d;
	}
	
	public static void main(String[] args) {
		DepartmentInsert di = new DepartmentInsert();
		try {
			int count = di.insertDepart();
			System.out.println("count:"+count);
			if(count>0) {
				System.out.println("등록성공");
			}else {
				System.out.println("등록실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
