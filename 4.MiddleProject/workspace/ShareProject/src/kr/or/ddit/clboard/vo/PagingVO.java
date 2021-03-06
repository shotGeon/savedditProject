package kr.or.ddit.clboard.vo;

public class PagingVO {

	private int pageCount = 10; // 페이지 목록 게시되는 페이지 수 (초기값: 10)
	private int countPerPage = 10; // 한 페이지당 게시되는 게시물 건 수(초기값: 10)
	private int currentPageNo; // 현재 페이지 번호
	private int totalCount; // 전체 게시물 건 수

	private int totalPageCount; // 전체 페이지 수
	private int firstPageNo; // 현재 페이지 목록의 첫 페이지 번호
	private int lastPageNo; // 현재 페이지 목록의 마지막 페이지 번호
	private int firstRecNo; // 첫번째 레코드 번호
	private int lastRecNo; // 마지막 레코드 번호
	
	private String clboard_title;
	
	private String clboard_content;
	
	public String getClboard_content() {
		return clboard_content;
	}

	public void setClboard_content(String clboard_content) {
		this.clboard_content = clboard_content;
	}

	private String board_title_id;
	
	
	
	

	public String getClboard_title() {
		return clboard_title;
	}

	public void setClboard_title(String clboard_title) {
		this.clboard_title = clboard_title;
	}

	public String getBoard_title_id() {
		return board_title_id;
	}

	public void setBoard_title_id(String board_title_id) {
		this.board_title_id = board_title_id;
	}
	
	private String group;
	private String msg_from;
	
	
	public String getMsg_from() {
		return msg_from;
	}

	public void setMsg_from(String msg_from) {
		this.msg_from = msg_from;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public int getCountPerPage() {
		return countPerPage;
	}

	public void setCountPerPage(int countPerPage) {
		this.countPerPage = countPerPage;
	}

	public int getPageSize() {
		return pageCount;
	}

	public void setPageSize(int pageSize) {
		this.pageCount = pageSize;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	// 전체 페이지 수
	public int getTotalPageCount() {
		totalPageCount = ((getTotalCount() - 1) / getCountPerPage()) + 1;
		return totalPageCount;
	}

	// 시작페이지 번호
	public int getFirstPageNo() {
		firstPageNo = ((getCurrentPageNo() - 1) / getPageSize()) * getPageSize() + 1;
		return firstPageNo;
	}

	// 마지막 페이지 번호
	public int getLastPageNo() {
		lastPageNo = getFirstPageNo() + getPageSize() - 1;
		if (lastPageNo > getTotalPageCount()) {
			lastPageNo = getTotalPageCount();
		}
		return lastPageNo;
	}

	// 첫번째 레코드 번호
	public int getFirstRecNo() {
		firstRecNo = totalCount - (getCurrentPageNo() - 1) * getCountPerPage() - getCountPerPage() + 1;
		if(firstRecNo <= 0)
			firstRecNo = 1;
		return firstRecNo;
	}

	// 마지막 레코드 번호
	public int getLastRecNo() {
		lastRecNo = totalCount - (getCurrentPageNo() - 1) * getCountPerPage();
		return lastRecNo;
	}
}
