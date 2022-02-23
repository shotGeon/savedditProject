package depart.vo;

import java.util.Date;

public class DepartVO {
	
	private int deptno;
	private String deptname;
	private int floor;
	private Date deday;
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public Date getDeday() {
		return deday;
	}
	public void setDeday(Date deday) {
		this.deday = deday;
	}
	
	

}
