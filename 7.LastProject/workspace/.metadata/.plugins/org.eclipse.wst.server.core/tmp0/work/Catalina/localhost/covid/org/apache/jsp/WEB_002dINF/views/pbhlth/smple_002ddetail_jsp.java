/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.37
 * Generated at: 2022-01-10 08:24:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.pbhlth;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class smple_002ddetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback\">\r\n");
      out.write(" <!-- Font Awesome -->\r\n");
      out.write(" <link rel=\"stylesheet\" href=\"../resources/bootstrap/plugins/fontawesome-free/css/all.min.css\">\r\n");
      out.write(" <!-- Theme style -->\r\n");
      out.write(" <link rel=\"stylesheet\" href=\"../resources/bootstrap/dist/css/adminlte.min.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"../resources/bootstrap/plugins/jquery/jquery.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"wrapper\" style=\"max-width: 1280px; margin: 0 auto;\">\r\n");
      out.write("\t\t\t<div class=\"content-wrapper\" style=\"background: #ffffff;\">\r\n");
      out.write("\t\t\t<div class=\"card-header\" style=\"background-color: #5bbc71;\">\r\n");
      out.write("\t\t\t\t<h3 class=\"card-title\"><span style=\"color: white\">시료 상세조회</span></h3>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"margin-top: 30px;\" class=\"col-3\">\r\n");
      out.write("\t\t\t\t<i class=\"fas fa-caret-right\">&nbsp&nbsp검사결과 정보</i>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"card-body\">\r\n");
      out.write("                <table class=\"table table-bordered\">\r\n");
      out.write("                  \r\n");
      out.write("                  <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td style=\"background-color: #f5f6f7; border-top: 2px solid black;\" width=\"100px;\"><strong>도착일자</strong></td>\r\n");
      out.write("                      <td style=\"border-top: 2px solid black;\" width=\"300px;\">2020/07/09 11:01:21</td>\r\n");
      out.write("                      \r\n");
      out.write("                      <td style=\"background-color: #f5f6f7; border-top: 2px solid black;\" width=\"100px;\"><strong>검사일자</strong></td>\r\n");
      out.write("                      <td style=\"border-top: 2px solid black;\" width=\"300px;\">2020/07/09 11:01:21</td>\r\n");
      out.write("                      \r\n");
      out.write("                    </tr>\r\n");
      out.write("                    \r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td style=\"background-color: #f5f6f7;\"><strong>확정일자</strong></td>\r\n");
      out.write("                      <td>2020/07/09 11:01:21</td>\r\n");
      out.write("                      \r\n");
      out.write("                      <td style=\"background-color: #f5f6f7;\"><strong>검사자</strong></td>\r\n");
      out.write("                      <td>아무개</td>\r\n");
      out.write("                      \r\n");
      out.write("                      \r\n");
      out.write("                    </tr>\r\n");
      out.write("                    \r\n");
      out.write("                     <tr>\r\n");
      out.write("                      <td style=\"background-color: #f5f6f7;\"><strong>검사결과</strong></td>\r\n");
      out.write("                      <td>\r\n");
      out.write("                      <select name=\"result\">\r\n");
      out.write("                      \t<option value=\"\" selected=\"selected\">미정</option>\r\n");
      out.write("                      \t<option value=\"양성\">양성</option>\r\n");
      out.write("                      \t<option value=\"음성\">음성</option>\r\n");
      out.write("                      </select>\r\n");
      out.write("                      </td>\r\n");
      out.write("                      \r\n");
      out.write("                      <td style=\"background-color: #f5f6f7;\"></td>\r\n");
      out.write("                      <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"margin: 0 auto;\" class=\"col-1\">\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn btn-block btn-default\" style=\"background-color: #5bbc71\"><span style=\"color: white;\">확정</span></button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div style=\"margin-top: 15px;\" class=\"col-3\">\r\n");
      out.write("\t\t\t\t<i class=\"fas fa-caret-right\">&nbsp&nbsp피검자정보</i>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"card-body\">\r\n");
      out.write("                <table class=\"table table-bordered\">\r\n");
      out.write("                  \r\n");
      out.write("                  <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td style=\"background-color: #f5f6f7; border-top: 2px solid black;\" width=\"100px;\"><strong>성명</strong></td>\r\n");
      out.write("                      <td style=\"border-top: 2px solid black;\" width=\"300px;\">아무개</td>\r\n");
      out.write("                      \r\n");
      out.write("                      <td style=\"background-color: #f5f6f7; border-top: 2px solid black;\" width=\"100px;\"><strong>생년월일</strong></td>\r\n");
      out.write("                      <td style=\"border-top: 2px solid black;\" width=\"300px;\">1996/06/25</td>\r\n");
      out.write("                      \r\n");
      out.write("                    </tr>\r\n");
      out.write("                    \r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td style=\"background-color: #f5f6f7;\"><strong>성별</strong></td>\r\n");
      out.write("                      <td>남</td>\r\n");
      out.write("                      \r\n");
      out.write("                      <td style=\"background-color: #f5f6f7;\"><strong>연락처</strong></td>\r\n");
      out.write("                      <td>010-7777-7777</td>\r\n");
      out.write("                      \r\n");
      out.write("                      \r\n");
      out.write("                    </tr>\r\n");
      out.write("                    \r\n");
      out.write("                     <tr>\r\n");
      out.write("                      <td style=\"background-color: #f5f6f7;\"><strong>주소</strong></td>\r\n");
      out.write("                      <td>대전시 어딘가</td>\r\n");
      out.write("                      \r\n");
      out.write("                      <td style=\"background-color: #f5f6f7;\"></td>\r\n");
      out.write("                      <td></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                  </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div style=\"margin-top: 15px;\" class=\"col-3\">\r\n");
      out.write("\t\t\t\t<i class=\"fas fa-caret-right\">&nbsp&nbsp검사 요청기관</i>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"card-body\">\r\n");
      out.write("                <table class=\"table table-bordered\">\r\n");
      out.write("                  \r\n");
      out.write("                  <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td style=\"background-color: #f5f6f7; border-top: 2px solid black;\" width=\"100px;\"><strong>요청기관</strong></td>\r\n");
      out.write("                      <td style=\"border-top: 2px solid black;\" width=\"300px;\">아무기관</td>\r\n");
      out.write("                      \r\n");
      out.write("                      <td style=\"background-color: #f5f6f7; border-top: 2px solid black;\" width=\"100px;\"><strong>요청자</strong></td>\r\n");
      out.write("                      <td style=\"border-top: 2px solid black;\" width=\"300px;\">아무개</td>\r\n");
      out.write("                      \r\n");
      out.write("                    </tr>\r\n");
      out.write("                    \r\n");
      out.write("                    <tr>\r\n");
      out.write("                      <td style=\"background-color: #f5f6f7;\"><strong>연락처</strong></td>\r\n");
      out.write("                      <td>010-7777-7777</td>\r\n");
      out.write("                      \r\n");
      out.write("                      <td style=\"background-color: #f5f6f7;\"></td>\r\n");
      out.write("                      <td></td>\r\n");
      out.write("                      \r\n");
      out.write("                    </tr>\r\n");
      out.write("                     \r\n");
      out.write("                  </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("                \r\n");
      out.write("\t\t\t</div>\t\t\t\r\n");
      out.write("                \r\n");
      out.write("                <div style=\"margin: 0 auto; \" class=\"col-1\">\r\n");
      out.write("\t\t\t\t\t<button type=\"button\" class=\"btn btn-block btn-default\" onclick=\"history.go(-1)\" style=\"background-color: #5bbc71\"><span style=\"color: white;\">취소</span></button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t</div>\t\r\n");
      out.write("</div>\r\n");
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
