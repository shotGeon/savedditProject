package kr.or.ddit.dao.spring;

import java.sql.SQLException;
import java.util.List;

import com.jsp.command.SearchCriteria;
import com.jsp.dto.ReplyVO;

public interface ReplyDAOBean {

	void insertReply(ReplyVO reply) throws SQLException;
	void updateReply(ReplyVO reply) throws SQLException;
	void deleteReply(int rno) throws SQLException;
	
	int selectReplySeqNextValue() throws SQLException;
	List<ReplyVO> selectReplyListPage(int bno, SearchCriteria cri) throws SQLException;
	
	int countReply(int bno) throws SQLException;
}
