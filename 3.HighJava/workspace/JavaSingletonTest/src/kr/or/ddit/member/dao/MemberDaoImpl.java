package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.util.JDBCUtil;
import kr.or.ddit.util.JDBCUtil3;

public class MemberDaoImpl implements IMemberDao {	
	
	private static IMemberDao memDao;
	
	private MemberDaoImpl() {
		
	}
	
	public static IMemberDao getInstance() {
		if(memDao ==null) {
			memDao = new MemberDaoImpl();
		}
		
		return memDao;
	}
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	@Override
	public int insertMember(MemberVO mv) {
		int cnt=0;
		try {
			conn = JDBCUtil.getConnection();
			String sql ="INSERT INTO MYMEMBER" 
		 	       + "(MEM_ID, MEM_NAME, MEM_TEL, MEM_ADDR)"  
				   + "VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mv.getMemId());
			pstmt.setString(2, mv.getMemName());
			pstmt.setString(3, mv.getMemTel());
			pstmt.setString(4, mv.getMemAddr());
			
			cnt=pstmt.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);			
		}
		return cnt;
	}

	@Override
	public boolean chkMember(String memId) {
	   
		boolean chk=false;
		
		try {	
			conn = JDBCUtil.getConnection();
			String sql="select count(*) as cnt from mymember"
					   + " where mem_id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			rs=pstmt.executeQuery();
			
			int cnt=0;
			while(rs.next()) {
				cnt=rs.getInt("cnt");
			}
			
			if(cnt>0) {
				chk=true;
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
		return chk;
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		
		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		try {
			conn = JDBCUtil3.getConnection();
			String sql ="SELECT * FROM MYMEMBER";
			
			stmt = conn.createStatement();
						
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				String memId = rs.getString("mem_id");
				String memName = rs.getString("mem_name");
				String memTel = rs.getString("mem_tel");
				String memAddr = rs.getString("mem_addr");
				
				MemberVO mv = new MemberVO();
				mv.setMemId(memId);
				mv.setMemName(memName);
				mv.setMemTel(memTel);
				mv.setMemAddr(memAddr);
				
				memList.add(mv);
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
		
		return memList;
	}

	@Override
	public int updateMember(MemberVO mv) {
		
		int cnt=0;
		
		try {
			conn =JDBCUtil.getConnection();
			String sql=" update mymember " 
					+ " set mem_name= ? "  
					+ " ,mem_tel= ? "  
					+ " ,mem_addr= ? "  
					+ " where mem_id = ?" ;
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mv.getMemName());
			pstmt.setString(2, mv.getMemTel());
			pstmt.setString(3, mv.getMemAddr());
			pstmt.setString(4, mv.getMemId());
			
			cnt =pstmt.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		
		int cnt=0;
		
		try {
			conn=JDBCUtil.getConnection();
			
			String sql="DELETE FROM MYMEMBER WHERE MEM_ID= ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			
			cnt=pstmt.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
		return cnt;
	}

	@Override
	public List<MemberVO> getSearchMember(MemberVO mv) {
		
		List<MemberVO> memList = new ArrayList<>();
		
		try {
			conn=JDBCUtil.getConnection();
			
			//1=1??? ???????????? ?????????????????? AND??? ????????? ????????? ??????.(?????? AND??? ????????? ?????? ???????????????
			//???????????? ????????? ??????.)
			String sql ="SELECT * FROM MYMEMBER WHERE 1=1";
			
			//????????? ?????? ?????? ?????? ??????
			//null???????????? ????????? ?????????(null??? ?????? ??????????????? ??????.)
			if(mv.getMemId() !=null&&!mv.getMemId().equals("")) {
				//?????? sql?????? ??????
				sql+=" AND MEM_ID= ? ";
			}
			if(mv.getMemName() !=null&&!mv.getMemName().equals("")) {
				//?????? sql?????? ??????
				sql+=" AND MEM_NAME= ? ";
			}
			if(mv.getMemTel() !=null&&!mv.getMemTel().equals("")) {
				//?????? sql?????? ??????
				sql+=" AND MEM_Tel= ? ";
			}
			if(mv.getMemAddr() !=null&&!mv.getMemAddr().equals("")) {
				//?????? sql?????? ??????
				//?????? ????????? ???????????? ????????? ??? ?????? LIKE??????
				sql+=" AND MEM_ADDR LIKE '%' || ? || '%' ";
			}
			
			pstmt = conn.prepareStatement(sql);
			
			//index???(???????)??? ???????????? ????????? ?????? ??????
			int index=1;
			
			if(mv.getMemId() !=null&&!mv.getMemId().equals("")) {
				//?????????????????? index??? ??????
				pstmt.setString(index++, mv.getMemId());
			}
			
			if(mv.getMemName() !=null&&!mv.getMemName().equals("")) {
				//?????????????????? index??? ??????
				pstmt.setString(index++, mv.getMemName());
			}
			
			if(mv.getMemTel() !=null&&!mv.getMemTel().equals("")) {
				//?????????????????? index??? ??????
				pstmt.setString(index++, mv.getMemTel());
			}
			
			if(mv.getMemAddr() !=null&&!mv.getMemAddr().equals("")) {
				//?????????????????? index??? ??????
				pstmt.setString(index++, mv.getMemAddr());
			}
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO mv2 = new MemberVO();
				
				mv2.setMemId(rs.getString("mem_id"));
				mv2.setMemName(rs.getString("mem_name"));
				mv2.setMemTel(rs.getString("mem_tel"));
				mv2.setMemAddr(rs.getString("mem_addr"));
				
				memList.add(mv2);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
		
		
		return memList;
	}

}
