package command;

public class PageMaker {
	private int totalCount;
	private int startPage =1;
	private int endPage=1;
	private int realEndPage;
	private boolean prev=true;
	private boolean next=true;
	
	private int displayPageNum=2;
	private Criteria cri = new Criteria();
	
    
	
	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", realEndPage=" + realEndPage + ", prev=" + prev + ", next=" + next + ", displayPageNum="
				+ displayPageNum + ", cri=" + cri + "]";
	}
	
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcDate();
	}
	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
	
	public int getRealEndPage() {
		return realEndPage;
	}
	
	public boolean isPrev() {
		return prev;
	}
	
	public boolean isNext() {
		return next;
	}
	
	private void calcDate() {
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
		startPage = (endPage-displayPageNum)+1;
		
		realEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum()));
		
		if(startPage<0) {
			startPage =1;
		}
		
		
		
		if(endPage >realEndPage) {
			endPage = realEndPage;
		}
		
		prev = startPage ==1 ? false : true;
		next = endPage >= realEndPage ? false :true;
	}
	
	
	
	
}
