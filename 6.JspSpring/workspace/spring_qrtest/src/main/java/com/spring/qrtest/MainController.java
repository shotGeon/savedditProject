package com.spring.qrtest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/qrgenerate")
	public String qrsuccess() {
		System.out.println("qrgenerate옴!");
		String url="qrgenerate";
		return url;
	}

}
