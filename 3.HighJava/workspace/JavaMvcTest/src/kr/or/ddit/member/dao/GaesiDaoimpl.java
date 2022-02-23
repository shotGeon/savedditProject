package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.or.ddit.member.vo.GaesiVO;
import kr.or.ddit.util.JDBCUtil;

public class GaesiDaoimpl implements IGaesiDao{
	private Connection conn;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet rs;
	
	private static IGaesiDao gsd ;
	
	private GaesiDaoimpl() {
	}
	
	public static IGaesiDao getInstance() {
		if(gsd==null) {
			gsd= new GaesiDaoimpl();
		}
		
		return gsd;
	}
	
	
	
	
	@Override
	public int insertBoard(GaesiVO gv) {
		int result=0;
		try {
			conn=JDBCUtil.getConnection();
			String sql="INSERT INTO JDBC_BOARD"
					+ "  (BOARD_NO, BOARD_TITLE, BOARD_WRITER, BOARD_DATE, BOARD_CONTENT)"
					+ " VALUES(BOARD_SEQ.NEXTVAL,?,?,SYSDATE,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, gv.getTitle());
			pstmt.setString(2, gv.getWriter());
			pstmt.setString(3, gv.getContent());
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		return result;
	}

	@Override
	public int updateBoard(int num, GaesiVO gv) {
		int result=0;
		try {
			conn=JDBCUtil.getConnection();
			String sql="UPDATE JDBC_BOARD"
					+ "    SET BOARD_TITLE=? "
					+ "   ,    BOARD_CONTENT=?"
					+ "   ,    BOARD_DATE=SYSDATE"
					+ "   WHERE BOARD_NO=? ";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, gv.getTitle());
			pstmt.setString(2, gv.getContent());
			pstmt.setInt(3, num);
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		return result;
	}

	@Override
	public int deleteBoard(int num) {
		int result=0;
		try {
			conn=JDBCUtil.getConnection();
			String sql="DELETE FROM JDBC_BOARD WHERE BOARD_NO=? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			result=pstmt.executeUpdate();
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
		return result;
	}

	@Override
	public List<GaesiVO> displayAllBoard() {
		List<GaesiVO> gaesiList = new ArrayList<>();
		
		try {
			conn = JDBCUtil.getConnection();
			String sql="SELECT * FROM JDBC_BOARD";
			pstmt= conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("BOARD_NO");
				String title = rs.getString("BOARD_TITLE");
				String content = rs.getString("BOARD_CONTENT");
				String writer = rs.getString("BOARD_WRITER");
				Date day = rs.getDate("BOARD_DATE");
				
				GaesiVO gv = new GaesiVO();
				gv.setNum(num);
				gv.setTitle(title);
				gv.setContent(content);
				gv.setWriter(writer);
				gv.setDay(day);
				
				gaesiList.add(gv);
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		
		
		return gaesiList;
	}



	@Override
	public GaesiVO checkBoard(GaesiVO gv) {
		int count = 0;
		try {
			conn=JDBCUtil.getConnection();
			String sql="SELECT * FROM JDBC_BOARD"
					+ "    WHERE 1=1";
			

			if(gv.getTitle()!=null && !gv.getTitle().equals("")) {
				sql+="AND BOARD_TITLE LIKE '%' || ? || '%' ";
			}
			if(gv.getContent()!=null && !gv.getContent().equals("")) {
				sql+=" AND BOARD_CONTENT LIKE '%' || ? || '%'";
			}
			if(gv.getWriter()!=null && !gv.getWriter().equals("")) {
				sql+="AND BOARD_WRITER LIKE '%' || ? || '%'";
			}
			
			
			pstmt=conn.prepareStatement(sql);
			
			int index=1;
			if(gv.getTitle()!=null&&!gv.getTitle().equals("")) {
				pstmt.setString(index++, gv.getTitle());
			
			}
			if(gv.getContent()!=null&&!gv.getContent().equals("")) {
				pstmt.setString(index++, gv.getContent());
			}
			if(gv.getWriter()!=null&&!gv.getWriter().equals("")) {
				pstmt.setString(index++, gv.getWriter());
			}
					
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				count++;
				gv.setNum(rs.getInt("BOARD_NO"));
				gv.setTitle(rs.getString("BOARD_TITLE"));
				gv.setContent(rs.getString("BOARD_CONTENT"));
				gv.setWriter(rs.getString("BOARD_WRITER"));
				gv.setDay(rs.getDate("BOARD_DATE"));	
			}
				
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			JDBCUtil.disConnect(conn, stmt, pstmt, rs);
		}
		if(count == 0) {
			gv = null;
		}
		
		return gv;
	}

}
