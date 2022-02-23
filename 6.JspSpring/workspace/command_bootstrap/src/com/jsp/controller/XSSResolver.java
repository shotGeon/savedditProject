package com.jsp.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.josephoconnell.html.HTMLInputFilter;

public class XSSResolver {
	
	public static void parseXSS(HttpServletRequest request) throws IOException, ServletException{
		Enumeration<String> crossParamNames = request.getParameterNames();

		while (crossParamNames.hasMoreElements()) {
			String paramName = crossParamNames.nextElement();

			String[] paramValues = request.getParameterValues(paramName);
			
			if (paramValues != null)
				for (int i = 0; i < paramValues.length; i++) {
					paramValues[i] = HTMLInputFilter.htmlSpecialChars(paramValues[i]);
				}

			request.setAttribute("XSS" + paramName, paramValues);
		}
	}
}
