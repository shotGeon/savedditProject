package member.vo;

public class PagingVO {
	private int totalCount;
	private int pageCount=10;
	private int listCount=5;
	private int currentPage;
	private int totalPage;
	
	private int firstPage;
	private int endPage;
	private int firstRecNo;
	private int lastRecNo;
	
	
	
	
	
	public void setFirstRecNo(int firstRecNo) {
		this.firstRecNo = firstRecNo;
	}
	public void setLastRecNo(int lastRecNo) {
		this.lastRecNo = lastRecNo;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public int getTotalPageCount() {
		totalPage=totalCount/listCount;
		if (totalCount%listCount>0) {
			totalPage++;
		}
		return totalPage;
	}
	
	
	public int getFirstPage() {
		firstPage = ((currentPage-1)/pageCount)*pageCount+1;
		return firstPage;
	}
	
	
	public int getEndPage() {
		endPage = firstPage+pageCount-1;
		if (endPage>totalPage) {
			endPage=totalPage;
		}
		return endPage;
	}
		
	public int getFirstRecNo() {
		firstRecNo = totalCount -(getCurrentPage()-1)*pageCount-pageCount+1;
		if(firstRecNo<=0) {
			firstRecNo=1;
		}
		return firstRecNo;
	}
	
	public int getLastRecNo() {
		lastRecNo = totalCount - (getCurrentPage()-1)*pageCount;
		return lastRecNo;
	}
	
	
	
	
	
	

}
