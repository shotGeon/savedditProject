package kr.or.ddit.at.vo;

/**
 * @author sena5
 *
 */
public class AtVO {
	private long atch_file_id = -1; // 첨부파일ID
	private int file_sn = 1; // 파일순번
	private String file_stre_cours; // 파일 저장경로
	private String stre_file_nm; // 저장파일명
	private String orignl_file_nm; // 실제파일명
	private String file_extsn; // 파일확장자
	private String file_cn; // 파일내용
	private long file_size = 0; // 파일크기
	private int adminboard_id;

	private String mem_id;
	private String mem_name;

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_name() {
		return mem_name;
	}

	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}

	public int getAdminboard_id() {
		return adminboard_id;
	}

	public void setAdminboard_id(int adminboard_id) {
		this.adminboard_id = adminboard_id;
	}

	public long getAtch_file_id() {
		return atch_file_id;
	}

	public void setAtch_file_id(long atch_file_id) {
		this.atch_file_id = atch_file_id;
	}

	public int getFile_sn() {
		return file_sn;
	}

	public void setFile_sn(int file_sn) {
		this.file_sn = file_sn;
	}

	public String getFile_stre_cours() {
		return file_stre_cours;
	}

	public void setFile_stre_cours(String file_stre_cours) {
		this.file_stre_cours = file_stre_cours;
	}

	public String getStre_file_nm() {
		return stre_file_nm;
	}

	public void setStre_file_nm(String stre_file_nm) {
		this.stre_file_nm = stre_file_nm;
	}

	public String getOrignl_file_nm() {
		return orignl_file_nm;
	}

	public void setOrignl_file_nm(String orignl_file_nm) {
		this.orignl_file_nm = orignl_file_nm;
	}

	public String getFile_extsn() {
		return file_extsn;
	}

	public void setFile_extsn(String file_extsn) {
		this.file_extsn = file_extsn;
	}

	public String getFile_cn() {
		return file_cn;
	}

	public void setFile_cn(String file_cn) {
		this.file_cn = file_cn;
	}

	public long getFile_size() {
		return file_size;
	}

	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}

	@Override
	public String toString() {
		return "AtVO [atch_file_id=" + atch_file_id + ", file_sn=" + file_sn + ", file_stre_cours=" + file_stre_cours
				+ ", stre_file_nm=" + stre_file_nm + ", orignl_file_nm=" + orignl_file_nm + ", file_extsn=" + file_extsn
				+ ", file_cn=" + file_cn + ", file_size=" + file_size + ", adminboard_id=" + adminboard_id + "]";
	}
}
