package command;

public class SearchCriteria extends Criteria {
	private String searchType="";
	private String keyword="";
	
	public SearchCriteria() {
	}

	public SearchCriteria(String page, String perPageNum,
						  String searchType, String keyword) {
		super(page, perPageNum);
		this.searchType=searchType;
		this.keyword=keyword;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	
	
	
	
}
