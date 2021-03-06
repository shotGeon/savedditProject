package kr.or.ddit.admin.vo;

import java.util.Date;

public class AdminVO {
	
	private String admin_id;
	private String admin_pw;
	private String mem_id;
	private String mem_pass;
	private String mem_group;
	private String mem_addr1;
	private String mem_addr2;
	private String mem_hp;
	private String mem_name;
	private String mem_sub;
	private String class_id;
	private String birth;
	private String class_name;
	private Date class_start;
	private Date class_end;
	private String mem_chk;
	private int count;
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getMem_chk() {
		return mem_chk;
	}
	public void setMem_chk(String mem_chk) {
		this.mem_chk = mem_chk;
	}
	public String getMem_check() {
		return mem_chk;
	}
	public void setMem_check(String mem_check) {
		this.mem_chk = mem_check;
	}
	public Date getClass_start() {
		return class_start;
	}
	public void setClass_start(Date class_start) {
		this.class_start = class_start;
	}
	public Date getClass_end() {
		return class_end;
	}
	public void setClass_end(Date class_end) {
		this.class_end = class_end;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getClass_id() {
		return class_id;
	}
	public void setClass_id(String class_id) {
		this.class_id = class_id;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_pw() {
		return admin_pw;
	}
	public void setAdmin_pw(String admin_pw) {
		this.admin_pw = admin_pw;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pass() {
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}
	public String getMem_group() {
		return mem_group;
	}
	public void setMem_group(String mem_group) {
		this.mem_group = mem_group;
	}
	public String getMem_addr1() {
		return mem_addr1;
	}
	public void setMem_addr1(String mem_addr1) {
		this.mem_addr1 = mem_addr1;
	}
	public String getMem_addr2() {
		return mem_addr2;
	}
	public void setMem_addr2(String mem_addr2) {
		this.mem_addr2 = mem_addr2;
	}
	public String getMem_hp() {
		return mem_hp;
	}
	public void setMem_hp(String mem_hp) {
		this.mem_hp = mem_hp;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_sub() {
		return mem_sub;
	}
	public void setMem_sub(String mem_sub) {
		this.mem_sub = mem_sub;
	}
	@Override
	public String toString() {
		return "AdminVO [admin_id=" + admin_id + ", admin_pw=" + admin_pw + ", mem_id=" + mem_id + ", mem_pass="
				+ mem_pass + ", mem_group=" + mem_group + ", mem_addr1=" + mem_addr1 + ", mem_addr2=" + mem_addr2
				+ ", mem_hp=" + mem_hp + ", mem_name=" + mem_name + ", mem_sub=" + mem_sub + ", class_id=" + class_id
				+ ", birth=" + birth + ", class_name=" + class_name + ", class_start=" + class_start + ", class_end="
				+ class_end + ", mem_chk=" + mem_chk + ", count=" + count + "]";
	}
}
