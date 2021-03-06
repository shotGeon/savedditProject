package kr.or.ddit.at.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import kr.or.ddit.at.vo.AtVO;

public interface IAtchFileService {
	/**
	 * 첨부파일 목록을 저장하기 위한 메서드
	 * @param fileItemMap
	 * @return
	 */
	public AtVO saveAtchFileList(Map<String, FileItem[]> fileItemMap) throws Exception;
	
	/**
	 * 첨부파일 목록을 저장하기 위한 메서드 (과제)
	 * @param fileItemMap
	 * @return
	 */
	public AtVO saveAtchFileList(Map<String, FileItem[]> fileItemMap, AtVO atVO) throws Exception;
	
	/**
	 * 첨부파일 목록을 저장하기 위한 메서드
	 * @param fileItemMap
	 * @return
	 */
	public AtVO updateAtchFileList(Map<String, FileItem[]> fileItemMap, AtVO atVO) throws Exception;
	
	/**
	 * 첨부파일 목록 조회하기
	 * @param atchFileVO
	 * @return
	 */
	public List<AtVO> getAtchFileList(AtVO atchFileVO);
	
	/**
	 * 첨부파일 세부정보 조회하기
	 * @param atchFileVO
	 * @return AtchFileVO 세부파일정보를 담은 객체
	 */
	public AtVO getAtchFileDetail(AtVO atchFileVO);
	
	public int selectAtchId(int adminId);
	
	/**
	 * 과제 게시판에 과제물 업로드 하는 메서드
	 * @param fileItemMap
	 * @param atVO
	 * @return
	 * @throws Exception
	 */
	public AtVO uploadFile(Map<String, FileItem[]> fileItemMap, AtVO atVO) throws Exception;
	
	/**
	 * 과제 게시판에서 atch_id를 만드는 메서드
	 * @param adminboard_id
	 * @return
	 */
	public int insertAtchId(int adminboard_id);
	
}
