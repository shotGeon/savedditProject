package command;

public class Criteria {
	
	private int page =1;
	private int startRowNum=0;
	private int perPageNum=10;
	
	public Criteria() {
	}
	
	public Criteria(int page, int perPageNum) {
		this.page = page;
		if(page<1) {
			this.page=1;
		}
		this.perPageNum = perPageNum;
		
		setStartRowNum();
	}
	
	public Criteria(String page, String perPageNum) {
		this.page = Integer.parseInt(page);
		if(this.page<1) {
			this.page=1;
		}
		this.perPageNum = Integer.parseInt(perPageNum);
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

	public void setStartRowNum() {
		this.startRowNum = (this.page-1)*perPageNum;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum<1) {
			this.perPageNum =10;
		}else {
			this.perPageNum = perPageNum;
		}
	}
	
	
	
	

}
