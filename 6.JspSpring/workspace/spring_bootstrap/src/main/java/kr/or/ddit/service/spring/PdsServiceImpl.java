package kr.or.ddit.service.spring;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jsp.command.PageMaker;
import com.jsp.command.SearchCriteria;
import com.jsp.dto.AttachVO;
import com.jsp.dto.PdsVO;
import com.jsp.service.PdsService;

import kr.or.ddit.dao.spring.AttachDAOBean;
import kr.or.ddit.dao.spring.PdsDAOBean;

public class PdsServiceImpl implements PdsService {

	private PdsDAOBean pdsDAOBean;
	
	public void setPdsDAOBean(PdsDAOBean pdsDAOBean) {
		this.pdsDAOBean = pdsDAOBean;
	}
	
	private AttachDAOBean attachDAOBean;
	
	public void setAttachDAOBean(AttachDAOBean attachDAOBean) {
		this.attachDAOBean = attachDAOBean;
	}

	@Override
	public AttachVO getAttachByAno(int ano) throws SQLException {
		AttachVO attach = attachDAOBean.selectAttachByAno(ano);
		return attach;
	}

	@Override
	public Map<String, Object> getList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		List<PdsVO> pdsList = pdsDAOBean.selectPdsCriteria(cri);
		
		if(pdsList != null) for (PdsVO pds : pdsList) {
			addAttachList(pds);
		}
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(pdsDAOBean.selectPdsCriteriaTotalCount(cri));
		
		dataMap.put("pdsList", pdsList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}

	@Override
	public PdsVO getPds(int pno) throws SQLException {
		PdsVO pds = pdsDAOBean.selectPdsByPno(pno);
		return pds;
	}

	@Override
	public void modify(PdsVO pds) throws SQLException {
		pdsDAOBean.updatePds(pds);
		
		if(pds.getAttachList() != null) for(AttachVO attach : pds.getAttachList()) {
			attach.setPno(pds.getPno());
			attach.setAttacher(pds.getWriter());
			attachDAOBean.insertAttach(attach);
		}
	}

	@Override
	public PdsVO read(int pno) throws SQLException {
		PdsVO pds = pdsDAOBean.selectPdsByPno(pno);
		pdsDAOBean.increaseViewCnt(pno);
		return pds;
	}

	@Override
	public void regist(PdsVO pds) throws SQLException {
		int pno = pdsDAOBean.getSeqNextValue();
		
		pds.setPno(pno);
		pdsDAOBean.insertPds(pds);
		
		if(pds.getAttachList() != null) for(AttachVO attach : pds.getAttachList()) {
			attach.setPno(pno);
			attach.setAttacher(pds.getWriter());
			attachDAOBean.insertAttach(attach);
		}
	}

	@Override
	public void remove(int pno) throws SQLException {
		attachDAOBean.deleteAllAttach(pno);
		pdsDAOBean.deletePds(pno);
	}

	@Override
	public void removeAttachByAno(int ano) throws SQLException {
		attachDAOBean.deleteAttach(ano);
	}
	
	private void addAttachList(PdsVO pds) throws SQLException{
		
		if(pds == null) return;
		
		int pno = pds.getPno();
		List<AttachVO> attachList = attachDAOBean.selectAttachesByPno(pno);
		
		pds.setAttachList(attachList);
	}

}
