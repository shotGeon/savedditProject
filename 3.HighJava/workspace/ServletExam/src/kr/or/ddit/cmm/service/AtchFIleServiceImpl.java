package kr.or.ddit.cmm.service;

import java.awt.PageAttributes.OriginType;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;

import kr.or.ddit.cmm.dao.AtchFileDaoImpl;
import kr.or.ddit.cmm.dao.IAtchFileDao;
import kr.or.ddit.cmm.vo.AtchFileVO;
import kr.or.ddit.util.FileUploadRequestWrapper;

public class AtchFIleServiceImpl implements IAtchFileService{
	private static Logger logger = Logger.getLogger(FileUploadRequestWrapper.class);
	
	private static IAtchFileService service;
	private IAtchFileDao dao;
	
	private AtchFIleServiceImpl() {
		dao = AtchFileDaoImpl.getInstance();
	}
	
	public static IAtchFileService getInstance() {
		if(service==null) {
			service = new AtchFIleServiceImpl();
		}
		return service;
	}
	
	@Override
	public AtchFileVO saveAtchFileList(Map<String, FileItem[]> fileItemMap) throws Exception {
		
		AtchFileVO atchFileVO = new AtchFileVO();
		
		dao.insertAtchFile(atchFileVO); //기본 첨부파일 테이블 저장
		
		for(FileItem[] itemArr : fileItemMap.values()) {
			
			for(FileItem item : itemArr) {
				
				File uploadDir = 
						new File(FileUploadRequestWrapper.UPLOAD_DIRECTORY);
				if(!uploadDir.exists()) {
					uploadDir.mkdir();
				}
				
				logger.info("item.getName()=>" + item.getName());
				
				String orignFileName = item.getName(); //원본 파일명
				long fileSize = item.getSize(); //파일크기
				String saveFileName = ""; //저장파일명
				File storeFile = null; //저장파일객체
				String saveFilePath = ";";//저장파일경로
				
				do {
					//저장파일명 생성하기
					saveFileName = UUID.randomUUID().toString()
							.replace("-", "");
					saveFilePath = FileUploadRequestWrapper.UPLOAD_DIRECTORY
							   + File.separator+saveFileName;
					storeFile = new File(saveFilePath);
					
				}while(storeFile.exists());//저장파일이 중복되지 않을때까지
				
				// 확장명 추출
				String fileExtension = orignFileName.lastIndexOf(".") < 0 ?
						"" : orignFileName
						       .substring(orignFileName.lastIndexOf(".")+1);
				item.write(storeFile); //업로드 파일 저장
				
				atchFileVO.setStreFileNm(saveFileName);
				atchFileVO.setFileSize(fileSize);
				atchFileVO.setOrignlFileNm(orignFileName);
				atchFileVO.setFileExtsn(fileExtension);
				atchFileVO.setFileStreCours(saveFilePath);
				
				//파일 상세정보 저장
				dao.insertAtchFileDetail(atchFileVO);
				
				item.delete(); //임시 업로드 파일 삭제하기
				
			}
		}
		
		return atchFileVO;
	}

	@Override
	public List<AtchFileVO> getAtchFileList(AtchFileVO fileVO) {
		return dao.getAtchFileList(fileVO);
	}

	@Override
	public AtchFileVO getAtchFileDetail(AtchFileVO fileVO) {
		return dao.getAtchFileDetail(fileVO);
	}

}
