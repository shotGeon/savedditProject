package com.spring.chart;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value="/chartdetail", method=RequestMethod.GET)
	public String detail() {
		String url="guest-chart";
		return url;
	}
	
	@RequestMapping(value="/chart/search", method=RequestMethod.GET)
	public void search(String search) {
		String result = search;
		System.out.println("result:"+result);
	}
	
	@RequestMapping(value="/chart/excelRead", method=RequestMethod.GET)
	public void excelRead() throws IOException{
		//System.out.println("와라");
		//파일경로주면서 파일객체 생성
		FileInputStream file = new FileInputStream("C:\\insp\\검사소.xls");
		if(file !=null) {
			System.out.println("건이짱!");
		}
		//XSSFWorkbook workbook = new XSSFWorkbook(file);
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		int rowNo = 0;
		int cellIndex=0;
		
		//첫번째 시트를 가져온다.
		//XSSFSheet sheet = workbook.getSheetAt(0);
		HSSFSheet sheet=workbook.getSheetAt(0);
		
		//사용자가 입력한 엑셀  Row수를 가져온다.
		int rows = sheet.getPhysicalNumberOfRows();
		
		System.out.println("rows:"+rows);
		
		for(rowNo=0; rowNo<rows; rowNo++) {
			HSSFRow row =sheet.getRow(rowNo);
			
			if(row !=null) {
				//해당 Row에 사용자가 입력한 셀의 수를 가져온다.
				int cells = row.getPhysicalNumberOfCells();
				
				for(cellIndex=0; cellIndex<=cells; cellIndex++) {
					//셀의 값을 가져온다.
					HSSFCell cell = row.getCell(cellIndex);
					String value ="";
					//빈 셀 체크
					if(cell ==null) {
						continue;
					}else {
						// 타입 별로 내용을 읽는다
						System.out.println(cell.getStringCellValue());
						System.out.println("===============================================");
					}
				}
			}
			
		}
		file.close();
	}
	@RequestMapping(value="/chart/agencyForm")
	public String agencyForm() {
		System.out.println("안녕");
		String url ="agencyRegistForm";
		
		return url;
	}
}










