package kr.or.ddit.admin.service;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.admin.vo.AdminVO;
import kr.or.ddit.board.vo.PagingVO;

public interface IAdminService {

	    public AdminVO adCheck(AdminVO av);
	
	    // 회원 정보 전체 조회
	    public List<AdminVO> groupByAllMem(PagingVO pv);
		
	    // 회원 크기
	    public int memSize();
		
	    // 회원 정보 상세 조회
		public AdminVO selectMemberDetail(String memId);
		
		//회원 정보 수정
		public int updateMember(AdminVO vo);
		
		// 회원 정보 삭제
		public int deleteMember(String memId);
		
		// 비밀번호 초기화
		public int passwordReset(String memId);
		
		//조건 검색 반
		public List<AdminVO> findClass(String class_id);
		//조건 검색 그룹
		public List<AdminVO> findGroup(String mem_group);
		//조건 검색 이름
		public List<AdminVO> findName(String mem_name);
		
		public int insertMember(AdminVO vo);
		
		// 검색 사이즈
		public int findclasssize(String class_id);
		
		public int findgroupsize(String mem_group);
		
		public int findnamesize(String mem_name);
		
		//검색 페이징
		public List<AdminVO> groupByFindCls(PagingVO pv);
		
		public List<AdminVO> groupByFindGroup(PagingVO pv);
		
		public List<AdminVO> groupByFindName(PagingVO pv);
}
