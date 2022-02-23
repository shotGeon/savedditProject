package com.spring.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.command.ParamCommad;

@Controller
public class TestController {
	
	//일반 servlet방식
	
	@RequestMapping(value="/http", method=RequestMethod.GET)
	public void httpGet(HttpServletRequest request, HttpServletResponse response) 
					throws IOException, SQLException{
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		System.out.println(id+":"+pwd+":"+num);
	}
	
	//parameter 방식
	
	@RequestMapping(value="/param", method=RequestMethod.GET)
	public void getParam(@RequestParam(value="id",defaultValue="mimi")String idd, String pwd, int num) 
					throws IOException, SQLException{
		
		System.out.println(idd+":"+pwd+":"+num);
	}
	
	@RequestMapping(value="/command", method=RequestMethod.GET)
		public void getCommand(ParamCommad cmd)throws IOException, SQLException{
			System.out.println(cmd);
	}
	
	
	
		
	

}
