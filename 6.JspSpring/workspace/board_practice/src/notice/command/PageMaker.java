package notice.command;

public class PageMaker {
	private int totalPage;
	private int startPage=1;
	private int endPage=1;
	private int realEndPage;
	
	private boolean prev;
	private boolean next;
	
	private int displayPageNum=10;
	
	Criteria cri = new Criteria();

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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

	

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	private void calcData() {
		endPage = (int) (Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum);
		startPage = (endPage-displayPageNum)+1;
		
		realEndPage =(int)(Math.ceil(totalPage/(double)cri.getPerPageNum()));
		
		
		
		
	}
	
	
	
	
	
	
}
