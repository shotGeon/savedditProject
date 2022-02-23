package depart.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import depart.vo.DepartVO;
import util.SqlMapClientFactory;

public class DepartmentSelect {
	private SqlMapClient smc = SqlMapClientFactory.getInstance();
	
	 
	
	 public List<DepartVO> getList() throws SQLException{
		 return smc.queryForList("depart.selectDepart");
	 }
	 
	public static void main(String[] args) {
		List<DepartVO> list = new ArrayList<DepartVO>();
		DepartmentSelect dmc = new DepartmentSelect();
		
		try {
			list = dmc.getList();
			for(int i=0; i<list.size(); i++) {
				DepartVO dv = list.get(i);
				
				System.out.println("Deptno"+dv.getDeptno());
				System.out.println("Deptname"+dv.getDeptname());
				System.out.println("Floor"+dv.getFloor());
				System.out.println("Deday"+dv.getDeday());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
