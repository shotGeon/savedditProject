package notice.service;

import java.util.List;

import notice.dto.NoticeVO;

public interface INoticeService {
	
	public List<NoticeVO> getImportantList() throws Exception;
	
	public List<NoticeVO> getNormalList() throws Exception;

}
