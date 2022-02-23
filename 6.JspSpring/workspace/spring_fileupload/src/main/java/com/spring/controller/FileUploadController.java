package com.spring.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.spring.command.MultipartCommand;

@Controller
public class FileUploadController {
	
	@RequestMapping("/acsel")
	public void acselDown(HttpServletResponse response) throws IOException{
		System.out.println("옵니다.");
		
		List<Map<String, String>> testList = new ArrayList<Map<String,String>>();
		Map<String, String> testMap = new HashMap<String, String>();
		
		testMap.put("testName", "하기재");
		testMap.put("testAge", "25세");
		testMap.put("testWeight", "100kg");
		
		testList.add(testMap);
		
		Workbook workbook = new SXSSFWorkbook();
		
		Sheet sheet = workbook.createSheet();
		
		int rowIndex = 0;
		Row headerRow = sheet.createRow(rowIndex++);
		Cell headerCell1 = headerRow.createCell(0);
		headerCell1.setCellValue("이름");
		
		Cell headerCell2 = headerRow.createCell(1);
		headerCell2.setCellValue("나이");
		
		Cell headerCell3 = headerRow.createCell(2);
		headerCell3.setCellValue("몸무게");
		
		
		for(Map<String, String> valMap : testList) {
			Row bodyRow = sheet.createRow(rowIndex++);
			
			Cell bodyCell1 = bodyRow.createCell(0);
			bodyCell1.setCellValue(valMap.get("testName"));
			
			Cell bodyCell2 = bodyRow.createCell(1);
			bodyCell2.setCellValue(valMap.get("testAge"));
			
			Cell bodyCell3 = bodyRow.createCell(2);
			bodyCell3.setCellValue(valMap.get("testWeight"));
		
		}
		
		response.setContentType("ms-vnd/excel");
		
		response.setHeader("Content-Disposition", "attachment;filename=example.xlsx");
		
		workbook.write(response.getOutputStream());
		workbook.close();
		
		
		
		
	}
	
	@RequestMapping("/fileUploadForm")
	public void fileUpload() {}
	
	@RequestMapping(value="/multipartFile", method=RequestMethod.POST,
					produces="text/plain;charset=utf-8")
	public ModelAndView uploadByMultipartFile(@RequestParam(value="title",
										defaultValue="제목없음") String title,
										@RequestParam("file") MultipartFile multi,
										HttpServletRequest request,
										HttpServletResponse response,
										ModelAndView mnv) throws Exception{
		mnv.setViewName("fileUploaded");
		fileUpload(multi, title, request, response, mnv);
		
		
		return mnv;
	}
	
	
	@RequestMapping(value="/multipartHttpServletRequest", method=RequestMethod.POST, 
			  		produces="text/plain;charset=utf-8")
	public ModelAndView uploadByMultipartHttpServletRequest(MultipartHttpServletRequest request,
															HttpServletResponse response,
															ModelAndView mnv) throws Exception{
		String title = request.getParameter("title");
		MultipartFile multi = request.getFile("file");
		mnv.setViewName("fileUploaded");
		fileUpload(multi, title, request, response, mnv);
		
		return mnv;
	}
	
	@RequestMapping(value="/commandObject", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
	public ModelAndView uploadByCommandObject(MultipartCommand mpc, 
											 HttpServletRequest request,
											 HttpServletResponse response,
											 ModelAndView mnv) throws Exception{
		MultipartFile multi = mpc.getFile();
		String title = mpc.getTitle();
		
		mnv.setViewName("fileUploaded");
		fileUpload(multi, title, request, response, mnv);
		
		return mnv;
	}
	
	
	private void fileUpload(MultipartFile multi,String title,
							HttpServletRequest request, HttpServletResponse response,
							ModelAndView mnv)
						throws Exception{
		
		if(multi.isEmpty()) {
			response.setCharacterEncoding("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>alert('파일이 없습니다.')</script>");
			out.println("<script>history.go(-1)</script>");
			mnv.setViewName(null);
			return;
		}
		if(multi.getSize()>1024*1024*5) {
			response.setCharacterEncoding("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<script>alert('용량초과 입니다.')</script>");
			out.println("<script>history.go(-1)</script>");
			mnv.setViewName(null);
			return;
		}
		
		String uploadPath = request.getSession().getServletContext().getRealPath("resources/upload");
		String fileName= UUID.randomUUID().toString().replace("-", "")+"$$"+multi.getOriginalFilename();
		
		File file = new File(uploadPath, fileName);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		multi.transferTo(file);
		
		mnv.addObject("title",title);
		mnv.addObject("originalFilename", multi.getOriginalFilename());
		mnv.addObject("uploadedFilename", file.getName());
		mnv.addObject("uploadPath", file.getAbsolutePath());
		
	}
}
