package notice.command;

public class Criteria {
	
	private int page=1;
	private int startRowNum=0;
	private int perPageNum=10;
	public Criteria() {
	}
	
	public Criteria(String pageStr, String perPageNumStr) {
		
		this.page = Integer.parseInt(pageStr);
		this.perPageNum = Integer.parseInt(perPageNumStr);
		setStartRowNum();
		
	}
	
	
	
	
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page<1) {
			this.page=1;
		}else {
			this.page=page;
		}
		setStartRowNum();
	}

	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum<1) {
			this.perPageNum = 10;
		}else {
			this.perPageNum = perPageNum;
		}
		setStartRowNum();
	}

	private void setStartRowNum() {
		this.startRowNum = (this.page-1)*perPageNum;
	}

}
