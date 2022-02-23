package kr.or.ddit.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.command.SearchCriteria;
import com.jsp.dto.NoticeVO;
import com.jsp.service.NoticeService;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	//@Autowired
	@Resource(name="noticeService")
	private NoticeService noticeService;
	
	@RequestMapping("/main")
	public String main()throws Exception {
		
		String url = "notice/main.open";
		
		return url;
	}
	
	@RequestMapping("/list")
	public String list(SearchCriteria cri, Model model) throws Exception{
		
		String url = "notice/list.open";
		Map<String, Object> dataMap = noticeService.getNoticeList(cri);
		model.addAllAttributes(dataMap);
		
		return url;
	}
	
	@RequestMapping("/registForm")
	public String registForm() {
		String url = "notice/regist.open";
		return url;
	}
	
	@RequestMapping("/regist")
	public String regist(NoticeVO notice, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		String url = "redirect:/notice/list";
		
//		notice.setTitle(HTMLInputFilter.htmlSpecialChars(notice.getTitle()));
		notice.setTitle((String)request.getAttribute("XSStitle")); // interceptor 이후
		
		noticeService.regist(notice);
		
		rttr.addFlashAttribute("from", "regist");
		
		return url;
	}
	
	@RequestMapping("/detail")
	public ModelAndView detail(int nno, @RequestParam(defaultValue="")String from, HttpServletRequest request, ModelAndView mnv) throws SQLException{
		String url = "notice/detail.open";
		
		NoticeVO notice = null;
		
		if(!from.equals("list")){
			notice = noticeService.getNoticeForModify(nno);
		}else {
			notice = noticeService.getNotice(nno);
			url = "redirect:/notice/detail.do?nno="+nno;
		}
		
		mnv.addObject("notice", notice);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping("/modifyForm")
	public ModelAndView modifyForm(int nno, ModelAndView mnv) throws Exception{
		String url = "notice/modify.open";
		
		NoticeVO notice = noticeService.getNoticeForModify(nno);
		
		mnv.addObject("notice", notice);
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPost(NoticeVO notice, HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		String url = "redirect:/notice/detail.do";
		
//		notice.setTitle(HTMLInputFilter.htmlSpecialChars(notice.getTitle()));
		notice.setTitle((String)request.getAttribute("XSStitle"));
		noticeService.modify(notice);
		
		rttr.addAttribute("nno", notice.getNno()); // 주소줄에 계속 남아 있음. parameter로 . param. 붙구
		rttr.addFlashAttribute("from", "modify"); // Attribute에 직접 심는거니까 param.이 없구.
		// redirect 할때 심어준 후, 날아감. 
		return url;
	}
	
	@RequestMapping(value="remove", method=RequestMethod.POST)
	public String remove(int nno, RedirectAttributes rttr) throws Exception{
		String url = "redirect:/notice/detail.do";
		
		noticeService.remove(nno);
		
		rttr.addFlashAttribute("from", "remove");
		rttr.addAttribute("nno", nno);
		
		return url;
		
	}
}
