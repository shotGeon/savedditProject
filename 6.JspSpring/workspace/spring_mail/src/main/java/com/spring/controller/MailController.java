package com.spring.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spring.command.MailRequestCommand;
import com.spring.mail.MimeAttachNotifier;

@Controller
@RequestMapping("/mail")
public class MailController {
	
	@Autowired
	private MimeAttachNotifier notifier;
	
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public void mailGet() throws Exception{}
	
	@RequestMapping(value="/send", method=RequestMethod.POST)
	public ModelAndView mailPost(MailRequestCommand mailReq,
								 HttpServletRequest request, ModelAndView mnv) throws Exception{
		String url ="mail/mail_success";
		
		MultipartFile attach = mailReq.getFile();
		
		String uploadPath
					=request.getServletContext().getRealPath("resources/mail_attach");
		

		if(attach!=null && !attach.isEmpty()) {
			System.out.println("옴");
			
			if(attach.getSize()<1024*1024*5) {
				File file = new File(uploadPath, attach.getOriginalFilename());
				file.mkdirs();
				
				attach.transferTo(file);
				
				try {
					notifier.sendMail(mailReq, uploadPath);
					
				}catch(Exception e) {
					e.printStackTrace();
					url="mail/mail_fail";
					mnv.addObject("message", "메일 보내기를 실패했습니다.");
				}
				
			}else {
				url="mail/mail_fail";
				mnv.addObject("message","첨부파일이 용량초과 입니다.");
			}
		}
		mnv.addObject("mailRequest",mailReq);
		mnv.setViewName(url);
		return mnv;
	}
}
