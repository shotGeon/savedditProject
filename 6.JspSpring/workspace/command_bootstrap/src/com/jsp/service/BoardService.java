package com.jsp.service;

import java.sql.SQLException;
import java.util.Map;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.BoardVO;

public interface BoardService {
	
    Map<String, Object> getBoardList(SearchCriteria cri) throws SQLException;
	
	BoardVO getBoard(int bno) throws SQLException;
	
	BoardVO getBoardForModify(int bno) throws SQLException;
	
	void regist(BoardVO board) throws SQLException;
	
	void modify(BoardVO board) throws SQLException;
	
	void remove(int bno) throws SQLException;
	
	

}
