package com.jsp.action.member;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.action.Action;
import com.jsp.controller.MultipartHttpServletRequestParser;
import com.jsp.controller.SaveFileResolver;
import com.jsp.dto.MemberVO;
import com.jsp.exception.NotMultipartFormDataException;
import com.jsp.service.MemberService;
import com.jsp.service.MemberServiceForModify;
import com.jsp.utils.GetUploadPath;

public class MemberModifyAction implements Action {

		private MemberServiceForModify memberServiceForModify;

	    public void setMemberService(MemberServiceForModify memberServiceForModify) {
		this.memberServiceForModify = memberServiceForModify;
	}

	   private static final int MEMORY_THRESHOLD=1024*500; 
	   private static final int MAX_FILE_SIZE=1024*1024*1; 
	   private static final int MAX_REQUEST_SIZE=1024*1024*2; 
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	      String url="/member/modify_success";
	      
	      try {
	         
	         //1. request 변환 (객체화)
	         MultipartHttpServletRequestParser multi = new MultipartHttpServletRequestParser(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);
	         
	         //수업내용으로는 오버스펙이기때문에 Adapter는 따로 만들지 않는다.
	         String id=multi.getParameter("id");
	         String pwd=multi.getParameter("pwd");
	         String email=multi.getParameter("email");
	         String authority=multi.getParameter("authority");
	         String name=multi.getParameter("name");
	         String phone=multi.getParameter("phone");
	         
	         MemberVO member=new MemberVO();
	         member.setId(id);
	         member.setPwd(pwd);
	         member.setPhone(phone);
	         member.setEmail(email);
	         member.setAuthority(authority);
	         member.setName(name);
	         
	         //file처리
	         //기존 사진 변경 유무 확인.
	         String uploadPicture=multi.getParameter("uploadPicture");
	         if(uploadPicture!=null && !uploadPicture.isEmpty())//사진 변경
	         {
	            //저장 경로
	            String uploadPath=GetUploadPath.getUploadPath("member.picture.upload");
	            File file=new File(uploadPath);
	            file.mkdirs();
	            
	            //기존 사진이미지 삭제
	            File deleteFile=new File(uploadPath,multi.getParameter("oldPicture"));
	            if(deleteFile.exists())
	            {
	               deleteFile.delete();
	            }
	            
	            //최근 사진이미지 저장
	            List<File> fileList=SaveFileResolver.fileUpload(multi.getFileItems("picture"), uploadPath);
	            File saveFile=fileList.get(0);
	            
	            member.setPicture(saveFile.getName());
	         }
	         else //사진 변경하지 않았다면. 기존 파일 그대로임. 텍스트만 바뀐꼴
	         {
	            member.setPicture(multi.getParameter("oldPicture"));
	         }
	         
	         //DB처리
	         memberServiceForModify.modify(member);
	         request.setAttribute("member", member);
	         
	         //로그인 사용자 확인.
	         //req.setAttribute("parentReload", false);
	         
	         HttpSession session = request.getSession();
	         MemberVO loginUser=(MemberVO)session.getAttribute("loginUser");
//	         if(member.getId().equals(loginUser.getId()) && loginUser!=null)
	         if(loginUser!=null && member.getId().equals(loginUser.getId()))
	         {
	        	 request.setAttribute("parentReload", true);
	            session.setAttribute("loginUser", memberServiceForModify.getMember(member.getId()));
	         }

	      } catch (NotMultipartFormDataException e) {
//	         e.printStackTrace();
	    	  response.sendError(response.SC_BAD_REQUEST);
	    	  url= null;
	      } catch (Exception e) {
	         e.printStackTrace();         
	         response.sendError(response.SC_INTERNAL_SERVER_ERROR);
	    	  url= null;	         
	      }
		return url;
	}

}
