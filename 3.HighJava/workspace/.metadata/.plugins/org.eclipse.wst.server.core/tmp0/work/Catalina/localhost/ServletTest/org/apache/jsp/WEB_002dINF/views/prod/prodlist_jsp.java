/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2021-10-28 11:27:17 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.prod;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kr.or.ddit.prod.vo.ProdVO;
import java.util.List;

public final class prodlist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("kr.or.ddit.prod.vo.ProdVO");
    _jspx_imports_classes.add("java.util.List");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	List<ProdVO> list = (List<ProdVO>) request.getAttribute("list");
	

      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\t<html>\r\n");
      out.write("\t<table border=\"1\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>prod_id</th>\t\r\n");
      out.write("\t\t\t<th>prod_name</th>\t\r\n");
      out.write("\t\t\t<th>prod_lgu</th>\t\r\n");
      out.write("\t\t\t<th>prod_buyer</th>\t\r\n");
      out.write("\t\t\t<th>prod_cost</th>\t\r\n");
      out.write("\t\t\t<th>prod_price</th>\t\r\n");
      out.write("\t\t\t<th>prod_sale</th>\t\r\n");
      out.write("\t\t\t<th>prod_outline</th>\t\r\n");
      out.write("\t\t\t<th>prod_img</th>\t\r\n");
      out.write("\t\t\t<th>prod_totalstock</th>\t\r\n");
      out.write("\t\t\t<th>prod_properstock</th>\t\r\n");
      out.write("\t\t</tr>\r\n");
	
	if(list.size()>0){
		for(int i=0; i<list.size(); i++){
			ProdVO pv = list.get(i);

      out.write("\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>");
      out.print(pv.getProd_id() );
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(pv.getProd_name() );
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(pv.getProd_lgu() );
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(pv.getProd_buyer() );
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(pv.getProd_cost() );
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(pv.getProd_price() );
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(pv.getProd_sale() );
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(pv.getProd_outline() );
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(pv.getProd_img() );
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(pv.getProd_totalstock() );
      out.write("</td>\r\n");
      out.write("\t\t<td>");
      out.print(pv.getProd_properstock() );
      out.write("</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
		
		}

      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");

	}else{

      out.write("\t\t\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td colspan=\"11\">상품없음</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\t\t\r\n");
	
	}


      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</table>\r\n");
      out.write("\t<input type=\"button\" id=\"prodInsert\" value=\"등록\">\t\t\r\n");
      out.write("\t</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
