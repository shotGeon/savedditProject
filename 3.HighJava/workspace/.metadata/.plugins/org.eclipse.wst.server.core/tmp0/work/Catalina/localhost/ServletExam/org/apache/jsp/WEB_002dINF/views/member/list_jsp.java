/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2021-10-07 02:37:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kr.or.ddit.cmm.vo.PagingVO;
import kr.or.ddit.member.vo.MemberVO;
import java.util.List;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("kr.or.ddit.member.vo.MemberVO");
    _jspx_imports_classes.add("kr.or.ddit.cmm.vo.PagingVO");
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
      out.write("\r\n");
      out.write("\r\n");

	List<MemberVO> memList = 
					(List<MemberVO>)request.getAttribute("memList");
	String msg =request.getParameter("msg")==null?
			"" : request.getParameter("msg");
	PagingVO pagingVO =(PagingVO) request.getAttribute("pagingVO");



      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>회원 목록</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<table border=\"1\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>ID</th>\r\n");
      out.write("\t\t\t<th>이름</th>\r\n");
      out.write("\t\t\t<th>전화번호</th>\r\n");
      out.write("\t\t\t<th>주소</th>\r\n");
      out.write("\t\t</tr>\r\n");

	int memSize = memList.size();
	if(memSize>0){
		for(int i=0; i<memSize; i++){
		
	


      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>");
      out.print(memList.get(i).getMemId());
      out.write("</td>\r\n");
      out.write("\t\t\t<td><a href=\"detail.do?memId=");
      out.print(memList.get(i).getMemId());
      out.write("\">\r\n");
      out.write("\t\t\t");
      out.print(memList.get(i).getMemName());
      out.write("</a></td>\r\n");
      out.write("\t\t\t<td>");
      out.print(memList.get(i).getMemTel());
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(memList.get(i).getMemAddr());
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");

		}
		

      out.write("\r\n");
      out.write("\t\t<!-- 페이징 처리 시작 -->\r\n");
      out.write("\t\t");
if(pagingVO.getTotalCount() > 0) {
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"4\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t<!-- 첫번째페이지 번호가 페이지 수보다 큰 경우(이젠페이지 존재함.) -->\r\n");
      out.write("\t\t\t\t\t");
if(pagingVO.getFirstPageNo() > pagingVO.getPageSize()) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"list.do?pageNo=");
      out.print(pagingVO.getFirstPageNo() - pagingVO.getPageSize() );
      out.write("\">[이전]</a>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t");
for(int pNo = pagingVO.getFirstPageNo(); pNo <= pagingVO.getLastPageNo(); pNo++) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<a ");
if(pNo == pagingVO.getCurrentPageNo()){ 
      out.write(" style=\"color:orange;\"");
} 
      out.write(" href=\"list.do?pageNo=");
      out.print(pNo );
      out.write('"');
      out.write('>');
      out.write('[');
      out.print(pNo );
      out.write("]</a>\r\n");
      out.write("\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<!-- 마지막페이지번호가 전체페이지 수보다 작은 경우(다음페이지 존재함.) -->\r\n");
      out.write("\t\t\t\t\t");
if(pagingVO.getLastPageNo() < pagingVO.getTotalPageCount()) { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"list.do?pageNo=");
      out.print(pagingVO.getFirstPageNo() + pagingVO.getPageSize() );
      out.write("\">[다음]</a>\r\n");
      out.write("\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\t\t<!-- 페이징 처리 끝 -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
	
    }else{

      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"4\">회원정보가 없습니다.</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");

    }

      out.write("\r\n");
      out.write("\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t<td colspan=\"4\"><a href=\"insert.do\">[회원등록]</a></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");

	if(msg.equals("성공")){
		

      out.write("\t\r\n");
      out.write("\t<script>alert(\"정상적으로 처리되었습니다.\")</script>\r\n");
      out.write("\r\n");

	}

      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
