package kr.or.ddit.cmm.vo;

public class AtchFileVO {
 
	private long atchFileId= -1; //첨부파일 ID
	private int fileSn= 1;       //파일순번
	private String fileStreCours;//파일저장 경로
	private String streFileNm;   //저장파일명
	private String orignlFileNm; //실제파일명
	private String fileExtsn;    //파일확장자
	private String fileCn;       //파일 내용
	private long fileSize =0;    //파일 크기
	
	public long getAtchFileId() {
		return atchFileId;
	}
	public void setAtchFileId(long atchFileId) {
		this.atchFileId = atchFileId;
	}
	public int getFileSn() {
		return fileSn;
	}
	public void setFileSn(int fileSn) {
		this.fileSn = fileSn;
	}
	public String getFileStreCours() {
		return fileStreCours;
	}
	public void setFileStreCours(String fileStreCours) {
		this.fileStreCours = fileStreCours;
	}
	public String getStreFileNm() {
		return streFileNm;
	}
	public void setStreFileNm(String streFileNm) {
		this.streFileNm = streFileNm;
	}
	public String getOrignlFileNm() {
		return orignlFileNm;
	}
	public void setOrignlFileNm(String orignlFileNm) {
		this.orignlFileNm = orignlFileNm;
	}
	public String getFileExtsn() {
		return fileExtsn;
	}
	public void setFileExtsn(String fileExtsn) {
		this.fileExtsn = fileExtsn;
	}
	public String getFileCn() {
		return fileCn;
	}
	public void setFileCn(String fileCn) {
		this.fileCn = fileCn;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	
	
}   
