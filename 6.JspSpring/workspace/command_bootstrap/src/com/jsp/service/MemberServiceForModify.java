package com.jsp.service;

import javax.servlet.http.HttpServletRequest;

import com.jsp.dto.MemberVO;
import com.jsp.exception.InvalidPasswordException;
import com.jsp.exception.NotFoundIdException;

public interface MemberServiceForModify extends MemberService {

 int modify(MemberVO member) throws Exception;
 
 void remove(String id) throws Exception;
 void enabled(String id, int enabled) throws Exception;
 
 void login(String id, String pwd) throws NotFoundIdException,
 										  InvalidPasswordException,
 										  Exception;
 
 
 
}
